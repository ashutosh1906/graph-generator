/*
 * Graph.java
 *
 * Created on 01 November 2005, 17:13
 *
 */
package graph.core;
import java.util.*;

/**
 * @author Linus Norton <linusnorton@gmail.com>
 *
 */
public class Graph {
    public ArrayList<Node> nodes;
    public ArrayList<Edge> edges;
    public int id = 0;

    /** Creates a new instance of Graph
     *  @param nodes number of nodes for the graph
     *  @param edges number of edges for the graph
     *  @param screen passed to nodes, so they can get their initial pos
     *
     *  throws an EdgeException if it cant add any more edges to any of the nodes
     */
    public Graph(int nodesCount, int edgesCount, int maxX, int maxY, int maxDegree)
        throws Exception {

        //reset graph so nodes go back to 0
        Node.nodeCount = 0;

        nodes = new ArrayList<Node>();
        edges = new ArrayList<Edge>();

        for (int i = 0; i < nodesCount; i++) {
            nodes.add(new Node( maxX, maxY));
        }

        //for all edges add some random nodes together
        //i = index for edges j = index for nodes
        for (int i = 0, j = 0; i < edgesCount; i++) {

            Node a = nodes.get(j++), b = getNodeFor(a);

            //if were at the end of the nodes go back to the start
            if (j == nodes.size()) {
                j = 0;

                //if the last node is full then we got a problem
                if (b == null || a.getDegree() >= maxDegree || b.getDegree() >= maxDegree)
                    throw new Exception("Cannot create any more edges, all nodes full!");
            }

            //current node is connected to all other nodes try next one
            if (b == null || a.getDegree() >= maxDegree || b.getDegree() >= maxDegree) {
                i--; //have to dec otherwise get unintialised edges
                continue;
            }

            edges.add( new Edge(a,b, maxX, maxX));
        }
    }

    public Graph() {
        //reset graph so nodes go back to 0
        Node.nodeCount = 0;
    }

    /**
     * This method returns a node that is not currently connected to a
     * or returns null if its connected to all nodes already
     */
    public Node getNodeFor(Node a) {
        /* try connecting a to a random node, if its already connected
           loop round all other nodes and try to connect. This used to
           select a random one each loop but that could mean that null
           may be returned when there is an available edge. This is still
           random because of the starting node.
        */

        int j = (int) (Math.random() * (nodes.size() -1));

        for (int i = 0; i < nodes.size(); i++ ) {
            if (!a.sharesEdgeWidth(nodes.get(j)) && a != nodes.get(j) )
                return nodes.get(j);

            //try the next node
            j++;
            //if weve gone passed the end go back to start
            if (j == nodes.size())
                j = 0;

        }

        //nothing found return null
        return null;
    }

    /** safely adds a node to the graph */
    public void addNode(Node n ) {
        if (n == null)
            return;

        nodes.add(n);
    }

    /** safely adds an edge to the graph */
    public void addEdge(Edge e ) {
        if (e == null)
            return;

        edges.add(e);
    }
   
}