package com.api.service;

import com.api.dto.exam.ExamDto;
import com.api.dto.exam.ViewExamDto;
import com.api.dto.task.TaskDto;
import com.api.dto.task.ViewTaskDto;

import com.api.entity.Exam;
import javassist.NotFoundException;

import java.util.List;

public interface ExamService {
  ViewExamDto createExam(ExamDto examDto);

  ViewExamDto updateExam(Integer id,ExamDto examDto) throws NotFoundException;

  void deleteExam (Integer id) throws NotFoundException;

  List<Exam> getList();
}
