package com.springboot.springproj.EmployeeManagementSystem.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class EmployeeDto {

    private String name;
    private String email;
    private int age;
    private double salary;
    private String gender;
    private List<AddressDTO> addresses = new ArrayList<>();

}
