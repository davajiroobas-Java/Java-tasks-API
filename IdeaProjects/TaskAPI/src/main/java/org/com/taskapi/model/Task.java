package org.com.taskapi.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Task {
    private Integer id;

    @NotBlank(message = "Name have to have a value")
    @Size(min=2, message = "Name must be at leats 2 characters")
    private String name;

    @NotNull(message = "Done must be true or false")
    private Boolean done;

//    @Email
//    private String email;

    public Task() {}

    public Task(Integer id, String name, Boolean done) {
        this.id = id;
        this.name = name;
        this.done = done;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }
}