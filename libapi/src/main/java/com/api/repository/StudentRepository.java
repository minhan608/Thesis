package com.api.repository;

import com.api.entity.StudentRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentRecord,Integer> {

    List<StudentRecord> findAllBySemesterAndYear(int semester, int year);
}
