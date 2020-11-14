import java.util.ArrayList;
/**
 * Write a description of class TutorAccount here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class TutorAccount extends UserAccount{
    // instance variables - replace the example below with your own
    private String userDescription;
    private double ratings;
    private int numberOfRatings;
    //private ArrayList<Review> reviews;
    //private ArrayList<Subject> subjects;
    //private ArrayList<Class> classes;
   

   public TutorAccount(String fName, String lName, String email, String password, String phoneNumber) {
        super(fName, lName, email, password, phoneNumber);
        userDescription = "";
        numberOfRatings = 0;
        ratings = 0.0;
   }
    
   public void setUserDescription(String description){
        userDescription = description;
   }
    
   public void updateRating(double rating){
        double totalRating = ratings * numberOfRatings;
        numberOfRatings += 1;
        ratings =(totalRating + rating)/numberOfRatings * 1.0;
        
   }
    /*
    public void addReview(String review, StudentAccount student){
        Review = new Review(review, 
        reviews.add(review);
    }
    
    */

}
