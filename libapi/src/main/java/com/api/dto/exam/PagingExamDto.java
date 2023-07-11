package com.api.dto.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagingExamDto {

    private Integer page;
    private Integer size;
    private List<ViewExamDto> listExam;
}
