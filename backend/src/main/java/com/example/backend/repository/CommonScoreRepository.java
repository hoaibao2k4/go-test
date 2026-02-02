package com.example.backend.repository;

import java.util.List;
import java.util.Map;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.backend.entity.CommonScore;

@Repository
public interface CommonScoreRepository extends JpaRepository<CommonScore, String> {
    @Query(value = "SELECT " +
            "SUM(CASE WHEN toan >= 8 THEN 1 ELSE 0 END) as toan_level1, " +
            "SUM(CASE WHEN toan < 8 AND toan >= 6 THEN 1 ELSE 0 END) as toan_level2, " +
            "SUM(CASE WHEN toan < 6 AND toan >= 4 THEN 1 ELSE 0 END) as toan_level3, " +
            "SUM(CASE WHEN toan < 4 THEN 1 ELSE 0 END) as toan_level4, " +

            "SUM(CASE WHEN ngu_van >= 8 THEN 1 ELSE 0 END) as ngu_van_level1, " +
            "SUM(CASE WHEN ngu_van < 8 AND ngu_van >= 6 THEN 1 ELSE 0 END) as ngu_van_level2, " +
            "SUM(CASE WHEN ngu_van < 6 AND ngu_van >= 4 THEN 1 ELSE 0 END) as ngu_van_level3, " +
            "SUM(CASE WHEN ngu_van < 4 THEN 1 ELSE 0 END) as ngu_van_level4, " +

            "SUM(CASE WHEN ngoai_ngu >= 8 THEN 1 ELSE 0 END) as ngoai_ngu_level1, " +
            "SUM(CASE WHEN ngoai_ngu < 8 AND ngoai_ngu >= 6 THEN 1 ELSE 0 END) as ngoai_ngu_level2, " +
            "SUM(CASE WHEN ngoai_ngu < 6 AND ngoai_ngu >= 4 THEN 1 ELSE 0 END) as ngoai_ngu_level3, " +
            "SUM(CASE WHEN ngoai_ngu < 4 THEN 1 ELSE 0 END) as ngoai_ngu_level4, " +

            "SUM(CASE WHEN vat_li >= 8 THEN 1 ELSE 0 END) as vat_li_level1, " +
            "SUM(CASE WHEN vat_li < 8 AND vat_li >= 6 THEN 1 ELSE 0 END) as vat_li_level2, " +
            "SUM(CASE WHEN vat_li < 6 AND vat_li >= 4 THEN 1 ELSE 0 END) as vat_li_level3, " +
            "SUM(CASE WHEN vat_li < 4 THEN 1 ELSE 0 END) as vat_li_level4, " +

            "SUM(CASE WHEN hoa_hoc >= 8 THEN 1 ELSE 0 END) as hoa_hoc_level1, " +
            "SUM(CASE WHEN hoa_hoc < 8 AND hoa_hoc >= 6 THEN 1 ELSE 0 END) as hoa_hoc_level2, " +
            "SUM(CASE WHEN hoa_hoc < 6 AND hoa_hoc >= 4 THEN 1 ELSE 0 END) as hoa_hoc_level3, " +
            "SUM(CASE WHEN hoa_hoc < 4 THEN 1 ELSE 0 END) as hoa_hoc_level4, " +

            "SUM(CASE WHEN sinh_hoc >= 8 THEN 1 ELSE 0 END) as sinh_hoc_level1, " +
            "SUM(CASE WHEN sinh_hoc < 8 AND sinh_hoc >= 6 THEN 1 ELSE 0 END) as sinh_hoc_level2, " +
            "SUM(CASE WHEN sinh_hoc < 6 AND sinh_hoc >= 4 THEN 1 ELSE 0 END) as sinh_hoc_level3, " +
            "SUM(CASE WHEN sinh_hoc < 4 THEN 1 ELSE 0 END) as sinh_hoc_level4, " +

            "SUM(CASE WHEN lich_su >= 8 THEN 1 ELSE 0 END) as lich_su_level1, " +
            "SUM(CASE WHEN lich_su < 8 AND lich_su >= 6 THEN 1 ELSE 0 END) as lich_su_level2, " +
            "SUM(CASE WHEN lich_su < 6 AND lich_su >= 4 THEN 1 ELSE 0 END) as lich_su_level3, " +
            "SUM(CASE WHEN lich_su < 4 THEN 1 ELSE 0 END) as lich_su_level4, " +

            "SUM(CASE WHEN dia_li >= 8 THEN 1 ELSE 0 END) as dia_li_level1, " +
            "SUM(CASE WHEN dia_li < 8 AND dia_li >= 6 THEN 1 ELSE 0 END) as dia_li_level2, " +
            "SUM(CASE WHEN dia_li < 6 AND dia_li >= 4 THEN 1 ELSE 0 END) as dia_li_level3, " +
            "SUM(CASE WHEN dia_li < 4 THEN 1 ELSE 0 END) as dia_li_level4, " +

            "SUM(CASE WHEN gdcd >= 8 THEN 1 ELSE 0 END) as gdcd_level1, " +
            "SUM(CASE WHEN gdcd < 8 AND gdcd >= 6 THEN 1 ELSE 0 END) as gdcd_level2, " +
            "SUM(CASE WHEN gdcd < 6 AND gdcd >= 4 THEN 1 ELSE 0 END) as gdcd_level3, " +
            "SUM(CASE WHEN gdcd < 4 THEN 1 ELSE 0 END) as gdcd_level4 " +

            "FROM entrance_scores", nativeQuery = true)
    Map<String, Object> getReportStats();

    @Query(value = "SELECT sbd, toan, vat_li, hoa_hoc, (toan + vat_li + hoa_hoc) as total_score " +
            "FROM entrance_scores " +
            "WHERE entrance_group = 'NATURAL' " +
            "AND toan IS NOT NULL AND vat_li IS NOT NULL AND hoa_hoc IS NOT NULL " +
            "ORDER BY total_score DESC " +
            "LIMIT 10", nativeQuery = true)
    List<Map<String, Object>> findTop10GroupA();
}
