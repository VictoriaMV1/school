package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.model.Teacher;
import com.example.school.service.ClaseService;
import com.example.school.service.StudentService;
import com.example.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class SchoolController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add-student")
    public String addStudent(@RequestBody Student student) throws Exception {
        studentService.save(student);
        return "principal";
    }

    @GetMapping("/listar")
    public String principal(Model model){
        
        model.addAttribute("students", studentService.findAll());
        return "principal";
    }

    @GetMapping("/find-student/{id}")
    public String findStudent(@PathVariable int id, Model model){
        Optional<Student> optionalStudent = studentService.findById(id);

        if(optionalStudent.isPresent()){
            model.addAttribute("findStudent", optionalStudent.get());
            //return optionalStudent.get();
            return "principal";
        }
        return "No se encontro estudiante con ese ID";
    }

    @DeleteMapping(path = "/delete-student/{id}")
    public String deleteStudent(@PathVariable int id, Model model){
        Optional<Student> optionalStudent = studentService.findById(id);

        if(optionalStudent.isPresent()){
            model.addAttribute("studentDeleted", optionalStudent.get().getId());
            studentService.deleteById(id);
            return "principal";
        }
        model.addAttribute("studentNoExist", id);
        return "principal";
    }

    /* End Points para Teacher */

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/add-teacher")
    public String addTeacher(@RequestBody Teacher teacher) throws Exception {
        teacherService.save(teacher);
        return "principal2";
    }

    @GetMapping("/listarTeachers")
    public String listarTeachers(Model model){

        model.addAttribute("teachers", teacherService.findAll());
        return "principal2";
    }

    @GetMapping("/find-teacher/{id}")
    public String findTeacher(@PathVariable int id, Model model){
        Optional<Teacher> teacher = teacherService.findById(id);

        if(teacher.isPresent()){
            model.addAttribute("findTeacher", teacher.get());
            //return optionalStudent.get();
            return "principal2";
        }
        model.addAttribute("teacherNoExist", teacher.get().getName());
        return "principal2";
    }

    @DeleteMapping(path = "/delete-teacher/{id}")
    public String deleteTeacher(@PathVariable int id, Model model){
        Optional<Teacher> teacher = teacherService.findById(id);

        if(teacher.isPresent()){
            model.addAttribute("teacherDeleted", teacher.get().getId());
            teacherService.deleteById(id);
            return "principal2";
        }
        model.addAttribute("teacherNoExist", id);
        return "principal2";
    }

}
