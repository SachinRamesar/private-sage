
package com.example.sage.model;
/**
 * Write a description of interface CapeSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CapeSubject implements Subject{
    private String subjectName;
    private int image;
    private int unitNumber;
    
    public CapeSubject(String subjectName,int image){
        this.subjectName = subjectName;
        this.unitNumber = 1;
        this.image=image;
    }
    
    public CapeSubject(String subjectName, int image, int unitNumber){
        this.subjectName = subjectName;
        this.unitNumber = unitNumber;
        this.image = image;
    }
    
    //getters
    public String getName(){
        return subjectName;
    }

    @Override
    public int getImage() {
        return image;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public int getUnitNumber(){
        return unitNumber;
    }

    public void setUnitNumber(int unitNumber) {
        this.unitNumber = unitNumber;
    }

    @Override
    public void setSubjectName(String subjectName) {

    }

    @Override
    public void setImage(int image) {

    }


    public String toString(){
        return subjectName + " Unit " + unitNumber;
    }
}
