
package graph.export;
/*
 * XMLOutput.java
 *
 * Created on 21 November 2005, 12:13
 *
 */
import graph.core.*;
import java.util.Iterator;

/**
 * @author Linus
 *
 * This class extends the exporter to provide XML output
 *
 */
public class XMLOutput extends Exporter {

    /**
     * Setup the exporter
     * @param graph
     */
    public XMLOutput(Graph graph) {
        super(graph);
    }

    /** return the graph in XML string format. This is in a seperate
      * class to Graph to stop it becoming bloated. For the purposes
      * of this app to only time it needs to be XML is for saving
      */
    public String export() {
        String xml = "<graph id='"+graph.id+"'>" ;

        Iterator<Node> it = graph.nodes.iterator();
        while (it.hasNext()) {
            Node n = it.next();
            xml += sep + "\t<vertex id='" + n.getIDString() + "' " +
                    " x='" + Double.toString( n.x) + "' " +
                    " y='" + Double.toString( n.y) + "' " +
                    " z='" + Double.toString( n.z) + "'/>";

        }

        Iterator<Edge> iter = graph.edges.iterator();
        while (iter.hasNext()) {
            Edge e = iter.next();
            xml += sep + "\t<edge v1='" + e.a.getIDString() + "' " +
                    " v2='" + e.b.getIDString() + "' " +
                    " length='" + Double.toString( e.getLength()) + "'";

            for (int i = 0; i < e.bends.size(); i++) {
                xml += " bend" + i + "x='" + e.bends.get(i).x + "'";
                xml += " bend" + i + "y='" + e.bends.get(i).y + "'";
            }

            xml += "/>";

        }

        return xml + sep + "</graph>";

    }

}