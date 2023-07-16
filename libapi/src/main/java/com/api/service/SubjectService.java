package com.api.service;

import com.api.dto.SubjectDto;
import com.api.entity.Subject;
import org.springframework.web.multipart.MultipartFile;

public interface SubjectService {

    void uploadExcel(MultipartFile file, String name, String teacher,int semester, int year ) throws  Exception;

    SubjectDto getResult(String name, String teacher, int semester, int year);
}
