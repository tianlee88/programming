public class Node<T>
{
T value;
Node<T> pointer;


public Node(T v, Node<T> p){
value = v;
pointer = p;
}

public void setValue(T v){
  value = v;
}

public T getValue(){
  return value;
}

public void setPointer(Node<T> p){
  pointer = p;
}

public Node<T> getNext(){
  return pointer;
}
}
