
/**
 * Write a description of interface CapeSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CapeSubject implements Subject{
    private String subjectName;
    private int unitNumber;
    
    public CapeSubject(String subjectName){
        this.subjectName = subjectName;
        unitNumber = 1;
    }
    
    public CapeSubject(String subjectName, int unitNumber){
        this.subjectName = subjectName;
        this.unitNumber = unitNumber;
    }
    
    //getters
    public String getName(){
        return subjectName;
    }
    
    public int getUnitNumber(){
        return unitNumber;
    }
    
    public String toString(){
        return subjectName + " Unit " + unitNumber;
    }
}
