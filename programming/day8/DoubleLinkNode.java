public class DoubleLinkNode<T> implements IDLink1<T>
{
  /**
   * The interface for the link cells in a doubly linked list
   */
  IDLink1<T> previous;
  IDLink1<T> next;
  T value;

// when a cell is at the head the p value points towards itself and when it is at the tail the next value point at itself

    public DoubleLinkNode(){
      previous = null;
      next = null;
      value = null;


    }

      /**
       * Gets the current value for this link cell
       * @return the value
       */
      public T getValue(){
        return value;
      }

      /**
       * Sets the current value for this link cell
       * @param v the value to place in this cell
       */
      public void setValue(T v){
        value = v;
      }

      /**
       * Gets the next cell in the list
       * @return the cell
       */
      public IDLink1<T> getNext(){
        return next;
      }


      /**
       * Gets the previous cell in the list
       * @return the cell
       */
      public IDLink1<T> getPrev(){
        return previous;
      }


      /**
       * Sets the next cell in the list
       * @param c the next cell
       */
      public void setNext(IDLink1<T> c){
        next = c;
      }

      /**
       * Sets the next cell in the list
       * @param c the next cell
       */
      public void setPrev(IDLink1<T> c){
        previous = c;
      }
  }
