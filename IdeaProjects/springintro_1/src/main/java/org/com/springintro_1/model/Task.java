package org.com.springintro_1.model;

public class Task {
    private Integer id;
    private String name;
    private Boolean done;

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