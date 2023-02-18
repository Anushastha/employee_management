package com.example.employee_management.services;

import com.example.employee_management.Entity.Task;

import java.util.List;


public interface TaskService {
    List<Task> getAllTask();

    Task saveTask(Task task);

    Task getTaskById(Long id);

    Task updateTask(Task task);

    void deleteTaskById(Long id);

}
