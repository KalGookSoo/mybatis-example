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

}
