package com.example.todoapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.todoapp.models.task;

public interface taskRepo extends JpaRepository<task, Long>{
    
}
