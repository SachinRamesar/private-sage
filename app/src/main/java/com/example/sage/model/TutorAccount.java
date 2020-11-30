package com.example.sage.model;

import java.util.ArrayList;
/**
 * Write a description of class TutorAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TutorAccount extends UserAccount{

    private String userDescription;
    private double ratings;
    private int numberOfRatings;
    private ArrayList<Review> reviews;
    private ArrayList<Class> classes;

    public TutorAccount(){

    }
    
    public TutorAccount(String fName, String lName, String email, String password, String phoneNumber) {
        super(fName, lName, email, password, phoneNumber);
        userDescription = "";
        ratings = 0.0;
        numberOfRatings = 0;
        reviews = new ArrayList<Review>();
        classes = new ArrayList<Class>();
    }
   
   //getters
    public String getUserDescription(){
       return userDescription;
    }
    
    public double getRatings(){
        return ratings;
    }
    
    public int getNumberOfRatings(){
        return numberOfRatings;
    }
    
    public ArrayList<Review> getReviews(){
        return reviews;
    }
    
    public ArrayList<Class> getClasses(){
        return classes;
    }

    //setters
    public void setUserDescription(String description){
        userDescription = description;
    }
   
    public void updateRating(double rating){
        double totalRating = ratings * numberOfRatings;
        numberOfRatings++;
        ratings =(totalRating + rating)/numberOfRatings * 1.0;

    }
    
    public void addReview(Review review){
        reviews.add(review);
    }
    
    public void addClass(Class newClass){
        classes.add(newClass);
    }
    
    public void removeClass(Class newClass){
        classes.remove(newClass);
    }
}
