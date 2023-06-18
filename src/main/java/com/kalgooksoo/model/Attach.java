package com.kalgooksoo.model;

public class Attach extends Timestamped {
    private Long id;
    private Long boardId;
    private String name;
    private String pathname;
    private Long size;

    public Long getId() {
        return id;
    }

    public Long getBoardId() {
        return boardId;
    }

    public String getName() {
        return name;
    }

    public String getPathname() {
        return pathname;
    }

    public Long getSize() {
        return size;
    }
}
