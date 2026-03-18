package com.springboot.springproj.EmployeeManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springproj.EmployeeManagementSystem.dto.AddressDTO;
import com.springboot.springproj.EmployeeManagementSystem.dto.EmployeeDto;
import com.springboot.springproj.EmployeeManagementSystem.entity.Employee;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @GetMapping("/mock")
    public EmployeeDto mock() {

        EmployeeDto employeeDTO = new EmployeeDto();
        employeeDTO.setName("Raj");
        employeeDTO.setAge(16);
        employeeDTO.setGender("Male");
        employeeDTO.setEmail("raju123@gmail.com");
        employeeDTO.setSalary(30000);

        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setCity("Patna");
        addressDTO.setStreet("Action Area 3");
        addressDTO.setState("Bihar");
        addressDTO.setCountry("India");

        List<AddressDTO> addresses = new ArrayList<>();
        addresses.add(addressDTO);

        employeeDTO.setAddresses(addresses);

        return employeeDTO;

    }

    @PostMapping("/mock2")
    public String savEmployee(EmployeeDto employeeDto) {

        return "employee object saved...";

    }

}
