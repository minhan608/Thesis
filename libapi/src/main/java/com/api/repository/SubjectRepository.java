package com.api.repository;

import com.api.entity.Subject;
import com.api.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {

    List<Subject> findAllByNameAndTeacherAndSemesterAndYear(String name, String teacher, int semester, int year);
}
