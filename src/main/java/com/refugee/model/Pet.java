package com.refugee.model;

public class Pet {
    private String type;
    private String name;

    public Pet(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }
}
