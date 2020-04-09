/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * filename: BirthdaySolver<br />
 * purpose : Estimates the probability that, among n randomly-chosen people,
 *             there is at least one duplicated birthdate
 * <p>
 * @author : Phil Dorin
 * @author : re-hosted by B.J. Johnson
 * @since  : 2020-04-09
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

import java.text.DecimalFormat;

/**
 * Finds the probability that in a set of people there will be two who share the same birthday.
 * <p>
 * This implementation does NOT consider leap years, only standard years
 */
public class BirthdaySolver2 {

  //  private fields don't get documented in javadoc output
   private static final int DAYS_PER_YEAR = 365;
   private static final int DEFAULT_NUMBER_OF_EXPERIMENTS = 100000;
   private static final int NOTIFICATION_CUTOFF = 2999999;
   private static final boolean DEBUG_ON = false;        // set to false for release

  /**
   * Informs the user of the correct way to run the program when they have made an entry error.
   *   It also exits the program, assuming that the user error will cause an un-runnable condition.
   */
   public void printUsage() {
      // you finish this!
   }

  /**
   * Calculates the actual probability that from a certain number of people, at least two of them
   *  share the same birthday.  Based on calculating the probability that they DO NOT share a
   *  birthday, then subtracting that probability from 1.0 to get the other side of the coin.
   *
   * @param  numberOfPeople  integer number of people in the sample
   * @return double the probability value, range between zero and one
   * @see <a href="http://bjohnson.lmu.build/cmsi186web/homework07.html">Assignment Page</a>
   * @see <a href="https://betterexplained.com/articles/understanding-the-birthday-paradox/">Better Explained Page</a>
   * @see <a href="https://en.wikipedia.org/wiki/Birthday_problem">Wikipedia Page</a>
   */
   public double calculateActualProbability( int numberOfPeople ) {
      // you finish this!
      return 0.0;
   }

  /**
   * This is the main method of the program.  It first verifies the arguments from
   *  the command line, then does a loop to calculate an approximate probability.
   *  After that, it calls the <code>calculateActualProbability</code> method and
   *  then displays both results for comparison.
   *
   * @param args two are used: [0] = number of people; [1] = number of experiments.
   */
   public static void main ( String [] args ) {

      DecimalFormat df = new DecimalFormat( "#.00" );
      BirthdaySolver2 b = new BirthdaySolver2();
      int n = 0;

     // you finish this!

     // check the arguments

     // declare and initialize the duplicates counter

     // notify the user that we're starting and let 'em know if it's gonna be looooooong

     // actual programming loop; note the internal try/catch
     //  this loop runs "n" experiments, and counts whenever there is a duplicate
     //     random birthday

     // SOME SORT OF LOOP GOES HERE

        // note that the try/catch block is NOT really used for program errors here;
        //  it simply flags that there is a duplicate birthday at that index so as
        //  to provide an increment for the count
         try {

           // SOME SORT OF LOOP GOES HERE, TOO

         }
         catch ( Exception e ) {
            if( DEBUG_ON ) { System.out.println( e.toString() ); }
            // INCREMENT THE COUNT
         }

     // done with the loop, now find the average probability by simple division
      System.out.println( "   Probability that two out of " + n + " people have the same birthday: " );
      System.out.println( "      Experimental value is: " + "%" );
      System.out.println( "            Actual value is: " + "%\n\n" );
   }
}
