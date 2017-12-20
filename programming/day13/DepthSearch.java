public class DepthSearch<N,W> implements ISearcher<N,W>
{
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

public int visitedHelper(IGraph<N,W> g,INode<N> target,DoubleLinkList<INode<N>> visited){
//System.out.println("whooray");
    INode<N>[] neighbors = g.getNeighbors(target);
    int unvisited = neighbors.length;
    boolean runner = true;
  //  System.out.println(neighbors[0].getValue());
    for(int i = 0; i<neighbors.length;i++){
      //System.out.println(visited.size());
      for(int j = 0; j<visited.size();j++){
        if (neighbors[i] == visited.fetch(j)){
            unvisited--;
            runner=false;
        }
      }
      runner = true;
    }
    return unvisited;
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
  //creating list to make sure that nodes have already been visited.
  DoubleLinkList visited_nodes = new DoubleLinkList();
  visited_nodes.append(s);
  //condition for when the start and end nodes are the same.
  if (s == e){
  IList<INode<N>> empty_path = new DoubleLinkList();
    return empty_path;
  }
  //initially putting the start node in the path_stack and adding meibors to temp stack

  Stack path_stack = new Stack();
  Stack temp_stack = new Stack();
  INode<N>[] neighbor = g.getNeighbors(s);
  int counter = 0;
  for (int i = 0;i<neighbor.length;i++){
      temp_stack.push(neighbor[i]);
  }
  path_stack.push(s);


  //finds path using while loop by calling get neighbors on the top of temp_stack
  boolean runner = true;
  while(runner == true)
  {

  System.out.println("went through the loop");
  System.out.println("wtf");


    if (temp_stack.isEmpty() == true) {
      System.out.println("its lit");
      return null;
    }
    INode<N> source_node = (INode<N>)temp_stack.pop();
    //check to see if the node has already been visited.
    for (int j = 0;j<visited_nodes.size(); j++){
      if(visited_nodes.fetch(j)==source_node){
        //System.out.println("checked");
          if(temp_stack.isEmpty()==true){
            //    System.out.println("checked1");
            return null;
          }
          source_node=(INode<N>)temp_stack.pop();
      }
    }
    visited_nodes.append(source_node);
    // condition if node path leads me down a rabbit hole
     // System.out.println(source_node.getValue());
      // System.out.println(g.getNeighbors(source_node)[0]);
    if(g.getNeighbors(source_node) == null){
        source_node = (INode<N>)path_stack.pop();

      while(visitedHelper(g,source_node,visited_nodes)==0){
      if(path_stack.pop()==null){
        return null;
      }
      else{
        source_node = (INode<N>)path_stack.pop();
      }

      // System.out.println(source_node.getValue()+"other guy");
      }
      // System.out.println(source_node.getValue()+"this is the guy");
      //source_node = (INode<N>)path_stack.pop();
      // System.out.println(source_node.getValue());
      // source_node = (INode<N>)path_stack.pop();
      // System.out.println(source_node.getValue());
      // source_node= (INode<N>)path_stack.pop();


    }

    INode<N>[] neighbor_list = g.getNeighbors(source_node);

    for (int i = 0;i<neighbor_list.length;i++){
      if (neighbor_list[i]==e){
        path_stack.push(e);
        runner = false;
      }

        temp_stack.push(neighbor_list[i]);
    }
    // System.out.println("the guy");
    //  System.out.println(source_node.getValue());

    path_stack.push(source_node);
  }

  INode<N> second_to_last = (INode<N>) path_stack.pop();
  INode<N> last = (INode<N>)path_stack.pop();
  path_stack.push(second_to_last);
  path_stack.push(last);

  IList<INode<N>> path = new DoubleLinkList();
  while(path_stack.isEmpty()==false){
    path.insert(0,(INode<N>) path_stack.pop());
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
      g.addNode("8");

    // g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
    // g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
    // g.addEdge(g.fetchNode("2"),g.fetchNode("3"),0);
    // g.addEdge(g.fetchNode("3"),g.fetchNode("4"),0);
    // g.addEdge(g.fetchNode("3"),g.fetchNode("6"),0);
    // g.addEdge(g.fetchNode("4"),g.fetchNode("5"),0);
    // g.addEdge(g.fetchNode("6"),g.fetchNode("7"),0);
    // g.addEdge(g.fetchNode("5"),g.fetchNode("8"),0);
    // g.addEdge(g.fetchNode("7"),g.fetchNode("8"),0);

    g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
    g.addEdge(g.fetchNode("3"),g.fetchNode("4"),0);



    // g.addEdge(g.fetchNode("1"),g.fetchNode("3"),0);
    // g.addEdge(g.fetchNode("3"),g.fetchNode("4"),0);
    // g.addEdge(g.fetchNode("3"),g.fetchNode("7"),0);
    // g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
    // g.addEdge(g.fetchNode("2"),g.fetchNode("6"),0);
    // g.addEdge(g.fetchNode("2"),g.fetchNode("5"),0);
    // g.addEdge(g.fetchNode("5"),g.fetchNode("8"),0);
    //   g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);

  // g.addEdge(g.fetchNode("1"),g.fetchNode("2"),0);
  //  g.addEdge(g.fetchNode("2"),g.fetchNode("3"),0);
  //  g.addEdge(g.fetchNode("3"),g.fetchNode("5"),0);
  //  g.addEdge(g.fetchNode("2"),g.fetchNode("4"),0);



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
    // System.out.println(g.fetchNode("8").getValue());
    // System.out.println("end");

 //System.out.println(d.pathExists(g,g.fetchNode("1"),g.fetchNode("5")));
 System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("4")));
    // IList<INode<String>> path = d.getPath(g,g.fetchNode("1"),g.fetchNode("3"));
    // for (int i =0; i<path.size();i++){
    //   System.out.println(path.fetch(i).getValue());
    // }

    // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("5")).fetch(1).getValue());
    // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("5")).fetch(2).getValue());
    // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("5")).fetch(3).getValue());
    //System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("5")).fetch(4).getValue());
    // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("5")).fetch(5).getValue());
    // System.out.println(d.getPath(g,g.fetchNode("1"),g.fetchNode("5")).fetch(6).getValue());



}


}
