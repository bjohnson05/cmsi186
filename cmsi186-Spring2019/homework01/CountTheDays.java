/**
 *  File name     :  CountTheDays.java
 *  Purpose       :  Program to count the days between two dates
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-02
 *  Description   :  This program calculates and displays the number of days between two dates that are
 *                   passed as arguments on the command line.  The order of the *dates* is not considered
 *                   important, but the order of each date must be "month, day, year".  Inputs are parsed
 *                   from the "args" command line arguments array and are validated.  Use is made of the
 *                   helper class "CalendarStuff.java" to accomplish most of the calculations.
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-02  B.J. Johnson  Initial writing and release
 */
public class CountTheDays extends Object {

  /**
   * these private fields are defined so that the main method has access to them
   *  they get filled in my the constructor
   *  REMEMBER!  This is just ONE way of doing this...  easy to understand and see
   *   what is going on here...
   */
   private static long month1 = 0;
   private static long day1   = 0;
   private static long year1  = 0;
   private static long month2 = 0;
   private static long day2   = 0;
   private static long year2  = 0;

   /**
    * The constructor takes in the arguments array, parses the array into
    *  its individula pieces, then converts them to "long" primitive types
    *  and sticks the results into the class fields.
    */
   public CountTheDays( String args[] ) {
      month1 = Long.parseLong( args[0] );
      day1   = Long.parseLong( args[1] );
      year1  = Long.parseLong( args[2] );
      month2 = Long.parseLong( args[3] );
      day2   = Long.parseLong( args[4] );
      year2  = Long.parseLong( args[5] );
   }

  /**
   * a simple method to swap the order of the dates to make things easy
   */
   public void swapDateOrder() {
      long temp = month1; month1 = month2; month2 = temp;
      temp = day1; day1 = day2; day2 = temp;
      temp = year1; year1 = year2; year2 = temp;
   }

  /**
   * this is the main method that:
   *  1. verifies that there are the proper number of arguments passed
   *  2. makes a new instance of the class
   *  3. makes a new instance of the CalendarStuff class
   *  4. checks that the dates are in order, and swaps them if they aren't
   *  5. calls the daysBetween menthod to calculate the days
   *  6. outputs the results to the display
   */
   public static void main( String args[] ) {
      if( 6 != args.length ) {
         System.out.println( "\n   Hey, bozo, there should be six arguments!" );
         System.exit( 1 );
      }
      CountTheDays ctd = new CountTheDays( args );
      CalendarStuff cs = new CalendarStuff();
      if( 1 == cs.compareDate( month1, day1, year1, month2, day2, year2 ) ) {
         ctd.swapDateOrder();
      }
      try {
         long count = cs.daysBetween( month1, day1, year1, month2, day2, year2 );
         System.out.println( "\n   Count of the days between: " +
                             " " + (long)month1 + "-" + (long)day1 + "-" + (long)year1 + " and " +
                             " " + (long)month2 + "-" + (long)day2 + "-" + (long)year2 +
                             " is " + count + ((count == 1) ? " day." : " days.") );
         System.exit( 0 );
      }
      catch( IllegalArgumentException iae ) {
      	 System.out.println( "\n   Hey, bozo, make sure the dates are valid!" );
         System.exit( 1 );    	
      }
   }

}
