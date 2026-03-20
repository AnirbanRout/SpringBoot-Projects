package com.springboot.springproj.StudentManagementSystem.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StudentDto {

    @NotBlank(message = "please enter name")
    private String name;

    @NotNull(message = "please enter age")
    private int age;

    @NotBlank(message = "please enter email")
    @Email(message = "please enter proper email")
    private String email;

    @NotBlank(message = "please enter password")
    private String password;

    @NotBlank(message = "please enter gender")
    private String gender;

    private int marks;

    @NotBlank(message = "please enter stream")
    private String stream;

}
