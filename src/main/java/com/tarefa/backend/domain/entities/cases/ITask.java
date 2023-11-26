package com.tarefa.backend.domain.entities.cases;

import com.tarefa.backend.adapters.TaskDTO;
import com.tarefa.backend.domain.entities.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface ITask {
    List<Task> listAllTasks();
    Task createTask(TaskDTO taskDTO);
    TaskDTO markAsCompleted(Long id);

}
