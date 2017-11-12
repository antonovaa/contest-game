package com.model;

/**
 * Created by Lord on 01.10.2017.
 */
public class Greeting {
    private String content;
    private String name ;

    public Greeting(String content, String name) {
        this.content = content;
        this.name = name;
    }

    public Greeting(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
