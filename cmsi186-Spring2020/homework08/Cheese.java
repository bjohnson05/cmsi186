/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: Cheese.java<br />
 * purpose : represents a piece of cheese in the maze for the mouse to find.
 * <p>
 * @author : B.J. Johnson
 * @since  : 2020-04-18
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

/**
 * A Cheese is just a particular MazeCell in the Maze which contains a "C" character.
 */
public class Cheese {

   private int[] location = new int[2];

  /**
   *  Constructor just sets the location
   * @param row where the cheese is located in the maze
   * @param col where the cheese is located in the maze
   */
   public Cheese( int row, int col ) {
      location[0] = row;
      location[1] = col;
   }

  /**
   * returns the location of the cheese in the maze as a String
   * @return a brief String description
   */
   public String toString() {
      return "Cheese at: [" + location[0] + "][" + location[1] + "]";
   }

  /**
   * returns the location of the cheese in the maze as an int[]
   * @return a brief String description
   */
   public int[] getLocation() {
      return location;
   }

  /**
   * test main for use with this class
   *  @param args not used
   */
   public static void main( String [] args ) {
      Cheese c = new Cheese( 10, 5 );
      System.out.println( c.toString() );
      c = new Cheese( 3, 7 );
      System.out.println( c.toString() );
      c = new Cheese( 35, 48 );
      System.out.println( c.toString() );
   }
}
