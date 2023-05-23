package dev.sugaroflead;

import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestSuite;

public class KthLargestTest extends TestCase{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public KthLargestTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( KthLargestTest.class );
    }

    /*
     * Input
    ["KthLargest", "add", "add", "add", "add", "add"]
    [[3, [4, 5, 8, 2]], [3], [5], [10], [9], [4]]
    Output
    [null, 4, 5, 5, 8, 8]
     */
    public void testCase1()
    {
        KthLargest kl = new KthLargest(3, new int[] {4, 5, 8, 2});

        assertEquals(4, kl.add(3));
        assertEquals(5, kl.add(5));
        assertEquals(5, kl.add(10));
        assertEquals(8, kl.add(9));
        assertEquals(8, kl.add(4));
    }
}
