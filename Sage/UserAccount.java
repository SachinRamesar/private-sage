
import java.util.ArrayList;
/**
 * Abstract class User - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class UserAccount {
    private String userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;
    //private ArrayList<Subject> subjects;
    //private CreditCard creditCard;
    
    public UserAccount(String firstName, String lastName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        //setUserId();
    }
   
    //method to verify password and email
    public boolean verifyLogin(String email, String password) {
        if(this.password == password && this.email == email)
            return true;
        return false;
    }
    
    //method to set userId where John Doe == john.doe and a next John Doe == john.doe1 similar to uwi email
    /*
     * private void setUserId() {
     *     int num = (checkUserId(firstName, lastName);
     *     if (num == 0){
     *          userId = firstName + "." + lastName;
     *     }
     *     userId = firstName + "." + lastName + num;
    }
     *
     */
    
    //
    /**
     * An example of a method - replace this comment with your own
     *
     * @param  y  a sample parameter for a method
     * @return    the sum of x and y
     */
    public int sampleMethod(int y)
    {
        // put your code here
        return y;
    }
}
