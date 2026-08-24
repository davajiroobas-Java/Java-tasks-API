package com.example.training;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication talar om för Spring Boot att detta
// är huvudklassen för applikationen.
//
// Annotationen aktiverar bland annat:
// 1. Spring Boot configuration
// 2. Component scanning
// 3. Auto-configuration
//
// Spring börjar alltså leta efter exempelvis:
// @Controller
// @RestController
// @Service
// @Repository
// @Entity
@SpringBootApplication
public class TrainingApplication {


    // main() är programmets startpunkt i Java.
    //
    // När vi startar applikationen börjar Java köra
    // programmet härifrån.
    public static void main(String[] args) {


        // SpringApplication.run() startar Spring Boot.
        //
        // TrainingApplication.class talar om för Spring
        // vilken huvudklass den ska använda.
        //
        // args innehåller eventuella argument som skickas
        // när applikationen startas.
        //
        // När denna rad körs startar bland annat:
        // - Spring
        // - Tomcat
        // - Controllers
        // - Services
        // - Repositories
        // - JPA/Hibernate
        // - Databasanslutningen
        SpringApplication.run(TrainingApplication.class, args);
    }

}