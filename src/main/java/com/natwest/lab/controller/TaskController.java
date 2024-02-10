package com.natwest.lab.controller;

import com.natwest.lab.customHandler.TaskNotFound;
import com.natwest.lab.entity.Task;
import com.natwest.lab.service.TaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {
    private Logger logger = LoggerFactory.getLogger ( this.getClass ( ) );

    @Autowired
    TaskService service;

    @PostMapping ( "/create")
    public Task saveTask(@RequestBody Task task){
        logger.info("Task created");
        return service.createTask(task);
    }

    @GetMapping("/get")
    public List<Task> getAllTasks(){
        logger.info("Tasks displayed");
        return service.getAllTasks();
    }

    @PutMapping("/update/{id}")
    public Object updateTask(@RequestBody Task task,@PathVariable Long id){
        try {
            if (service.taskExistsById(id)) {
                logger.info("Task {} updated", id);
                return service.updateTask(task, id);
            }
            throw new TaskNotFound();
        }catch(TaskNotFound e){
                logger.error("Task not found");
        }
            return "Task doesn't exist";
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteById(@PathVariable Long id){
        try {
            if (service.taskExistsById(id)){
                    service.deleteTask(id);
                    logger.warn("Task {} deleted",id);
                    return new ResponseEntity<>("Task removed successfully", HttpStatus.OK);
            }
            throw new TaskNotFound();
        }catch (TaskNotFound e){
            logger.error("Task not found");
        }
        return new ResponseEntity<>("Task doesn't exist",HttpStatus.NOT_FOUND);
    }
}
