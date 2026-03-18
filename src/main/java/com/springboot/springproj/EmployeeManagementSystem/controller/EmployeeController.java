package com.springboot.springproj.EmployeeManagementSystem.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springproj.EmployeeManagementSystem.dto.AddressDTO;
import com.springboot.springproj.EmployeeManagementSystem.dto.EmployeeCreateDto;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    @GetMapping("/mock")
    public EmployeeCreateDto mock() {

        EmployeeCreateDto employeeDTO = new EmployeeCreateDto();
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

}
