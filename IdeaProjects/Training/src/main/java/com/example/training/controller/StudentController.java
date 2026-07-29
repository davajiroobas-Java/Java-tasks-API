package com.example.training.controller;

import com.example.training.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {




    private List<Student> students=new ArrayList<>();

    private Integer nextId=1;


    //Create student  with ID

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){

        student.setId(nextId++);
        students.add(student);

        return student;
    }

    // Fetch All Students



    // Fetch Students by id and use @PathVariable(req.params)
    @GetMapping("/students/{id}")
    public Student getStudentById(@PathVariable Integer id){

        for(Student student: students){
            if(student.getId().equals(id)){
                return student;
            }
        }
        return null;
    }


    // Fetch Students by searching name and use @RequestParam(query-parameter)
    @GetMapping("/students/search")
    public List<Student> searchStudents(@RequestParam String name) {

        List<Student> result = new ArrayList<>();

        for (Student student : students) {
            if (student.getName().equalsIgnoreCase(name)) {
                result.add(student);
            }
        }

        return result;
    }


  // To update user/student  by id use both @PathVariable and @RequestBody
    @PutMapping("/students/{id}")
    public Student updateStudent(@PathVariable Integer id,
                                 @RequestBody Student updatedStudent) {

        for (Student student : students) {

            if (student.getId().equals(id)) {

                student.setName(updatedStudent.getName());
                student.setAge(updatedStudent.getAge());

                return student;
            }
        }

        return null;
    }


    //To remove a student by id, just use @PathVariable
    @DeleteMapping("/students/{id}")
    public String deleteStudent(@PathVariable Integer id) {

        for (Student student : students) {

            if (student.getId().equals(id)) {

                students.remove(student);

                return "Student borttagen";
            }
        }

        return "Student hittades inte";
    }

}
