package org.com.springintro_1.controller;

import org.com.springintro_1.model.Task;
import org.com.springintro_1.repository.TaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

public class TaskController {
    private final TaskRepository repository;


    // När spring skapar ett object av TaskController ( som den gör eftersom vi har @Restkontroller anotationen)
    // så kommer spring använda denna konstruktör. Eftersom vi säger att constructor ska ta in ett TaskRepsoitory objekt
    // så kommer spring använda det TaskRepository objekt som den skapat åt oss
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    @PostMapping("/tasks")
    public String addTask(@RequestBody Task task) {
        repository.save(task);
        return "Task added";
    }


    //Delete /tasks/{id}
    @DeleteMapping("/tasks/{id}")
    public String deleteTask(@PathVariable int id) {
        repository.delete(id);

        return "Task deleted";
    }

    @PatchMapping("/tasks/{id}")
    public String updateTask(@PathVariable int id, @RequestBody Task updates) {
        Task task = repository.findById(id);
        if (task == null) {
            return "Task not found";
        }
        if (updates.getName() != null) {
            task.setName(updates.getName());
        }
        if (updates.getDone() != null) {
            task.setDone(updates.getDone());
        }
        return "Task updated";
    }
}