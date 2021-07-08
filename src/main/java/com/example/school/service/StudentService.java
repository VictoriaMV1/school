package com.example.school.service;

import com.example.school.model.Student;
import com.example.school.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepo studentRepo;

    @Override
    public boolean save(Student student) throws Exception {
        studentRepo.save(student);
        return false;
    }

    @Override
    public boolean findAll() {
        return false;
    }
}
