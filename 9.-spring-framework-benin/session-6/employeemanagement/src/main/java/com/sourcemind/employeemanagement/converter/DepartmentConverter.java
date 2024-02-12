package com.sourcemind.employeemanagement.converter;

import com.sourcemind.employeemanagement.dto.DepartmentDto;
import com.sourcemind.employeemanagement.entity.Department;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentConverter {
    public DepartmentDto convert(Department department){
        ModelMapper modelMapper = new ModelMapper();
        DepartmentDto departmentDto = modelMapper.map(department, DepartmentDto.class);
        return departmentDto;
    }

    public List<DepartmentDto> convert(List<Department> departments){
        List<DepartmentDto> converted = new ArrayList<>();
        for(Department department: departments){
           converted.add(convert(department)) ;
        }
        return converted;
    }

}
