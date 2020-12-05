 

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
 

public class TutorAccountTest
{
    private TutorAccount tutorAcc1;
    private ArrayList<ClassSession> session;

    public TutorAccountTest()
    {
    }
    

    @Before
    public void setUp(){
        tutorAcc1 = new TutorAccount("Shanice", "Jones", "ShanJones@gmail.com", "SJo45");
        
    }

    @After
    public void tearDown()
    {
    }

    //Assert Equals function is assertEquals(expected, actual)

    @Test
    public void testFirstName()
    {
        assertEquals("Shanice", tutorAcc1.getFirstName());
    }

    @Test
    public void testLastName()
    {
        assertEquals("Jones", tutorAcc1.getLastName());
    }

    @Test
    public void testEmail()
    {
        assertEquals("ShanJones@gmail.com", tutorAcc1.getEmail());
    }
    
    //The test below is supposed to fail
    @Test
    public void testEmail2()
    {
        assertEquals("SJones@gmail.com", tutorAcc1.getEmail());
    }

    @Test
    public void testPassword()
    {
        assertEquals("SJo45", tutorAcc1.getPassword());
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
        
        tutorAcc1.addClass(new Class (new CsecSubject("Mathematics", 1), 10, "Class for CSEC Maths", session, 50.00));
        assertNotNull(tutorAcc1.getClasses());
    }
    
    @Test
    public void testRemoveClass()
    {
        String str1 = "2020-11-27 01:00";
        String str2 = "2020-11-27 03:00";
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime startDateTime = LocalDateTime.parse(str1, formatter);
        LocalDateTime endDateTime = LocalDateTime.parse(str2, formatter);
        
        session = new ArrayList<ClassSession>();
        session.add(new ClassSession(startDateTime, endDateTime, "zoom link"));
        
        Class class1 = new Class (new CsecSubject("Biology", 1), 10, "Class for CSEC Biology", session, 50.00);
        tutorAcc1.addClass(class1);
        tutorAcc1.removeClass(class1);
        
        //assertNull(tutorAcc1.getClasses());
    }
    
 
}















