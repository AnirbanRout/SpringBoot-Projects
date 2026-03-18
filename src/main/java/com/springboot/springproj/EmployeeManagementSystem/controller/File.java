
package com.springboot.springproj.EmployeeManagementSystem.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class File {

    @GetMapping("/")
    public String res1() {
        return "Landing Page";
    }

    @GetMapping("/login")
    public String res() {
        return "Login Page";
    }

}