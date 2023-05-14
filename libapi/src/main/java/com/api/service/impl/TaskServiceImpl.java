package com.api.service.impl;

import com.api.convert.TaskConverter;
import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.entity.Task;
import com.api.entity.User;
import com.api.repository.TaskRepository;
import com.api.repository.UserRepository;
import com.api.service.TaskService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final UserRepository userRepository;

    private final TaskRepository taskRepository;

    @Override
    public ViewTaskDto createTask(TaskDto taskDto) {
        LocalDate currentDate = LocalDate.now();
        Task newTask = Task.builder().createdAt(LocalDate.now()).updatedAt(LocalDate.now()).build();
        TaskConverter.mapTaskDtoToTask(taskDto , newTask);
        taskRepository.save(newTask);
        return TaskConverter.convertTaskToViewDTO(newTask);
    }

    @Override
    public ViewTaskDto updateTask(Integer id, TaskDto taskDto) throws NotFoundException {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));

        TaskConverter.mapTaskDtoToTask(taskDto, task);
        task.setUpdatedAt(LocalDate.now());
        task = taskRepository.save(task);
        return TaskConverter.convertTaskToViewDTO(task);
    }

    @Override
    public void deleteTask(Integer id) throws NotFoundException {
        if (!taskRepository.existsById(id)) {
            throw new NotFoundException("Task not found");
        }
        taskRepository.deleteById(id);
    }

}
