

package graph.core;

/*
 * Node.java
 *
 * Created on 19 October 2005, 15:30
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author Linus
 */
public class Node {
    public double x, y, z;
    private int width, height;
    private int screenX, screenY, xOffset, yOffset, id;
    public ArrayList<Edge> edges;
    public static int nodeCount = 0;

    /** Creates a new instance of Node
     *
     *  @param x x position of node
     *  @param y y position of node
     *  @param z z position of node
     *  @param screenX screen width. used to calculate the center of the screen
     *  @param screenY screen height, used for center of screen.
     */
    public Node(int x, int y, int z, int screenX, int screenY) {
        this.x = x;
        this.y = y;
        this.z = z;

        width = 15;
        height = 15;

        setScreen(screenX, screenY);

        edges = new ArrayList<Edge>();
        id = nodeCount++;
    }

    /** Creates a new instance of Node
     *
     *  @param x x position of node
     *  @param y y position of node
     *  @param z z position of node
     *  @param screenX screen width. used to calculate the center of the screen
     *  @param screenY screen height, used for center of screen.
     *  @param width width of the node (when drawn)
     *  @param height height of the node (when drawn)
     */
    public Node(int x, int y, int z, int screenX, int screenY, int width, int height) {
        this.x = x;
        this.y = y;
        this.z = z;

        this.width = width;
        this.height = height;

        setScreen(screenX, screenY);

        edges = new ArrayList<Edge>();
        id = nodeCount++;
    }

    /** Creates a new instance of Node
     *
     *  @param screenX screen width. used to calculate the center of the screen
     *  @param screenY screen height, used for center of screen.
     *
     *  x, y and z are randomly calculated using the screen size as follows:
     *
     *  this.x = (Math.random() * screenX) - screenX / 2;
     *
     *  so with a screenX of 480 the pos will be +/- 240
     */
    public Node(int screenX, int screenY) {
        this.x = (Math.random() * screenX);
        this.y = (Math.random() * screenY);
        this.z = (Math.random() * screenX);

        width = 15;
        height = 15;

        setScreen(screenX, screenY);

        edges = new ArrayList<Edge>();
        id = nodeCount++;
    }

    public Node(int screenX, int screenY, boolean twoDimensional) {
        this.x = (Math.random() * screenX);
        this.y = (Math.random() * screenY);

        if (twoDimensional)
            this.z = 0;
        else
            this.z = (Math.random() * screenX);

        width = 15;
        height = 15;

        setScreen(screenX, screenY);

        edges = new ArrayList<Edge>();
        id = nodeCount++;
    }

    /** Creates a new instance of Node
     *
     *  @param screenX screen width. used to calculate the center of the screen
     *  @param screenY screen height, used for center of screen.
     *  @param width width of the node (when drawn)
     *  @param height height of the node (when drawn)
     *
     *  x, y and z are randomly calculated using the screen size as follows:
     *
     *  this.x = (Math.random() * screenX) - screenX / 2;
     *
     *  so with a screenX of 480 the pos will be +/- 240
     */
    public Node(int screenX, int screenY, int width, int height) {
        this.x = (Math.random() * screenX) - screenX / 2;
        this.y = (Math.random() * screenY) - screenY / 2;
        this.z = (Math.random() * screenX) - screenX / 2;

        this.width = width;
        this.height = height;

        setScreen(screenX, screenY);

        edges = new ArrayList<Edge>();
        id = nodeCount++;
    }

    /**
     * along as the same edge is not being added twice add the edge
     */
    public void addEdge(Edge e) {
        if (!edges.contains(e) && e != null)
            edges.add(e);
    }

    /** remove an edge from the node */
    public void removeEdge(Edge e) {
        edges.remove(e);
    }

    /** returns true if e.getOpposingNode(this) == b
     *  where e is each one of the edges the node has
     */
    public boolean sharesEdgeWidth(Node b) {
        Iterator<Edge> it = edges.iterator();
        while (it.hasNext()) {
            Edge e = it.next();

            //node opersite this one is b then connected
            if (e.getOpposingNode(this) == b)
                return true;

        }

        return false;
    }

    /** move to the side in an anti clockwise direction by theta (radians) */
    public void yaw(double theta) {
        double X = z * Math.sin(theta) + x * Math.cos(theta);
        double Z = z * Math.cos(theta) - x * Math.sin(theta);
        x = X;
        z = Z;
    }

    /** move down by theta (radians) */
    public void pitch(double theta) {
        double Y = y * Math.cos(theta) - z * Math.sin(theta);
        double Z = y * Math.sin(theta) + z * Math.cos(theta);
        y = Y;
        z = Z;
    }

    public void paint(Graphics g) {
        g.fillOval( (int)x + xOffset, (int)y + yOffset , width , height );
        g.setColor(Color.WHITE);
        g.setFont(new Font("Aerial", Font.PLAIN, 10));
        g.drawString(Integer.toString(id), (int)x + xOffset + 2, (int)y + yOffset + 10);
        g.setColor(Color.BLACK);
    }

    /** sets the offsets used for drawing */
    public void setScreen(int x, int y) {
        screenX = x;
        screenY = y;
        xOffset = (int) ( x / 2 ) - ( width / 2 );
        yOffset = (int) ( y / 2 ) - ( height / 2 );
    }

    public String getIDString() {
        return Integer.toString(id);
    }

    public int getID() {
        return id;
    }

    public void setID(int i ) {
        id = i;
    }

    /** destroy all edges connected to this node */
    public void destroy(ArrayList<Edge> masterEdgeList) {
       Iterator<Edge> it = edges.iterator();
       while (it.hasNext()) {
           //destroy but only tell the other node because
           //we dont want concurrent modification
           Edge e = it.next();
           masterEdgeList.remove(e);
           e.destroy(this);
       }
    }

    public int getDegree() {
        return edges.size();
    }
}