/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  BrobInt.java
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
 *  1.0.0  2017-04-04  B.J. Johnson  Initial writing and begin coding
 *  1.1.0  2017-04-13  B.J. Johnson  Completed addByt, addInt, compareTo, equals, toString, Constructor,
 *                                     validateDigits, two reversers, and valueOf methods; revamped equals
 *                                     and compareTo methods to use the Java String methods; ready to
 *                                     start work on subtractByte and subtractInt methods
 *  1.2.0  2019-04-18  B.J. Johnson  Fixed bug in add() method that was causing errors in Collatz
 *                                     sequence.  Added some tests into the main() method at the bottom
 *                                     of the file to test construction.  Also added two tests there to
 *                                     test multiplication by three and times-3-plus-1 operations
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BrobIntTemplate {

   public static final BrobInt ZERO     = new BrobInt(  "0" );      /// Constant for "zero"
   public static final BrobInt ONE      = new BrobInt(  "1" );      /// Constant for "one"
   public static final BrobInt TWO      = new BrobInt(  "2" );      /// Constant for "two"
   public static final BrobInt THREE    = new BrobInt(  "3" );      /// Constant for "three"
   public static final BrobInt FOUR     = new BrobInt(  "4" );      /// Constant for "four"
   public static final BrobInt FIVE     = new BrobInt(  "5" );      /// Constant for "five"
   public static final BrobInt SIX      = new BrobInt(  "6" );      /// Constant for "six"
   public static final BrobInt SEVEN    = new BrobInt(  "7" );      /// Constant for "seven"
   public static final BrobInt EIGHT    = new BrobInt(  "8" );      /// Constant for "eight"
   public static final BrobInt NINE     = new BrobInt(  "9" );      /// Constant for "nine"
   public static final BrobInt TEN      = new BrobInt( "10" );      /// Constant for "ten"

  /// Some constants for other intrinsic data types
  ///  these can help speed up the math if they fit into the proper memory space
   public static final BrobInt MAX_INT  = new BrobInt( Integer.valueOf( Integer.MAX_VALUE ).toString() );
   public static final BrobInt MIN_INT  = new BrobInt( Integer.valueOf( Integer.MIN_VALUE ).toString() );
   public static final BrobInt MAX_LONG = new BrobInt( Long.valueOf( Long.MAX_VALUE ).toString() );
   public static final BrobInt MIN_LONG = new BrobInt( Long.valueOf( Long.MIN_VALUE ).toString() );

  /// These are the internal fields
   public  String internalValue = "";        // internal String representation of this BrobInt
   public  byte   sign          = 0;         // "0" is positive, "1" is negative
  /// You can use this or not, as you see fit.  The explanation was provided in class
   private String reversed      = "";        // the backwards version of the internal String representation

   private static BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
   private static final boolean DEBUG_ON = false;
   private static final boolean INFO_ON  = false;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobIntTemplate( String value ) {
      super();			// replace this with the appropriate code to accomplish what is in the javadoc text
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() throws IllegalArgumentException {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  NOTE: you can use this or not, as you see fit; explanation was given in class
   *  @see StringBuffer API page for an easy way to do this
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt reverser() {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of a BrobIntk passed as argument
   *  Note: static method
   *  @param  bint         BrobInt to reverse its value
   *  @return BrobInt that is the reverse of the value of the BrobInt passed as argument
   *  NOTE: you can use this or not, as you see fit; explanation was given in class
   *  @see StringBuffer API page for an easy way to do this
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt reverser( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt add( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtract( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply this by
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt bint ) {
      throw new UnsupportedOperationException( "\n         Sorry, that operation is not yet implemented." );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to compare a BrobInt passed as argument to this BrobInt
   *  @param  bint  BrobInt to compare to this
   *  @return int   that is one of neg/0/pos if this BrobInt precedes/equals/follows the argument
   *  NOTE: this method does not do a lexicographical comparison using the java String "compareTo()" method
   *        It takes into account the length of the two numbers, and if that isn't enough it does a
   *        character by character comparison to determine
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public int compareTo( BrobInt bint ) {

     // remove any leading zeros because we will compare lengths
      String me  = removeLeadingZeros( this ).toString();
      String arg = removeLeadingZeros( bint ).toString();

     // handle the signs here
      if( 1 == sign && 0 == bint.sign ) {
         return -1;
      } else if( 0 == sign && 1 == bint.sign ) {
         return 1;
      } else if( 0 == sign && 0 == bint.sign ) {
        // the signs are the same at this point ~ both positive
        // check the length and return the appropriate value
        //   1 means this is longer than bint, hence larger positive
        //  -1 means bint is longer than this, hence larger positive
         if( me.length() != arg.length() ) {
            return (me.length() > arg.length()) ? 1 : -1;
         }
      } else {
        // the signs are the same at this point ~ both negative
         if( me.length() != arg.length() ) {
            return (me.length() > arg.length()) ? -1 : 1;
         }
      }

     // otherwise, they are the same length, so compare absolute values
      for( int i = 0; i < me.length(); i++ ) {
         Character a = Character.valueOf( me.charAt(i) );
         Character b = Character.valueOf( arg.charAt(i) );
         if( Character.valueOf(a).compareTo( Character.valueOf(b) ) > 0 ) {
            return 1;
         } else if( Character.valueOf(a).compareTo( Character.valueOf(b) ) < 0 ) {
            return (-1);
         }
      }
      return 0;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to check if a BrobInt passed as argument is equal to this BrobInt
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if they are equal and false otherwise
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean equals( BrobInt bint ) {
      return ( (sign == bint.sign) && (this.toString().equals( bint.toString() )) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a BrobInt given a long value passed as argument
   *  @param  value    long type number to make into a BrobInt
   *  @return BrobInt  which is the BrobInt representation of the long
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static BrobInt valueOf( long value ) throws NumberFormatException {
      BrobInt bi = null;
      try { bi = new BrobInt( Long.valueOf( value ).toString() ); }
      catch( NumberFormatException nfe ) { throw new NumberFormatException( "\n  Sorry, the value must be numeric of type long." ); }
      return bi;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a String representation of this BrobInt
   *  @return String  which is the String representation of this BrobInt
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
      return internalValue;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to remove leading zeros from a BrobInt passed as argument
   *  @param  bint     BrobInt to remove zeros from
   *  @return BrobInt that is the argument BrobInt with leading zeros removed
   *  Note that the sign is preserved if it exists
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt removeLeadingZeros( BrobInt bint ) {
      Character sign = null;
      String returnString = bint.toString();
      int index = 0;

      if( allZeroDetect( bint ) ) {
         return bint;
      }
      if( ('-' == returnString.charAt( index )) || ('+' == returnString.charAt( index )) ) {
         sign = returnString.charAt( index );
         index++;
      }
      if( returnString.charAt( index ) != '0' ) {
         return bint;
      }

      while( returnString.charAt( index ) == '0' ) {
         index++;
      }
      returnString = bint.toString().substring( index, bint.toString().length() );
      if( sign != null ) {
         returnString = sign.toString() + returnString;
      }
      return new BrobInt( returnString );

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to return a boolean if a BrobInt is all zeros
   *  @param  bint     BrobInt to compare to this
   *  @return boolean  that is true if the BrobInt passed is all zeros, false otherwise
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean allZeroDetect( BrobInt bint ) {
      for( int i = 0; i < bint.toString().length(); i++ ) {
         if( bint.toString().charAt(i) != '0' ) {
            return false;
         }
      }
      return true;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  byte array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( byte[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display a prompt for the user to press 'ENTER' and wait for her to do so
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void pressEnter() {
      String inputLine = null;
      try {
         System.out.print( "      [Press 'ENTER' to continue]: >> " );
         inputLine = input.readLine();
      }
      catch( IOException ioe ) {
         System.out.println( "Caught IOException" );
      }

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  the main method redirects the user to the test class
   *  @param  args  String array which contains command line arguments
   *  NOTE:  we don't really care about these, since we test the BrobInt class with the BrobIntTester
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void main( String[] args ) {
      System.out.println( "\n  Hello, world, from the BrobInt program!!\n" );
      System.out.println( "\n   You should run your tests from the BrobIntTester...\n" );

      BrobInt b1 = null;;
      try { System.out.println( "   Making a new BrobInt: " ); b1 = new BrobInt( "147258369789456123" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      try { System.out.println( "   expecting: 147258369789456123\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      System.out.println( "\n    Multiplying 82832833 by 3: " );
      try { System.out.println( "      expecting: 248498499\n        and got: " + new BrobInt("82832833").multiply( BrobInt.THREE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Multiplying 3 by 82832833 and adding 1: " );
      try { System.out.println( "      expecting: 248498500\n        and got: " + BrobInt.THREE.multiply( new BrobInt( "82832833" ) ).add( BrobInt.ONE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      System.exit( 0 );

   }
}
