package com.example.employee_management.services;

import com.example.employee_management.Entity.Employee;

import java.util.List;

public interface StudentService {
    List<Employee> getAllStudents();

    Employee saveStudent(Employee employee);

    Employee getStudentById(Long id);

    Employee updateStudent(Employee employee);

    void deleteStudentById(Long id);
}
