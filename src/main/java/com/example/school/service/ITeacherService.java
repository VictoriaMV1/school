package com.example.school.service;

import com.example.school.model.Teacher;

import java.util.List;
import java.util.Optional;

public interface ITeacherService {
    boolean save(Teacher teacher) throws Exception;
    List<Teacher> findAll();
    Optional<Teacher> findById(int id);
    void deleteById(int id);
}
