package com.api.dto.student;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDto {
    private Integer id;
    private String studentId;

    private String name;

    private String status;

    private int noStudy;

    private int noReserved;

    private int noDrop;
}
