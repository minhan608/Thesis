package com.api.entity;

import com.api.common.StudentStatus;
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
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private  Integer id;
    @NotNull
    private String studentName;

    @NotNull
    private String studentId;

    // @Enumerated(EnumType.STRING)
    // private StudentStatus studentStatus;

    private String status;

    @NotNull
    private Integer semester;

    @NotNull
    private Integer year;

    private Integer noStudy;

    private Integer noReserved;

    private Integer noDrop;
}
