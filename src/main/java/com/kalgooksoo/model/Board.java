package com.kalgooksoo.model;

public class Board extends Timestamped {
    private Long id;
    private Long categoryId;
    private String author;
    private Integer hit;
    private String content;

    public Long getId() {
        return id;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public Integer getHit() {
        return hit;
    }

    public String getContent() {
        return content;
    }
}
