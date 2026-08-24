package com.example.training.service;


// Vi importerar Student eftersom Service arbetar
// med Student-objekt.
import com.example.training.Student;


// Vi importerar StudentRepository.
// Repository används för att kommunicera med databasen.
import com.example.training.repository.StudentRepository;


// @Service talar om för Spring Boot att denna klass
// är ett Service-lager.
//
// Spring skapar automatiskt ett objekt av StudentService
// och gör det tillgängligt för andra klasser.
import org.springframework.stereotype.Service;

import java.util.List;


// Detta är Service-klassen för Student.
@Service
public class StudentService {


    // Vi sparar en referens till StudentRepository.
    //
    // "private" betyder att variabeln bara används
    // inne i denna klass.
    //
    // "final" betyder att repository-referensen inte
    // kan bytas ut efter att objektet skapats.
    private final StudentRepository studentRepository;


    // Constructor Injection.
    //
    // Spring skickar automatiskt in StudentRepository
    // när StudentService skapas.
    public StudentService(StudentRepository studentRepository) {

        // Vi sparar repository-objektet i vår variabel.
        this.studentRepository = studentRepository;
    }


    // Hämtar EN student baserat på ID.
    //
    // Exempel:
    // GET /students/1
    public Student getStudentById(Long id) {

        // findById() är en färdig metod från JpaRepository.
        //
        // Eftersom vårt repository använder Long:
        //
        // JpaRepository<Student, Long>
        //
        // kan vi skicka Long direkt.
        //
        // findById() returnerar Optional<Student>.
        //
        // orElse(null) betyder:
        // Om studenten finns → returnera studenten.
        // Om studenten inte finns → returnera null.
        return studentRepository.findById(id).orElse(null);
    }


    // Hämtar ALLA studenter.
    //
    // Exempel:
    // GET /students
    public List<Student> getStudents() {

        // findAll() är en färdig metod från JpaRepository.
        //
        // Den hämtar alla rader från student-tabellen.
        return studentRepository.findAll();
    }


    // Skapar en ny student.
    //
    // Exempel:
    // POST /students
    public Student createStudent(Student student) {

        // save() sparar studenten i databasen.
        //
        // Eftersom ID:t genereras av databasen behöver
        // vi normalt inte sätta ID själva.
        return studentRepository.save(student);
    }


    // Raderar en student baserat på ID.
    //
    // Exempel:
    // DELETE /students/1
    public void deleteStudent(Long id) {

        // deleteById() är en färdig metod från JpaRepository.
        //
        // Den raderar studenten med det angivna ID:t.
        studentRepository.deleteById(id);
    }
}