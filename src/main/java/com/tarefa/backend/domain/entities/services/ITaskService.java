package com.tarefa.backend.domain.entities.services;

import com.tarefa.backend.domain.entities.Task;

public interface ITaskService {
    Task createTask(String description);
    void markAsCompleted(Long id);
}
