package com.springboot.springbootannotations.services;

import com.springboot.springbootannotations.entity.Task;

import java.util.List;

public interface TaskService {
    Task createTask(Task task);
    Task getTaskById(Long id);
    List<Task> getAllTasks();
     Task updateTask(Task task);
     void delete(Long id);
}
