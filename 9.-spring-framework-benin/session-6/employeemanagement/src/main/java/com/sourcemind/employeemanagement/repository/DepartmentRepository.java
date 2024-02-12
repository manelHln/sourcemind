package com.sourcemind.employeemanagement.repository;

import com.sourcemind.employeemanagement.entity.Department;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
