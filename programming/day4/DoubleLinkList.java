
public class DoubleLinkList<T> implements IList<T>
{

  IDLink<T> head;
  IDLink<T> tail;
  IDLink<T> current;
  int length;



  public DoubleLinkList(){
    head = null;
    tail = null;
    current = null;
    length = 0;
  }

  /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */
  public void insert(int idx, T v){
    IDLink<T> insert = new DoubleLinkNode();
    insert.setValue(v);
    current = head;
    if (idx == 0){
      insert.setNext(current);
      insert.setPrev(insert);
      current.setPrev(insert);
      head = insert;
    }
    else if(idx == length){
      tail.setNext(insert);
      insert.setPrev(tail);
      insert.setNext(insert);
      tail = insert;
    }
    else{
      for(int i = 0; i<idx-1;i++){
        current = current.getNext();
      }
      IDLink<T> after = current.getNext();
      IDLink<T> before = current;
      before.setNext(insert);
      after.setPrev(insert);
      insert.setNext(after);
      insert.setPrev(before);
    }

    length++;

  }

/**
 * Adds an item to the end of list. Called 'Add' in class, but more usually called
 * append in other libraries. Moves <i>current</i> to the end of the list.
 * @param v Item to add
 */
public void append(T v){
  DoubleLinkNode node = new DoubleLinkNode();
  node.setValue(v);
  if (length == 0){
    node.setPrev(tail);
    node.setNext(head);
    tail = node;
    head = node;
  }
  else{
    node.setPrev(tail);
    node.setNext(node);
    tail.setNext(node);
    tail = node;
  }
  length++;


}

/**
 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
 * the previous item in the list, if such element exists.
 */
public void remove(){




  if (current == head){
    IDLink<T> after = current.getNext();
    after.setPrev(after);
    current = after;
    head = current;
  }
  if (current == tail){
    IDLink<T> before = current.getPrev();
    before.setNext(before);
    current = before;
    tail = current;
  }
  else{
    IDLink<T> after = current.getNext();
    IDLink<T> before = current.getPrev();
    before.setNext(after);
    after.setPrev(before);
      current = before;
  }

  length--;


}

/**
 * Removes the item at a specific index
 * @param idx index of item to remove
 */
public void remove(int idx){

  current = head;
  for(int i = 0; i<idx;i++){
    current = current.getNext();
  }
  if (current == head){
      IDLink<T> after = current.getNext();
      after.setPrev(after);
      head = after;
  }
  else if(current ==tail){
      IDLink<T> before = current.getPrev();
      before.setNext(before);
      tail = before;
  }
  else{
    IDLink<T> after = current.getNext();
    IDLink<T> before = current.getPrev();
    before.setNext(after);
    after.setPrev(before);
  }
  length--;
}

/**
 * Changes the location of an existing element in the list
 * @param sidx - The initial index for the element to move
 * @param didx - The final index for the element to move
 */
public void move(int sidx, int didx){
  IDLink<T> temp = head;
  for(int i = 0; i<sidx;i++){
    temp = temp.getNext();
  }


   remove(sidx);
   insert(didx,(T)temp.getValue());

}

/**
 * Fetches the value at the <i>current</i> index in the list.
 * @return the requested item
 */
public T fetch(){
  return current.getValue();
}
/**
 * Fetches the value at a specific index in the list.
 * @param idx index of the item to return
 * @return the requested item
 */
public T fetch(int idx){
  IDLink<T> temp = head;
  for(int i = 0; i<idx;i++){
    temp = temp.getNext();;
  }
  return temp.getValue();
}

/**
 * Advances the <i>current</i> index to the next index, if possible.
 */
public void next(){
  current = current.getNext();
}

/**
 * Advances the <i>current</i> index to the previous index, if possible.
 */
public void prev(){
current = current.getPrev();
}

/**
 * Advances the <i>current</i> to the tail element
 */
public void jumpToTail(){
    current = tail;
}

/**
 * Advances the <i>current</i> to the head element
 */
public void jumpToHead(){
  current = head;
}

/**
 * Returns the number of elements in the list
 */
public int size(){
  return length;
}

public static void main(String[] args){
    IList<Integer> doubleList = new DoubleLinkList<Integer>();
  for(int i=0; i<10; i++) {
      doubleList.append(i);
    }

debugPrint(doubleList);
doubleList.move(0,3);
doubleList.move(3,6);
doubleList.move(6,9);
System.out.println(" ");
debugPrint(doubleList);





}

public static void debugPrint(IList l) {
  for(int i=0; i<l.size(); i++) {
      System.out.println(i+": "+l.fetch(i));
  }
}

}
