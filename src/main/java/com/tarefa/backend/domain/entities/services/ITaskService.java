package com.tarefa.backend.domain.entities.services;

import com.tarefa.backend.domain.entities.Task;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskService {
    Task createTask(String description);
    void markAsCompleted(Long id);
}
