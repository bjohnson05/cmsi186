/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobIntLoopTest.java
 * Purpose    :  Learning exercise to implement arbitrarily large numbers and their operations
 * @author    :  B.J. Johnson
 * Date       :  2020-04-05
 * Description:  @see <a href='http://bjohnson.lmu.build/cmsi186web/homework06.html'>Assignment Page</a>
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2020-04-05  B.J. Johnson  Initial writing and begin coding
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class BrobIntLoopTest {

   public static void main( String [] args ) {

      System.out.println( "\n   Demonstrating BrobInt looping \n"+
                          "       counting from zero to nine" );

      for( BrobInt i = BrobInt.ZERO; (i.compareTo( BrobInt.TEN ) < 0); i = i.add( BrobInt.ONE ) ) {

         System.out.println( "         Iteration number: " + i.toString() );

      }

      System.out.println( "\n   Demonstrating BrobInt looping \n"+
                          "       counting from one to ten" );

      for( BrobInt i = BrobInt.ONE; (i.compareTo( BrobInt.TEN ) <= 0); i = i.add( BrobInt.ONE ) ) {

         System.out.println( "         Iteration number: " + i.toString() );

      }
   }
}

