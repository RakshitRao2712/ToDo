package com.example.todoapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todoapp.models.task;
import com.example.todoapp.repository.taskRepo;

@Service
public class taskService {
    @Autowired
    private taskRepo taskRepo;

    public List<task> getAlltasks(){
        return taskRepo.findAll();
    }

    public void createTask(String title) {
        task task = new task();
        task.setTitle(title);
        task.setCompleted(false);
        taskRepo.save(task);
    }

    public void deleteTask(Long id) {
        taskRepo.deleteById(id);
    }

    public void toggleTask(Long id) {
        task task = taskRepo.findById(id)
                      .orElseThrow(()-> new IllegalArgumentException("Invalid task id"));
                      task.setCompleted(!task.isCompleted());
                      taskRepo.save(task);
    }
}
