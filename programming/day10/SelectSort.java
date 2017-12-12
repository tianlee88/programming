
public class SelectSort<T extends Comparable> implements ISort<T>
{
     /**
     * Sorts an array of items in place
     * @param in An array to sort
     */
    public  void sort(T[] in){
      T holder;
      for (int i = 0; i< in.length -1 ; i++){
        int idx = i;
      for (int j = i+1; j< in.length; j++){
        if (in[j].compareTo(in[idx])< 0){
          idx = j;
        }

      }
        holder = in[idx];
        in[idx] = in[i];
        in[i]= holder;
      }





    // int length = in.length;
    //
    //   T smallest = in[0];
    //   for (int j = 0; j <length - 1; j++){
    //
    //     for(int i = j+1; i  <length-1 - j; i++){
    //
    //       if (smallest.comparteTo(in[i +j])>0){
    //         smallest = in[i +j];
    //       }
    //
    //     }
    //     in[j] = smallest;
    //   }
    //
    //   T holder


      // length = in.length;
      // sorted_list = new T[length];
      // T smallest = in[0];
      // int counter = 0;
      // for (int j = 0; length - 1; j++){
      //
      //   for(int i = 0; i <length-1; i++){
      //     if ((smallest.comparteTo(in[i])>0)&& in[i]){
      //       smallest = in[i]];
      //     }
      //   }
      //   sorted_list[j] = smallest
      //   counter ++;
      //
      //
      //
      // }

    }


    /**
     * Produces the name of the kind of sort implemented
     * @return the name of the sort algorithm
     */
    public String sortName(){
      return "SelectSort";
    }

  //   public void doIt(){
  //     T[] in = (T[]) new Object[4];
  //     in[0] = (T)4;
  //     in[1] = (T)2;
  //     in[2] = (T)3;
  //     in[3] = (T)1;
  //
  //     sort(in);
  //     System.out.println(in[0]);
  //     System.out.println(in[1]);
  //     System.out.println(in[2]);
  //     System.out.println(in[3]);
  //   }
  //
    // public static void main(String[] argv) {
    //       int[] in = new int[4];
    //       in[0] = (T)4;
    //       in[1] = (T)2;
    //       in[2] = (T)3;
    //       in[3] = (T)1;
    //
    //       sort(in);
    //       System.out.println(in[0]);
    //       System.out.println(in[1]);
    //       System.out.println(in[2]);
    //       System.out.println(in[3]);

      // System.out.println(t.fetch(1));
  //
  }
