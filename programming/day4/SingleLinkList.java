
public class SingleLinkList<T> implements IList<T>
{

  ISLink<T> head;
  ISLink<T> tail;
  ISLink<T> current;
  int length;
  int current_int;


  public SingleLinkList(){
    head = null;
    tail = null;
    current = null;
    length = 0;
    current_int = 0;
  }
  /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */


  public void insert(int idx, T v){
    ISLink<T> insert = new SingleLinkNode();
    insert.setValue(v);
    current = head;
    current_int = 0;
    if (idx == 0){
      insert.setNext(current);
      head = insert;
    }
    else if(idx == length){
      tail.setNext(insert);
      insert.setNext(insert);
      tail = insert;
    }
    else{
      for(int i = 0; i<idx-1;i++){
        current = current.getNext();
        current_int++;
      }
      ISLink<T> after = current.getNext();
      ISLink<T> before = current;
      before.setNext(insert);
      insert.setNext(after);
    }
    length++;

  }

/**
 * Adds an item to the end of list. Called 'Add' in class, but more usually called
 * append in other libraries. Moves <i>current</i> to the end of the list.
 * @param v Item to add
 */
public void append(T v){
  SingleLinkNode node = new SingleLinkNode();
  node.setValue(v);
  if (length == 0){

    node.setNext(head);
    tail = node;
    head = node;
  }
  else{

    node.setNext(node);
    tail.setNext(node);
    tail = node;
  }
  length++;
  current = tail;
  current_int = length- 1;
}

/**
 * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
 * the previous item in the list, if such element exists.
 */
public void remove(){
 remove(current_int);
 length--;
}

/**
 * Removes the item at a specific index
 * @param idx index of item to remove
 */
public void remove(int idx){
  current = head;
  current_int = 0;
  for(int i = 0; i<idx;i++){
    current = current.getNext();
    current_int++;
  }
  if (current == head){
      ISLink<T> after = current.getNext();
      head = after;
  }
  else if(current ==tail){
      prev();
      ISLink<T> before = current;
      before.setNext(before);
      tail = before;
  }
  else{
    ISLink<T> after = current.getNext();
    prev();
    ISLink<T> before = current;
    before.setNext(after);
  }
  length--;
}


/**
 * Changes the location of an existing element in the list
 * @param sidx - The initial index for the element to move
 * @param didx - The final index for the element to move
 */
public void move(int sidx, int didx){
  ISLink<T> temp = head;
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
  ISLink<T> temp = head;
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
  current_int++;
}

/**
 * Advances the <i>current</i> index to the previous index, if possible.
 */
public void prev(){
  ISLink<T> c = head;
  int current_int1 = 0;
  if (current == head){return;}
  else{
    while(c.getNext()!=current){
      c= c.getNext();
      current_int1++;
    }
  }
  current = c;
  current_int = current_int1;
}

/**
 * Advances the <i>current</i> to the tail element
 */
public void jumpToTail(){
  current = tail;
  current_int = length - 1;
}

/**
 * Advances the <i>current</i> to the head element
 */
public void jumpToHead(){
  current = head;
  current_int = 0;
}

/**
 * Returns the number of elements in the list
 */
public int size(){
  return length;
}


public static void main(String[] args){
     IList<Integer> singleList = new SingleLinkList<Integer>();
  for(int i=0; i<10; i++) {
      singleList.append(i);
    }
    System.out.println("first test (0,9)");
   debugPrint(singleList);
   singleList.insert(9,20);
   System.out.println(" ");
   debugPrint(singleList);

//     IList<Integer> singleList1 = new SingleLinkList<Integer>();
//  for(int i=0; i<10; i++) {
//      singleList1.append(i);
//    }
//    IList<Integer> singleList2 = new SingleLinkList<Integer>();
// for(int i=0; i<10; i++) {
//     singleList2.append(i);
//   }
//   IList<Integer> singleList3 = new SingleLinkList<Integer>();
// for(int i=0; i<10; i++) {
//    singleList3.append(i);
//  }
// System.out.println("first test (0,9)");
// debugPrint(singleList);
// singleList.move(0,9);
// System.out.println(" ");
// debugPrint(singleList);
//
// System.out.println("second test 9,0");
// System.out.println(" ");
// debugPrint(singleList1);
// singleList1.move(9,0);
// System.out.println(" ");
// debugPrint(singleList1);
//
// System.out.println("third test 2,9");
// System.out.println(" ");
// debugPrint(singleList2);
// System.out.println(" ");
// singleList2.move(2,9);
// debugPrint(singleList2);
// System.out.println(" ");
//
// System.out.println("fourth test 2,8");
// debugPrint(singleList3);
// System.out.println(" ");
// singleList3.move(2,4);
// debugPrint(singleList3);




// for(int i=0; i+2<11; i+=2) {
//     singleList.move(i, i+2);
// }
// System.out.println(" ");
// debugPrint(singleList);
//
// for(int i=8; i-2>0; i-=2) {
//     singleList.move(i, i-2);
//}
    // System.out.println(" ");
    // debugPrint(singleList);



}

public static void debugPrint(IList l) {
  for(int i=0; i<l.size(); i++) {
      System.out.println(i+": "+l.fetch(i));
  }

}
}
