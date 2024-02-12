package com.sourcemind.employeemanagement.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @GetMapping()
    public ResponseEntity<?> getAll(){

        return new ResponseEntity<>("Hello world", HttpStatus.OK);
    }


}
