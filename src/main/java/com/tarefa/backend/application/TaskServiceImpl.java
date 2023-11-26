package com.tarefa.backend.application;

import com.tarefa.backend.domain.entities.Task;
import com.tarefa.backend.domain.entities.repositories.ITask;
import com.tarefa.backend.domain.entities.services.ITaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl {
    private final ITaskService iTaskService;
    private final ITask iTask;
    @Autowired
    public TaskServiceImpl(ITaskService iTaskService, ITask iTask) {
        this.iTaskService = iTaskService;
        this.iTask = iTask;
    }

    public Task createTask(String description){
        Task task = new Task();
        task.setDescription(description);
        return iTask.save(task);
    }

    public void markAsCompleted(Long id) {
        Task task = iTask.getById(id);
        if(task != null) {
            task.setCompleted(true);
            iTask.save(task);
        }
        throw new IllegalArgumentException("Tarefa não encontrada com ID: " + id);
    }
}
