/**
 * The interface for the link cells in a doubly linked list
 */
public interface IDLink1<T> {
    /**
     * Gets the current value for this link cell
     * @return the value
     */
    public T getValue();

    /**
     * Sets the current value for this link cell
     * @param v the value to place in this cell
     */
    public void setValue(T v);

    /**
     * Gets the next cell in the list
     * @return the cell
     */
    public IDLink1<T> getNext();

    /**
     * Gets the previous cell in the list
     * @return the cell
     */
    public IDLink1<T> getPrev();

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setNext(IDLink1<T> c);

    /**
     * Sets the next cell in the list
     * @param c the next cell
     */
    public void setPrev(IDLink1<T> c);
}
