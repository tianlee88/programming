/**
 * Class to represent a Node in a graph
 */
public class Node<N> implements INode<N>{
    // Fields
    N value;

    // Edge list?

    public Node() {
        value = null;
    }

    /**
     * Sets the value
     * @param v the value
     */
    public void setValue(N v) {
        value = v;
    }

    /**
     * Retrieve the nodes value
     * @return the value
     */
    public N getValue() {
        return value;
    }
}
