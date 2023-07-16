package com.api.dto.student;

import lombok.Data;

import java.util.List;

@Data
public class PagingStudentDto {

    private Integer page;
    private Integer size;
    private List<StudentDto> listStudent;
}
