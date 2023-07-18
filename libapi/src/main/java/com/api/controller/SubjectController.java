package com.api.controller;

import com.api.dto.SubjectDto;
import com.api.entity.Subject;
import com.api.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subject")
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping("/upload")
    public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file ,@RequestParam("name") String name, @RequestParam("teacher") String teacher, @RequestParam("semester") int semester, @RequestParam("year") int year) throws Exception {
        subjectService.uploadExcel(file,name,teacher,semester,year);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/detail")
    ResponseEntity<SubjectDto> getResultByProperty( @RequestParam("name") String name, @RequestParam("teacher") String teacher, @RequestParam("semester") int semester, @RequestParam("year") int year) throws Exception {
        return new ResponseEntity<>(subjectService.getResult(name,teacher,semester,year),HttpStatus.OK);
    }

    @GetMapping
    ResponseEntity<Subject> getResult( ) {
        return new ResponseEntity<>(subjectService.getResultFromDb(),HttpStatus.OK);
    }
}
