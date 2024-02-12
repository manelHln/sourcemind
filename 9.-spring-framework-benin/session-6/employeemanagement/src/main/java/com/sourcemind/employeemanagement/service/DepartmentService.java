package com.sourcemind.employeemanagement.service;


import com.sourcemind.employeemanagement.converter.DepartmentConverter;
import com.sourcemind.employeemanagement.dto.DepartmentDto;
import com.sourcemind.employeemanagement.entity.Department;
import com.sourcemind.employeemanagement.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private DepartmentConverter departmentConverter;

    public List<DepartmentDto> getAll(){

        List<Department> departments = departmentRepository.findAll();

        return departmentConverter.convert(departments);
    }
}
