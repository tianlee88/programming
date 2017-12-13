
public class Node<K,V> {
    K key;
    V value;
    Node<K,V> left;
    Node<K,V> right;
    int idx = 0;
    int counter = 0;

    /**
     * Makes a shiny new Node
     * @param k the key
     * @param v the value
     */
    public Node(K k, V v) {
        key = k;
        value = v;
        counter++;
    }

    /**
     * Sets the left child of this node
     * @param l the new left child
     */
    public void setLeft(Node<K,V> l) {
        left = l;
    }

    /**
     * Sets the right child of this node
     * @param r the new left child
     */
    public void setRight(Node<K,V> r) {
        right = r;
    }

    /**
     * Gets the left child
     * @return left child
     */
    public Node<K,V> getLeft() {
        return left;
    }
    /**
     * Gets the right child
     * @return right child
     */
    public Node<K,V> getRight() {
        return right;
    }

    /**
     * Checks if the node is a leaf
     * @return true if the node is a leaf
     */
    public boolean isLeaf() {
        if(left==null && right==null) {
            return true;
        }
        return false;
    }

    /**
     * Gets the key for this node
     * @return the key value
     */
    public K getKey() {
        return key;
    }

    /**
     * Gets the value for this node
     * @return the node value
     */
    public V getValue() {
        return value;
    }

    public void setValue(V v){
      value = v;
    }



    public K[] preorder() {
        int index = 0;
        K[] key_array = (K[])new Comparable[counter];
        // print self

        key_array[index] = getKey();
        index++;
        // print left
        if(left != null) {
            left.preorder();
        }
        // print right
        if(right != null) {
            right.preorder();
        }

        return key_array;
    }
}
