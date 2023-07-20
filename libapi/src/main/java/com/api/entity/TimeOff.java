package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name = "time_off")
public class TimeOff {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

//    @Column(name = "teacher_id", nullable = false)
//    private int teacherId;

    @Column (name = "teacher_name")
    @NotNull
    private String teacherName;

    @Column(name = "date_off")
    @NotNull
    private LocalDate dateOff;

    @Column(name = "status")
    private String status;

    @Column(name = "comment")
    private String comment;
}