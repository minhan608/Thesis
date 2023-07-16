package com.api.service;

import com.api.dto.student.StudentDto;
import com.api.dto.student.StudentRecordDto;
import com.api.entity.StudentRecord;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    void saveStudentRecord(MultipartFile file, Integer semester, Integer year) throws Exception;

    List<StudentDto> getListStudent();

    StudentRecordDto getRecord();
    
}
