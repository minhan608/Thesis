package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "subject")
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  Integer id;
    private Integer noPassed;

    private Integer noFailed;

    private Integer noProhibited;

    private Integer noAbsent;

    private String name;
    private String teacher;
    private Integer semester;
    private Integer year;

}
