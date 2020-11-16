import java.util.Date;
/**
 * Write a description of class Session here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Session{
    private Date sessionDate;
    private double startTime;
    private double endTime;
    private String zoomLink;
    
    public Session(Date date, double startTime, double endTime){
        sessionDate = date;
        this.startTime = startTime;
        this.endTime = endTime;
        //generateZoomLink();
    }
    
    //getters
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
    public void generateZoomLink(){
        zoomLink =;
    }
    */

    //setters
    public boolean updateSessionTime(double startTime, double endTime) {
        if (endTime - startTime > 0){
            this.startTime = startTime;
            this.endTime = endTime;
            return true;
        }
        return false;
    }
}
