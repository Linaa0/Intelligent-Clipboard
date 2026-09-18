package com.clipboard.manager.model;

import java.time.LocalDateTime;

public class Snippet {

    private final int id;
    private final String content;
    private final String type;
    private final LocalDateTime timestamp;

    public Snippet(int id, String content, String type) {
        this.id = id;
        this.content = content;
        this.type = type;
        this.timestamp = LocalDateTime.now();
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}