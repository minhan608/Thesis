package com.api.dto.task;

import com.api.dto.exam.ViewExamDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagingTaskDto {

    private Integer page;
    private Integer size;
    private List<ViewTaskDto> listTask;
}
