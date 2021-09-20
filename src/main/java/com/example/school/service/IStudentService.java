package com.example.school.service;

import com.example.school.model.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    boolean save(Student student) throws Exception;
    List<Student> findAll();
    Optional<Student> findById(int id);
    void deleteById(int id);
}
