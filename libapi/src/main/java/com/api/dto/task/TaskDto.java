package com.api.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {

    private String name;
    private String taskStatus;
    private String taskType;
    private String comment;
    private LocalDate createdAt;
    private LocalDate updatedAt;


}
