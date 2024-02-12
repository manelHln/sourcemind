package com.sourcemind.employeemanagement.controller;

import com.sourcemind.employeemanagement.dto.DepartmentDto;
import com.sourcemind.employeemanagement.entity.Department;
import com.sourcemind.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartementController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> getAll(){

        return new ResponseEntity<>(departmentService.getAll(), HttpStatus.OK);
    }
}
