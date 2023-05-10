package com.api.service;

import com.api.entity.StudentRecord;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface StudentService {
    void saveStudentRecord(MultipartFile file, Integer semester, Integer year) throws Exception;

}
