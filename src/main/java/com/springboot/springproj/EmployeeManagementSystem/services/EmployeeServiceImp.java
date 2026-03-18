package com.springboot.springproj.EmployeeManagementSystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.springproj.EmployeeManagementSystem.dto.AddressDTO;
import com.springboot.springproj.EmployeeManagementSystem.dto.EmployeeDto;
import com.springboot.springproj.EmployeeManagementSystem.entity.Address;
import com.springboot.springproj.EmployeeManagementSystem.entity.Employee;
import com.springboot.springproj.EmployeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public String saveEmployee(EmployeeDto employeeDto) {

        Employee employee = Employee.builder().name(employeeDto.getName())
                .age(employeeDto.getAge()).email(employeeDto.getEmail())
                .salary(employeeDto.getSalary()).gender(employeeDto.getGender()).build();

        List<Address> addressList = new ArrayList<>();
        List<AddressDTO> addresses = employeeDto.getAddresses();

        for (AddressDTO adr : addresses) {

            Address address = new Address();
            address.setCity(adr.getCity());
            address.setState(adr.getState());
            address.setCountry(adr.getCountry());
            address.setStreet(adr.getStreet());
            address.setEmployee(employee);

            addressList.add(address);
        }

        employee.setAddresses(addressList);
        int id = employeeRepository.save(employee).getId();

        return "Employee saved successfully with id:" + id;
    }

}
