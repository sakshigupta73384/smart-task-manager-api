package com.task.api.service;

import com.task.api.entity.Task;
import com.task.api.entity.User;
import com.task.api.repository.TaskRepository;
import com.task.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    TaskRepository taskRepo;

    @Autowired
    UserRepository userRepo;

    // Add Task

    public String addTask(Task task) {

        taskRepo.save(task);

        return "Task Added Successfully";
    }

    // Get All Tasks

    public List<Task> getTasks() {

        return taskRepo.findAll();
    }

    // Assign Task To User

    public String assignTask(Integer taskId, Integer userId) {

        Task task = taskRepo.findById(taskId).orElse(null);

        User user = userRepo.findById(userId).orElse(null);

        if (task != null && user != null) {

            task.setAssignedUser(user);

            taskRepo.save(task);

            return "Task Assigned Successfully";
        }

        return "Task or User Not Found";
    }

    // Update Status

    public String updateStatus(Integer id, String status) {

        Task task = taskRepo.findById(id).orElse(null);

        if (task != null) {

            task.setStatus(status);

            taskRepo.save(task);

            return "Task Status Updated";
        }

        return "Task Not Found";
    }

    // Delete Task

    public String deleteTask(Integer id) {

        taskRepo.deleteById(id);

        return "Task Deleted Successfully";
    }
}