public class ArrayList<T> implements IList<T>
{
  T[] array;
  int current;
  /**
   * Inserts an item at a specific index in the list
   * @param idx where the item should be inserted
   * @param v the value to insert
   */

   public ArrayList(){
     array = (T[]) new Object[0];
     current = 0;
   }

  public void insert(int idx, T v)
  {
    int size = array.length;
    T[] temporary =(T[]) new Object[size+1];
    int counter = 0;

    for (int i = 0; i < size; i++){
      if (i == idx){
        temporary[i] = v;
        counter++;
      }
      if (counter == 0) {
        temporary[i] = array[i];
      }
      else {
        temporary[i+1] = array[i];
      }
    }
    if (idx == size)
      temporary[idx] = v;


    array = temporary;


  }


  /**
  * Adds an item to the end of list. Called 'Add' in class, but more usually called
  * append in other libraries. Moves <i>current</i> to the end of the list.
  * @param v Item to add
  */
  public void append(T v)
  {

      int size = array.length;
      T[] temporary =(T[]) new Object[size+1];
      for (int i = 0; i < size; i++){
          temporary[i] = array[i];
        }
      temporary[size] = v;
      array = temporary;
      current = size -1;
  }


  /**
  * Removes the item at the <i>current</i> index in the list. <i>Current</i> becomes
  * the previous item in the list, if such element exists.
  */
  public void remove(){
    int size = array.length;
    T[] temporary =(T[]) new Object[size-1];
    int counter = 0;
    for (int i = 0; i < size; i++){
      if (i == current){
        counter++;
      }
      else if (counter == 0) {
        temporary[i] = array[i];
      }
      else {
        temporary[i-1] = array[i];
      }

    }
    array = temporary;
    if (current != 0){
      prev();
    }
    else {
      int do_nothing = 0;
    }



  }

  /**
  * Removes the item at a specific index
  * @param idx index of item to remove
  */
  public void remove(int idx){
    int size = array.length;
    T[] temporary =(T[]) new Object[size-1];
    int counter = 0;
    for (int i = 0; i < size; i++){
      if (i == idx){
        counter++;
      }
      else if (counter == 0) {
        temporary[i] = array[i];
      }
      else {
        temporary[i-1] = array[i];
      }

    }
    array = temporary;
  }

  /**
  * Changes the location of an existing element in the list
  * @param sidx - The initial index for the element to move
  * @param didx - The final index for the element to move
  */
  public void move(int sidx, int didx){
    // T[] temporary =(T[]) new Object[size];
    T mover = array[sidx];
    remove(sidx);
    // for (T e : array){
    //   System.out.println(e);
    // }
    insert(didx,mover);
  }
    // int size = array.length;
  //
  //   int counter = 0;
  //
  //   if (sidx < didx){
  //     for (int i = 0; i < size; i++){
  //       if (i == sidx){
  //         temporary[didx] = array[sidx];
  //         counter++;
  //       }
  //       else if (counter == 1) {
  //         temporary[i] = array[i-1];
  //       }
  //       else if (counter == 0) {
  //         temporary[i] = array[i];
  //       }
  //       else{
  //         int do_nothing = 0;
  //       }
  //     }
  //   }
  //   else {
  //     for (int i = size -1; i < 0; i--){
  //       if (i == sidx){
  //         temporary[didx] = array[sidx];
  //         counter++;
  //       }
  //       else if (counter == 1) {
  //         temporary[i] = array[i+1];
  //       }
  //       else if (counter == 0) {
  //         temporary[i] = array[i];
  //       }
  //       else{
  //         int do_nothing = 0;
  //       }
  //   }
  // }
    // array = temporary;


  /**
  * Fetches the value at the <i>current</i> index in the list.
  * @return the requested item
  */
  public T fetch(){
    return array[current];
  }

  /**
  * Fetches the value at a specific index in the list.
  * @param idx index of the item to return
  * @return the requested item
  */
  public T fetch(int idx){
      return array[idx];
  }

  /**
  * Advances the <i>current</i> index to the next index, if possible.
  */
  public void next(){
    if (current <array.length -1){
    current++;
  }
  }
  /**
  * Advances the <i>current</i> index to the previous index, if possible.
  */
  public void prev(){
    if (current > 0){
    current--;
  }
}



  /**
  * Advances the <i>current</i> to the tail element
  */
  public void jumpToTail(){
     current = array.length -1;
  }

  /**
  * Advances the <i>current</i> to the head element
  */
  public void jumpToHead(){
    current  = 0;
  }

  /**
  * Returns the number of elements in the list
  */
  public int size(){
    return array.length;
  }

  public static void main(String[] args){
  IList<Integer> arrayList  = new ArrayList<Integer>();
  for(int i=0; i<10; i++)
    {
      arrayList.append(i);
    }


  arrayList.insert(2,20);
  arrayList.move(1,9);
    debugPrint(arrayList);
  System.out.println(" ");
  debugPrint(arrayList);

  }


public static void debugPrint(IList l) {
    for(int i=0; i<l.size(); i++) {
        System.out.println(i+": "+l.fetch(i));
    }
  }
}
