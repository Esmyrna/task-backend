package com.tarefa.backend.domain.entities.repositories;

import com.tarefa.backend.domain.entities.Task;

public interface ITask {
    Task save(Task task);
    Task getById(Long id);
}
