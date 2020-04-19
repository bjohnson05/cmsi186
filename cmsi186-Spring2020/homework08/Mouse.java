/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: Mouse.java<br />
 * purpose : represents a mouse in the maze looking for the cheese.
 * <p>
 * @author : B.J. Johnson
 * @since  : 2020-04-18
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/**
 * A Mouse is starts as a particular MazeCell in the Maze which contains a "M" character.
 */
public class Mouse {

   private int[] location = new int[2];

  /**
   * Constructor sets the row and column location of the mouse
   */
   public Mouse( int row, int col ) {
      location[0] = row;
      location[1] = col;
   }

  /**
   * Move is a wrapper that moves in the indicated direction by calling
   *  one of the other move methods
   * @param direction int value of N, E, S, or W
   */
   public void move( int direction ) {
      if( direction == 'N' ) {
         moveNorth();
      } else if( direction == 'E' ) {
         moveEast();
      } else if( direction == 'S' ) {
         moveSouth();
      } else if( direction == 'W' ) {
         moveWest();
      }
   }

  /**
   * Returns if the mouse is in the same location as the cheese
   * @return true if mouse has found the cheese, false otherwise
   */
   public boolean foundCheese( int[] cheeseLocation ) {
      return ( (cheeseLocation[0] == location[0]) && (cheeseLocation[1] == location[1]) );
   }

  /**
   * returns the location of the cheese in the maze as a String
   * @return a brief String description
   */
   public String toString() {
      return "Mouse at: [" + location[0] + "][" + location[1] + "]";
   }

   public void moveNorth() {}
   public void moveEast()  {}
   public void moveSouth() {}
   public void moveWest()  {}

   public static void main( String [] args ) {


   }
}
