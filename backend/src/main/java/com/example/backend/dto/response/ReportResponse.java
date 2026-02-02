package com.example.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ReportResponse {
    private SubjectReport toan;
    private SubjectReport nguVan;
    private SubjectReport ngoaiNgu;
    private SubjectReport vatLi;
    private SubjectReport hoaHoc;
    private SubjectReport sinhHoc;
    private SubjectReport lichSu;
    private SubjectReport diaLi;
    private SubjectReport gdcd;
}
