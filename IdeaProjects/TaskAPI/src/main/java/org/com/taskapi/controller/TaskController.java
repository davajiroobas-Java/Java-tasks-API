package org.com.taskapi.controller;

import org.com.taskapi.model.Task;
import org.com.taskapi.repository.TaskRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TaskController {
    private TaskRepository repository;

    // När spring skapar ett object av TaskController ( som den gör eftersom vi har @Restkontroller anotationen)
    // så kommer spring använda denna konstruktor. Eftersom vi säger att konstruktorn ska ta in ett TaskRepsoitory objekt
    // så kommer spring använda det Taskrepository objekt som den skapat åt oss
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    public ResponseEntity<Task> addTask(@Valid @RequestBody Task task) {
        repository.save(task);
        //return new ResponseEntity<>(task, HttpStatus.CREATED);
        return ResponseEntity.status(HttpStatus.CREATED).body(task);
    }


    @DeleteMapping("/tasks/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Void> deleteTask(@PathVariable int id) {
        Task task = repository.findById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        repository.delete(id);
        return ResponseEntity.noContent().build();
    }


    @PatchMapping("/tasks/{id}")
    public ResponseEntity<Task> patchTask(@PathVariable int id, @RequestBody Task updates) {
        Task task = repository.findById(id);

        if (task == null) {
            return ResponseEntity.notFound().build();
        }

        if (updates.getName() != null) {
            task.setName(updates.getName());
        }

        if (updates.getDone() != null) {
            task.setDone(updates.getDone());
        }

        return ResponseEntity.ok(task);
    }




}