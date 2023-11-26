package com.tarefa.backend.infra.controllers.repositories;

import com.tarefa.backend.adapters.TaskRepository;
import com.tarefa.backend.domain.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryImpl extends JpaRepository<Task, Long>, TaskRepository {
}
