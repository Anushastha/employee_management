package com.example.employee_management.controller;
import com.example.employee_management.Entity.Employee;
import com.example.employee_management.Entity.Task;
import com.example.employee_management.services.TaskService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

public class TaskController {

    private TaskService taskService;
    public TaskController(TaskService taskService) {
        super();
        this.taskService = taskService;
    }

    @GetMapping("/task")
    public String getTaskPage(Model model) {
        return "task";
    }

//    @GetMapping("/tasks")
//    public String listTask(Model model) {
//        model.addAttribute("task", taskService.getAllTask());
//        return "task";
//    }
    @GetMapping("/tasklist")
    public String getTask(Model model) {
        List<Task> tasks = taskService.getAllTask();
        model.addAttribute("task", tasks.stream().map(task ->
                        Task.builder()
                                .id(task.getId())
//                        .imageBase64(getImageBase64(user.getImage()))
                                .employee_name(task.getEmployee_name())
                                .task_assigned(task.getTask_assigned())
                                .assigned_date(task.getAssigned_date())
                                .build()
        ));
//        model.addAttribute("UPLOAD_DIRECTORY", "/" + UPLOAD_DIRECTORY);
        return "task";
    }
    @GetMapping("/task/new")
    public String createTaskForm(Model model) {
        Task task = new Task();
        model.addAttribute("task", task);
        return "addTask";
    }

    @PostMapping("/task/save")
    public String saveTask(@ModelAttribute("task") Task task) {
        taskService.saveTask(task);
        return "redirect:/task";
    }

    @GetMapping("/task/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("task", taskService.getTaskById(id));
        return "edit_employee";
    }

    @PostMapping("/task/{id}")
    public String updateTask(@PathVariable Long id,
                                 @ModelAttribute("task") Task task,
                                 Model model) {

        // get task from database by id
        Task existingTask = taskService.getTaskById(id);
        existingTask.setId(id);
        existingTask.setTask_assigned(task.getTask_assigned());
        existingTask.setAssigned_date(task.getAssigned_date());

        // save updated task object
        taskService.updateTask(existingTask);
        return "redirect:/task";
    }
    @GetMapping("/task/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return "redirect:/task";
    }
}
