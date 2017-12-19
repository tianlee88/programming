public class BreadthSearch<N,W> implements ISearcher<N,W>
{
//double coded by paul and tian
/**
 * Determines if there is a path without returning the path
 * @param g the graph to search in
 * @param s node to start from
 * @param e node to end at
 * @return if a path of any length exists
 */
public boolean pathExists(IGraph<N,W> g, INode<N> s, INode<N> e){
  return false;
  }


/**
 * Finds a path based on the properties of the search algorithm.
 * If there is no path in graph g from node s to node e, null should be
 * returned. If node s and node e are the same, an empty list should be returned.
 * @param g the graph to search in
 * @param s node to start from
 * @param e node to end at
 * @return the list of nodes in the path
 */
public IList<INode<N>> getPath(IGraph<N,W> g, INode<N> s, INode<N> e){
ArrayQueue<IEdge<N,W>> q = new ArrayQueue(g.getEdgeSet().length);
DoubleLinkList<INode<N>> visited_nodes = new DoubleLinkList();
Stack<IEdge<N,W>> dq_edges = new Stack();

if (s == e){
IList<INode<N>> empty_path = new DoubleLinkList();
  return empty_path;
}

  IEdge<N,W>[] edge_neighbors = g.getEdgesFrom(s);
  visited_nodes.append(s);

  for (int i = 0;i<edge_neighbors.length;i++){
      q.enqueue(edge_neighbors[i]);
      visited_nodes.append(edge_neighbors[i].getDestination());
  }

boolean runner = true;
while(runner == true)
{
  //if it gets through the whole thing and doesn't finds
  // e
  if(g.getEdgeSet().length == dq_edges.getSize()){
    return null;
  }

    IEdge<N,W> edge = q.dequeue();
    boolean node_checker = true;
    //cycles visisted nodes to
    for (int j = 0;j<visited_nodes.size(); j++ ) {
      if(visited_nodes.fetch(j) == edge.getDestination()){
        node_checker = false;
      }
    }

    if(node_checker == true)
    {
      dq_edges.push(edge);
      INode<N> node = edge.getDestination();
        visited_nodes.append(node);
    if(node == e){
      runner = false;
    }

    IEdge<N,W>[] edge_neighbor = g.getEdgesFrom(node);


    //IEdge<N,W>[] edge_neighbor = g.getEdgesFrom(dequeue_edge);
    for (int i = 0;i<edge_neighbor.length;i++){
        q.enqueue(edge_neighbor[i]);
    }
    }
}


IList<INode<N>> path = new DoubleLinkList();
while(dq_edges.isEmpty()==false){
    path.insert(0,dq_edges.pop().getSource());
}

return path;
}



public static void main(String[] args) {
  DepthSearch<String,Integer> d = new DepthSearch<String,Integer>();
  Graph<String,Integer> g = new Graph<String,Integer>();

  g.addNode("1");
  g.addNode("2");
  g.addNode("3");
  g.addNode("4");
  g.addNode("5");
  g.addNode("6");
  g.addNode("7");


  g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
  g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
  g.addEdge(g.fetchNode("3"),g.fetchNode("2"),0);
  g.addEdge(g.fetchNode("2"),g.fetchNode("4"),0);
  g.addEdge(g.fetchNode("4"),g.fetchNode("3"),0);
  g.addEdge(g.fetchNode("5"),g.fetchNode("3"),0);
  g.addEdge(g.fetchNode("4"),g.fetchNode("3"),0);
  g.addEdge(g.fetchNode("4"),g.fetchNode("5"),0);
  g.addEdge(g.fetchNode("5"),g.fetchNode("6"),0);
  g.addEdge(g.fetchNode("6"),g.fetchNode("4"),0);
  g.addEdge(g.fetchNode("6"),g.fetchNode("7"),0);


  // System.out.println(g.getEdgesFrom(g.fetchNode("5"))[0].getDestination().getValue());
  // System.out.println(g.getEdgesFrom(g.fetchNode("5"))[1].getDestination().getValue());



  //   System.out.println("start");
  // System.out.println(g.fetchNode("1").getValue());
  // System.out.println(g.fetchNode("2").getValue());
  // System.out.println(g.fetchNode("3").getValue());
  // System.out.println(g.fetchNode("4").getValue());
  // System.out.println(g.fetchNode("5").getValue());
  // System.out.println(g.fetchNode("6").getValue());
  // System.out.println(g.fetchNode("7").getValue());
  // // System.out.println(g.fetchNode("8").getValue());
  // System.out.println("end");
  IList<INode<String>> path = d.getPath(g,g.fetchNode("1"),g.fetchNode("7"));
  for (int i =0; i<path.size();i++){
    System.out.println(path.fetch(i).getValue());
  }
//System.out.println(d.pathExists(g,g.fetchNode("1"),g.fetchNode("5")));
  // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("7")).fetch(0).getValue());
  // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("7")).fetch(1).getValue());
  // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("7")).fetch(2).getValue());
  // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("7")).fetch(3).getValue());
  // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("7")).fetch(4).getValue());
  // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("7")).fetch(5).getValue());
  // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("7")).fetch(6).getValue());
}


}
