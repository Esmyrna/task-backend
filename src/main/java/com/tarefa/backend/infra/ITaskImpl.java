package com.tarefa.backend.infra;

import com.tarefa.backend.domain.entities.Task;
import com.tarefa.backend.domain.entities.repositories.ITask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskImpl extends JpaRepository<Task, Long>,ITask {
}
