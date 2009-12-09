package graph.generator;
import uk.co.flamingpenguin.jewel.cli.CommandLineInterface;
import uk.co.flamingpenguin.jewel.cli.Option;
import uk.co.flamingpenguin.jewel.cli.Unparsed;

/**
 * User: Linus
 * Date: 09-Dec-2009
 * Time: 22:04:14
 * This interface specifies the CLI parameters using the JewelCLI library
 */
@CommandLineInterface(application="graph-generator")
public interface CLIInterface {

    @Option(shortName="n", longName="number-graphs", description="number of graphs to create")
    int getNumberOfGraphs();

    @Option(shortName="v", longName="number-vertex", description="number of nodes to create per graph")
    int getNumberOfVertex();

    @Option(shortName="e", longName="number-edges", description="number of edges to create per graph")
    int getNumberOfEdges();

    @Option(shortName="x", longName="file-format", description="file format (extension), either XML|GML")
    String getFileFormat();
    boolean isFileFormat();

    @Option(shortName="f", longName="filename", description="filename prefix")
    String getFilename();
    boolean isFilename();
    
    @Option(shortName="d", longName="max-degree", description="maximum degree a node can have")
    int getMaxDegree();
    boolean isMaxDegree();
    
    @Option(helpRequest = true, description = "display help", shortName = "h")
    boolean isHelp();


}
