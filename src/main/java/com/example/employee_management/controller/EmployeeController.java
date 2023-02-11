package com.example.employee_management.controller;

import com.example.employee_management.Entity.Employee;
import com.example.employee_management.services.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private StudentService studentService;

    public EmployeeController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    // handler method to handle list employee and return mode and view
    @GetMapping("/employee")
    public String listStudents(Model model) {
        model.addAttribute("employee", studentService.getAllStudents());
        return "employee";
    }

    @GetMapping("/employee/new")
    public String createStudentForm(Model model) {

        // create employee object to hold employee form data
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "create_employee";

    }

    @PostMapping("/employee")
    public String saveStudent(@ModelAttribute("employee") Employee employee) {
        studentService.saveStudent(employee);
        return "redirect:/employee";
    }

    @GetMapping("/employee/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_employee";
    }

    @PostMapping("/employee/{id}")
    public String updateStudent(@PathVariable Long id,
                                @ModelAttribute("employee") Employee employee,
                                Model model) {

        // get employee from database by id
        Employee existingEmployee = studentService.getStudentById(id);
        existingEmployee.setId(id);
        existingEmployee.setFirstName(employee.getFirstName());
        existingEmployee.setLastName(employee.getLastName());
        existingEmployee.setEmail(employee.getEmail());

        // save updated employee object
        studentService.updateStudent(existingEmployee);
        return "redirect:/employee";
    }

    // handler method to handle delete employee request

    @GetMapping("/employee/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/employee";
    }

}
