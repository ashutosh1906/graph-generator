
package graph.export;
import java.util.Iterator;
import graph.core.*;

/**
 *
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class GMLOutput extends Exporter {

    public GMLOutput(Graph graph) {
        super(graph);
    }

    /**
     * return the graph in GML string format. This is in a seperate
     * class to Graph to stop it becoming bloated.
     */
    public String export() {
        String xml = "graph [\n" +
                "\tlabel \""+ graph.id +"\"\n" +
                "\tdirected 0\n";

        Iterator<Node> it = graph.nodes.iterator();
        while (it.hasNext()) {
            Node n = it.next();

            xml += "\tnode [\n" +
                    "\t\tid " + n.getIDString() + "\n" +
                    "\t\tlabelAnchor \"c\"\n" +
                    "\t\tgraphics [ \n" +
                    "\t\t\tx " + Double.toString( n.getX()) + "\n" +
                    "\t\t\ty " + Double.toString( n.getY()) + "\n" +
                    "\t\t\tw 10\n" +
                    "\t\t\th 10\n" +
                    "\t\t\ttype \"rectangle\"\n" +
                    "\t\t\tfill \"#FFFFE6\"\n" +
                    "\t\t\toutline \"#000000\"\n" +
                    "\t\t]\n" +
                    "\t]\n";
        }

        Iterator<Edge> iter = graph.edges.iterator();
        while (iter.hasNext()) {
            Edge e = iter.next();
            xml += "\tedge [\n" +
                    "\t\tsource " + e.getA().getIDString() + "\n" +
                    "\t\ttarget " + e.getB().getIDString() + "\n" +
                    "\t\tgraphics [ \n" +
                    "\t\t\ttype \"line\"\n" +
                    "\t\t]\n" +
                    "\t]\n";

        }

        return xml + "\n]";

    }

}
