package org.com.springintro_1.repository;


 import org.com.springintro_1.model.Task;
import org.springframework.stereotype.Repository;

 import java.util.ArrayList;
 import java.util.List;



//Repository klassen ansvara för lagringen
// i och med annotationen @Repository så kommer Spring att skapa upp ett object (en bean) av Taskrepository klassen
// och sedan hålla reda på det objektet
@Repository
public class TaskRepository {
    private final List<Task>tasks= new ArrayList<>();


    // när TaskRepositoryObjektet skapas lägg till lite dummy-data
    public TaskRepository() {
        tasks.add(new Task(1, "gurka", false));
        tasks.add(new Task(2, "mjölk", true));
        tasks.add(new Task(3, "citron", false));
    }
    public List<Task>findAll(){
        return tasks;
    }

    public void saved (Task task){
        tasks.add(task);
    }
    public void delete(int id){
        tasks.removeIf(task -> task.getId()== id);
    }

   // public void updateTask( int id, Task updates){
       // Task task =findById(id);
      //  if()

   // }

    public Task findById(int id){
        return tasks.stream().filter(task -> task.getId()==id).findFirst().orElse(null);
    }

    public void save(Task task) {
        tasks.add(task);
    }
}
