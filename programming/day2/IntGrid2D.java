public class IntGrid2D implements IIntGrid2D
{
  int upper_left_x;
  int upper_left_y;
  int lower_right_x;
  int lower_right_y;
  char fill_value;
  char[][] grid;


  public IntGrid2D(int _upper_left_x, int _upper_left_y,int _lower_right_x, int _lower_right_y, char _fill_value){
    upper_left_x = _upper_left_x;
    upper_left_y = _upper_left_y;
    lower_right_x = _lower_right_x;
    lower_right_y = _lower_right_y;
    fill_value = _fill_value;
    int grid_x = Math.abs(upper_left_x)+1+lower_right_x;
    int grid_y = upper_left_y+1+Math.abs(lower_right_y);
    grid = new char[grid_x][grid_y];
    for (int i = grid_x; i>0; i 
      for (int j = grid_y; j>0; j--)
        grid[i-1][j-1] = ' ';
  }


  /**
   * Sets the value at a point on the grid, replacing the previous value if any.
   * @param p The coordinate to set the value of
   * @param v The value to set at the coordinate
   */
  public void setPoint(IIntPoint2D p, char v){
      grid[p.getX()-upper_left_x][p.getY()-lower_right_y] = v;
  }

  /**
   * Gets the value at a point on the grid
   * @param p The coordinate to get the value of
   * @returns the stored value
   */
  public char getPoint(IIntPoint2D p){
    char point = grid[p.getX()-upper_left_x][p.getY()-lower_right_y];
    return point;

  }

  /**
   * Gets the coordinate for the upper left most location
   * @returns an IIntPoint that is the coordinate of the upper left corner
   */
  public IIntPoint2D getUpperLeftCorner(){
    IIntPoint2D ulcorner = new IntPoint2D(upper_left_x,upper_left_y);
    return ulcorner;

  }

  /**
   * Gets the coordinate for the lower right most location
   * @returns an IIntPoint that is the lower right corner
   */
  public IIntPoint2D getLowerRightCorner(){
      IIntPoint2D lrcorner = new IntPoint2D(lower_right_x,lower_right_y);
      return lrcorner;
  }
}
