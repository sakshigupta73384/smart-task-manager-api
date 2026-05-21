package com.task.api.controller;

import com.task.api.entity.Task;
import com.task.api.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService service;

    // Add Task

    @PostMapping("/addTask")
    public String addTask(@RequestBody Task task) {

        return service.addTask(task);
    }

    // Get Tasks

    @GetMapping("/tasks")
    public List<Task> getTasks() {

        return service.getTasks();
    }

    // Assign Task

    @PutMapping("/assign/{taskId}/{userId}")
    public String assignTask(@PathVariable Integer taskId,
                             @PathVariable Integer userId) {

        return service.assignTask(taskId, userId);
    }

    // Update Status

    @PutMapping("/updateStatus/{id}")
    public String updateStatus(@PathVariable Integer id,
                               @RequestParam String status) {

        return service.updateStatus(id, status);
    }

    // Delete Task

    @DeleteMapping("/delete/{id}")
    public String deleteTask(@PathVariable Integer id) {

        return service.deleteTask(id);
    }
}