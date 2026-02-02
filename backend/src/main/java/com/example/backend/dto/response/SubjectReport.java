package com.example.backend.dto.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SubjectReport {
    private Long level1; // >= 8
    private Long level2; // 6 <= x < 8
    private Long level3; // 4 <= x < 6
    private Long level4; // < 4
}
