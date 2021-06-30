package com.example.controller;

import com.example.model.Student;
import com.example.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SchoolController {

    @Autowired
    private IStudentRepo studentRepo;

    @GetMapping("/agregar")
    public String principal(@RequestParam(name="name", required = false, defaultValue = "Wold") String name, Model model){
        Student s = new Student();
        s.setName("Vic");
        s.setAddress("Sancio");
        studentRepo.save(s);
        model.addAttribute("name", name);
        return "principal";
    }

    @GetMapping("/listar")
    public String principal(Model model){
        
        model.addAttribute("students", studentRepo.findAll());
        return "principal";
    }
}
