package com.api.service.impl;

import com.api.convert.ExamConverter;
import com.api.convert.TimeOffConverter;
import com.api.dto.exam.ExamDto;
import com.api.dto.exam.ViewExamDto;
import com.api.entity.Exam;
import com.api.entity.TimeOff;
import com.api.repository.ExamRepository;
import com.api.service.ExamService;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService{

  private final ExamRepository examRepository;
  @Override
  public ViewExamDto createExam(ExamDto examDto) {
    Exam newExam = Exam.builder().build();
    ExamConverter.mapExamDtoToExam(examDto , newExam);
    examRepository.save(newExam);
    return ExamConverter.convertExamToExamDto(newExam);
  }

  @Override
  public ViewExamDto updateExam(Integer id, ExamDto examDto) throws NotFoundException {
    Exam exam = examRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("Exam not found"));

    ExamConverter.mapExamDtoToExam(examDto, exam);
    exam = examRepository.save(exam);
    return ExamConverter.convertExamToExamDto(exam);
  }

  @Override
  public void deleteExam(Integer id) throws NotFoundException {
    if (!examRepository.existsById(id)) {
      throw new NotFoundException("Task not found");
    }
    examRepository.deleteById(id);
  }
  
}
