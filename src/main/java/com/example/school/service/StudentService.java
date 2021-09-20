package com.example.school.service;

import com.example.school.model.Student;
import com.example.school.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements IStudentService {

    @Autowired
    IStudentRepo studentRepo;

    @Override
    public boolean save(Student student) throws Exception {
        studentRepo.save(student);
        return false;
    }

    @Override
    public List<Student> findAll() {
        List<Student> students = studentRepo.findAll();
        return students;
    }

    @Override
    public Optional<Student>  findById(int id){
        return studentRepo.findById(id);
    }

    @Override
    public void deleteById(int id){
        studentRepo.deleteById(id);
    }
}
