package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import com.api.common.ExamStatus;

import java.time.LocalDate;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "exam")
public class Exam {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "teacher_id")
    // private Teacher teacher;

    @Column(name = "teacher")
    private String teacher;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "exam_date")
    private LocalDate examDate;

    @Column(name = "semester")
    private Integer semester;

    @Column(name = "status")
    private String status;
}
