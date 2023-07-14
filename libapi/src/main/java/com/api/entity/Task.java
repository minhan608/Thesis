package com.api.entity;

import com.api.common.TaskStatus;
import com.api.common.TaskType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Table(name = "task")
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
    // @Enumerated(EnumType.STRING)
    // private TaskStatus taskStatus;

    private String status;

    @NotNull
    private LocalDateTime deadline;

    private LocalDate createdAt;

    private LocalDate  updatedAt;

    private String comment;
}
