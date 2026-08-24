package com.example.training.controller;

import com.example.training.Student;
import com.example.training.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
// @RestController talar om för Spring Boot att den här klassen
// ska fungera som en REST Controller.
// Den tar emot HTTP-anrop från exempelvis Postman eller en frontend.
@RestController

// Alla endpoints i den här controllern börjar med /students.
// Exempel:
// GET    /students
// GET    /students/1
// POST   /students
// DELETE /students/1
@RequestMapping("/students")

// Vi skapar en Controller-klass som heter StudentController.
public class StudentController {


    // Vi deklarerar StudentService som ett beroende.
    // "private" betyder att variabeln bara kan användas i denna klass.
    // "final" betyder att variabeln måste få sitt värde när objektet skapas
    // och sedan inte kan pekas om till ett annat objekt.
    private final StudentService studentService;


    // Constructor för StudentController.
    //
    // Spring Boot skickar automatiskt in StudentService här.
    // Detta kallas Constructor Injection.
    //
    // Vi behöver alltså inte själva skriva:
    // studentService = new StudentService(...)
    //
    // Spring sköter det åt oss.
    public StudentController(StudentService studentService) {

        // Vi sparar StudentService som vi fick från Spring
        // i klassens studentService-variabel.
        this.studentService = studentService;
    }


    // @GetMapping("/{id}") betyder:
    // Kör denna metod när klienten skickar GET till exempelvis:
    //
    // GET /students/1
    // GET /students/2
    // GET /students/10
    //
    // {id} är en variabel del av URL:en.
    @GetMapping("/{id}")

    // Metoden returnerar en Student.
    //
    // @PathVariable hämtar id från URL:en.
    //
    // Om klienten skickar:
    // GET /students/5
    //
    // blir:
    // id = 5
    public Student getStudentById(@PathVariable Long id) {

        // Vi skickar id vidare till StudentService.
        //
        // Service-lagret får ansvaret för att hitta studenten.
        //
        // Resultatet från service returneras sedan till klienten.
        return studentService.getStudentById(id);
    }


    // @GetMapping utan någon path betyder:
    // GET /students
    //
    // Den här metoden används för att hämta ALLA studenter.
    @GetMapping

    // Metoden returnerar en List med Student-objekt.
    //
    // Exempel på resultat:
    //
    // [
    //     {"id": 1, "name": "Soma", "age": 36},
    //     {"id": 2, "name": "Anna", "age": 25}
    // ]
    public List<Student> getStudents() {

        // Vi ber StudentService att hämta alla studenter.
        return studentService.getStudents();
    }


    // @PostMapping betyder att metoden körs när klienten
    // skickar ett POST-anrop till:
    //
    // POST /students
    //
    // POST används vanligtvis för att skapa en ny student.
    @PostMapping

    // @RequestBody betyder att Spring ska läsa JSON från requestens body
    // och omvandla JSON:en till ett Student-objekt.
    //
    // Om klienten skickar:
    //
    // {
    //     "name": "Soma",
    //     "age": 36
    // }
    //
    // skapar Spring ett Student-objekt av JSON:en.
    public Student createStudent(@RequestBody Student student) {

        // Vi skickar Student-objektet till StudentService.
        //
        // Service-lagret kommer sedan att spara studenten
        // genom StudentRepository.
        return studentService.createStudent(student);
    }


    // @DeleteMapping("/{id}") betyder:
    // Kör metoden när klienten skickar DELETE till exempelvis:
    //
    // DELETE /students/1
    //
    // {id} kommer från URL:en.
    @DeleteMapping("/{id}")

    // @PathVariable hämtar id från URL:en.
    //
    // Om klienten skickar:
    // DELETE /students/3
    //
    // blir:
    // id = 3
    public void deleteStudent(@PathVariable Long id) {

        // Vi skickar id till StudentService.
        //
        // Service-lagret kommer sedan be Repository
        // att radera studenten från databasen.
        studentService.deleteStudent(id);
    }

}