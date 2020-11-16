import java.util.Date;
/**
 * Write a description of class ClassSession here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClassSession{
    private static int classSessionCount = 0;
    private int classSessionId;
    private Date sessionDate;
    private double startTime;
    private double endTime;
    
    public ClassSession(Date date, double startTime, double endTime){
        classSessionCount++;
        classSessionId = classSessionCount;
        sessionDate = date;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public boolean updateSessionTime(double startTime, double endTime) {
        if (endTime - startTime > 0){
            this.startTime = startTime;
            this.endTime = endTime;
            return true;
        }
        return false;
    }
    
    public double getStartTime(){
        return startTime;
    }
    
    public double getEndTime(){
        return endTime;
    }
    
    public double getDuration(){
        return endTime - startTime;
    }
}
