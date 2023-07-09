package com.kalgooksoo.command;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class BoardCommand {
    private Long id;

    @NotNull
    private Long categoryId;

    @NotBlank
    private String author;

    @NotBlank
    private String title;

    @NotBlank
    private String content;

    public BoardCommand() {
    }

    public BoardCommand(Long categoryId) {
        this.categoryId = categoryId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
