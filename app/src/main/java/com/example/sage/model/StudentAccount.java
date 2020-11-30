package com.example.sage.model;


import java.util.ArrayList;
/**
 * Write a description of class StudentAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudentAccount extends UserAccount{
    private ArrayList<Class> classes;
    private ArrayList<StudySession> studySessions;
    //private String educationLevel;

    public StudentAccount(){

    }
    public StudentAccount(String fName, String lName, String email, String password){
        super(fName, lName, email, password);
        classes = new ArrayList<Class>();
        //studySessions = new ArrayList<StudySession>();
        //this.educationLevel = educationLevel;
    }
    
    //getters
    public ArrayList<Class> getClasses(){
        return classes;
    }
    
    public ArrayList<StudySession> getStudySessions(){
        return studySessions;
    }
    
    /*
    public String getEducationLevel(){
        return educationLevel;
    }
    
    //setters
    /*public void setEducationLevel(String educationLevel){
        this.educationLevel = educationLevel;
    }
    */

    public void setClasses(ArrayList<Class> classes) {
        this.classes = classes;
    }

    public void setStudySessions(ArrayList<StudySession> studySessions) {
        this.studySessions = studySessions;
    }

    public void addClass(Class newClass){
        classes.add(newClass);
    }
    
    public void removeClass(Class newClass){
        classes.remove(newClass);
    }
    
    public void addStudySession(StudySession studySession){
        studySessions.add(studySession);
    }
    
    public void removeStudySession(StudySession studySession){
        studySessions.remove(studySession);
    }

}
