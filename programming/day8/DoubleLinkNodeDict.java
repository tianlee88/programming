public class DoubleLinkNodeDict<K,V> implements IDLink<K,V>
{
  /**
   * The interface for the link cells in a doubly linked list
   */
  IDLink<K,V> previous;
  IDLink<K,V> next;
  V value;
  K key;

// when a cell is at the head the p value points towards itself and when it is at the tail the next value point at itself

    // public DoubleLinkNodeDict(){
    //   previous = null;
    //   next = null;
    //   value = null;
    //   key = null;

      public DoubleLinkNodeDict(){
        previous = null;
        next = null;
        value = null;
        key = null;


    }

      /**
       * Gets the current value for this link cell
       * @return the value
       */
      public V getValue(){
        return value;
      }

      /**
       * Sets the current value for this link cell
       * @param v the value to place in this cell
       */
      public void setValue(V v){
        value = v;
      }

      /**
       * Gets the next cell in the list
       * @return the cell
       */
      public IDLink<K,V> getNext(){
        return next;
      }


      /**
       * Gets the previous cell in the list
       * @return the cell
       */
      public IDLink<K,V> getPrev(){
        return previous;
      }


      /**
       * Sets the next cell in the list
       * @param c the next cell
       */
      public void setNext(IDLink<K,V> c){
        next = c;
      }

      /**
       * Sets the next cell in the list
       * @param c the next cell
       */
      public void setPrev(IDLink<K,V> c){
        previous = c;
      }

      public void setKey(K k){
        key = k;
      }

      public K getKey(){
        return key;
      }
  }
