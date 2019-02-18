/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  HighRoll.java
 *  Purpose       :  Plays a game of "High Roll"
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-21
 *  Description   :  Plays a dice game to implement the Die.java and DiceSet.java classes
 *                   See http://bjohnson.lmu.build/cmsi186web/homework03.html for details
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-21  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class HighRoll {
   private static int highScore = 0;
   private static BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );

   public static void main( String args[] ) {
      String inputLine = null;
      int    count     = 0;
      int    sides     = 0;
      int    total     = 0;
      int    highest   = 0;
      if( 2 > args.length ) {
         throw new IllegalArgumentException();
      }
      try {
         count = Integer.parseInt( args[0] );
         sides = Integer.parseInt( args[1] );
      }
      catch( NumberFormatException nfe) { System.out.println( "You must enter two numbers as arguments,\n" +
                                                              " the number of dice, and the number of sides." ); }
      DiceSet ds = new DiceSet( count, sides );
      System.out.println( "\n  Welcome to High Roll!\n\n" );
      System.out.println( "This program plays a dice game to try to make a high score." );
      System.out.println( "You roll the dice, you can re-roll an individual die, and\n" +
                          "you can roll as many times as you want before quitting.\n\n" );
      while( true ) {
         System.out.println( "Please enter one of the following selections: \n" +
                             "R .. Roll all the dice\n" +
                             "D .. Roll a single die\n" +
                             "C .. Calculate the score for this set\n" +
                             "S .. Save this score as a high score\n" +
                             "Y .. Display the high score\n" +
                             "Q .. Quit the game" );
         System.out.print(   "\n   Which? ==> " );
         try {
            inputLine = input.readLine();
            if( 0 == inputLine.length() ) {
               continue;
            } else if( 'Q' == inputLine.toUpperCase().charAt(0) ) {
               break;
            } else if( 'R' == inputLine.toUpperCase().charAt(0) ) {
               ds.roll();
               System.out.println();
               System.out.println( ds.toString() );
               System.out.println();
            } else if( 'D' == inputLine.toUpperCase().charAt(0) ) {
               System.out.print( "\n   Which die do you want to roll? (1 - " + count + "): " );
               inputLine = input.readLine();
               int index = 0;
               try {
                  index = Integer.parseInt( inputLine ) - 1;
               }
               catch( NumberFormatException nfe ) {
                  System.out.println( "\n   Sorry, bogus number -- try again!" );
               }
               ds.rollIndividual( index );
               System.out.println();
               System.out.println( ds.toString() );
               System.out.println();
            } else if( 'C' == inputLine.toUpperCase().charAt(0) ) {
               total = ds.sum();
               System.out.println();
               System.out.println( "Total of all values is now: " + total );
               System.out.println();
            } else if( 'S' == inputLine.toUpperCase().charAt(0) ) {
               highest = total;
               System.out.println();
               System.out.println( "High score value is now: " + highest );
               System.out.println();
            } else if( 'Y' == inputLine.toUpperCase().charAt(0) ) {
               System.out.println();
               System.out.println( "High score value is currently: " + highest );
               System.out.println();
            } else {
               continue;
            }
         }
         catch( IOException ioe ) {
            System.out.println( "Caught IOException -- something bogus happened, dude..." );
         }
      }
   }
}
