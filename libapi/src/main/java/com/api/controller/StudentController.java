package com.api.controller;

import com.api.dto.student.StudentDto;
import com.api.dto.student.StudentRecordDto;
import com.api.exception.ResponseMessage;
import com.api.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file, @RequestParam Integer semester, @RequestParam Integer year) throws Exception {
        studentService.saveStudentRecord(file, semester, year);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<StudentDto>> getStudentList() {
        return new ResponseEntity<>(studentService.getListStudent(), HttpStatus.OK);
    }

    @GetMapping("/record")
    public ResponseEntity<StudentRecordDto> getRecord() {
        return new ResponseEntity<>(studentService.getRecord(), HttpStatus.OK);
    }
}
