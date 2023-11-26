package com.tarefa.backend.infra.controllers;

import com.tarefa.backend.adapters.TaskDTO;
import com.tarefa.backend.application.TaskImpl;
import com.tarefa.backend.domain.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    private final TaskImpl taskServiceImpl;
    @Autowired
    public TaskController(TaskImpl taskServiceImpl) {
        this.taskServiceImpl = taskServiceImpl;
    }

    @GetMapping("/list-tasks")
    public List<Task> listAllTasks() {
        return taskServiceImpl.listAllTasks();
    }

    @PostMapping("/create")
    public void createTask(@RequestBody TaskDTO taskDTO){
        taskServiceImpl.createTask(taskDTO);
    }

    @PutMapping("/completed/{id}")
    public ResponseEntity<TaskDTO> completedTask(@PathVariable Long id) {
        TaskDTO markedTask = taskServiceImpl.markAsCompleted(id);
        if(markedTask != null) {
         return  ResponseEntity.ok(markedTask);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> DeleteTask(@PathVariable  Long id){
        taskServiceImpl.DeleteTask(id);
        return ResponseEntity.ok().build();
    }
}
