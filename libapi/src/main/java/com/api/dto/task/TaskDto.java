package com.api.dto.task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TaskDto {

    private String name;
    private String taskStatus;
    private LocalDateTime deadline;
    private String comment;

}
