package com.springboot.springproj.EmployeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.springproj.EmployeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
