
package graph.export;
import graph.core.*;
import java.io.*;
/**
 *
 * @author Linus Norton <linusnorton@gmail.com>
 */
public  abstract class Exporter {
    protected Graph graph;
    protected String sep = System.getProperty("line.separator");

    /**
     * Stores the graph
     * @param graph
     */
    public Exporter(Graph graph) {
        this.graph = graph;
    }


    /**
     * Save the graph to a filename
     * @param filename
     */
    public void save(String filename) {
        File file = new File(filename);
        String content = this.export();

        try {
            FileWriter fw = new FileWriter(file);
            fw.write(content);
            fw.flush();
            fw.close();
        }
        catch (IOException e) {
            System.err.println("Error writing file: " + filename);
        }
    }

    public abstract String export();
}
