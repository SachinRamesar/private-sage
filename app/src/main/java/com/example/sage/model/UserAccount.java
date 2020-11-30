package com.example.sage.model;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Abstract class User - write a description of the class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class UserAccount {
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phoneNumber;     //removing most likely
    private ArrayList<Subject> subjects;
    //private CreditCard creditCard;

    public UserAccount(){

    }
    
    public UserAccount(String firstName, String lastName, String email, String password, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        //setUsername();
    }
    
    //getters
    public String getUserName(){
        return username;
    }
    
    public String getFirstName(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public String getEmail(){
        return email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public ArrayList<Subject> getSubjects(){
        return subjects;
    }
    
    //setters   
    public void setFirstName(String firstName){
        this.firstName = firstName;
    }
    
    public void setLastName(String lastName){
        this.lastName = lastName;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
    
    public void setSubjects(ArrayList<Subject> subjectList){
        this.subjects = new ArrayList<Subject>(subjectList);
    }
    
    //methods
    public boolean verifyLogin(String email, String password) {
        if(this.password == password && this.email == email)
            return true;
        return false;
    }
    
    //method to set username where John Doe == john.doe and a next John Doe == john.doe1 similar to uwi email, uses database to
    /*
     * private void setUsername() {
     *     int num = (checkUsername(firstName, lastName);
     *     if (num == 0){
     *          username = firstName + "." + lastName;
     *     }
     *     username = firstName + "." + lastName + num;
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
