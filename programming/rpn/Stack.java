public class Stack<T> implements IStack<T>
{
Node<T> top;
int length;

public Stack(){
  length = 0;
  top = null;
}



/**
 * Pushes a new value onto the stack
 * @param v the value to push
 */
public void push(T v) throws OverFlowException{
  Node<T> push_node = new Node<T>(v,top);
  top = push_node;
  length++;


}

public boolean isEmpty(){
  if(length == 0){
    return true;
  }
  return false;
}

/**
 * Pops the top value from the stack
 * @return the value
 */
public T pop() throws UnderFlowException{
  if (length == 0){throw new UnderFlowException();}
  T v = top.getValue();
  top = top.getNext();
  length--;
  return v;
}

public static void main(String[]argv)throws Exception{
  Stack<Integer> ls = new Stack<Integer>();
  ls.push(1);
  ls.push(2);
  System.out.println(ls.pop());
  System.out.println(ls.pop());
}
}
