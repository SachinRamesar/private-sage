

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StudentAccountTest
{
    private StudentAccount studentA1;
    private ArrayList<ClassSession> session;

    public StudentAccountTest()
    {
    }

    @Before
    public void setUp()
    {
        studentA1 = new StudentAccount("John" , "Thomas", "JThomas@hotmail.com", "jj123");
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testFirstName()
    {
        assertEquals("John", studentA1.getFirstName());
    }

    @Test
    public void testLastName()
    {
        assertEquals("Thomas", studentA1.getLastName());
    }

    @Test
    public void testEmail()
    {
        assertEquals("JThomas@hotmail.com", studentA1.getEmail());
    }

    @Test
    public void testPassword()
    {
        assertEquals("jj123", studentA1.getPassword());
    }
    
    //The test below should fail
    @Test
    public void testPassword2()
    {
        assertEquals("JJ123", studentA1.getPassword());
    }
    
    @Test
    public void testAddClass()
    {
        String str1 = "2020-11-24 10:00";
        String str2 = "2020-11-24 12:00";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(str1, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(str2, formatter);
        
        session = new ArrayList<ClassSession>();
        session.add(new ClassSession(startDateTime, endDateTime, "zoom link"));
        
        studentA1.addClass(new Class (new CsecSubject("Mathematics", 1), 10, "Class for CSEC Maths", session, 50.00));
        assertNotNull(studentA1.getClasses());
    }
    
    @Test
    public void testRemoveClass()
    {
        String str1 = "2020-11-30 02:30";
        String str2 = "2020-11-30 04:30";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(str1, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(str2, formatter);
        
        session = new ArrayList<ClassSession>();
        session.add(new ClassSession(startDateTime, endDateTime, "zoom link"));
        
        Class class1 = new Class (new CsecSubject("Comuter Science", 1), 10, "Class for CSEC Comp Sci", session, 50.00);
        studentA1.addClass(class1);
        studentA1.removeClass(class1);
        
        //assertNull(studentA1.getClasses());
    }
}





