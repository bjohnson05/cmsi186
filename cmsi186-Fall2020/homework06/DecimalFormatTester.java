/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DecimalFormatTester.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  B.J. Johnson
 * Date       :  2017-04-04
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2019-04-22  B.J. Johnson  Initial writing and begin coding
 *  1.0.1  2020-04-05  B.J. Johnson  Added file header
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;

public class DecimalFormatTester {
   String result = "";
   int [] d = { 1, 2002, 300003, 40000004, 500000005, 60606, 7654321 };
   DecimalFormat df = new DecimalFormat( "000000000" );
   public static void main( String [] args ) {
      DecimalFormatTester dft = new DecimalFormatTester();
      for( int i = dft.d.length - 1; i >= 0; i-- ) {
         dft.result += dft.df.format( dft.d[i] );
         System.out.println( "result is: " + dft.result );
      }

      System.out.println( "result is: " + dft.result );
   }
}
