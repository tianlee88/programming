/**
 * Interface for a dictionary data structure
 */
public class TreeDict<K extends Comparable<K>,V> implements IDict<K, V>
{
    Tree<K,V> tree = new Tree<>();




    /**
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */
    public V add(K k, V v){
      if (tree.size()==0){
        tree.insert(k,v);
        return null;
      }
      if (tree.fetchIsKey(k) == false){
        tree.insert(k,v);
        return null;
      }
      else{
          V value = tree.fetch(k);
        tree.changeValue(k,v);

        return value;
      }
    }

    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k){
      if (tree.size()==0){
        return null;
      }
      if (tree.fetchIsKey(k)== false){
        return null;
      }
      else{
        V value = tree.fetch(k);
        tree.remove(k);
        tree.reduceSize();
        return value;
      }
    }

    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size(){
      return tree.size();
    }

    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k){
      return tree.fetch(k);
    }

    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys(){
    return tree.keyArray();
    }

    public static void main(String[] argv) {
        TreeDict<Integer,Integer> dictionary = new TreeDict();

        dictionary.add(5,4);
        dictionary.add(2,4);
        dictionary.add(1,4);
        dictionary.add(8,4);
        dictionary.add(6,4);

          System.out.println(dictionary.keys()[0]);


    }
}
