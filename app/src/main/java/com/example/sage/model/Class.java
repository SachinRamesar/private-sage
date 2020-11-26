package com.example.sage.model;

import java.util.ArrayList;
/**
 * Write a description of class Class here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Class{
    private static int classCount = 0;
    private int classId;
    private String classDescription;
    private Subject subject;
    private double price;
    private int classCapacity;
    private ArrayList<ClassSession> classSessions;
    private ArrayList<StudentAccount> students;
  
    public Class(Subject subject, int capacity, String classDescription, ArrayList<ClassSession> classSessions,double price){
        classCount++;
        classId = classCount;
        this.classDescription = classDescription;
        this.subject = subject;
        this.classCapacity = capacity;
        this.classSessions = new ArrayList<ClassSession>(classSessions);
        this.students = new ArrayList<StudentAccount>();
        this.price = price;
    }

    //getters
    public int getClassId(){
        return classId;
    }
    
    public Subject getSubject(){
        return subject;
    }
    
    public int getClassSize(){
        return students.size();
    }
    
    public int getClassCapacity(){
        return classCapacity;
    }

    public int getNumSessions(){ return classSessions.size();}
    
    public String getClassDescription(){
        return classDescription;
    }

    public static int getClassCount() {
        return classCount;
    }

    public double getPrice() {
        return price;
    }


    //setters
    public void setCapacity(int capacity){
        this.classCapacity = capacity;
    }
    
    public void setClassDescription(String classDescription){
        this.classDescription = classDescription;
    }
    
    public void addSession(ClassSession classSession){
        classSessions.add(classSession);
    }
    
    public void removeSession(ClassSession classSession){
        classSessions.remove(classSession);
    }
    
    public boolean addStudent(StudentAccount student){
        if (getClassSize() < classCapacity){
            students.add(student);
            return true;
        }
        return false;
    }
    
    public void removeStudent(StudentAccount student){
        students.remove(student);
    }

}
