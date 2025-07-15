package com.example.todoapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.todoapp.models.task;
import com.example.todoapp.service.taskService;



@Controller
public class taskControllr {

      @Autowired
      private taskService taskService;

@GetMapping
private String getTasks(Model model){
    List<task> tasks = taskService.getAlltasks();
    model.addAttribute("tasks", tasks);
    return "tasks";
}

@PostMapping
private String createTask(@RequestParam String title){
    taskService.createTask(title);
    return "redirect:/";
    
}
@GetMapping("/{id}/delete")
private String deleteTasks(@PathVariable Long id){
    taskService.deleteTask(id);
    return "redirect:/";
}
@GetMapping("/{id}/toggle")
private String toggleTasks(@PathVariable Long id){
    taskService.toggleTask(id);
    return "redirect:/";
}

    
}
