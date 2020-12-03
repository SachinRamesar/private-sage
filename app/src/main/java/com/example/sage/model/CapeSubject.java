
package com.example.sage.model;
/**
 * Write a description of interface CapeSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CapeSubject extends Subject{

    private int unitNumber;
    
    public CapeSubject(String subjectName,int image){
        setName(subjectName);
        setImage(image);
        this.unitNumber = 1;
    }
    
    public CapeSubject(String subjectName, int image, int unitNumber){
        setName(subjectName);
        setImage(image);
        this.unitNumber = unitNumber;
    }
    
    //getters
    public int getUnitNumber(){
        return unitNumber;
    }

    //setters
    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }


    @Override
    public String toString(){
        return getName() + " Unit " + unitNumber;
    }
}
