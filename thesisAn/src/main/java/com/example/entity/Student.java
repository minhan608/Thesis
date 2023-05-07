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
@Table (name = "student")
public class Student {

    @Id
    private  Integer id;
    @NotNull
    private String studentId;

    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private StudentStatus studentStatus;

    @NotNull
    private String semester;

    private String year;
}
