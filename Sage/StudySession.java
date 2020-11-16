import java.util.ArrayList;
import java.util.Date;
/**
 * Write a description of class StudySession here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class StudySession extends Session{
    private static int studySessionCount = 0;
    private int studySessionId;
    private String studySessionDescription;
    private Subject subject;
    private int studySessionCapacity;
    private ArrayList<StudentAccount> students;
    /*
    private Date sessionDate;
    private double startTime;
    private double endTime;
    */
  
    public StudySession(Subject subject, int capacity, Date date, double startTime, double endTime){
        super(date, startTime, endTime);
        studySessionCount++;
        studySessionId = studySessionCount;
        this.studySessionDescription = studySessionDescription;
        this.subject = subject;
        this.studySessionCapacity = capacity;
        students = new ArrayList<StudentAccount>();
        /*
        sessionDate = date;
        this.startTime = startTime;
        this.endTime = endTime;
        */
    }
    
    //getters
    public int getStudySessionId(){
        return studySessionId;
    }
    
    public Subject getSubject(){
        return subject;
    }
    
    public int getStudySessionSize(){
        return students.size();
    }
    
    public int getStudySessionCapacity(){
        return studySessionCapacity;
    }
    
    public String getStudySessionDescription(){
        return studySessionDescription;
    }
    
    /*
    public Date getStudySessionDate(){
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
    */
    
    //setters
    public void setStudySessionCapacity(int capacity){
        this.studySessionCapacity = capacity;
    }
    
    public void setStudySessionDescription(String description){
        this.studySessionDescription = description;
    }

    public boolean addStudent(StudentAccount student){
        if (getStudySessionSize() < studySessionCapacity){
            students.add(student);
            return true;
        }
        return false;
    }
    
    public void removeStudent(StudentAccount student){
        students.remove(student);
    }

}
