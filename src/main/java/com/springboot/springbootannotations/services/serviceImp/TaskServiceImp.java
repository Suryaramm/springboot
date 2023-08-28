package com.springboot.springbootannotations.services.serviceImp;

import com.springboot.springbootannotations.Respository.TaskRepository;
import com.springboot.springbootannotations.entity.Task;

import com.springboot.springbootannotations.services.TaskService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskServiceImp implements TaskService {
    private TaskRepository taskRepository;
    @Override
    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task getTaskById(Long id) {

        Optional<Task> optionalTask =taskRepository.findById(id);
        return optionalTask.get();
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTask(Task task) {
        Task exitTask=taskRepository.findById(task.getId()).get();
        exitTask.setDescription(task.getDescription());
        exitTask.setStatus(task.getStatus());
        exitTask.setStartDate(task.getStartDate());
        exitTask.setEndDate(task.getEndDate());
        Task updatedTask=taskRepository.save(exitTask);
        return updatedTask;
    }

    @Override
    public void delete(Long id) {
     taskRepository.deleteById(id);
    }
}
