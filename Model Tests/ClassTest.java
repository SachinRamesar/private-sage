

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class ClassTest
{
    private Class class1;
    private ArrayList<ClassSession> session;
    private ArrayList<ClassSession> classSession;
    
    public ClassTest()
    {
    }

    @Before
    public void setUp()
    {
        Subject subject = new CsecSubject("Information Technology", 9);
        int capacity = 8;
        String description = "This an Information Technology class for CSEC students";
        double price = 50.00;
        
        String str1 = "2020-11-24 08:00";
        String str2 = "2020-11-24 10:00";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(str1, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(str2, formatter);
        
        session = new ArrayList<ClassSession>();
        session.add(new ClassSession(startDateTime, endDateTime, "zoom link"));
        
        class1 = new Class(subject, capacity, description, session, price);
    }

    @After
    public void tearDown()
    {
    }


    @Test
    public void testClassDescription()
    {
        assertNotNull(class1.getClassDescription());
    }

    @Test
    public void testPrice()
    {
        assertEquals(50.0, class1.getPrice(), 0.1);
    }
    
    @Test
    public void testAddSession()
    {
        String str1 = "2020-11-27 10:00";
        String str2 = "2020-11-27 12:00";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(str1, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(str2, formatter);
        
        class1.addSession(new ClassSession(startDateTime, endDateTime, "zoom link"));
        assertEquals(2, class1.getNumSessions());
    }
    
    @Test
    public void testRemoveSession()
    {
        String str1 = "2020-11-27 10:00";
        String str2 = "2020-11-27 12:00";
        String str3 = "2020-11-30 10:00";
        String str4 = "2020-11-30 12:00";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(str1, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(str2, formatter);
        LocalDateTime startDateTime2 = LocalDateTime.parse(str3, formatter);
        LocalDateTime endDateTime2 = LocalDateTime.parse(str4, formatter);
        
        class1.addSession(new ClassSession(startDateTime, endDateTime, "zoom link"));
        class1.addSession(new ClassSession(startDateTime2, endDateTime2, "zoom link"));
        
        class1.removeSession(new ClassSession(startDateTime2, endDateTime2, "zoom link"));
        
        assertEquals(3, class1.getNumSessions());
    }


    @Test
    public void testAddStudent()
    {
        assertEquals(true, class1.addStudent(new StudentAccount("Diane" , "George", "DG@gmail.com", "ddg24")));
    }
    
    //The test below should fail as the class capacity is full
    @Test
    public void testAddStudent2()
    {
        class1.setCapacity(3);
        assertEquals(true, class1.addStudent(new StudentAccount("John" , "Thomas", "JThomas@hotmail.com", "jj123")));
        assertEquals(true, class1.addStudent(new StudentAccount("Keith" , "Charles", "KiethC@hotmail.com", "kc78")));
        assertEquals(true, class1.addStudent(new StudentAccount("Luke" , "Boodoo", "LukeB@hotmail.com", "BooL12")));
        assertEquals(true, class1.addStudent(new StudentAccount("Mary" , "Stweart", "MaryS@hotmail.com", "mary332")));
    }
    
    

    @Test
    public void testRemoveStudent()
    {
        class1.setCapacity(3);
        assertEquals(true, class1.addStudent(new StudentAccount("John" , "Thomas", "JThomas@hotmail.com", "jj123")));
        assertEquals(true, class1.addStudent(new StudentAccount("Keith" , "Charles", "KiethC@hotmail.com", "kc78")));
        assertEquals(true, class1.addStudent(new StudentAccount("Mary" , "Stweart", "MaryS@hotmail.com", "mary332")));
        class1.removeStudent(new StudentAccount("Keith" , "Charles", "KiethC@hotmail.com", "kc78"));
    }
}









