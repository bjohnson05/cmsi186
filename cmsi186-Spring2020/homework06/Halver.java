/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  Halver.java
 * Purpose    :  Program to divide a String input by two
 * @author    :  B.J. Johnson
 * Date       :  2017-04-19
 * Description:  This program demonstrates dividing a number given on the command line as a String by 2.
 *                The number is treated as an integer, and the division result is also an integer with no
 *                remainder taken into account.  This is intended as a prototype to demonstrate a method
 *                ["byte-based"] for doing "halving" which is needed for Russian Peasant Multiplication
 *                for the "BrobdingnagianInt" programming assignment, if the student wishes to implement
 *                multiplication using that method.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial writing and begin coding
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class Halver {

   private String myNumber = "";
   private String reversed = "";
   private byte[] a        = null;
   private byte[] b        = null;


   public Halver() {
      super();
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this GinormousInt as its bytes
   *  @param  c  byte array containing the data to display
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( byte[] c ) {
      System.out.println( "array value is: " + Arrays.toString( c ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide a string by 2
   *  @param  input String to divide in half; note this is integer division so the remainder is not
   *                considered important
   *  @return String value that is integer half of the input string
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String halve( String input ) {

     // declare and initialize the variables
      int          j        = 0;
      String       result_s = null;
      StringBuffer result   = null;

      myNumber = input;
      reversed = new String( new StringBuffer( myNumber ).reverse() );
      a = new byte[myNumber.length() + 1];   // extra place to handle "carry"
      b = new byte[myNumber.length()];

     // assign the values to the byte array
      for( int i = 0; i < a.length - 1; i++ ) {
         a[i] = (byte)((int)(myNumber.charAt(i)) - 48);         // NOTE: only works for ASCII
      }

     // do the division
      for( int i = 0; i < b.length; i++ ) {
         b[i] = (byte)((int)a[i] / 2);
         if( 1 == ((int)a[i] - ((int)b[i] * 2)) ) {
            a[i+1] = (byte)((int)a[i+1] + 10);
         }
      }

     // remove leading zero if present
      int start = 0;
      if( 0 == b[0] ) {
         start = 1;
      }

     // build the result string to pass back
      result = new StringBuffer();
      for( int i = start; i < a.length - 1; i++ ) {
         result = result.append( (int)b[i] );
      }
      return new String( result );

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Test main() method
   *  @param  args String array passed on the command line
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      if( args.length == 0 ) {
         System.out.println( "\n   Sorry, you must at least supply one argument." );
         System.exit( -1 );
      }
      Halver h = new Halver();
      System.out.println( h.halve( args[0] ) );
      System.exit( 0 );
   }
}
