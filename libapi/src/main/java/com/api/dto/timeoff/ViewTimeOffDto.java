package com.api.dto.timeoff;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViewTimeOffDto {

    private Integer id;

    private String teacherName;
    private LocalDate dateOff;

    private String status;

    private String comment;
}
