
package graph.generator;
import graph.core.Graph;
import graph.export.*;
import uk.co.flamingpenguin.jewel.cli.ArgumentValidationException;
import uk.co.flamingpenguin.jewel.cli.CliFactory;

/**
 *
 * @author Linus Norton <linusnorton@gmail.com>
 */
public class Main {
    private int noToCreate;
    private int edges;
    private int vertex;
    private int maxDegree = 900;
    private String filenamePrefix = "";
    private String fileFormat = "";

    /** Creates a new instance of Main */
    public Main(CLIInterface cli) {
        //mandatory
        this.edges = cli.getNumberOfEdges();
        this.vertex = cli.getNumberOfVertex();
        this.noToCreate = cli.getNumberOfGraphs();
        //optional
        this.fileFormat = cli.isFileFormat() ? cli.getFileFormat() : this.fileFormat;
        this.filenamePrefix = cli.isFilename() ? cli.getFilename() : this.filenamePrefix;
        this.maxDegree = cli.isMaxDegree() ? cli.getMaxDegree() : this.maxDegree;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            //create the CLI interface
            CLIInterface result = CliFactory.parseArguments(CLIInterface.class, args);
            //setup the Main object and create the graphs
            new Main(result).run();
        }
        catch(ArgumentValidationException e) {
            Main.showHelp();
        }

    }

    /**
     * Create the graphs
     */
    public void run() {

        for (int i = 0; i < noToCreate; i++) {
            try {
                Graph g = new Graph(vertex, edges, maxDegree);
                g.id = i;

                if (fileFormat.equals("gml")) {
                    new GMLOutput(g).save(filenamePrefix + i + ".gml");
                }
                else if (fileFormat.equals("xml")) {
                    new XMLOutput(g).save(filenamePrefix + i + ".xml");
                }
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


    public static void showHelp(){
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
