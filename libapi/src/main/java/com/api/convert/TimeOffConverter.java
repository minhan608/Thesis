package com.api.convert;

import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.dto.timeoff.TimeOffDto;
import com.api.dto.timeoff.ViewTimeOffDto;
import com.api.entity.Task;
import com.api.entity.TimeOff;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class TimeOffConverter {

    private static final ModelMapper viewTimeMapper;

    private static final ModelMapper timeMapper;

    private static final ObjectMapper patchObjectMapper;

    private TimeOffConverter() {
    }

    static {
        viewTimeMapper = getViewDataMapper();

        timeMapper = getSaveDataMapper();

        patchObjectMapper = new ObjectMapper();
    }

    public static ViewTimeOffDto convertTimeOffToTimeOffDTO(TimeOff timeOff) {

        return viewTimeMapper.map(timeOff, ViewTimeOffDto.class);
    }

    public static void mapTimeOffDtoToTimeOff(TimeOffDto timeOffDto, TimeOff timeOff) {
        timeMapper.map(timeOffDto, timeOff);
    }

    private static ModelMapper getViewDataMapper() {
        return getDefaultModelMapper();
    }

    private static ModelMapper getSaveDataMapper() {
        return getDefaultModelMapper();
    }

    private static ModelMapper getDefaultModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}
