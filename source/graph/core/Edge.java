
package graph.core;

/*
 * Edge.java
 *
 * Created on 19 October 2005, 15:34
 */
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Linus
 */
public class Edge {
    public Node a, b;
    public ArrayList<Point> bends;
    private int xOffset, yOffset;

    /** Creates a new instance of Edge */
    public Edge(Node a, Node b, int width, int height) throws EdgeException {
        setScreen(width, height);

        if (a == null || b == null)
            throw new EdgeException("Cannot create edge with nodes that dont exist");

        if (a == b)
            throw new EdgeException("Cannot connect to self.");

        if (a.sharesEdgeWidth(b))
            throw new EdgeException("Already connected.");

        this.a = a;
        this.b = b;

        bends = new ArrayList<Point>();

        a.addEdge(this);
        b.addEdge(this);
    }


    public double getLength() {
        if (a == null || b == null)
            return 0;

        double x = a.x - b.x;
        double y = a.y - b.y;
        double z = a.z - b.z;

        return Math.sqrt(x*x + y*y + z*z);
    }

    public Node getOpposingNode(Node n) {
        if (n == a)
            return b;
        else if (n == b)
            return a;
        else
            return null;
    }

    public void paint(Graphics g) {
        int x1 = (int) a.x + xOffset;
        int y1 = (int) a.y + yOffset;

        for (Point p : bends) {
            int x2 = p.x + xOffset;
            int y2 = p.y + yOffset;
            g.drawLine(x1,y1,  x2, y2);

            x1 = x2;
            y1 = y2;
        }
        g.drawLine( x1, y1, (int) b.x + xOffset, (int) b.y + yOffset);
    }

    public void setScreen(int x, int y) {
        xOffset = (int) x / 2 ;
        yOffset = (int) y / 2 ;
    }

    public void destroy() {
        a.removeEdge(this);
        b.removeEdge(this);
    }

    public void destroy(Node n) {
        getOpposingNode(n).removeEdge(this);
    }

    public String toString() {
        return "From node: " + a.getIDString() + " to node: " + b.getIDString();
    }

    public void addBend(Point b) {
        bends.add(b);
    }
}