package com.api.dto.exam;

import com.api.entity.Teacher;

import javax.persistence.Column;
import java.time.LocalDate;

public class ExamDto {
    private String subjectName;
    private LocalDate examDate;

    private String teacherName;
    private Integer semester;
    private String status;
}
