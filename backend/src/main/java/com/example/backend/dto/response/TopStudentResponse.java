package com.example.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class TopStudentResponse {
    private String sbd;
    private Double toan;
    private Double vatLi;
    private Double hoaHoc;
    private Double totalScore;
}
