package com.natwest.lab.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table (name = "taskManagement")
public class Task {
    @Id
    private Long id;
    private String description;
    private String status;

    @Override
    public String toString() {
        return "ToDo{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
