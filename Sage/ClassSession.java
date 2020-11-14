import java.util.Date;
/**
 * Write a description of class ClassSession here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClassSession{
    private boolean cancelled;
    private Date sessionDate;
    
    public ClassSession(Date date){
        sessionDate = date;
        cancelled = false;
    }
    
    public boolean getSessionStatus(){
        return cancelled;
    }
    
    public void cancelSession(){
        cancelled = true;
    }
    
    //might remove
    public void updateSessionDate(Date date) {
        sessionDate = date;
    }
}
