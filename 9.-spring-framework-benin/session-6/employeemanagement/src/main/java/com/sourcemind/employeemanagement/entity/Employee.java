package com.sourcemind.employeemanagement.entity;


import com.sourcemind.employeemanagement.enums.GenderType;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name="employee")
public class Employee implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true)
    private Integer id;

    @Column(name = "fistname", nullable = true)
    private String firstname;
    @Column(name = "lastname", nullable = true)
    private String lastname;
    @Column(name = "birthdate")
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;
    private String birthplace;
    @Enumerated(EnumType.STRING)
    private GenderType gender;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
}
