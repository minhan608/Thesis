package com.api.controller;

import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.dto.timeoff.TimeOffDto;
import com.api.dto.timeoff.ViewTimeOffDto;
import com.api.entity.Task;
import com.api.entity.TimeOff;
import com.api.service.TaskService;
import com.api.service.TimeOffService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/time")
public class TimeOffController {

    private final TimeOffService timeOffService;

    @PostMapping()
    public ResponseEntity<ViewTimeOffDto> createTask(@RequestBody TimeOffDto timeOffDto) {
        return new ResponseEntity<ViewTimeOffDto>(timeOffService.createTime(timeOffDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViewTimeOffDto> updateTask(
            @RequestBody TimeOffDto timeOffDto, @PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<ViewTimeOffDto>(timeOffService.updateTime(id,timeOffDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask( @PathVariable Integer id) throws NotFoundException {
        timeOffService.deleteTime(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TimeOff>> getList() throws NotFoundException {
        return new ResponseEntity<>(timeOffService.getList(),HttpStatus.OK);
    }
}
