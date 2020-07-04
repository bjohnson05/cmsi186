/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  FibonacciLister.java
 *  Purpose       :  Lists the Fibonacci numbers from 1 to "N", where "N" is a command line parameter
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-16
 *  Description   :  See purpose (in this case; other files will have more details)
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  NumberFormatException
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-16  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Added try-catch block for argument conversion to integer
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
public class FibonacciLister {
   public static void main( String args[] ) {
      System.out.println( "\n   Welcome to the Fibonacci Lister!!\n" );
      long num1 = 1;
      long num2 = 1;
      long num3 = 0;
      long max  = 19;
      if( args.length == 0 ) {
         System.out.print( "     No arguments supplied: Defaulting to 19 max!\n" );
         System.out.print( "     Next time, try entering an integer for the maximum count...." );
         System.out.println();
         System.out.println();
      } else {
         try {
            max = Integer.parseInt( args[0] );
         }
         catch( NumberFormatException nfe ) {
            System.out.println( "   Sorry, bad input: must be an integer number!  Please try again..." );
            System.exit( -1 );
         }
      }
      System.out.println( "   Here is a list of the Fibonacci series up to the number specified:\n" );
      System.out.print( "   " + num1 + " " + num2 + " " );
      for( int i = 0; i < max; i++ ) {
         num3 = num1 + num2;
         System.out.print( num3 + " " );
         num1 = num2;
         num2 = num3;
      }
      System.out.println();
      System.exit( 0 );
   }
}
