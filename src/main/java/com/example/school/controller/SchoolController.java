package com.example.school.controller;

import com.example.school.model.Student;
import com.example.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
}
