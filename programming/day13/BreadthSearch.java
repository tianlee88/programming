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
  if (getPath(g,s,e)==null){
    return false;
  }
  else{
    return true;

  }
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
Stack<IEdge<N,W>> path_stack = new Stack();
IList<INode<N>> path = new DoubleLinkList();

if (s == e){
IList<INode<N>> empty_path = new DoubleLinkList();
  return empty_path;
}

  IEdge<N,W>[] edge_neighbors = g.getEdgesFrom(s);
  visited_nodes.append(s);

  for (int i = 0;i<edge_neighbors.length;i++){
      if(edge_neighbors[i].getDestination() == e){
        path.insert(0,e);
      }
      //might be doing this too early
      //visited_nodes.append(edge_neighbors[i].getDestination());
      q.enqueue(edge_neighbors[i]);
  }

boolean runner = true;
while(runner == true)
{
    System.out.println("going through loop");
  //if it gets through the whole thing and doesn't finds
  // e
  if(g.getEdgeSet().length == path_stack.getSize()){
    return null;
  }

    IEdge<N,W> edge = q.dequeue();
    if(edge == null){
      return null;
    }
    boolean node_checker = true;
    //cycles visisted nodes to
  //System.out.println(edge);
  //System.out.println(edge.getDestination().getValue());
    for (int j = 0;j<visited_nodes.size(); j++ ) {
      if(visited_nodes.fetch(j) == edge.getDestination()){
        System.out.println("yes");
        node_checker = false;
      }
      else if(edge.getDestination() == e){
        path_stack.push(edge);
        runner = false;
      }
    }

    if(node_checker == true)
    {
      path_stack.push(edge);
      INode<N> node = edge.getDestination();
        visited_nodes.append(node);
        if(g.getEdgesFrom(node)!= null){
          IEdge<N,W>[] edge_neighbor = g.getEdgesFrom(node);
          // System.out.println(edge_neighbor[0].getDestination().getValue());

          for (int i = 0;i<edge_neighbor.length;i++){
              if(edge_neighbor[i].getDestination() == e){
                  System.out.println("why");
                path_stack.push(edge_neighbor[i]);
                path.insert(0,e);
                runner = false;
              }
              q.enqueue(edge_neighbor[i]);
        }

    }
    }
}



IEdge<N,W> beginning_edge = path_stack.pop();
  INode<N> beginning_node = beginning_edge.getSource();
while(path_stack.isEmpty()==false){
    IEdge<N,W> new_edge = path_stack.pop();
    if(new_edge.getDestination()==beginning_node){
    //  System.out.println(new_edge.getSource().getValue());
      path.insert(0,new_edge.getDestination());
    //  path.insert(0,new_edge.getSource());
      beginning_node = new_edge.getSource();
    }
}
path.insert(0,s);
System.out.println(path.fetch(0));
return path;
}



public static void main(String[] args) {
  BreadthSearch<String,Integer> b = new BreadthSearch<String,Integer>();
  Graph<String,Integer> g = new Graph<String,Integer>();

  g.addNode("1");
  g.addNode("2");
  g.addNode("3");
  g.addNode("4");
  g.addNode("5");
  g.addNode("6");
  g.addNode("7");
  g.addNode("8");
    g.addNode("9");

  //
  // g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
  // g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
  // g.addEdge(g.fetchNode("3"),g.fetchNode("2"),0);
  // g.addEdge(g.fetchNode("2"),g.fetchNode("4"),0);
  // g.addEdge(g.fetchNode("4"),g.fetchNode("3"),0);
  // g.addEdge(g.fetchNode("5"),g.fetchNode("3"),0);
  // g.addEdge(g.fetchNode("4"),g.fetchNode("5"),0);
  // g.addEdge(g.fetchNode("5"),g.fetchNode("6"),0);
  // g.addEdge(g.fetchNode("6"),g.fetchNode("4"),0);
  // g.addEdge(g.fetchNode("6"),g.fetchNode("7"),0);

// // easy case
// g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
//  g.addEdge(g.fetchNode("3"),g.fetchNode("4"),0);
//   g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
//   g.addEdge(g.fetchNode("2"),g.fetchNode("7"),0);
//  g.addEdge(g.fetchNode("7"),g.fetchNode("6"),0);
//  g.addEdge(g.fetchNode("4"),g.fetchNode("5"),0);
//  g.addEdge(g.fetchNode("5"),g.fetchNode("6"),0);




  // second it test1
  // g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
  // g.addEdge(g.fetchNode("2"),g.fetchNode("3"),0);
  //
  //  g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
  //
  // g.addEdge(g.fetchNode("3"),g.fetchNode("5"),0);
  // g.addEdge(g.fetchNode("5"),g.fetchNode("9"),0);
  // g.addEdge(g.fetchNode("9"),g.fetchNode("6"),0);
  // g.addEdge(g.fetchNode("5"),g.fetchNode("2"),0);
  // g.addEdge(g.fetchNode("2"),g.fetchNode("4"),0);
  // g.addEdge(g.fetchNode("4"),g.fetchNode("6"),0);
  // g.addEdge(g.fetchNode("4"),g.fetchNode("7"),0);
  // g.addEdge(g.fetchNode("7"),g.fetchNode("6"),0);
  // g.addEdge(g.fetchNode("6"),g.fetchNode("8"),0);


// // cycles one
//   g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
//  g.addEdge(g.fetchNode("2"),g.fetchNode("3"),0);
//  g.addEdge(g.fetchNode("3"),g.fetchNode("5"),0);
//
//
//
//  g.addEdge(g.fetchNode("4"),g.fetchNode("2"),0);
//  g.addEdge(g.fetchNode("5"),g.fetchNode("7"),0);
//  g.addEdge(g.fetchNode("5"),g.fetchNode("4"),0);
//
//  g.addEdge(g.fetchNode("7"),g.fetchNode("8"),0);
//
//  g.addEdge(g.fetchNode("6"),g.fetchNode("5"),0);
//  g.addEdge(g.fetchNode("8"),g.fetchNode("9"),0);
//   g.addEdge(g.fetchNode("8"),g.fetchNode("6"),0);

g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
g.addEdge(g.fetchNode("1"),g.fetchNode("9"),0);
g.addEdge(g.fetchNode("3"),g.fetchNode("4"),0);
g.addEdge(g.fetchNode("4"),g.fetchNode("5"),0);
g.addEdge(g.fetchNode("5"),g.fetchNode("6"),0);
g.addEdge(g.fetchNode("6"),g.fetchNode("2"),0);
g.addEdge(g.fetchNode("9"),g.fetchNode("8"),0);
g.addEdge(g.fetchNode("8"),g.fetchNode("7"),0);
g.addEdge(g.fetchNode("7"),g.fetchNode("6"),0);



  // // his first case
  // g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
  //  g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
  //  g.addEdge(g.fetchNode("3"),g.fetchNode("4"),0);
  //  g.addEdge(g.fetchNode("3"),g.fetchNode("5"),0);
  //  g.addEdge(g.fetchNode("5"),g.fetchNode("6"),0);
  //  g.addEdge(g.fetchNode("5"),g.fetchNode("7"),0);




// //  first iteration test case1
//   g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
//   g.addEdge(g.fetchNode("2"),g.fetchNode("3"),0);
//   g.addEdge(g.fetchNode("3"),g.fetchNode("5"),0);
//   g.addEdge(g.fetchNode("5"),g.fetchNode("2"),0);
//   g.addEdge(g.fetchNode("2"),g.fetchNode("4"),0);
//   g.addEdge(g.fetchNode("4"),g.fetchNode("6"),0);
//   g.addEdge(g.fetchNode("5"),g.fetchNode("6"),0);
//   g.addEdge(g.fetchNode("4"),g.fetchNode("7"),0);
//   g.addEdge(g.fetchNode("6"),g.fetchNode("7"),0);
//   g.addEdge(g.fetchNode("6"),g.fetchNode("8"),0);



  // System.out.println(g.getEdgesFrom(g.fetchNode("5"))[0].getDestination().getValue());
  // System.out.println(g.getEdgesFrom(g.fetchNode("5"))[1].getDestination().getValue());




  //System.out.println(b.getPath(g,g.fetchNode("1"),g.fetchNode("4")));
  // nice way to print out path
  IList<INode<String>> path = b.getPath(g,g.fetchNode("1"),g.fetchNode("2"));
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
