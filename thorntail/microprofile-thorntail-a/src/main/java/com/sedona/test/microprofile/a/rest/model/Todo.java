package com.sedona.test.microprofile.a.rest.model;

public class Todo {

    private String title;
    private String description;

    public Todo() {
    }

    private Todo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public static Todo create(String title, String description) {
        return new Todo(title, description);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}

