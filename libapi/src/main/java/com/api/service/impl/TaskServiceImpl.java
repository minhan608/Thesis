package com.api.service.impl;

import com.api.convert.TaskConverter;
import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.entity.Task;
import com.api.entity.User;
import com.api.exception.GlobalException;
import com.api.repository.TaskRepository;
import com.api.repository.UserRepository;
import com.api.service.TaskService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Slf4j
@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    private final UserRepository userRepository;

    private final TaskRepository taskRepository;

    @Override
    public ViewTaskDto createTask(TaskDto taskDto) {
      LocalDate current = LocalDate.now();
        Task newTask = Task.builder().createdAt(current).updatedAt(current).build();
        TaskConverter.mapTaskDtoToTask(taskDto , newTask);
        taskRepository.save(newTask);
        return TaskConverter.convertTaskToViewDTO(newTask);
    }

    @Override
    public ViewTaskDto updateTask(Integer id, TaskDto taskDto) throws NotFoundException {

        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Task not found"));
        
        LocalDate current = LocalDate.now();
        TaskConverter.mapTaskDtoToTask(taskDto, task);
        task.setUpdatedAt(current);
        task = taskRepository.save(task);
        return TaskConverter.convertTaskToViewDTO(task);
    }

    @Override
    public void deleteTask(Integer id) throws NotFoundException {
        if (!taskRepository.existsById(id)) {
            throw new GlobalException("Task not found", "Task not found", HttpStatus.NOT_FOUND);
        }
        taskRepository.deleteById(id);
    }

}
