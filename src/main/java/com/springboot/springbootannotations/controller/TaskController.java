package com.springboot.springbootannotations.controller;

import com.springboot.springbootannotations.entity.Task;
import com.springboot.springbootannotations.entity.User;
import com.springboot.springbootannotations.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("api/tasks")
public class TaskController {
    private TaskService taskService;

    @PostMapping
    public ResponseEntity<Task> creteTask(@RequestBody Task task){
        Task savedTask= taskService.createTask(task);
        return new ResponseEntity<>(savedTask, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id){
        Task task= taskService.getTaskById(id);
        return new ResponseEntity<>(task,HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<Task>> getAllTasks(){
        List<Task>  listAllTasks=taskService.getAllTasks();
        return new ResponseEntity<>(listAllTasks,HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Task> updateUser(@PathVariable Long id,
                                           @RequestBody Task task){
        task.setId(id);
        Task updatedTask=  taskService.updateTask(task);
        return new ResponseEntity<>(updatedTask,HttpStatus.OK);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return new ResponseEntity<>("user deleted successfully",HttpStatus.OK);
    }
}
