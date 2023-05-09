package com.example.entity;

import com.example.common.StudentStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table (name = "student_record")
public class StudentRecord {

    @Id
    private  Integer id;
    @NotNull
    private String studentId;

    @NotNull
    private String studentName;

    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    @NotNull
    private Integer semester;

    @NotNull
    private Integer year;
}
