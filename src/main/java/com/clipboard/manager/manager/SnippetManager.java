package com.clipboard.manager.manager;

import com.clipboard.manager.model.Snippet;

import java.util.LinkedHashMap;
import java.util.Map;

public class SnippetManager {

    private final Map<Integer, Snippet> snippets = new LinkedHashMap<>();

    private int nextId = 1;

    public Snippet addSnippet(String content, String type) {

        Snippet snippet = new Snippet(
                nextId,
                content,
                type
        );

        snippets.put(nextId, snippet);

        nextId++;

        return snippet;
    }

    public Map<Integer, Snippet> getSnippets() {
        return snippets;
    }

    public int getSize() {
        return snippets.size();
    }
}