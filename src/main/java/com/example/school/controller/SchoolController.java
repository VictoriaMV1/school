package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.service.StudentService;
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

}
