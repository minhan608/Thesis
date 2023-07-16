package com.api.controller;

import com.api.dto.exam.ExamDto;
import com.api.dto.exam.ViewExamDto;
import com.api.entity.Exam;
import com.api.service.ExamService;
import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/exam")
public class ExamController {
    private final ExamService examService;

    @PostMapping()
    public ResponseEntity<ViewExamDto> createExam(@RequestBody ExamDto examDto) {
        return new ResponseEntity<ViewExamDto>(examService.createExam(examDto), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ViewExamDto> updateExam(
            @RequestBody ExamDto examDto, @PathVariable Integer id) throws NotFoundException {
        return new ResponseEntity<ViewExamDto>(examService.updateExam(id,examDto),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExam( @PathVariable Integer id) throws NotFoundException {
        examService.deleteExam(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Exam>> getExam()  {
        return new ResponseEntity<>(examService.getList(),HttpStatus.OK);
    }
}
