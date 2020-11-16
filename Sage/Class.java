import java.util.ArrayList;
/**
 * Write a description of class Class here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Class{
    private static int classCount = 0;
    private int classId;
    private String classDescription;
    private Subject subject;
    private int classCapacity;
    private ArrayList<ClassSession> classSessions;
    private ArrayList<StudentAccount> students;
  
    public Class(Subject subject, int capacity, ArrayList<ClassSession> classes){
        classCount++;
        classId = classCount;
        this.classDescription = classDescription;
        this.subject = subject;
        this.classCapacity = capacity;
        classSessions = new ArrayList<ClassSession>(classes); 
        students = new ArrayList<StudentAccount>();
    }
    
    public void addSession(ClassSession classSession){
        classSessions.add(classSession);
    }
    
    public void cancelSession(ClassSession classSession){
        classSessions.remove(classSession);
    }
    
    public boolean addStudent(StudentAccount student){
        if (getClassSize() < classCapacity){
            students.add(student);
            return true;
        }
        return false;
    }
    
    public void removeStudent(StudentAccount student){
        students.remove(student);
    }

    public int getClassId(){
        return classId;
    }
    
    public Subject getSubject(){
        return subject;
    }
    
    public int getClassSize(){
        return students.size();
    }
    
    public int getClassCapacity(){
        return classCapacity;
    }
    
    public void setCapacity(int capacity){
        this.classCapacity = capacity;
    }
    
    public void setClassDescription(String classDescription){
        this.classDescription = classDescription;
    }
    
    public String getClassDescription(){
        return classDescription;
    }
}
