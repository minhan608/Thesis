package com.api.service;

import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import javassist.NotFoundException;

public interface TaskService {
    ViewTaskDto createTask(TaskDto taskDto);

    ViewTaskDto updateTask(Integer id,TaskDto taskDto) throws NotFoundException;

    void deleteTask (Integer id) throws NotFoundException;
}
