
/**
 * Write a description of class CsecSubject here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class CsecSubject implements Subject{
    private String subjectName;
    
    public CsecSubject(String subjectName){
        this.subjectName = subjectName;
    }
    
    public String getName(){
        return subjectName;
    }
}
