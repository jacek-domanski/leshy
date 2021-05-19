package com.example.Leshy;

public class Hello {
    private final String content;
    private final String data;
    
    public String getContent() {
        return content;
    }
    public String getData() {
        return data;
    }

    public Hello(String content, String data) {
        this.content = content;
        this.data = data;
    }
    
    @Override
    public String toString(){
        return String.format("Content: %s, Data: %s", content, data);
    }
    
}
