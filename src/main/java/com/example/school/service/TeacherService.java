package com.example.school.service;

import com.example.school.model.Teacher;
import com.example.school.repository.ITeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService implements ITeacherService{

    @Autowired
    ITeacherRepo teacherRepo;

    @Override
    public boolean save(Teacher teacher) throws Exception {
        teacherRepo.save(teacher);
        return false;
    }

    @Override
    public List<Teacher> findAll() {
        List<Teacher> teachers = teacherRepo.findAll();
        return teachers;
    }

    @Override
    public Optional<Teacher> findById(int id) {
        return teacherRepo.findById(id);
    }

    @Override
    public void deleteById(int id) {
        teacherRepo.deleteById(id);
    }
}
