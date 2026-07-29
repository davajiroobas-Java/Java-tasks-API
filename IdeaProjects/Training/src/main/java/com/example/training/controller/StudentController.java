package com.example.training.controller;

import com.example.training.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;


@RestController
public class StudentController {


@GetMapping("/hello")
    public String hello(){
    return  "Hello from java!";
}





}
