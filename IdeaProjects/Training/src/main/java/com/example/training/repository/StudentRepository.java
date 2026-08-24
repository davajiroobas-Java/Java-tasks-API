package com.example.training.repository;

// Vi importerar Student-klassen.
// Repository ska arbeta med Student-objekt.
import com.example.training.Student;

// JpaRepository ger oss färdiga metoder för databasen.
import org.springframework.data.jpa.repository.JpaRepository;


// StudentRepository är vårt repository för Student.
//
// Genom att ärva från JpaRepository får vi automatiskt
// många färdiga databasmetoder.
public interface StudentRepository
        extends JpaRepository<Student, Long> {

}