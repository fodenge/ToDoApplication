package com.natwest.lab.service;

import com.natwest.lab.entity.Task;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {
    Task createTask(Task task);
    List<Task> getAllTasks();
    Task updateTask(Task task, Long id);
    String deleteTask(Long id);
    boolean taskExistsById(Long id);
}
