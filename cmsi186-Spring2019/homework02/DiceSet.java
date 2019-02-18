/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  DiceSet.java
 *  Purpose       :  Provides a class describing a set of dice
 *  Author        :  B.J. Johnson
 *  Date          :  2017-02-09
 *  Description   :  This class provides everything needed (pretty much) to describe a set of dice.  The
 *                   idea here is to have an implementing class that uses the Die.java class.  Includes
 *                   the following:
 *                   public DiceSet( int k, int n );                  // Constructor for a set of k dice each with n-sides
 *                   public int sum();                                // Returns the present sum of this set of dice
 *                   public void roll();                              // Randomly rolls all of the dice in this set
 *                   public void rollIndividual( int i );             // Randomly rolls only the ith die in this set
 *                   public int getIndividual( int i );               // Gets the value of the ith die in this set
 *                   public String toString();                        // Returns a stringy representation of this set of dice
 *                   public static String toString( DiceSet ds );     // Classwide version of the preceding instance method
 *                   public boolean isIdentical( DiceSet ds );        // Returns true iff this set is identical to the set ds
 *                   public static void main( String[] args );        // The built-in test program for this class
 *
 *  Notes         :  Stolen from Dr. Dorin pretty much verbatim, then modified to show some interesting
 *                   things about Java, and to add this header block and some JavaDoc comments.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the number of sides or pips is out of range
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-09  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-02-20  B.J. Johnson  Added code to make methods work, updated per requirements
 *  @version 1.2.0  2017-02-15  B.J. Johnson  Added explanatory comments and updated exception handling
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class DiceSet {

  /**
   * private instance data
   */
   private int count;
   private static int countStatic;        // Just for demonstration purposes
   private int sides;
   private Die[] ds = null;               // size unknown at this point, just declare

   // public constructor:
  /**
   * constructor
   * @param  count int value containing total dice count
   * @param  sides int value containing the number of pips on each die
   * @throws IllegalArgumentException if one or both arguments don't make sense
   * @note   parameters are checked for validity; invalid values throw "IllegalArgumentException"
   */
   public DiceSet( int count, int sides ) {
      if( 0 == count ) {
         throw new IllegalArgumentException();
      }
      this.count = count;                 // THIS keyword used to disambituate
      this.countStatic = this.count;
      this.ds = new Die[ count ];         // *NOW* we know that size so we can make the real one
      for( int i = 0; i < count; i++ ) {  //  .... and load it up
         this.ds[i] = new Die( sides );
         this.ds[i].roll();               // initialize to random values
      }
   }

  /**
   * Method to calculate and return the total of all the rolled dice in the set
   * @return the sum of all the dice values in the set
   */
   public int sum() {
      int total = 0;                      // pretty self-explanatory for this one
      for( int i = 0; i < count; i++ ) {
         total += ds[i].getValue();
      }
      return total;
   }

  /**
   * Method to randomly roll all of the dice in this set
   * @note   you will need to use one of the "toString()" methods to obtain
   *          the values of the dice in the set
   * @note   it kind of makes NO sense to return something from this, since
   *          you are rolling ALL the dice -- just use the toSTring() method
   */
   public void roll() {
      for( int i = 0; i < count; i++ ) {
         ds[i].roll();                    // Same here...... :)
      }
   }

  /**
   * Method to randomly roll a single die of the dice in this set
   *  indexed by the 'dieIndex' argument
   * @param  dieIndex int of which die to roll
   * @return the integer value of the newly rolled die
   * @throws IllegalArgumentException if the index is out of range
   * @note   this is expected to be ZERO BASED, since this is an array
   *          If the calling routine uses a ONE BASED index, that should
   *          be handled OUTSIDE THIS METHOD
   */
   public int rollIndividual( int dieIndex ) {
      if( (dieIndex > this.count) || (dieIndex < 0) ) {
         throw new IllegalArgumentException();
      }
      return ds[dieIndex].roll();
   }

  /**
   * Method to get the value of the die in this set indexed by 'dieIndex'
   * @param  dieIndex int of which die to roll
   * @throws IllegalArgumentException if the index is out of range
   * @note   same notes as previous method
   */
   public int getIndividual( int dieIndex ) {
      if( (dieIndex > this.count) || (dieIndex < 0) ) {
         throw new IllegalArgumentException();
      }
      return ds[dieIndex].getValue();
   }

  /**
   * Public Instance method that returns a representation of the DiceSet instance
   *  using calls to the individual die instances
   * @return  String  representation of the DiceSet instance
   */
   public String toString() {
      String result = "";
      for( int i = 0; i < this.count; i++ ) {
         result = result + ds[i] + " ";
      }
      return result;
   }

  /**
   * Class-wide version of the preceding instance method
   * @return  String  representation of the DiceSet instance
   */
   public static String toString( Die[] ds ) {
      String result = "{";
      for( int i = 0; i < countStatic; i++ ) {
         result = result + ds[i] + "} ";
      }
      return result;
   }

  /**
   * Method to return true/false based on identical sets
   * @return  true iff this set is identical to the set passed as an argument
   * @note    two ways to go: 1) just compare size and number of sides, *OR*
   *          2) do that PLUS check if the values are the same, regardless of order
   * @note    SIDE EFFECT WARNING: the dice set passed in will be changed!
   */
   public boolean isIdentical( DiceSet dset ) {

     // This first if statement checks the count and the sides.  This is the 
     //  easy way as in "1)" in the note
	   if( (this.count != dset.count) || (this.sides != dset.sides) ) {
	  	   return false;               // number of dice and/or number of sides mis-match!
	   }

     // This part is a *bit* more complex, but still straightforward:
     //  we know now that they are the same size, and same number of faces on each
     //  create a new dice set to use for tracking, then iterate through the two sets
     //  whenever a match is found, we set THAT particular die to a new instance
     //    the new instance has a "tracking value" of 999 sides; this works because
     //    in the "Die" class, I initialize the die's value to the number of sides
     //  after all the dice in the set have been checked, if they are all equal and
     //    accounted for, there should be NO DICE that are NOT "99"s
	   for( int i = 0; i < this.count; i++ ) {
         for( int j = 0; j < this.count; j++ ) {
            if( this.getIndividual( i ) == dset.getIndividual( j ) ) {
               dset.ds[j] = new Die( 99 );
            }
         }
	   }
      for( int i = 0; i < this.count; i++ ) {
         if( dset.getIndividual( i ) != 99 ) {
            return false;
         }
      }
      return true;
   }

  /**
   * A little test main to check things out
   */
   public static void main( String[] args ) {
      System.out.println( "Testing the DiceSet class" );
      System.out.println( "  DiceSet: 3 dice, six sided - ds36:" );
      DiceSet ds36 = new DiceSet( 3, 6 );
      System.out.println( "    initialized ds36 contents             : " + ds36.toString() );
      ds36.roll();
      System.out.println( "    after collective roll ds36 contents   : " + ds36.toString() );
      ds36.rollIndividual( 2 );
      System.out.println( "    after individual roll(2) ds36 contents: " + ds36.toString() );
      System.out.println( "    sum of dice values is: " + ds36.sum() );
      System.out.println( "Re-rolling all dice" );
      ds36.roll();
      System.out.println( "    after collective roll ds36 contents   : " + ds36.toString() );
      ds36.rollIndividual( 2 );
      System.out.println( "    after individual roll(2) ds36 contents: " + ds36.toString() );
      System.out.println( "    sum of dice values is                 : " + ds36.sum() );
      System.out.println( "Test of getIndividual(): ");
      System.out.println( "    value of die at index 0: " + ds36.getIndividual( 0 ) );
      System.out.println( "    value of die at index 1: " + ds36.getIndividual( 1 ) );
      System.out.println( "    value of die at index 2: " + ds36.getIndividual( 2 ) );

      System.out.println( "\n\n  DiceSet: 6 dice, nine sided - ds69:" );
      DiceSet ds69 = new DiceSet( 6, 9 );
      System.out.println( "    initialized ds36 contents             : " + ds69.toString() );
      ds69.roll();
      System.out.println( "    after collective roll ds69 contents   : " + ds69.toString() );
      ds69.rollIndividual( 2 );
      System.out.println( "    after individual roll(2) ds69 contents: " + ds69.toString() );
      System.out.println( "    sum of dice values is                 : " + ds69.sum() );
      System.out.println( "Re-rolling all dice" );
      ds69.roll();
      System.out.println( "    after collective roll ds69 contents   : " + ds69.toString() );
      ds69.rollIndividual( 3 );
      System.out.println( "    after individual roll(3) ds69 contents: " + ds69.toString() );
      System.out.println( "    sum of dice values is                 : " + ds69.sum() );
      System.out.println( "Test of getIndividual(): ");
      System.out.println( "    value of die at index 0: " + ds69.getIndividual( 0 ) );
      System.out.println( "    value of die at index 1: " + ds69.getIndividual( 1 ) );
      System.out.println( "    value of die at index 2: " + ds69.getIndividual( 2 ) );
      System.out.println( "    value of die at index 3: " + ds69.getIndividual( 3 ) );
      System.out.println( "    value of die at index 4: " + ds69.getIndividual( 4 ) );
      System.out.println( "    value of die at index 5: " + ds69.getIndividual( 5 ) );

      System.out.println( "\n\n  DiceSet: 9 dice, 17 sided - ds917:" );
      DiceSet ds917 = new DiceSet( 9, 17 );
      System.out.println( "    initialized ds36 contents              : " + ds917.toString() );
      ds917.roll();
      System.out.println( "    after collective roll ds917 contents   : " + ds917.toString() );
      ds917.rollIndividual( 6 );
      System.out.println( "    after individual roll(6) ds917 contents: " + ds917.toString() );
      System.out.println( "    sum of dice values is                  : " + ds917.sum() );
      System.out.println( "Re-rolling all dice" );
      ds917.roll();
      System.out.println( "    after collective roll ds917 contents   : " + ds917.toString() );
      ds917.rollIndividual( 8 );
      System.out.println( "    after individual roll(8) ds69 contents : " + ds917.toString() );
      System.out.println( "    sum of dice values is                  : " + ds917.sum() );
      System.out.println( "Test of getIndividual(): ");
      System.out.println( "    value of die at index 0: " + ds917.getIndividual( 0 ) );
      System.out.println( "    value of die at index 1: " + ds917.getIndividual( 1 ) );
      System.out.println( "    value of die at index 2: " + ds917.getIndividual( 2 ) );
      System.out.println( "    value of die at index 3: " + ds917.getIndividual( 3 ) );
      System.out.println( "    value of die at index 4: " + ds917.getIndividual( 4 ) );
      System.out.println( "    value of die at index 5: " + ds917.getIndividual( 5 ) );
      System.out.println( "    value of die at index 6: " + ds917.getIndividual( 6 ) );
      System.out.println( "    value of die at index 7: " + ds917.getIndividual( 7 ) );
      System.out.println( "    value of die at index 8: " + ds917.getIndividual( 8 ) );

      System.out.println( "\n\nTest of isIndentical(): " );
      System.out.println( "Test of ds917 against ds69   : " + ds917.isIdentical( ds69 ) );
      System.out.println( "Test of ds917 against itself : " + ds917.isIdentical( ds917 ) );
      ds917 = new DiceSet( 9, 17 );
      DiceSet ds2_917 = new DiceSet( 9, 17 );
      ds917.roll();
      ds2_917.roll();
      System.out.println( "DiceSet ds917 contents       : " + ds917.toString() );
      System.out.println( "New DiceSet ds2_917 contents : " + ds2_917.toString() );
      System.out.println( "Test of ds917 against ds2_917: " + ds917.isIdentical( ds2_917 ) );
   }

}
