import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileNotFoundException;

/**
 * Class that is capable of reading in a graph file from disk.
 * Graph files are line based. Node names have type String and edge weights have
 * type Double. Fields on the line are separated by ':' and there is no extra white space.
 */
public class DiGraphReader implements IGraphReader {
    // Fields needed for the Graph Reader should be added here

    /**
     * Creates a new graph reader instance
     */
    public DiGraphReader() {
        // Configure the graph reader here
    }

    /**
     * Reads in a file and instantiates the graph
     * @param filename the file to read
     * @return the instantiated graph
     */
    public IGraph<String,Double> read(String filename) throws FileNotFoundException, IOException {
      Graph g = new Graph();
        // Open the file
      BufferedReader br = new BufferedReader(new FileReader(filename));
        // Parse the lines. If a line does not have exactly 3 fields, ignore the line
        String l = br.readLine();
        while(l != null)
        {
        String[] elements = l.split(":");
          while(elements.length != 3){
            l = br.readLine();
            elements = l.split(":");
          }
          Node<String> start_node = new Node<String>();
          Node<String> end_node = new Node<String>();
          start_node.setValue((String) elements[0]);
          end_node.setValue((String) elements[1]);
          double weight = Double.parseDouble(elements[2]);
          g.addEdge(start_node,end_node,weight);
          l = br.readLine();
        }
        // For each line, add the nodes and edge
            //How many fields and what is in each fields//
            //h

        // Return the graph instance
        return g;
    }

    /**
     * Simple main method to open and process a file
     */
    public static void main(String[] argv) throws Exception {
        // This code should work without modification once your reader code is working
        IGraphReader r = new DiGraphReader();
        IGraph<String,Double> g = r.read("graphfile.cs2");
        IEdge<String,Double>[] edges = g.getEdgeSet();
        for(int i=0; i<edges.length; i++) {
            System.out.println(edges[i].getSource().getValue()+" -> "+edges[i].getDestination().getValue()+"  w: "+edges[i].getWeight());
        }
    }
}
