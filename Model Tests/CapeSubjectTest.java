

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CapeSubjectTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CapeSubjectTest
{
    private CapeSubject capeSubj1;

    /**
     * Default constructor for test class CapeSubjectTest
     */
    public CapeSubjectTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        capeSubj1 = new CapeSubject("Chemistry", 7, 1);
        capeSubj1.getName();
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testSetCapeSubject()
    {
        capeSubj1.setName("Pure Mathematics");
        assertNotNull(capeSubj1.getName());
    }

    @Test
    public void testCapeUnit()
    {
        assertEquals(1, capeSubj1.getUnitNumber());
    }

    @Test
    public void testSetCapeUnit()
    {
        capeSubj1.setUnitNumber(2);
        assertEquals(2, capeSubj1.getUnitNumber());
    }

    @Test
    public void testToString()
    {
        assertEquals("Chemistry Unit 1", capeSubj1.toString());
    }
}




