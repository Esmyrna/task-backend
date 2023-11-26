package com.tarefa.backend.application;

import com.tarefa.backend.adapters.TaskDTO;
import com.tarefa.backend.adapters.TaskRepository;
import com.tarefa.backend.domain.entities.Task;
import com.tarefa.backend.domain.entities.cases.ITask;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskImpl implements ITask {

    private final TaskRepository taskRepository;

    public TaskImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> listAllTasks(){
        return taskRepository.findAll();
    }

    @Override
    public Task createTask(TaskDTO taskDTO) {
        Task newTask = new Task();
        newTask.setDescription(taskDTO.description());
        newTask.setCompleted(false);

        return taskRepository.save(newTask);
    }

    @Override
    public TaskDTO markAsCompleted(Long id) {
        Optional<Task> existingTaskOptional = taskRepository.findById(id);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();

            existingTask.setCompleted(true);
            taskRepository.save(existingTask);

            return new TaskDTO(existingTask.getDescription(), existingTask.isCompleted());
        }

        return null;
    }
}