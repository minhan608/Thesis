package com.api.controller;

import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.entity.Task;
import com.api.exception.ResponseMessage;
import com.api.service.StudentService;
import com.api.service.TaskService;
import javassist.NotFoundException;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/task")
public class TaskController {

    private final TaskService taskService;

    @PostMapping()
    public ResponseEntity<ViewTaskDto> createTask(@RequestBody TaskDto taskDto) {
        return new ResponseEntity<ViewTaskDto>(taskService.createTask(taskDto),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViewTaskDto> updateTask(
            @RequestBody TaskDto taskDto, @PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<ViewTaskDto>(taskService.updateTask(id,taskDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask( @PathVariable Integer id) throws NotFoundException {
        taskService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
