package com.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SubjectDto {

    private Integer noPassed;

    private Integer noFailed;

    private Integer noProhibited;

    private Integer noAbsent;

}
