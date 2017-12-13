
public class Edge<N,W> implements IEdge<N,W> {
    // Field
    W weight;

    // Nodes connected by this edge
    INode<N> a;
    INode<N> b;

    public Edge(INode<N> a, INode<N> b, W w) {
        this.a = a;
        this.b = b;
        weight = w;
    }

    /**
     * Change the weight
     * @param w the new weight
     */
    public void setWeight(W w) { weight=w; }

    /**
     * Retrieve the current weight
     * @return weight
     */
    public W getWeight() { return weight; }

    /**
     * Get Node A
     * @return a side
     */
    public INode<N> getSource() { return a; }

    /**
     * Get Node B
     * @return b side
     */
    public INode<N> getDestination() { return b; }

    /**
     * Test for equality of two edges.
     * Edges are equal when the node instances are exactly the same; i.e. this.src==o.src
     * and this.dst == o.dst
     * @param o the other edge
     * @return true if the edges are the same
     */
    public boolean equals(Object o){

      try {
        IEdge<N,W> e = new Edge<N,W>(null,null,null);
        e = (IEdge)o;
        if ((this.a == e.getSource()) && (this.b == e.getDestination())){
          return true;
        }
        else{
          return false;
        }
      }
      catch(ClassCastException error){
        return false;
      }

    }
}
