package org.com.taskapi.repository;

import org.com.taskapi.model.Task;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


// repsoitory klassen ansvara för lagringen
// i och med annotationen @Repository så kommer Spring att skapa upp ett object (en bean) av Taskrepository klassen
// och sedan hålla reda på det objektet
@Repository
public class TaskRepository {
    private List<Task> tasks = new ArrayList<>();


    // när Taskrepositoryobjektet skapas lägg till lite dummy-data
    public TaskRepository() {
        tasks.add(new Task(1, "gurka", false));
        tasks.add(new Task(2, "mjölk", true));
        tasks.add(new Task(3, "citron", false));
    }

    public List<Task> findAll() {
        return tasks;
    }

    public void save(Task task)  {
        tasks.add(task);
    }

    public void delete(int id) {
        tasks.removeIf(task -> task.getId() == id);

    }

    public Task findById(int id) {
        return tasks.stream().filter(task -> task.getId() == id).findFirst().orElse(null);
    }

}