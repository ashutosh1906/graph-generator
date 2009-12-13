
package graph.core;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class NodeTest {

    public NodeTest() {
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

    /**
     * Test of addEdge method, of class Node.
     */
    @Test
    public void testAddNullEdge() {
        System.out.println("addNullEdge");
        Edge e = null;
        Node instance = new Node();
        
        int lengthBeforeAdd = instance.getEdges().size();
        instance.addEdge(e);
        int lengthAfterAdd = instance.getEdges().size();

        assertEquals(lengthBeforeAdd, lengthAfterAdd);
    }

    /**
     * Test of addEdge method, of class Node.
     */
    @Test
    public void testAddEdge()
        throws EdgeException {

        System.out.println("addEdge");
        Edge e = new Edge(new Node(), new Node());
        Node instance = new Node();

        int lengthBeforeAdd = instance.getEdges().size();
        instance.addEdge(e);
        int lengthAfterAdd = instance.getEdges().size();

        assertEquals(lengthBeforeAdd + 1, lengthAfterAdd);
    }


    /**
     * Test of removeEdge method, of class Node.
     */
    @Test
    public void testRemoveEdge()
        throws EdgeException {

        System.out.println("removeEdge");
        Node instance = new Node();
        Edge e = new Edge(new Node(), instance);

        int lengthBeforeAdd = instance.getEdges().size();
        instance.removeEdge(e);
        int lengthAfterAdd = instance.getEdges().size();
        
        assertEquals(lengthBeforeAdd - 1, lengthAfterAdd);
    }

    /**
     * Test of sharesEdgeWidth method, of class Node.
     */
    @Test
    public void testSharesEdgeWidth()
        throws EdgeException {

        System.out.println("sharesEdgeWidth");
        Node b = new Node();
        Node instance = new Node();
        Edge e = new Edge(b, instance);
        boolean expResult = true;
        boolean result = instance.sharesEdgeWidth(b);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getIDString method, of class Node.
     */
    @Test
    public void testGetIDString() {
        System.out.println("getIDString");
        Node instance = new Node();
        String expResult = "0";
        String result = instance.getIDString();
        assertEquals(expResult, result);
    }

    /**
     * Test of destroy method, of class Node.
     */
    @Test
    public void testDestroy() 
        throws EdgeException {

        System.out.println("destroy");
        ArrayList<Edge> masterEdgeList = new ArrayList<Edge>();
        Node instance = new Node();
        Node b = new Node();
        Edge e = new Edge(b, instance);

        masterEdgeList.add(e);
        instance.destroy(masterEdgeList);
        assertEquals(0, masterEdgeList.size());
    }

    /**
     * Test of getDegree method, of class Node.
     */
    @Test
    public void testGetDegree() {
        System.out.println("getDegree");
        Node instance = new Node();
        int expResult = 0;
        int result = instance.getDegree();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDegree method, of class Node.
     */
    @Test
    public void testGetDegreeWidthEdge()
        throws EdgeException {

        System.out.println("getDegreeWithEdge");
        Node instance = new Node();
        Node b = new Node();
        new Edge(instance, b);

        int expResult = 1;
        int result = instance.getDegree();

        assertEquals(expResult, result);
    }

    /**
     * Test of getEdges method, of class Node.
     */
    @Test
    public void testGetEdges() 
        throws EdgeException {

        System.out.println("getEdges");
        Node instance = new Node();
        Node b = new Node();
        new Edge(b, instance);

        int expResult = 1;
        ArrayList result = instance.getEdges();
        assertEquals(expResult, result.size());
        
    }

    /**
     * Test of getID method, of class Node.
     */
    @Test
    public void testGetID() {
        System.out.println("getID");
        Node instance = new Node();
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
    }

    /**
     * Test of setID method, of class Node.
     */
    @Test
    public void testSetID() {
        System.out.println("setID");
        int id = 0;
        Node instance = new Node();
        instance.setID(id);

        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);

    }

    /**
     * Test of getX method, of class Node.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Node instance = new Node(0.5, 0.5, 0.5, 1);
        double expResult = 0.5;
        double result = instance.getX();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setX method, of class Node.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        double x = 0.0;
        Node instance = new Node();
        instance.setX(x);

        double result = instance.getX();
        assertEquals(x, result, 0.0);
    }

    /**
     * Test of getY method, of class Node.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Node instance = new Node(0.5, 0.5, 0.5, 1);
        double expResult = 0.5;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setY method, of class Node.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        double y = 0.0;
        Node instance = new Node();
        instance.setY(y);

        double result = instance.getY();
        assertEquals(y, result, 0.0);
    }

    /**
     * Test of getZ method, of class Node.
     */
    @Test
    public void testGetZ() {
        System.out.println("getZ");
        Node instance = new Node(0.5, 0.5, 0.5, 1);
        double expResult = 0.5;
        double result = instance.getY();
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of setZ method, of class Node.
     */
    @Test
    public void testSetZ() {
        System.out.println("setZ");
        double z = 0.0;
        Node instance = new Node();
        instance.setZ(z);

        double result = instance.getZ();
        assertEquals(z, result, 0.0);
    }

}