package com.api.convert;

import com.api.dto.SubjectDto;
import com.api.dto.student.StudentDto;
import com.api.entity.StudentRecord;
import com.api.entity.Subject;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class SubjectConverter {
    private static final ModelMapper viewSubjectMapper;

    private static final ModelMapper subjectMapper;

    private static final ObjectMapper patchObjectMapper;

    private SubjectConverter() {
    }

    static {
        viewSubjectMapper = getViewDataMapper();

        subjectMapper = getSaveDataMapper();

        patchObjectMapper = new ObjectMapper();
    }

    public static SubjectDto convertRecordToSubjectDto(Subject subject) {
        return viewSubjectMapper.map(subject, SubjectDto.class);
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
