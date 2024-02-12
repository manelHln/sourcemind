package com.sourcemind.employeemanagement.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

    private String code;
    private String name;

    @OneToMany(mappedBy = "department")
    private Set<Employee> employees;
}
