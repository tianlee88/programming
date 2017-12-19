public class StackNode<T>
{
T value;
StackNode<T> pointer;


public StackNode(T v, StackNode<T> p){
value = v;
pointer = p;
}

public void setValue(T v){
  value = v;
}

public T getValue(){
  return value;
}

public void setPointer(StackNode<T> p){
  pointer = p;
}

public StackNode<T> getNext(){
  return pointer;
}
}
