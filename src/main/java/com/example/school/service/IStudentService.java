package com.example.school.service;

import com.example.school.model.Student;

public interface IStudentService {
    boolean save(Student student) throws Exception;
    boolean findAll();
}
