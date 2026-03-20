package com.springboot.springproj.StudentManagementSystem.services;

import com.springboot.springproj.StudentManagementSystem.dto.StudentDto;
import com.springboot.springproj.StudentManagementSystem.entity.Student;

public interface StudentService {

    String addStudent(StudentDto studentDto);

    Student findStudent(int id);

    String login(String email, String password);

    String updateStudent(StudentDto studentDto, int id);

}
