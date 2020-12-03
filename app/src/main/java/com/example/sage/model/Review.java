package com.example.sage.model;

/**
 * Write a description of class Review here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Review{
    private static int count = 0;
    private int reviewId;
    private String reviewDescription;
    private int upVotes;
    private int downVotes;
    
    public Review(String reviewDescription){
        this.reviewDescription = reviewDescription;
        upVotes = 0;
        downVotes = 0;
        count++;
        reviewId = count;
    }
    
    //getters
    public int getReviewId(){
        return reviewId;
    }
    
    public String getReviewDescription(){
        return reviewDescription;
    }
    
    public int getUpVotes(){
        return upVotes;
    }
    
    public int getDownVotes(){
        return downVotes;
    }
    
    //setters
    public void setReviewDescription(String review){
        reviewDescription = review;
    }
    
    public void upVote(){
        upVotes += 1;
    }

    public void downVote(){
        downVotes += 1;
    }

}
