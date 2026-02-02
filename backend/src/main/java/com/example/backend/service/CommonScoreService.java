package com.example.backend.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.backend.dto.response.ReportResponse;
import com.example.backend.dto.response.ScoreResponse;
import com.example.backend.dto.response.SubjectReport;
import com.example.backend.dto.response.TopStudentResponse;
import com.example.backend.entity.CommonScore;
import com.example.backend.entity.NaturalScore;
import com.example.backend.entity.SocialScore;
import com.example.backend.repository.CommonScoreRepository;
import com.example.backend.service.interfaces.ICommonScoreService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommonScoreService implements ICommonScoreService {
    private final CommonScoreRepository commonScoreRepository;

    public ScoreResponse checkScore(String sbd) {
        String normalized = sbd.trim();
        if (normalized == null || normalized.isEmpty()) {
            throw new IllegalArgumentException("SBD cannot be empty");
        } else if (normalized.length() > 10) {
            throw new IllegalArgumentException("Invalid SBD");
        } else if (!normalized.matches("^\\d+$")) {
            throw new IllegalArgumentException("Invalid SBD");
        }

        CommonScore score = commonScoreRepository.findById(sbd)
                .orElseThrow(() -> new IllegalArgumentException("Student not found: " + sbd));

        if (score instanceof NaturalScore naturalScore) {
            return calculateNaturalScore(naturalScore);
        } else if (score instanceof SocialScore socialScore) {
            return calculateSocialScore(socialScore);
        }

        throw new IllegalStateException("Unknown score type");
    }

    private ScoreResponse calculateNaturalScore(NaturalScore score) {
        Double vatLi = score.getVatLi();
        Double hoaHoc = score.getHoaHoc();
        Double sinhHoc = score.getSinhHoc();

        return ScoreResponse.builder()
                .sbd(score.getSbd())
                .groupType("NATURAL")
                .toan(score.getToan())
                .nguVan(score.getNguVan())
                .ngoaiNgu(score.getNgoaiNgu())
                .vatLi(vatLi)
                .hoaHoc(hoaHoc)
                .sinhHoc(sinhHoc)
                .build();
    }

    private ScoreResponse calculateSocialScore(SocialScore score) {
        Double lichSu = score.getLichSu();
        Double diaLi = score.getDiaLi();
        Double gdcd = score.getGdcd();

        return ScoreResponse.builder()
                .sbd(score.getSbd())
                .groupType("SOCIAL")
                .toan(score.getToan())
                .nguVan(score.getNguVan())
                .ngoaiNgu(score.getNgoaiNgu())
                .lichSu(lichSu)
                .diaLi(diaLi)
                .gdcd(gdcd)
                .build();
    }

    @Override
    public ReportResponse getReportStats() {
        Map<String, Object> stats = commonScoreRepository.getReportStats();

        return ReportResponse.builder()
                .toan(buildSubjectReport(stats, "toan"))
                .nguVan(buildSubjectReport(stats, "ngu_van"))
                .ngoaiNgu(buildSubjectReport(stats, "ngoai_ngu"))
                .vatLi(buildSubjectReport(stats, "vat_li"))
                .hoaHoc(buildSubjectReport(stats, "hoa_hoc"))
                .sinhHoc(buildSubjectReport(stats, "sinh_hoc"))
                .lichSu(buildSubjectReport(stats, "lich_su"))
                .diaLi(buildSubjectReport(stats, "dia_li"))
                .gdcd(buildSubjectReport(stats, "gdcd"))
                .build();
    }

    private SubjectReport buildSubjectReport(Map<String, Object> stats, String prefix) {
        return SubjectReport.builder()
                .level1(safeLong(stats.get(prefix + "_level1")))
                .level2(safeLong(stats.get(prefix + "_level2")))
                .level3(safeLong(stats.get(prefix + "_level3")))
                .level4(safeLong(stats.get(prefix + "_level4")))
                .build();
    }

    private Long safeLong(Object value) {
        if (value instanceof Number number) {
            return number.longValue();
        }
        return 0L;
    }

    private Double safeDouble(Object value) {
        if (value instanceof Number number) {
            return number.doubleValue();
        }
        return null;
    }

    @Override
    public List<TopStudentResponse> getTop10GroupA() {
        List<Map<String, Object>> results = commonScoreRepository.findTop10GroupA();

        return results.stream()
                .map(row -> TopStudentResponse.builder()
                        .sbd((String) row.get("sbd"))
                        .toan(safeDouble(row.get("toan")))
                        .vatLi(safeDouble(row.get("vat_li")))
                        .hoaHoc(safeDouble(row.get("hoa_hoc")))
                        .totalScore(safeDouble(row.get("total_score")))
                        .build())
                .collect(Collectors.toList());
    }
}
