package com.api.dto.timeoff;

import com.api.dto.exam.ViewExamDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PagingTimeOffDto {

    private Integer page;
    private Integer size;
    private List<TimeOffDto> listTimeOff;
}
