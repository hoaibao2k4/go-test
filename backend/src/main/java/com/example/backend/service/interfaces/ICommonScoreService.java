package com.example.backend.service.interfaces;

import java.util.List;

import com.example.backend.dto.response.ReportResponse;
import com.example.backend.dto.response.ScoreResponse;
import com.example.backend.dto.response.TopStudentResponse;

public interface ICommonScoreService {
    ScoreResponse checkScore(String sbd);

    ReportResponse getReportStats();

    List<TopStudentResponse> getTop10GroupA();
}
