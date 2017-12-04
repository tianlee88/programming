public class DoubleLinkNode<T> implements IDLink<T>
{
  /**
   * The interface for the link cells in a doubly linked list
   */
  IDLink<T> previous;
  IDLink<T> next;
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
      public IDLink<T> getNext(){
        return next;
      }


      /**
       * Gets the previous cell in the list
       * @return the cell
       */
      public IDLink<T> getPrev(){
        return previous;
      }


      /**
       * Sets the next cell in the list
       * @param c the next cell
       */
      public void setNext(IDLink<T> c){
        next = c;
      }

      /**
       * Sets the next cell in the list
       * @param c the next cell
       */
      public void setPrev(IDLink<T> c){
        previous = c;
      }
  }
