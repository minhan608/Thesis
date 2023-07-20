package com.api.service;

import com.api.dto.SubjectDto;
import com.api.entity.Subject;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface SubjectService {

    void uploadExcel(MultipartFile file, String name, String teacher,int semester, int year ) throws  Exception;

    Subject getResultFromDb();

    SubjectDto getResult(String name, String teacher, int semester, int year);

}
