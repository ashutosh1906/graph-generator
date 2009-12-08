
package graph.generator;
import graph.core.Graph;
import graph.export.*;

/**
 *
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class Main {
    private int noToCreate = 0;
    private int edges = 0;
    private int vertex = 0;
    private int maxDegree = 900;
    private String filenamePrefix = "";
    private String fileFormat = "";
    public static final int MAX_WIDTH = 800, MAX_HEIGHT = 600;

    /** Creates a new instance of Main */
    public Main() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new Main().run(args);
    }

    public void run(String[] args) {
        setup(args);

        for (int i = 0; i < noToCreate; i++) {
            try {
                Graph g = new Graph(vertex, edges, Main.MAX_WIDTH, Main.MAX_HEIGHT, maxDegree);
                g.id = i;

                if (fileFormat.equals("gml"))
                    new GMLOutput(g).save(filenamePrefix + i + ".gml");
                else if (fileFormat.equals("xml"))
                    new XMLOutput(g).save(filenamePrefix + i + ".xml");
                else {
                    new GMLOutput(g).save(filenamePrefix + i + ".gml");
                    new XMLOutput(g).save(filenamePrefix + i + ".xml");
                }
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setup(String[] args) {
        if (args.length == 0)
            showHelp();

        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("-help") || args[i].equals("/help")) {
                showHelp();
            }
            else if (args[i].equals("-h") || args[i].equals("/h")) {
                showHelp();
            }
            else if (args[i].equals("-n") || args[i].equals("/n")) {
                if (i+1 < args.length)
                    noToCreate = Integer.parseInt(args[i+1]);
            }
            else if (args[i].equals("-e") || args[i].equals("/e")) {
                if (i+1 < args.length)
                    edges = Integer.parseInt(args[i+1]);
            }
            else if (args[i].equals("-v") || args[i].equals("/v")) {
                if (i+1 < args.length)
                    vertex = Integer.parseInt(args[i+1]);
            }
            else if (args[i].equals("-f") || args[i].equals("/f")) {
                if (i+1 < args.length)
                    filenamePrefix = args[i+1];
            }
            else if (args[i].equals("-fm") || args[i].equals("/fm")) {
                if (i+1 < args.length)
                    fileFormat = args[i+1];
            }
            else if (args[i].equals("-d") || args[i].equals("/d")) {
                if (i+1 < args.length)
                    maxDegree = Integer.parseInt(args[i+1]);
            }
        }

    }

    public void showHelp(){
        System.out.println("'-v 7' creates a graph with 7 vertex");
        System.out.println("'-e 3' creates a graph with 3 edges");
        System.out.println("'-n 10' creates a graphs");
        System.out.println("'-f graph' sets the filename prefix for the output to graph");
        System.out.println("'-fm xml|gml' sets the output format");
        System.out.println("'-d 4' sets the maximum degree of a vertex to 4");
        System.out.println("'-h' shows this help screen");
        System.exit(0);
    }


}
