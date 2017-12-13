public class Graph<N,W> implements IGraph<N,W>
{
    DoubleLinkList<INode> nodes;
    DoubleLinkList<IEdge> edges;
    INode<N> curr;

    public Graph() {
        nodes = new DoubleLinkList<INode>();
        edges = new DoubleLinkList<IEdge>();
        curr  = null;
    }

    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */
    public INode<N> addNode(N v) {
          for (int i = 0; i<nodes.size(); i++){
            if (nodes.fetch(i).getValue()==v){
                return null;
            }
          }
        INode<N> n = new Node<N>();
        n.setValue(v);
        curr = n;
        nodes.append(n);
        return n;
    }

    /**
     * Gets an array of all the nodes in the graph
     * @return the node set
     */
    public INode<N>[] getNodeSet(){
      int length = nodes.size();
      INode[] node_array = new Node[length];
      for (int i = 0; i<length; i++){
        node_array[i] = nodes.fetch(i);
      }
      return node_array;
    }

    /**
     * An array of the neighbors of a node
     * @param n the node
     * @return neighbors of n
     */
    public INode<N>[] getNeighbors(INode<N> n){
      int counter = 0;

      for (int i = 0; i<edges.size(); i++){
        if(edges.fetch(i).getSource() == n){
          counter++;
        }
      }
      INode<N>[] node_array = new Node[counter];
      int counter1 = 0;
      for (int i = 0; i<edges.size(); i++){
        if(edges.fetch(i).getSource() == n){
          node_array[counter1] = edges.fetch(i).getDestination();
          counter1++;
        }
      }

      return node_array;

    }

    /**
     * Adds a node to the graph
     * @param v value at the node
     * @return the newly added node
     */

     /**
      * Adds an edge to the graph.
      * Duplicate edges are not allowed in the graph. The equals method of the edge can
      * be used to determine if two edges duplicate one another.
      * @param w weight of the edge
      * @param s source node
      * @param d destination node
      */
    public void addEdge(INode<N> s, INode<N> d, W w){
        IEdge<N,W> e = new Edge<N,W>(s,d,w);
        boolean should_add = true;
        if(should_add == true){
          for (int i = 0; i<edges.size(); i++){
            if (edges.fetch(i).equals(e)){
                should_add = false;
            }
          }
        }
        if(should_add == true){
          edges.append(e);
        }
        // Book keeping for when nodes know their edges
        //a.addEdge(n);
        //b.addEdge(n);
    }

    public IEdge<N,W>[] getEdgeSet(){
      int length = edges.size();
      IEdge[] edge_array = new Edge[length];
      for (int i = 0; i<length; i++){
        edge_array[i] = edges.fetch(i);
      }
      return edge_array;
    }

    /**
     * Gets an array of all the edges sourced at a particular node
     * @param n the source node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesFrom(INode<N> n){
      int counter = 0;
      for (int i = 0; i<edges.size(); i++){
        if(edges.fetch(i).getSource() == n){
          counter++;
        }
      }
      IEdge[] edge_array = new Edge[counter];
      int counter1 = 0;
      for (int i = 0; i<edges.size(); i++){
        if(edges.fetch(i).getSource() == n){
          edge_array[counter1] = edges.fetch(i);
          counter1++;
        }
      }
      return edge_array;
    }

    /**
     * Gets an array of all the edges destined for a particular node
     * @param n the destination node
     * @return the edge set
     */
    public IEdge<N,W>[] getEdgesTo(INode<N> n){
      int counter = 0;
      for (int i = 0; i<edges.size(); i++){
        if(edges.fetch(i).getDestination() == n){
          counter++;
        }
      }
      IEdge[] edge_array = new Edge[counter];
      int counter1 = 0;
      for (int i = 0; i<edges.size(); i++){
        if(edges.fetch(i).getDestination() == n){
          edge_array[counter1] = edges.fetch(i);
          counter1++;
        }
      }
      return edge_array;
    }



    /**
     * Retrieve the node with a specific value
     * @param v the value
     * @return the node
     */
    public INode<N> fetchNode(N v) {
        for(int i=0;i<nodes.size(); i++) {
            INode<N> n = nodes.fetch(i);
            if( n.getValue().equals(v) ) {
                return n;
            }
        }
        return null;
    }

    public IEdge<N,W> fetchEdge(INode<N> source_node) {
        for(int i=0;i<edges.size(); i++) {
            IEdge<N,W> e = edges.fetch(i);
            if( e.getSource().equals(source_node) ) {
                return e;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Graph<String,Integer> g = new Graph<String,Integer>();
        g.addNode("Hi");
        g.addNode("Howdy");
        g.addNode("Sup");
        g.addNode("Doggy");

        g.addEdge(g.fetchNode("Hi"),g.fetchNode("Howdy"),0);
        g.addEdge(g.fetchNode("Sup"),g.fetchNode("Doggy"),0);
        System.out.println(g.fetchEdge(g.fetchNode("Hi")).equals(g.fetchEdge(g.fetchNode("Hi"))));
        System.out.println(g.fetchNode("Bye bye"));
    }
}
