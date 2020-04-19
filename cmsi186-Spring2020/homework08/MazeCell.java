/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: MazeCell.java<br />
 * purpose : represents a single "square" in a maze.
 * <p>
 * @author : B.J. Johnson
 * @since  : 2020-04-18
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/**
 * A MazeCell represents a single "square" in a maze.  The cell has four sides,
 *    each which can have a state of "OPEN" or "WALL".  There is an array of
 *    four elements to hold the side descriptions.
 */
public class MazeCell {

   private static final int UNSEEN  = 0;
   private static final int VISITED = 1;
   private static final int DONE    = 2;
   private static final int N = 0;
   private static final int E = 1;
   private static final int S = 2;
   private static final int W = 3;

  /**
   * keeps track of the sides for the cell
   */
   private String[] sides = new String[4];
   private int myRow = 0;
   private int myCol = 0;

  /**
   * keeps track of the state for the cell;
   *  states can be one of "VISITED", "DONE", or "UNSEEN"
   */
   private int state = UNSEEN;

  /**
   * constructor sets the initial state, sets all sides to null,
   *  and defines the other adjacent MazeCell connections
   */
   public MazeCell( int row, int col ) {
      state = UNSEEN;
      myRow = row;
      myCol = col;
   }

  /**
   * gets the state of the MazeCell
   * return state CellState [enum value]
   */
   public int getState() {
      return state;
   }

  /**
   * sets the state of the MazeCell
   */
   public void setState( int newState ) throws IllegalArgumentException {
      if( (newState == UNSEEN) ||
          (newState == VISITED) ||
          (newState == DONE) ) {
         state = newState;
      } else {
         throw new IllegalArgumentException( "Illegal state for MazeCell" );
      }
   }

  /**
   * returns the X and Y location information of this MazeCell
   *  in a 2-element array
   */
   public int[] getLocation() {
      int [] location = new int[2];
      location[0] = myRow;
      location[1] = myCol;
      return location;
   }

  /**
   * returns a String representation of this MazeCell
   */
   public String toString() {
      return "row: " + myRow + " col: " + myCol + " state: " + state +
             " N: " + sides[0] + " E: " + sides[1] + " S: " + sides[2] + " W: " + sides[3];
   }


  /**
   * Sets the north side to the value of "WALL" or "OPEN"
   */
   public void setNorth( String value ) {
      sides[N] = value;
   }

  /**
   * Sets the east side to the value of "WALL" or "OPEN"
   */
   public void setEast( String value ) {
      sides[E] = value;
   }

  /**
   * Sets the south side to the value of "WALL" or "OPEN"
   */
   public void setSouth( String value ) {
      sides[S] = value;
   }

  /**
   * Sets the north side to the value of "WALL" or "OPEN"
   */
   public void setWest( String value ) {
      sides[W] = value;
   }

  /**
   * Returns the location above this one.
   */
   public int[] getLocationAbove() {
      int [] location = new int[2];
      location[0] = myRow - 1;
      location[1] = myCol;
      return location;
   }

  /**
   * Returns the location below this one.
   */
   public int[] getLocationBelow() {
      int [] location = new int[2];
      location[0] = myRow + 1;
      location[1] = myCol;
      return location;
   }

  /**
   * Returns the location to the left of this one.
   */
   public int[] getLocationLeft() {
      int [] location = new int[2];
      location[0] = myRow;
      location[1] = myCol - 1;
      return location;
   }

  /**
   * Returns the location to the right of this one.
   */
   public int[] getLocationRight() {
      int [] location = new int[2];
      location[0] = myRow;
      location[1] = myCol + 1;
      return location;
   }

  /**
   * main method for testing
   * @param args not used
   */
   public static void main( String [] args ) {
      int row = 0;
      int col = 0;
      FileDemo fd = new FileDemo();
      MazeCell mz = new MazeCell( row, col );
      for( int i = 0; i < 3; i++ ) {
         for( int j = 0; j < 3; j++ ) {
            mz = new MazeCell( i, j );
            System.out.println( "mz is: " + mz.toString() );
         }
      }

   }

}
