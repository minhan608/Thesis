package com.api.dto.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ViewExamDto {

    private Integer id;
    private String subjectName;
    private LocalDate examDate;

    private String teacherName;
    private Integer semester;
    private String status;
}
