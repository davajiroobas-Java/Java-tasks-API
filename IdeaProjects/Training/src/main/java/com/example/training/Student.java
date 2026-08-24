package com.example.training;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


// @Entity talar om för JPA/Hibernate att den här Java-klassen
// ska kopplas till en tabell i databasen.
//
// Klassen Student blir alltså en databas-entity.
@Entity
public class Student {


    // @Id betyder att detta fält är primärnyckeln (Primary Key).
    //
    // Varje student måste ha ett unikt id.
    //
    // Exempel:
    // Student 1 -> id = 1
    // Student 2 -> id = 2
    // Student 3 -> id = 3
    @Id

    // @GeneratedValue betyder att ID:t ska genereras automatiskt.
    //
    // GenerationType.IDENTITY betyder att databasen själv
    // skapar nästa ID.
    //
    // Vi behöver alltså inte själva göra:
    // id = 1
    // id = 2
    // id = 3
    //
    // PostgreSQL sköter detta.
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    // Studentens namn.
    //
    // Eftersom detta är ett vanligt fält kommer JPA/Hibernate
    // skapa en kolumn för name i databastabellen.
    private String name;


    // Studentens ålder.
    //
    // int i Java motsvarar normalt INTEGER i PostgreSQL.
    private int age;


    // Tom constructor.
    //
    // JPA/Hibernate behöver kunna skapa ett Student-objekt
    // utan att vi skickar in några värden.
    //
    // Därför ska den finnas.
    public Student() {

    }


    // Constructor som gör det möjligt att skapa en Student
    // med age och name direkt.
    //
    // Exempel:
    // new Student(36, "Soma");
    public Student(int age, String name) {

        this.age = age;
        this.name = name;
    }


    // Getter för id.
    //
    // Används för att läsa studentens ID.
    //
    // Exempel:
    // student.getId();
    public Long getId() {
        return id;
    }


    // Getter för name.
    //
    // Används för att läsa studentens namn.
    //
    // Exempel:
    // student.getName();
    public String getName() {
        return name;
    }


    // Setter för name.
    //
    // Används för att ändra studentens namn.
    //
    // Exempel:
    // student.setName("Anna");
    public void setName(String name) {

        this.name = name;
    }


    // Getter för age.
    //
    // Används för att läsa studentens ålder.
    //
    // Exempel:
    // student.getAge();
    public int getAge() {

        return age;
    }


    // Setter för age.
    //
    // Används för att ändra studentens ålder.
    //
    // Exempel:
    // student.setAge(37);
    public void setAge(int age) {

        this.age = age;
    }
}