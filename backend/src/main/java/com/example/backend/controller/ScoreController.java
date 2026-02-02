package com.example.backend.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.backend.dto.response.ReportResponse;
import com.example.backend.dto.response.ScoreResponse;
import com.example.backend.dto.response.TopStudentResponse;
import com.example.backend.service.CommonScoreService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/scores")
@RequiredArgsConstructor
public class ScoreController {
    private final CommonScoreService commonScoreService;

    @GetMapping
    public ResponseEntity<ScoreResponse> getScore(@RequestParam String sbd) {
        return ResponseEntity.ok(commonScoreService.checkScore(sbd));
    }

    @GetMapping("/report")
    public ResponseEntity<ReportResponse> getReport() {
        return ResponseEntity.ok(commonScoreService.getReportStats());
    }

    @GetMapping("/top10-group-a")
    public ResponseEntity<List<TopStudentResponse>> getTop10GroupA() {
        return ResponseEntity.ok(commonScoreService.getTop10GroupA());
    }
}
