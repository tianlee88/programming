import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Random;

/**
 * Interface for a dictionary data structure
 */
public class ListDict<K extends Comparable<K>,V> implements IDict<K, V>
{
    Tree<K,V> tree = new Tree<>();

    DoubleLinkListDict<K,V> list = new DoubleLinkListDict<>();




    // public ListDict(){
    //   DoubleLinkListDict<K,V> list = new DoubleLinkListDict();
    //
    // }
    /*
     * Adds a value to the dictionary, replacing the existing value if any.
     * @param k key for the new value
     * @param v value
     * @return the value replaced, otherwise null
     */
    public V add(K k, V v){
      boolean key_present = false;
      int key = 0;

      if(list.size()==0){
          // System.out.println("does this guy");
        list.insert(0,v,k);
        list.reduceSize();
      }
      else{
        for (int i = 0; i <list.size()||key_present==true; i++){
          if (k.compareTo(list.fetchKey(i)) == 0){
            key = i;
            key_present = true;
          }
        }
      }
      if (key_present == true){
      V value = list.fetchValue(key);
      list.fetchNode(key).setValue(v);
      return value;
      }
      else{
        list.insert(0,v,k);
        return null;
      }

    }

    /**
     * Removes a value and key from the dictionary. An unmatched key should return null.
     * @param k key to remove
     * @return the value of the removed key
     */
    public V remove(K k){
      int key = -1;
      for (int i = 0; i <list.size(); i++){
        System.out.println("in the loop");
        if (k.compareTo(list.fetchNode(i).getKey())==0){
            key = i;
        }
      }
      if (key == -1){
        System.out.println("first if");
        return null;
      }
      else{
        System.out.println("else");
          V value = list.fetchValue(key);
          list.remove(key);
          return value;
      }

    }


    /**
     * Returns the size of the dictionary
     * @return the number of values stored in the dictionary
     */
    public int size(){
      return list.size();
    }

    /**
     * Returns the value associated with a particular key in the dictionary.
     * Returns null if there is no matching key.
     * @param k key to retrieve the value for
     * @return the value
     */
    public V fetch(K k){
      int key = -1;


      for (int i = 0; i <list.size(); i++){
        if (k.compareTo(list.fetchNode(i).getKey())==0){
            key = i;
        }
    }
    if(key == -1){
      return null;
    }
    else{
      return list.fetchValue(key);
    }
  }

    /**
     * Returns an array of the keys in the dictionary
     * @return array of all keys
     */
    public K[] keys(){
      return list.keyArray();
    }


    public static void main(String[] args){
      ListDict dictionary = new ListDict();
      System.out.println(dictionary.size());

      dictionary.add("a",1);
      System.out.println(dictionary.size());

      System.out.println(" ");
      dictionary.add("b",2);
      System.out.println(dictionary.size());

      System.out.println(" ");
      dictionary.add("c",2);
      System.out.println(dictionary.size());

      System.out.println(" ");

      dictionary.remove("b");
        System.out.println(dictionary.size());

      // dictionary.add(3,"c");
      // dictionary.add(4,"d");
      // System.out.println(dictionary.size());

      System.out.println(dictionary.fetch("a"));
    }


}
