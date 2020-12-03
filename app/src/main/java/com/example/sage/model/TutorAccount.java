package com.example.sage.model;

import java.util.ArrayList;
/**
 * Write a description of class TutorAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TutorAccount extends UserAccount{

    private ArrayList<Class> classes;

    public TutorAccount(){

    }
    
    public TutorAccount(String fName, String lName, String email, String password) {
        super(fName, lName, email, password);
        classes = new ArrayList<Class>();
    }

   //getters


    public ArrayList<Class> getClasses(){
        return classes;
    }



    public void addClass(Class newClass){
        classes.add(newClass);
    }

    public void removeClass(Class newClass){
        classes.remove(newClass);
    }
}
