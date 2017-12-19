public class Stack<T> implements IStack<T>
{
StackNode<T> top;
int length;

public Stack(){
  length = 0;
  top = null;
}



/**
 * Pushes a new value onto the stack
 * @param v the value to push
 */
public void push(T v) {

  StackNode<T> push_node = new StackNode<T>(v,top);
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
public T pop() {
//  if (length == 0){throw new UnderFlowException();}
  T v = top.getValue();
  top = top.getNext();
  length--;
  return v;
}

public int getSize(){
  return length;
}

public static void main(String[]argv){
  Stack<Integer> ls = new Stack<Integer>();
  ls.push(1);
  ls.push(2);
  System.out.println(ls.pop());
  System.out.println(ls.pop());
}
}
