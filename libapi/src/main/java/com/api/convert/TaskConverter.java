package com.api.convert;

import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.entity.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class TaskConverter {
    private static final ModelMapper viewTaskMapper;

    private static final ModelMapper saveTaskMapper;

    private static final ObjectMapper patchObjectMapper;

    private TaskConverter() {
    }

    static {
        viewTaskMapper = getViewDataMapper();

        saveTaskMapper = getSaveDataMapper();

        patchObjectMapper = new ObjectMapper();
    }

    public static ViewTaskDto convertTaskToViewDTO(Task task) {
        return viewTaskMapper.map(task, ViewTaskDto.class);
    }

    public static void mapTaskDtoToTask(TaskDto taskDto, Task task) {
        saveTaskMapper.map(taskDto, task);
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
