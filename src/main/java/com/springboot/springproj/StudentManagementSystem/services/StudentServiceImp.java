package com.springboot.springproj.StudentManagementSystem.services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springproj.StudentManagementSystem.dto.StudentDto;
import com.springboot.springproj.StudentManagementSystem.entity.Student;
import com.springboot.springproj.StudentManagementSystem.repository.StudentRepository;

@Service("studentimp")
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @SuppressWarnings("null")
    @Override
    public String addStudent(StudentDto studentDto) {

        Student student = new Student();

        // method-1
        // student.setName(studentDto.getName());
        // student.setAge(studentDto.getAge());
        // student.setEmail(studentDto.getEmail());
        // student.setGender(studentDto.getGender());
        // student.setMarks(studentDto.getMarks());
        // student.setPassword(studentDto.getPassword());
        // student.setStream(studentDto.getStream());

        // method-2
        // Student student2 = Student.builder()
        // .name(studentDto.getName())
        // .age(studentDto.getAge())
        // .email(studentDto.getEmail())
        // .gender(studentDto.getGender())
        // .marks(studentDto.getMarks())
        // .password(studentDto.getPassword())
        // .stream(studentDto.getStream())
        // .build();

        // method-3
        BeanUtils.copyProperties(studentDto, student);

        studentRepository.save(student);

        return "student data added with id:" + student.getId();

    }

    @Override
    public Student findStudent(int id) {

        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }

        return null;

    }

    @Override
    public String login(String email, String password) {
        Optional<Student> optionalStudent = studentRepository.findByEmail(email);
        if (optionalStudent.isPresent()) {

            Student student = optionalStudent.get();
            if (student.getPassword().equals(password)) {
                return "login successfull...";
            }

            else {
                return "wrong password!! login failed";
            }

        }

        return "no user found with this email...";
    }

    @SuppressWarnings("null")
    @Override
    public String updateStudent(StudentDto studentDto, int id) {

        Optional<Student> optionalstudent = studentRepository.findById(id);

        if (optionalstudent.isPresent()) {

            Student student = optionalstudent.get();

            if (studentDto.getName() != null) {
                student.setName(studentDto.getName());
            }

            if (studentDto.getAge() != 0) {
                student.setAge(studentDto.getAge());
            }

            if (studentDto.getMarks() != 0) {
                student.setMarks(studentDto.getMarks());
            }

            if (studentDto.getPassword() != null) {
                student.setPassword(studentDto.getPassword());
            }

            if (studentDto.getStream() != null) {
                student.setStream(studentDto.getStream());
            }

            if (studentDto.getGender() != null) {
                student.setGender(studentDto.getGender());
            }

            if (studentDto.getEmail() != null) {
                student.setEmail(studentDto.getEmail());

            }

            studentRepository.save(student);

            return "student obj is updated...";
        }

        return "no student found with this id...";
    }

}
