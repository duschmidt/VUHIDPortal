package vuhidtools;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class VUHIDSenderTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public VUHIDSenderTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( VUHIDSenderTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        VUHIDSender s = new VUHIDSender();
        assertFalse( s.testMe() );
    }
}
