import java.util.Date;
/**
 * Write a description of class ClassSession here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class ClassSession extends Session{
    private static int classSessionCount = 0;
    private int classSessionId;
    /*
    private Date sessionDate;
    private double startTime;
    private double endTime;
    //String zoomLink;
    */
    
    public ClassSession(Date date, double startTime, double endTime){
        super(date, startTime, endTime);
        classSessionCount++;
        classSessionId = classSessionCount;
    }

    //getters
    public int getClassSessionId(){
        return classSessionId;
    }
    /*
    public Date getSessionDate(){
        return sessionDate;
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
    
    /*
    public String getZoomLink(){
        return zoomLink;
    }
    
   
    //setters
    public boolean updateSessionTime(double startTime, double endTime) {
        if (endTime - startTime > 0){
            this.startTime = startTime;
            this.endTime = endTime;
            return true;
        }
        return false;
    }
    
    //api to generate zoom link
    public void setZoomLink(){
    }
    */
}
