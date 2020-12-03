package com.example.sage.model;

public abstract class Subject {
    private String name;
    private int image;

    //getters
    public String getName(){
        return name;
    }
    public int getImage(){
        return image;
    }

    //setters
    public void setName(String subjectName) {
        this.name = subjectName;
    }
    public void setImage(int image) {
        this.image = image;
    }
}
