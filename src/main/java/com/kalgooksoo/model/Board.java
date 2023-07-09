package com.kalgooksoo.model;

public class Board extends Timestamped {
    private Long id;
    private Long categoryId;
    private String author;
    private String title;
    private Integer hit;
    private String content;

    public Board() {
    }

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public Integer getHit() {
        return hit;
    }

    public String getContent() {
        return content;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
