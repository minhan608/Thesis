package com.api.convert;

import com.api.dto.exam.ExamDto;
import com.api.dto.exam.ViewExamDto;
import com.api.entity.Exam;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

public class ExamConverter {

    private static final ModelMapper viewExam;

    private static final ModelMapper saveExamMapper;

    private static final ObjectMapper patchObjectMapper;

    private ExamConverter() {
    }

    static {
        viewExam = getViewDataMapper();

        saveExamMapper = getSaveDataMapper();

        patchObjectMapper = new ObjectMapper();
    }

    public static ViewExamDto convertExamToExamDto(Exam exam) {
        return viewExam.map(exam, ViewExamDto.class);
    }

    public static void mapExamDtoToExam(ExamDto examDto, Exam exam) {
        viewExam.map(examDto, exam);
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
