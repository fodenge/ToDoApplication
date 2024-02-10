package com.natwest.lab.service;

import com.natwest.lab.entity.Task;
import com.natwest.lab.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    TaskRepository repository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        repository = taskRepository;
    }

    @Override
    public Task createTask(Task task) {
        return repository.save(task);
    }

    @Override
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @Override
    public Task updateTask(Task task, Long id){
        repository.save(task);
        return task;
    }

    @Override
    public String deleteTask(Long id){
        repository.deleteById(id);
        return "Success";
    }

    @Override
    public boolean taskExistsById(Long id){
        return repository.existsById(id);
    }
}
