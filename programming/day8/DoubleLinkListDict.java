/*
greater than zero if its after
less than zero if its before
0 if its the same
doubleLinkw
*/


public class DoubleLinkListDict<K extends Comparable<K>,V>
{

  IDLink<K,V> head;
  IDLink<K,V> tail;
  IDLink<K,V> current;
  int length = 0;




  public DoubleLinkListDict(){
  // IDLink<K,V> head = new IDlink<K,V>();
  // head.setKey(1);
  // head.setValue(2);
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
  public void insert(int idx, V v, K k){
    IDLink<K,V> insert = new DoubleLinkNodeDict();
    insert.setValue(v);
    insert.setKey(k);

    current = head;
    if (idx == 0 && length ==0){
        // System.out.println("first if");
      insert.setNext(insert);
      insert.setPrev(insert);
      head = insert;

    }
    else if(idx == 0){
      // System.out.println("third if");
    //  System.out.println("went into second if");
      insert.setNext(current);
      insert.setPrev(insert);
      current.setPrev(insert);
      head = insert;

    }
   else if(idx == length-1){
      // System.out.println("second if");
      tail.setNext(insert);
      insert.setPrev(tail);
      insert.setNext(insert);
      tail = insert;
    }
    else{
      for(int i = 0; i<idx-1;i++){
        current = current.getNext();
      }
      IDLink<K,V> after = current.getNext();
      IDLink<K,V> before = current;
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
// public void append(T k){
  // DoubleLinkNodeDict node = new DoubleLinkNodeDict();
  // node.setValue(v);
  // node.setKey(k);
  // if (length == 0){
  //   node.setPrev(tail);
  //   node.setNext(head);
  //   tail = node;
  //   head = node;
  // }
  // else{
  //   node.setPrev(tail);
  //   node.setNext(node);
  //   tail.setNext(node);
  //   tail = node;
  // }
  // length++;
  //

//}

/**
 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
 * the previous item in the list, if such element exists.
 */
public void remove(){




  if (current == head){
    IDLink<K,V> after = current.getNext();
    after.setPrev(after);
    current = after;
    head = current;
  }
  if (current == tail){
    IDLink<K,V> before = current.getPrev();
    before.setNext(before);
    current = before;
    tail = current;
  }
  else{
    IDLink<K,V> after = current.getNext();
    IDLink<K,V> before = current.getPrev();
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
      IDLink<K,V> after = current.getNext();
      after.setPrev(after);
      head = after;
  }
  else if(current ==tail){
      IDLink<K,V> before = current.getPrev();
      before.setNext(before);
      tail = before;
  }
  else{
    IDLink<K,V> after = current.getNext();
    IDLink<K,V> before = current.getPrev();
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
  // IDLink<T> temp = head;
  // for(int i = 0; i<sidx;i++){
  //   temp = temp.getNext();
  // }
  //
  //
  //  remove(sidx);
  //  insert(didx,(T)temp.getValue());

}
public void reduceSize(){
  length--;
}

/**
 * Fetches the value at the <i>current</i> index in the list.
 * @return the requested item
 */

/**
 * Fetches the value at a specific index in the list.
 * @param idx index of the item to return
 * @return the requested item
 */
public V fetchValue(int idx){
  IDLink<K,V> temp = head;
  for(int i = 0; i<idx;i++){
    temp = temp.getNext();
  }
  return temp.getValue();
}
public IDLink<K,V> fetchNode(int idx){
  IDLink<K,V> temp = head;
  for(int i = 0; i<idx;i++){
    temp = temp.getNext();
  }
  return temp;
}

public K fetchKey(int idx){
  IDLink<K,V> temp = head;
  if (idx == 0 ){
    return temp.getKey();
  }
  for(int i = 0; i<idx;i++){
    temp = temp.getNext();
  }
  return temp.getKey();
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

public K[] keyArray(){
  IDLink<K,V> temp = head;
  K[] key_array = (K[])new Comparable[length];
  for(int i =0; i < length; i++){
    key_array[i] = temp.getKey();
    temp = temp.getNext();
  }
  return key_array;
}


// public static void main(String[] args){
//   DoubleLinkListDict list = new DoubleLinkListDict();
//   list.insert(0,1,1);
//   list.insert(0,1,2);
//   list.insert(0,1,3);
//   System.out.println(list.keyArray());
//   System.out.println(list.keyArray()[1]);
//   System.out.println(list.keyArray()[2]);
// }



}
