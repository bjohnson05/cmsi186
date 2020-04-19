/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: FileDemo.java<br />
 * purpose : Estimates getting input from a file for the MazeSolver program
 * <p>
 * @author : B.J. Johnson
 * @since  : 2020-04-18
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Demonstrates a simple input mechanism for reading a text file and writing its
 *    contents into a 1D array of String objects.
 * <p>
 * This is a demonstrator only and does not *DO* anything with the array other
 *    than print it to the display; however, it does contain a method that will read
 *    the named file and return an array of Strings contining the maze description.
 *    I left the name to be "FileDemo" because it includes a main method that shows
 *    how it can be used.
 */
public class FileDemo {

   private static final int X_INDEX = 0;
   private static final int Y_INDEX = 1;

  /**
   * Reads a file that contains a description of a Maze
   *
   * @param filename String that contains the name of the file; file is assumed to be
   *           in the same directory as the program which calls this method
   */
   public String[] getMazeFromFile( String filename ) throws IOException {

     // line to read array sizes from file
      String sizes = null;

     // array of lines describing the maze
      String [] lineArray = null;

     // index into lineArray
      int index = 0;

     // 2D array to hole X and Y values; only Y is really used here
      int [] dimensions = new int[2];

     // open the file
      File file = new File( filename );
      BufferedReader br = new BufferedReader( new FileReader( file ) );

     // get the array sizes and put then into the array, then dimension the lineArray
      sizes = br.readLine();
      dimensions[X_INDEX] = Integer.parseInt( sizes.substring( 0, 2 ) );
      dimensions[Y_INDEX] = Integer.parseInt( sizes.substring( 3 ) );
      lineArray = new String[(dimensions[Y_INDEX] * 2) + 2];

     // read all the lines into the lineArray and return the contents
     //  there MUST be a line containing "EOF" in a properly formatted file
      lineArray[index] = br.readLine();
      while( !(lineArray[index].contains( "EOF" )) ) {
         lineArray[index] = lineArray[index].substring( (lineArray[index].indexOf( '\"' ) + 1), lineArray[index].length() - 2 );
         index++;
         lineArray[index] = br.readLine();
      }
      return lineArray;
   }

  /**
   * This is the main method of the program.  If opens a file, reads the first line to decide
   *  how big an array should be, then reads in enough lines to fulfill the "Y" dimension
   *  of the array.
   *
   * @param args [not used]
   */
   public static void main( String [] args ) {

      System.out.println( "\n   Howdy li'l pardner! \n\n" );
      FileDemo fd = new FileDemo();
      String [] myLineArray = null;

     // try the get method and catch any errors
      try {
         myLineArray = fd.getMazeFromFile( "mazediagram.txt" );
      }
      catch( IOException ioe ) {
         System.out.println( "\n   Error on open/read... exiting\n" );
         System.exit( -1 );
      }

     // output the results to the display then exit
      for( int index = 0; index < myLineArray.length; index++ ) {
         System.out.println( myLineArray[index] );
      }
      System.exit( 0 );

   }
}
