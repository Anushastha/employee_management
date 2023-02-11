package com.example.employee_management.services.impl;

import com.example.employee_management.Entity.Employee;
import com.example.employee_management.repo.EmployeeRepository;
import com.example.employee_management.services.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private EmployeeRepository employeeRepository;

    public StudentServiceImpl(EmployeeRepository employeeRepository) {
        super();
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllStudents() {
        return employeeRepository.findAll();
    }


    @Override
    public Employee saveStudent(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getStudentById(Long id) {
        return employeeRepository.findById(id).get();
    }

    @Override
    public Employee updateStudent(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteStudentById(Long id) {
        employeeRepository.deleteById(id);
    }

}
