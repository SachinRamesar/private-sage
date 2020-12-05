

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CsecSubjectTest
{
    private CsecSubject csecSubj1;

    /**
     * Default constructor for test class CsecSubjectTest
     */
    public CsecSubjectTest()
    {
    }

    @Before
    public void setUp()
    {
        csecSubj1 = new CsecSubject("Mathematics", 1);
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void testCsecSubject()
    {
        assertEquals("Mathematics", csecSubj1.getName());
    }

    //The test below checks that the subject name changed from the name in the fixture
    @Test
    public void testSetCsecSubject()
    {
        csecSubj1.setName("English Literature");
        assertNotSame("Mathematics", csecSubj1.getName());
    }
}


