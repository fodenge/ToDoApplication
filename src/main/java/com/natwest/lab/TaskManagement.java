package com.natwest.lab;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TaskManagement {
    public static void main(String[] args){
        SpringApplication.run(TaskManagement.class,args);
    }
}
