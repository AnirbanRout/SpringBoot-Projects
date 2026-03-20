package com.springboot.springproj.StudentManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springproj.StudentManagementSystem.dto.StudentDto;
import com.springboot.springproj.StudentManagementSystem.entity.Student;
import com.springboot.springproj.StudentManagementSystem.services.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    @Autowired
    @Qualifier("studentimp")
    private StudentService studentService;

    @GetMapping("/")
    public String homepage() {
        return "home page...";
    }

    @PostMapping("/save-student")
    public String saveStudent(@Valid @RequestBody StudentDto studentDto) {
        String msg = studentService.addStudent(studentDto);
        return msg;

    }

    @GetMapping("/find-student/{id}")
    public Student findStudent(@PathVariable("id") int id) {
        return studentService.findStudent(id);
    }

    @PostMapping("/login")
    public String login(@Valid @RequestParam String email, @RequestParam String password) {
        String msg = studentService.login(email, password);
        return msg;
    }

    @PutMapping("/update-student")
    public String updateStudent(@RequestBody StudentDto studentDto, @RequestParam int id) {

        return studentService.updateStudent(studentDto, id);

    }

}
