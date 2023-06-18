package com.kalgooksoo.model;

public class Comment extends Timestamped {
    private Long id;
    private Long boardId;
    private String author;
    private String content;

    public Long getId() {
        return id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public String getAuthor() {
        return author;
    }

    public String getContent() {
        return content;
    }
}
