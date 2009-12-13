/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package graph.core;

import java.awt.Point;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author linus
 */
public class EdgeTest {

    public EdgeTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    public static Edge getTestEdge()
        throws EdgeException {
        Node a = new Node(1);
        Node b = new Node(2);
        return new Edge(a,b);
    }

    /**
     * Test of getLength method, of class Edge.
     */
    @Test
    public void testGetLength() 
        throws EdgeException {
        System.out.println("getLength");
        Node a = new Node(0.0, 1.0, 0.0, 1);
        Node b = new Node(1.0, 0.0, 0.0, 2);

        Edge instance = new Edge(a, b);

        double expResult = Math.sqrt(2.0);
        double result = instance.getLength();
        assertEquals(expResult, result, 0.0);        
    }

    /**
     * Test of getOpposingNode method, of class Edge.
     */
    @Test
    public void testGetOpposingNode() 
        throws EdgeException {
        System.out.println("getOpposingNode");

        Node a = new Node();
        Node b = new Node();
        Edge e = new Edge(a,b);

        Node expResult = b;
        Node result = e.getOpposingNode(a);
        assertEquals(expResult, result);
    }


    /**
     * Test of toString method, of class Edge.
     */
    @Test
    public void testToString()
        throws EdgeException {

        System.out.println("toString");
        Edge instance = EdgeTest.getTestEdge();

        String expResult = "From node: 1 to node: 2";
        String result = instance.toString();
        assertEquals(expResult, result);
    }

    /**
     * Test of addBend method, of class Edge.
     */
    @Test
    public void testAddBend()
        throws EdgeException {

        System.out.println("addBend");
        Point b = new Point();
        Edge instance = getTestEdge();
        instance.addBend(b);
        assertEquals(1, instance.getBends().size());
    }

    /**
     * Test of getA method, of class Edge.
     */
    @Test
    public void testGetA() 
        throws EdgeException {
        System.out.println("getA");
        Edge instance = getTestEdge();
        int expResult = 1;
        int result = instance.getA().getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setA method, of class Edge.
     */
    @Test
    public void testSetA()
        throws EdgeException {

        System.out.println("setA");
        Node a = new Node();
        Edge instance = getTestEdge();
        instance.setA(a);

        assertSame(a, instance.getA());
    }

    /**
     * Test of getB method, of class Edge.
     */
    @Test
    public void testGetB()
        throws EdgeException {
        System.out.println("getB");
        Edge instance = getTestEdge();
        int expResult = 2;
        int result = instance.getB().getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setB method, of class Edge.
     */
    @Test
    public void testSetB()
        throws EdgeException {

        System.out.println("setB");
        Node b = new Node();
        Edge instance = getTestEdge();
        instance.setB(b);

        assertSame(b, instance.getB());
    }

    /**
     * Test of getBends method, of class Edge.
     */
    @Test
    public void testGetBends()
        throws EdgeException {
        System.out.println("getBends");
        Edge instance = getTestEdge();
        int expResult = 0;
        int result = instance.getBends().size();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBends method, of class Edge.
     */
    @Test
    public void testSetBends()
        throws EdgeException {

        System.out.println("setBends");
        ArrayList<Point> bends = new ArrayList<Point>();
        Edge instance = getTestEdge();
        instance.setBends(bends);
        assertSame(bends, instance.getBends());
    }

}