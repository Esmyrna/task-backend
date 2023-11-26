package com.tarefa.backend.adapters;

import com.tarefa.backend.domain.entities.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Task save(Task task);
    Optional<Task> findById(Long id);
}


