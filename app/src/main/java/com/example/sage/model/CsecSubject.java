package com.example.sage.model;

import com.example.sage.model.Subject;

public class CsecSubject implements Subject {

    private String name;
    private int image;

    public CsecSubject(String subjectName, int image){
        this.name = subjectName;
        this.image = image;
    }

    public String getName(){
        return name;
    }

    public int getImage(){
        return image;
    }


    public void setSubjectName(String subjectName) {
        this.name = subjectName;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
