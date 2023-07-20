package com.api.dto.exam;

import com.api.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExamDto {
    private String subjectName;
    private LocalDate examDate;

    private String teacher;
    private Integer semester;
    private String status;

    private String comment;
}
