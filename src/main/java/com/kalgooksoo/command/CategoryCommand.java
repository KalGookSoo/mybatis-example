package com.kalgooksoo.command;

public class CategoryCommand {
    private Long id;
    private String name;

    public CategoryCommand(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryCommand() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
