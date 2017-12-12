public class MergeSort<T extends Comparable> implements ISort<T> {
    /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public void sort(T[] in){
      T[] storer = helper(in);
      for (int i = 0; i< storer.length;i++){
        in[i] = storer[i];
      }
    }

    public T[] helper(T[] in){
      int length = in.length;
      if (length == 1){
        return in;
      }
      else{
        T[] sublist1 =  (T[]) new Comparable[length/2 +length % 2];
        T[] sublist2 = (T[]) new Comparable[length/2];
        int counter1 = 0;
        int counter2 = 0;
        for (int i = 0; i< length; i+=2){

          sublist1[counter1] = in[i];
          counter1++;
        }
        for (int i = 1; i< length; i+=2){
          sublist2[counter2] = in[i];
          counter2++;
        }
        sublist1 = helper(sublist1);
        sublist2 = helper(sublist2);
        return merge(sublist1,sublist2);

      }
}
    public void printList(T[] in){
      for (int i = 0; i<in.length; i++){
        System.out.println(in[i]);
      }
    }


    public T[] merge(T[] sublist1, T[] sublist2){
      int temp_length = sublist1.length+sublist2.length;
      T[] temp_array = (T[]) new Comparable[temp_length];
      int sub1_pointer = 0;
      int sub2_pointer = 0;
    for(int i =0; i< temp_length; i++){
      if(sub1_pointer> sublist1.length - 1){
        temp_array[i]=sublist2[sub2_pointer];
      }
      else if(sub2_pointer> sublist2.length - 1){
        temp_array[i]=sublist1[sub1_pointer];
      }

      else if (sublist1[sub1_pointer].compareTo(sublist2[sub2_pointer])< 0){
      temp_array[i]  = sublist1[sub1_pointer];
      sub1_pointer++;
      }
      else{
          temp_array[i]  = sublist2[sub2_pointer];
          sub2_pointer++;
      }
    }
    return  temp_array;
  }
    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName(){
      return "MergeSort";
    }

    public static void main(String[] args){
      MergeSort mergie = new MergeSort();
      Comparable[] array = new Comparable[7];
      array[0] = 1;
      array[1] = 2;
      array[2] = 3;
      array[3] = 4;
      array[4] = 5;
      array[5] = 6;
      array[6] = 7;
      mergie.sort((Comparable[])array);

}

}
