package com.api.convert;

import com.api.dto.student.StudentDto;
import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;
import com.api.entity.StudentRecord;
import com.api.entity.Task;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class StudentConverter {
    private static final ModelMapper viewStudentMapper;

    private static final ModelMapper studentMapper;

    private static final ObjectMapper patchObjectMapper;

    private StudentConverter() {
    }

    static {
        viewStudentMapper = getViewDataMapper();

        studentMapper = getSaveDataMapper();

        patchObjectMapper = new ObjectMapper();
    }

    public static StudentDto convertRecordToStudentDto(StudentRecord studentRecord) {
        return viewStudentMapper.map(studentRecord, StudentDto.class);
    }

    private static ModelMapper getViewDataMapper() {
        return getDefaultModelMapper();
    }

    private static ModelMapper getSaveDataMapper() {
        return getDefaultModelMapper();
    }

    private static ModelMapper getDefaultModelMapper() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        return modelMapper;
    }
}
