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


public class BrobInt {

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
   private byte[] byteVersion   = null;      // byte array for storing the string values; uses the reversed string

   private static String g19String = "56789";
   private static String g20String = "37";
   private static BrobInt g19 = null;
   private static BrobInt g20 = null;

   private static BufferedReader input = new BufferedReader( new InputStreamReader( System.in ) );
   private static final boolean DEBUG_ON = false;
   private static final boolean INFO_ON  = false;

  /**
   *  Constructor takes a string and assigns it to the internal storage, checks for a sign character
   *   and handles that accordingly;  it then checks to see if it's all valid digits, and reverses it
   *   for later use
   *  @param  value  String value to make into a BrobInt
   */
   public BrobInt( String value ) {
      internalValue = value;
      reversed = new String( new StringBuffer( internalValue ).reverse() );
      if( value.charAt(0) == '+' ) {
         sign = 0;
         reversed = reversed.substring( 0, reversed.length() - 1 );
      } else if( value.charAt(0) == '-' ) {
         sign = 1;
         reversed = reversed.substring( 0, reversed.length() - 1 );
      }
      try {
         validateDigits();
      }
      catch( IllegalArgumentException iae ) {
         System.out.println( iae.toString() );
         System.out.println( iae.getLocalizedMessage() );
         System.exit( -1 );
      }
      byteVersion = new byte[reversed.length()];
      for( int i = 0; i < reversed.length(); i++ ) {
         byteVersion[i] = (byte)Character.getNumericValue( reversed.charAt(i) );
      }
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to validate that all the characters in the value are valid decimal digits
   *  @return  boolean  true if all digits are good
   *  @throws  IllegalArgumentException if something is hinky
   *  note that there is no return false, because of throwing the exception
   *  note also that this must check for the '+' and '-' sign digits
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public boolean validateDigits() throws IllegalArgumentException {
      if( 0 == internalValue.length() ) {
         throw new IllegalArgumentException( "\n  Sorry, you must enter at least one decimal digit." );
      } else {
         for( int i = 0; i < internalValue.length(); i++ ) {
            if( !(Character.isDigit( internalValue.charAt(i) )) &&
                !('+' == internalValue.charAt(i) ) &&
                !('-' == internalValue.charAt(i) ) ) {
               throw new IllegalArgumentException( "\n  Sorry, all characters must be decimal digit or sign characters." );
            }
         }
      }
      return true;
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to reverse the value of this BrobInt
   *  @return BrobInt that is the reverse of the value of this BrobInt
   *  NOTE: you can use this or not, as you see fit; explanation was given in class
   *  @see StringBuffer API page for an easy way to do this
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt reverser() {
      return new BrobInt( new String( new StringBuffer( internalValue ).reverse() ) );
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
      return new BrobInt( new String( new StringBuffer( bint.internalValue ).reverse() ) );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to add the value of a BrobIntk passed as argument to this BrobInt using int array
   *  @param  bint         BrobInt to add to this
   *  @return BrobInt that is the sum of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt add( BrobInt bint ) {

      boolean carry = false;              // handles the carry for addition

     // dimension the byte arrays and set the shortest length tracker (i.e. "j") to zero
      int[] a = new int[reversed.length()];
      int[] b = new int[bint.reversed.length()];
      int[] c = new int[(Math.max( reversed.length(), bint.reversed.length() )) + 2];

      int          j        = 0;
      String       result_s = null;
      StringBuffer result   = null;

     // assign the values to each byte array
      for( int i = 0; i < a.length; i++ ) {
         a[i] = reversed.charAt(i) - 48;           // NOTE: only works for ASCII
      }
      for( int i = 0; i < b.length; i++ ) {
         b[i] = bint.reversed.charAt(i) - 48;      // NOTE: only works for ASCII
      }
      if( INFO_ON ) { toArray( a ); }
      if( INFO_ON ) { toArray( b ); }

     // perform the addition for the shortest part
      for( int i = 0; i < (Math.min(a.length, b.length)); i++ ) {

        // do the addition part
         if( carry ) {
            c[i] = a[i] + b[i] + 1;
         } else {
            c[i] = a[i] + b[i];
         }

        // handle the carry part
         if( c[i] > 9 ) {
            carry = true;
            c[i] = c[i] - 10;
         } else {
            carry = false;
         }
         j++;        // brute force to keep track of the end of the shortest array for later
      }

     // if they aren't the same length, copy the rest of the numbers from
     //  the longer number into the result, rippling the carry across if needed
      if( a.length < b.length ) {
         for( int i = j; i < b.length; i++ ) {
            if( carry ) {
               c[i] = b[j++] + 1;
               if( c[i] > 9 ) {
                  carry = true;
                  c[i] = c[i] - 10;
               } else {
                  carry = false;
               }
            } else {
               c[i] = b[i];
            }
         }
      } else if( a.length > b.length ) {
         for( int i = j; i < a.length; i++ ) {
            if( carry ) {
               c[i] = a[j++] + 1;
               if( c[i] > 9 ) {
                  carry = true;
                  c[i] = c[i] - 10;
               } else {
                  carry = false;
               }
            } else {
               c[i] = a[i];
            }
         }
      }

     // build the result string
      result = new StringBuffer();
      for( int i = 0; i < Math.max(a.length, b.length); i++ ) {
         result = result.append( (int)c[i] );
      }
      if( carry ) {
         result = result.append( '1' );
      }
      if( sign == 1 ) {
         result = result.append( "-" );
      }
      result_s = new String( result.reverse() );

      return new BrobInt( result_s );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to subtract the value of a BrobIntk passed as argument to this BrobInt using bytes
   *  @param  bint         BrobInt to subtract from this
   *  @return BrobInt that is the difference of the value of this BrobInt and the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt subtract( BrobInt bint ) {

      boolean      borrow   = false;            // handles the borrow for addition
      boolean      negative = false;            // set to true if result should be negative
      byte[]       a        = null;
      byte[]       b        = null;
      int          j        = 0;
      int          mySign   = 0;                // initialize to positive
      int          bintSign = 0;                // initialize to positive
      String       result_s = null;
      StringBuffer result   = null;

     // set up for the sign handling to decide what to do based on the following cases:
     //    1. no signs at all, this item larger than argument:        simple subtraction a - b
     //    2. both signs positive, this item larger than argument:    simple subtraction a - b
     //    3. one positive one no sign, this item larger than arg:    simple subtraction a - b
     //    4. no signs at all, this item smaller than argument:       swap a & b, subtract a - b, result negative
     //    5. both signs positive, this item smaller than argument:   swap a & b, subtract a - b, result negative
     //    6. one positive one no sign, this item smaller than arg:   swap a & b, subtract a - b, result negative
     //    7. this no sign or positive, arg negative:                 remove neg from arg and call this.add( arg )
     //    8. this negative, arg positive:                            add negative to arg and call this.add( arg )
     //    9. both signs negative, this larger abs than arg abs:      remove signs, subtract, add neg to result
     //   10. both signs negative, this smaller abs than arg abs:     remove signs, swap a & b, subtract, result pos
     //
     // set the sign for 'this'; already initialized to zero for positive default, so check for minus
     //  NOTE: signs removed in the constructors and "sign" values set for easier handling
      mySign   = sign;
      bintSign = bint.sign;

     // check to set the negative boolean for later or perform addition instead
      if( (0 == mySign) && (0 == bintSign) && (0 <= this.compareTo( bint )) ) {           // case 1 - 3
         negative = false;
      } else if( (0 == mySign) && (0 == bintSign) && (0 > this.compareTo( bint )) ) {     // case 4 - 6
         negative = true;
      } else if( (0 == mySign) && (1 == bintSign) && (0 < this.compareTo( bint )) ) {     // case 7
         BrobInt bint1 = new BrobInt( new String( bint.internalValue.substring( 1, bint.internalValue.length() ) ) );
         return this.add( bint1 );
      } else if( (1 == mySign) && (0 == bintSign) && (0 > this.compareTo( bint )) ) {     // case 8
         negative = true;
         BrobInt gMe = new BrobInt( new String( internalValue.substring( 1, internalValue.length() ) ) );
         BrobInt myResult = new BrobInt( new String( "-" + gMe.add( bint ).toString() ) );
         return myResult;
      } else if( (1 == mySign) && (1 == bintSign) && (0 < this.compareTo( bint )) ) {     // case 9
         negative = true;
      } else if( (1 == mySign) && (1 == bintSign) && (0 > this.compareTo( bint )) ) {     // case 10
         negative = false;
      }

     // dimension the byte arrays and initialize them appropriately for their lengths;
     //  'a' gets the longer string; if they are the same length, 'a' gets the bigger value
      if( (reversed.length() > bint.reversed.length()) || (0 <= this.compareTo( bint )) ) {
         a = new byte[reversed.length()];
         for( int i = 0; i < a.length; i++ ) {
            a[i] = (byte)((int)(reversed.charAt(i)) - 48);         // NOTE: only works for ASCII
         }
         b = new byte[bint.reversed.length()];
         for( int i = 0; i < b.length; i++ ) {
            b[i] = (byte)((int)(bint.reversed.charAt(i)) -48);     // NOTE: only works for ASCII
         }
      } else {
         a = new byte[bint.reversed.length()];
         for( int i = 0; i < a.length; i++ ) {
            a[i] = (byte)((int)(bint.reversed.charAt(i)) -48);     // NOTE: only works for ASCII
         }
         b = new byte[reversed.length()];
         for( int i = 0; i < b.length; i++ ) {
            b[i] = (byte)((int)(reversed.charAt(i)) - 48);         // NOTE: only works for ASCII
         }
      }
      byte[] c = new byte[(Math.max( reversed.length(), bint.reversed.length() )) + 2];

     // perform the subtraction for the shortest part
     //  if a borrow is required, loop through from the current location to the end of the input,
     //   if necessary, to find the first non-zero value from which to borrow; that one gets decremented
     //   and all the ones in between that used to be zero become nines.
     // perform the subtraction for the shortest part
      for( int i = 0; i < (Math.min(a.length, b.length)); i++ ) {
         if( a[i] < b[i] ) {
            a[i] += 10;
            a[i + 1]--;
         }
         c[i] = (byte)((int)a[i] - (int)b[i]);
         j++;        // brute force end of the shortest array for later
      }

     // if they aren't the same length, copy the rest of the numbers from
     //  the longer number into the result, rippling the borrow across if needed
      if( a.length < b.length ) {
         for( int i = j; i < b.length; i++ ) {
            if( borrow ) {
               c[i] = (byte)((int)b[j] + 1);
               if( c[i] > 9 ) {
                  borrow = true;
                  c[i] = (byte)((int)c[i] - 10);
               } else {
                  borrow = false;
               }
            } else {
               c[i] = b[i];
            }
         }
      } else if( a.length > b.length ) {
         for( int i = j; i < a.length; i++ ) {
            if( borrow ) {
               c[i] = (byte)((int)a[j] + 1);
               if( c[i] > 9 ) {
                  borrow = true;
                  c[i] = (byte)((int)c[i] - 10);
               } else {
                  borrow = false;
               }
            } else {
               c[i] = a[i];
            }
         }
      }

     // build and return the result string; note, the sign gets handled here
      result = new StringBuffer();
      for( int i = 0; i < Math.max(a.length, b.length); i++ ) {
         result = result.append( (int)c[i] );
      }

      if( borrow ) {
         result = result.append( '1' );
      }

      if( negative ) {
         result = result.append( "-" );
      }

      result_s = new String( result.reverse() );
      if( (result_s.charAt( 0 ) == '0') && ( !(1 == result_s.length()) ) ) {
         result_s = result_s.substring( 1, result_s.length() );
      }
      return new BrobInt( result_s );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to multiply the value of a BrobIntk passed as argument to this BrobInt
   *  @param  bint         BrobInt to multiply by this BrobInt
   *  @return BrobInt that is the product of the value of this BrobInt and the one passed in
   *  Note: this code implements the normal multiplication like we learn in grammar school
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt multiply( BrobInt bint ) {

      boolean      negative = false;            // set to true if result should be negative
      byte[]       a        = null;
      byte[]       b        = null;
      int          carry    = 0;                // initialize to zero
      int          k        = 0;                // initialize to zero
      String       result_s = null;
      StringBuffer result   = null;

     // check for the signs; if not the same, the result should be negative
      if( (sign == 1 && bint.sign == 0) || (sign == 0 && bint.sign == 1) ) {
         negative = true;
      }

     // dimension the byte arrays and initialize them appropriately for their lengths;
     //   'a' gets the longer string
      if( (reversed.length() > bint.reversed.length()) || (0 <= this.compareTo( bint )) ) {
         a = new byte[reversed.length()];
         for( int i = 0; i < a.length; i++ ) {
            a[i] = (byte)((int)(reversed.charAt(i)) - 48);         // NOTE: only works for ASCII
         }
         b = new byte[bint.reversed.length()];
         for( int i = 0; i < b.length; i++ ) {
            b[i] = (byte)((int)(bint.reversed.charAt(i)) - 48);     // NOTE: only works for ASCII
         }
      } else {
         a = new byte[bint.reversed.length()];
         for( int i = 0; i < a.length; i++ ) {
            a[i] = (byte)((int)(bint.reversed.charAt(i)) - 48);     // NOTE: only works for ASCII
         }
         b = new byte[reversed.length()];
         for( int i = 0; i < b.length; i++ ) {
            b[i] = (byte)((int)(reversed.charAt(i)) - 48);         // NOTE: only works for ASCII
         }
      }

     // dimension and zero out the result array
      byte[] c = new byte[reversed.length() + bint.reversed.length() + 1];
      for( int i = 0; i < b.length; i++ ) {
         c[i] = (byte)carry;         // NOTE: since carry is zero already, just use that
      }

     // this is the multiplication loop; we handle the addition with each iteration
     //  multiply each digit in 'a' by each digit in 'b' sequentially, while also
     //  handling the carry and the addition of the previous sum of digits in the column
      for( int i = 0; i < b.length; i++) {
         k = i;
         for( int j = 0; j < a.length; j++ ) {

            c[k] = (byte)((int)a[j] * (int)b[i] + carry + (int)c[k]);
            if( c[k] > 9 ) {
               carry = (int)c[k] / 10;
               c[k] = (byte)((int)c[k] % 10);
            } else {
               carry = 0;
            }
            k++;
         }
         c[k - 1] = (byte)((int)c[k - 1] % 10);
         c[k] = (byte)((int)carry);
         carry = 0;
      }

      result = new StringBuffer();
      for( int i = 0; i <= k; i++ ) {
         result = result.append( (int)c[i] );
      }

      if( 0 != carry ) {
         result = result.append( carry );
      }

      if( negative ) {
         result = result.append( "-" );
      }

      result_s = new String( result.reverse() );

      if( result_s.charAt(0) == '0' ) {
         result_s = new String( result_s.substring( 1, result_s.length() ) );
      }

      return new BrobInt( result_s );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to divide the value of this BrobIntk by the BrobInt passed as argument
   *  @param  bint         BrobInt to divide this by
   *  @return BrobInt that is the dividend of this BrobInt divided by the one passed in
   *  Note: this code implements the normal division like we learn in grammar school;
   *        the passed BrobInt is to be the divisor, and this BrobInt is the dividend
   *        i.e., "this divided by bint is what"
   *        for brevity [at first] divisor is "d1" and dividend is "d2"; quotient is "q"
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt divide( BrobInt bint ) {
      BrobInt d1 = this;
      BrobInt d2 = bint;
      BrobInt d3 = BrobInt.ZERO;
      BrobInt q = BrobInt.ZERO;

      if( DEBUG_ON ) { System.out.println( "        in divide, this is: " + this.toString() + " and bint is: " + bint.toString() ); }
     // for implementation, in this discussion/comment/steps:
     //  0. divisor [passed in as argument] is "d1" [denominator]
     //     dividend [this] is "d2" [numerator]
     //     current dividend being handled is "d3"
     //     quotient is "q" and string length count is "n"
     //        for example, 56789 divided by 37: d1 == 37 and d2 == 56789
     //                     d3 starts with 56 and goes on adding single digits with each iteration
     //                     "q" starts at zero, and "n" starts at 2
     //  1. is d1 == 0?  if so, throw IllegalArgumentException
      if( bint.equals( BrobInt.ZERO ) ) {
         throw new IllegalArgumentException("\n  Argument causes a divide-by-zero error\n\n" );

     //  2. is d1 > d2?  if so, return BrobInt.ZERO [integer division]
      } else if( 0 > this.compareTo( bint ) ) {
         return BrobInt.ZERO;

     //  3. is d1 == d2? if so, return BrobInt.ONE [divided by itself]
      } else if( this.equals( bint ) ) {
         return BrobInt.ONE;

     //  4. get length of d1 and put into "n"
      } else {
         int n = bint.internalValue.length();

     //  5. extract that many characters from the front of d2 and put into d3
         d3 = new BrobInt( this.toString().substring( 0, n ) );

     //  6. is d1 > d3?  if so, add one to "n" and re-extract characters from d2 into d3
         if( 0 > d1.compareTo( d3 ) ) {
            n++;
            d3 = new BrobInt( this.toString().substring( 0, n ) );
         }

     //  7. while "n" <= d2.toString().length()
         while( n <= d1.toString().length() ) {
            if( DEBUG_ON ) { System.out.println("          outer while 1a ~ d1: " + d1.toString() + ", d2: " + d2.toString() + ", d3: " + d3.toString() + ", n: " + n ); }
            if( DEBUG_ON ) { System.out.println("          outer while 1b ~ (0 < d3.compareTo( d2 ))" + ( 0 < d3.compareTo( d2 ) ) ); }

           // a. while d3 > d2:
           //     i. subtract d2 from d3 [ bint.subtract( this ) ]
           //    ii. add one to quotient [ q.add( BrobInt.ONE ) ]
            while( 0 < d3.compareTo( d2 ) ) {
               if( DEBUG_ON ) { System.out.println("            inner while 1 ~ d1: " + d1.toString() + ", d2: " + d2.toString() + ", d3: " + d3.toString() + ", n: " + n + ", q: " + q ); }
               if( allZeroDetect( d3 ) ) {
                  break;
               }
               d3 = d3.subtract( d2 );
               q  = q.add( BrobInt.ONE );
               if( DEBUG_ON ) { System.out.println("            inner while 2 ~ d1: " + d1.toString() + ", d2: " + d2.toString() + ", d3: " + d3.toString() + ", n: " + n + ", q: " + q ); }
            }
           // b. d3 now has any remainder [e.g., 56 - 37 = 19, "q" is one and d3 is 19]
           //    check if d3 is equal to d2; if they come out even we may be one off
            if( d3.equals( d2 ) ) {
               d3 = BrobInt.ZERO;
               q  = q.add( BrobInt.ONE );
               if( DEBUG_ON ) { System.out.println("          outer while 2 ~ d1: " + d1.toString() + ", d2: " + d2.toString() + ", d3: " + d3.toString() + ", n: " + n + ", q: " + q ); }
            }

           // c. if "n++" is equal to d1.toString().length() then we are done
            n++;
            if( DEBUG_ON ) { System.out.println("          outer while 3 ~ d1: " + d1.toString() + ", d2: " + d2.toString() + ", d3: " + d3.toString() + ", n: " + n + ", q: " + q ); }
            if( n > d1.toString().length() ) {
               break;
            }

           // d. multiply d3 by 10 using d3.multiply( BrobInt.TEN )
            d3 = d3.multiply( BrobInt.TEN );

           // e. multiply "q" by 10 using q.multiply( BrobInt.TEN )
            q = q.multiply( BrobInt.TEN );
            if( DEBUG_ON ) { System.out.println("          outer while 4 ~ d1: " + d1.toString() + ", d2: " + d2.toString() + ", d3: " + d3.toString() + ", n: " + n + ", q: " + q ); }

           // f. extract next digit from d2 using d2.toString().substring( n-1, n )
           // g. add current value of d3 to extracted digit [e.g., get "7" from d2, concat to d3 to make "197"]
            d3 = d3.add( new BrobInt( d1.toString().substring( n-1, n ) ) );
            if( DEBUG_ON ) { System.out.println("          outer while 5 ~ d1: " + d1.toString() + ", d2: " + d2.toString() + ", d3: " + d3.toString() + ", n: " + n + ", q: " + q ); }

            if( DEBUG_ON ) { System.out.println("          outer while 6 ~ d3.equals( BrobInt.ZERO ): " + d3.equals( BrobInt.ZERO ) ); }
         }
      }

     //  8. return "q" value
      if( DEBUG_ON ) { System.out.println( "        leaving divide: q is: " + q.toString() ); }
      return this.removeLeadingZeros( q );
   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to get the remainder of division of this BrobInt by the one passed as argument
   *  @param  bint         BrobInt to divide this one by
   *  @return BrobInt that is the remainder of division of this BrobInt by the one passed in
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public BrobInt remainder( BrobInt bint ) {
      if( INFO_ON ) {
         System.out.println( "      calculate remainder:" );
         System.out.println( "        division value: " + this.divide( bint ) );
         System.out.println( "        that multiplied: " + this.divide( bint ).multiply( bint ) );
         System.out.println( "        and that subtracted: " + this.subtract( this.divide( bint ).multiply( bint ) ) );
         System.out.println( "        and that de-zeroed: " + this.removeLeadingZeros( this.subtract( this.divide( bint ).multiply( bint ) ) ) );
      }
      return this.removeLeadingZeros( this.subtract( this.divide( bint ).multiply( bint ) ) );

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
   *  NOTE: the "byteVersion" and "byteVersionOutput" are merely for observation purposes
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public String toString() {
      String byteVersionOutput = "";
      for( int i = 0; i < byteVersion.length; i++ ) {
         byteVersionOutput = byteVersionOutput.concat( Byte.toString( byteVersion[i] ) );
      }
      byteVersionOutput = new String( new StringBuffer( byteVersionOutput ).reverse() );
      // if( DEBUG_ON ) { toArray( byteVersion ); };
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
   public void toArray( int[] d ) {
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
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      try { System.out.println( "   expecting: 147258369789456123\n     and got: " + b1.toString() ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Multiplying 82832833 by 3: " );
      try { System.out.println( "      expecting: 248498499\n        and got: " + new BrobInt("82832833").multiply( BrobInt.THREE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.out.println( "\n    Multiplying 3 by 82832833 and adding 1: " );
      try { System.out.println( "      expecting: 248498500\n        and got: " + BrobInt.THREE.multiply( new BrobInt( "82832833" ) ).add( BrobInt.ONE ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      try { System.out.println( "\n\n   Making a new BrobInt: " ); b1 = new BrobInt( "-99999" ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " ); }
      System.out.println( "\n   Testing equals() method on b1 of -99999 and b2 of 99999: " );
      try { System.out.println( "      expecting: true\n        and got: " + b1.equals( new BrobInt( "99999" ) ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }
      System.out.println( "\n   Testing equals() method on b1 of -99999 and b2 of -99999: " );
      try { System.out.println( "      expecting: true\n        and got: " + b1.equals( new BrobInt( "-99999" ) ) ); }
      catch( Exception e ) { System.out.println( "        Exception thrown:  " + e.toString() ); }

      System.exit( 0 );

   }
}
