public class IntPoint2D implements IIntPoint2D
{
  int x;
  int y;
  public IntPoint2D(int _x, int _y)
  {
    x = _x;
    y = _y;

  }
    /**
     * @returns the X coordinate
     */
    public int getX(){
      return x;
    }


    /**
     * @returns the Y coordinate
     */
    public int getY(){
      return y;
    }

    /**
     * Computes the manhattan distance to another point.
     * formula: abs(x1-x2) + abs(y1-y2)
     * @param o the other point
     * @returns the manhattan distance
     */
    public int manhattanDistance(IIntPoint2D o){
    int manhatten_distance = Math.abs(x - o.getX()) + Math.abs(y - o.getY());
    return manhatten_distance;
    }

    /**
     * Computes the euclidean distance to another point.
     * formula: sqrt((x1-x2)^2 + (y1-y2)^2)
     * @param o the other point
     * @returns the euclidean distance
     */
    public double distance(IIntPoint2D o){
      double e_distance = Math.sqrt(Math.pow(x-o.getX(),2) + Math.pow(y-o.getY(),2));
      return e_distance;

    }




    // The following methods make JAVA objects better behaved
    /**
     * Converts a point object to a string of the form (X,Y)
     * @returns human friendly point representation
     */
    public String toString(){

      return "("+ x + "," + y + ")";
    }


    /**
     * Determines if this point is the same as another (i.e. x1=x2 and y1=y2)
     * @returns true if this point is the same as point o
     */
  public boolean equals(IntPoint2D o){
      if (x != o.getX()){
        return false;
      }
      else if (y != o.getY()){
        return false;
      }
      else{
        return true;
      }
    }

    /**
     * Hashcode to support some standard library data structures
     * formula: (x<<16)+y
     * @returns the hashcode for the point
     */
    public int hashcode(){
      return (x<<16)+y;
    }
}
