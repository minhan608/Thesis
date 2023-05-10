package com.api.entity;

import com.api.common.TaskStatus;
import com.api.common.TaskType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
    private Integer id;

    @NotNull
    private String name;
    @Enumerated(EnumType.STRING)
    private TaskStatus taskStatus;
    @Enumerated(EnumType.STRING)
    private TaskType taskType;

    private LocalDateTime createdAt;

    private LocalDateTime  updatedAt;
}
