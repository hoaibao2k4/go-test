package com.example.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ScoreResponse {
    private String sbd;
    private String groupType;
    private Double toan;
    private Double nguVan;
    private Double ngoaiNgu;
    private Double vatLi;
    private Double hoaHoc;
    private Double sinhHoc;
    private Double lichSu;
    private Double diaLi;
    private Double gdcd;
}
