
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
    private int votes;
    private boolean hidden;
    
    public Review(String reviewDescription){
        this.reviewDescription = reviewDescription;
        votes = 1;
        hidden = false;
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
    
    public int getVotes(){
        return votes;
    }
    
    public boolean isHidden(){
        return hidden;
    }
    
    //setters
    public void setReviewDescription(String review){
        reviewDescription = review;
    }
    
    public void upvote(){
        votes += 1;
    }
    
    public void downvote(){
        votes -= 1;
        if (votes < -10)
            hidden = true;
    }
}
