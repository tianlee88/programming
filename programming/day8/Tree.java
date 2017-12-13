import java.util.ArrayList;

public class Tree<K extends Comparable<K>,V> {
    Node<K,V> root;
    Node<K,V> curr;
    int length;
    // ArrayList key_array;

    /**
     * Makes a new empty tree
     */
    public Tree() {
        root = null;
        curr = null;
        length = 0;
        // key_array = new ArrayList();
    }

    public V changeValue(K k,V v){
      curr = root;
      if (k.compareTo(curr.getKey())==0){
        V value = curr.getValue();
        curr.setValue(v);
        return value;
      }
      while (curr.getRight()!= null || curr.getLeft()!=null){
        if(k.compareTo(curr.getKey())> 0) {
            // walk right
            curr= curr.getRight();
            if (k.compareTo(curr.getKey())== 0 ){
              V value = curr.getValue();
              curr.setValue(v);
              return value;
            }
        } else {
            // walk left
            curr= curr.getLeft();
            if (k.compareTo(curr.getKey())== 0 ){
              V value = curr.getValue();
              curr.setValue(v);
              return value;
            }
        }
      }
      return null;
    }

    /**
     * Places a new node in the tree
     * @param k key for the new node
     * @param v value for new node
     */
    public void insert(K k, V v) {
        // look at the root first
        curr = root;
        if(curr==null) {
            root= new Node<K,V>(k,v);
            length++;
            // key_array.add(k);
            return;
        }
        // What to do if we aren't inserting the root
        helper(k,v);
        length++;
        // key_array.add(k);
    }
    // Helps with the insertion method
    public void helper(K k, V v) {
        // Does the new node fit as a direct child

        if((k.compareTo(curr.getKey())< 0 && curr.getLeft()==null) || (k.compareTo(curr.getKey())> 0 && curr.getRight()==null) ){
            if(k.compareTo(curr.getKey())< 0) {
                // insert left
                curr.setLeft(new Node<K,V>(k,v));
            } else {
                // insert right
                curr.setRight(new Node<K,V>(k,v));
            }
            // Work done for the easy case
            return;
        }
        // Place the node with one of the children, based on if the key
        // goes to the left or the right
        if(k.compareTo(curr.getKey())< 0) {
            curr = curr.getLeft();
        } else {
            curr = curr.getRight();
        }
        helper(k,v);
    }

    /**
     * Get the value associated with some key
     * @param k key to search for in the tree
     * @return value associated with the key
     */
    public V fetch(K k) {
        if (fetchIsKey(k)==false){
          return null;
        }
        // start at the root
        curr = root;
        // while we haven't found the key
            // curr.getKey()!=k
            // k!= curr.getKey()
        while(k.compareTo(curr.getKey())!=0) {
            if(k.compareTo(curr.getKey())> 0) {
                // walk right
                curr = curr.getRight();
            } else {
                // walk left
                curr = curr.getLeft();
            }
        }
        // We have found the key or ran out of children
        return curr.getValue();
    }

    public boolean fetchIsKey(K k){
      curr = root;
      if (k.compareTo(curr.getKey())==0){
        return true;
      }
      while (curr.getRight()!= null || curr.getLeft()!=null){
        if(k.compareTo(curr.getKey())>0) {
            // walk right
            curr= curr.getRight();
            if (curr == null){
              return false;
            }
            if (k.compareTo(curr.getKey())== 0 ){
              return true;
            }
        } else {
            // walk left
            curr= curr.getLeft();
              //System.out.println(curr.getKey());
              if (curr == null){
                return false;
              }
            if (k.compareTo(curr.getKey())== 0 ){
              return true;
            }
        }
      }
      return false;
    }

    /**
     * Removes a node from the tree based on the key
     * @param k the key to remove
     */
    public void remove(K k) {
        // Find the node to remove and it's parent
        Node<K,V> parent = null;
        // start at the root
        curr = root;
        // while we haven't found the key
        while(curr.getKey()!=k) {
            if(k.compareTo(curr.getKey())>0) {
                // walk right
                parent = curr;
                curr = curr.getRight();
            } else {
                // walk left
                parent = curr;
                curr = curr.getLeft();
            }
        }
        // We have the node and it's parent

        // Case 1: no children, just kill the node
        // ...could have used isLeaf... but didn't think of that first
        if(curr.getRight()==null && curr.getLeft()==null) {
            if(parent.getRight()==curr) { parent.setRight(null); }
            if(parent.getLeft()==curr)  { parent.setLeft(null); }
            curr = root;
            return;
        }
        // Case 2: 1 child, replace node with child
        // ...maybe redundant... might remove later
        if(curr.getRight()==null || curr.getLeft()==null) {
            // Set the parent to point at the child
            if(curr.getRight()==null) {
                if(parent.getRight()==curr) {
                    parent.setRight(curr.getLeft());
                } else {
                    parent.setLeft(curr.getLeft());
                }
            } else {
                // if(curr.getLeft()==null)
                if(parent.getRight()==curr) {
                    parent.setRight(curr.getRight());
                } else {
                    parent.setLeft(curr.getRight());
                }
            }
            curr=root;
            return;
        }
        // Case 3: Go right once, go left until you can't, remove that
        //         left most node, replace the node you wanted to remove
        //         with the left most node
        // Does this work if the curr is the root... Probably not
        Node<K,V> swapparent = curr;
        Node<K,V> swapnode = curr.getRight(); // trying to find the one to swap
                                            // into curr's place in the tree
        while(swapnode.getLeft() != null) {
            swapparent=swapnode;
            swapnode=swapnode.getLeft();
        }
        // Have left most node, set the left most parent to the right child
        swapparent.setLeft(swapnode.getRight());
        swapnode.setLeft(curr.getLeft());
        swapnode.setRight(curr.getRight());
        if(parent.getRight()==curr) { parent.setRight(swapnode); }
        if(parent.getLeft()==curr)  { parent.setLeft(swapnode); }
        curr = root;
    }

    /**
     * Main method to do some basic checks on functionality
     */
    // public static void main(String[] argv) {
    //     // Tree t = new Tree<Integer,Integer>();
    //       Tree t = new Tree<String,Integer>();
    //     t.insert("c",17);
    //     t.insert("b",10);
    //     t.insert("a",20);
    //     t.insert("e",25);
    //
    //     t.insert(,17);
    //     t.insert(2,10);
    //     t.insert(1,20);
    //     t.insert(5,25);
    //     System.out.println(t.fetchIsKey("e"));
    //     // System.out.println(t.changeValue(1,300));
    //     // System.out.println(t.fetch(1));
    //
    // }

    public int size(){
      return length;
    }

    public void reduceSize(){
      length--;
    }

    public K[] keyArray(){
      curr = root;
      return curr.preorder();
    }




}
