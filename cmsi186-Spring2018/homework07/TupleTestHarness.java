/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  TupleTestHarness.java
 * Purpose    :  Test harness for the Tuple class
 * @author    :  Professor Don Murphy
 * @author    :  B.J. Johnson totally ripped off from the original; thanks Professor Murphy!
 * Date       :  2017-04-19
 * Description:  Duh.... see the Purpose above
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial writing and release; stolen blatently from Professor Murphy
 *                                    with his permission; added this comment block and some javadocs
 *  1.1.0  2017-04-28  B.J. Johnson  Added complete JavaDocs; added "throws" clauses to the methods that
 *                                    use them; added explanatory notes to comments; added "testCount"
 *                                    field and "makeTwoDigits" method to implement automated test count
 *                                    during test runs; added tests for the "isImpossible" method and the
 *                                    "hashCode" method
 *  1.2.0  2018-04-16  B.J. Johnson  Added a few more tests to verify six- and ten-tuples
 *  1.2.1  2018-04-18  B.J. Johnson  Added param description for main for javadocs
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class TupleTestHarness {

   private static int attempts  = 0;
   private static int successes = 0;
   private static int testCount = 0;

  /**
   *  the main method which calls all the test methods
   *  @param  args  String array containing the string values of the command line arguments
   */
   public static void main(String[] args) {

      test_toString();
      test_setElement();
      test_add();
      test_equals();
      test_getElement();
      test_length();
      test_total();
      test_isImpossible();
      test_hashCode();

      System.out.println( "\n\nResults: " + successes + "/" + attempts + " tests passed.");
   }

  /**
   *  method to display success or failure as a result of a test
   *  @param  value  boolean success/failure
   *  Note that this method keeps track of the count of tests run
   *    as well as the number of successes
   */
   private static void displaySuccessIfTrue( boolean value) {
      attempts++;
      successes += value ? 1 : 0;

      System.out.println(value ? "success" : "failure");
   }

  /**
   *  silly little method to add zeros to the front of a number string
   *    to ensure it fills two places for test output alignment
   *  @return two-character string that is a two-place number from 00 to 99
   *  note: this method also increments the testCount private field
   */
   private static String makeTwoDigits() {
      testCount++;
      if( testCount < 10 ) {
         return new String( "0" + testCount );
      } else {
         return new Integer( testCount ).toString();
      }
   }

  /**
   *  method to display a failure, probably for things that are
   *   supposed to fail on purpose [that's a guess]
   */
   private static void displayFailure() {
      displaySuccessIfTrue( false );
   }

  /**
   *  method to test the "toString()" method a buncha times
   */
   public static void test_toString() {
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing Tuple.IMPOSSIBLE.toString():" );
         System.out.print  ( "  Expecting: 'Impossible tuple': " );
         displaySuccessIfTrue( "Impossible tuple".equals(Tuple.IMPOSSIBLE.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing if Tuple.IMPOSSIBLE returns isImpossible():" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( Tuple.IMPOSSIBLE.isImpossible() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

     // Only one impossible.
      Tuple fakeImpossible = new Tuple(new int[0]);
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing if '<>' [empty Tuple] equals fakeImpossible.toString():" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( "<>".equals(fakeImpossible.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing if fakeImpossible equals Tuple.IMPOSSIBLE:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( fakeImpossible.equals(Tuple.IMPOSSIBLE));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing if fakeImpossible returns isImpossible:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( !fakeImpossible.isImpossible() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t0 = new Tuple(0);
         System.out.println( "Test " + makeTwoDigits() + "    : testing constructing '<>' [empty Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( "<>".equals(t0.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t1 = new Tuple(1);
         System.out.println( "Test " + makeTwoDigits() + "    : testing constructing '<0>' [one-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( "<0>".equals(t1.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t2 = new Tuple(2);
         System.out.println( "Test " + makeTwoDigits() + "    : testing constructing '<0,0>' [two-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( "<0,0>".equals(t2.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t3 = new Tuple(new int[] { 3, 1, 2 });
         System.out.println( "Test " + makeTwoDigits() + "    : testing constructing '<3,1,2>' [three-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( "<3,1,2>".equals(t3.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t4 = new Tuple(new int[] { 13, 11, 23, 19, 5, 29 });
         System.out.println( "Test " + makeTwoDigits() + "    : testing constructing '<13,11,23,19,5,29>' [six-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( "<13,11,23,19,5,29>".equals(t4.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         Tuple t5 = new Tuple(new int[] { 17, 53, 29, 31, 5, 7, 11, 47, 19, 71 });
         System.out.println( "Test " + makeTwoDigits() + "    : testing constructing '<17,53,29,31,5,7,11,47,19,71>' [ten-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         displaySuccessIfTrue( "<17,53,29,31,5,7,11,47,19,71>".equals(t5.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "setElement()" method a couple of times
   *   makes a few Tuples and checks that you got what you paid for
   *   note that the "toString()" method puts angle brackets around
   *   the tuple for easy reading
   */
   public static void test_setElement() {
      Tuple t0 = new Tuple(new int[] { 3, 1, 2 });
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing setting element zero of '<3,1,2>' [three-Tuple] to -1:" );
         System.out.println( "  currently: " + t0.toString() );
         t0.setElement(0, -1);
         System.out.print  ( "  Expecting: '<-1,1,2>': " );
         displaySuccessIfTrue( "<-1,1,2>".equals(t0.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing setting element one of '<-1,1,2>' [three-Tuple] to 0:" );
         System.out.println( "  currently: " + t0.toString() );
         t0.setElement(1, 0);
         System.out.print  ( "  Expecting: '<-1,0,2>': " );
         displaySuccessIfTrue( "<-1,0,2>".equals(t0.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing setting element two of '<-1,0,2>' [three-Tuple] to 15:" );
         System.out.println( "  currently: " + t0.toString() );
         t0.setElement(2, 15);
         System.out.print  ( "  Expecting: '<-1,0,15>': " );
         displaySuccessIfTrue( "<-1,0,15>".equals(t0.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test adding two tuples together.  Only one test, but theoretically
   *   should test a lot of different sizes, not just "three-Tuples"
   */
   public static void test_add() {
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing Tuple addition of '<-1,0,2>' to '<3,1,2>':" );
         Tuple t0 = new Tuple(new int[] { -1, 0, 2 });
         Tuple t1 = new Tuple(new int[] { 3, 1, 2 });
         System.out.println( "  currently: t0 is " + t0.toString() );
         System.out.println( "  currently: t1 is " + t1.toString() );
         Tuple sum = t0.add(t1);
         System.out.print  ( "  Expecting: Tuple sum is '<2,1,4>': " );
         displaySuccessIfTrue( "<2,1,4>".equals(sum.toString() ) &&
                              "<-1,0,2>".equals(t0.toString() ) &&
                              "<3,1,2>".equals(t1.toString() ));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "equals()" method
   */
   public static void test_equals() {
      Tuple t0 = new Tuple(new int[] { -1, 0, 2 });
      Tuple t1 = new Tuple(new int[] { -1, 0, 2 });

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing Tuple equals 'some string object':" );
         System.out.print  ( "  Expecting: 'some string object': " );
         displaySuccessIfTrue( !t0.equals("some string object"));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing Tuple equals <-1.0>:" );
         System.out.print  ( "  Expecting: '<-1.0>': " );
         displaySuccessIfTrue( !t0.equals(new Tuple(new int[] { -1, 0 })));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing Tuple equals new Tuple(3):" );
         System.out.print  ( "  Expecting: t0 not equal new Tuple(3): " );
         displaySuccessIfTrue( !t0.equals(new Tuple(3)));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing Tuples are equal both ways:" );
         System.out.print  ( "  Expecting: t0.equals(t1) and t1.equals(t0) to be true: " );
         displaySuccessIfTrue( t0.equals(t1) & t1.equals(t0));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "getElement()" method
   */
   public static void test_getElement() {
      Tuple t0 = new Tuple(new int[] { -1, 0, 2 });

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing getElement zero of t0:" );
         System.out.print  ( "  Expecting: -1: " );
         displaySuccessIfTrue( -1 == t0.getElement(0));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing getElement one of t0:" );
         System.out.print  ( "  Expecting: 0: " );
         displaySuccessIfTrue( 0 == t0.getElement(1));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing getElement two of t0:" );
         System.out.print  ( "  Expecting: 2: " );
         displaySuccessIfTrue( 2 == t0.getElement(2));
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "length()" method
   */
   public static void test_length() {
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing length on empty Tuple:" );
         System.out.print  ( "  Expecting: length == 0: " );
         Tuple t0 = new Tuple(0);
         displaySuccessIfTrue( 0 == t0.length() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing length on three-Tuple <-1,0,2>:" );
         System.out.print  ( "  Expecting: length == 3: " );
         Tuple t1 = new Tuple(new int[] { -1, 0, 2 });
         displaySuccessIfTrue( 3 == t1.length() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing length on '<13,11,23,19,5,29>' [six-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         Tuple t4 = new Tuple(new int[] { 13, 11, 23, 19, 5, 29 });
         displaySuccessIfTrue( 6 == t4.length() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing length on '<17,53,29,31,5,7,11,47,19,71>' [ten-Tuple]:" );
         System.out.print  ( "  Expecting: 'true': " );
         Tuple t5 = new Tuple(new int[] { 17, 53, 29, 31, 5, 7, 11, 47, 19, 71 });
         displaySuccessIfTrue( 10 == t5.length() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "total()" method
   */
   public static void test_total() {
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing total on empty Tuple:" );
         System.out.print  ( "  Expecting: total == 0: " );
         Tuple t0 = new Tuple(0);
         displaySuccessIfTrue( 0 == t0.total() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing total on three-Tuple <-1,0,2>:" );
         System.out.print  ( "  Expecting: total == 1: " );
         Tuple t1 = new Tuple(new int[] { -1, 0, 2 });
         displaySuccessIfTrue( 1 == t1.total() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing total on Tuple.IMPOSSIBLE:" );
         System.out.print  ( "  Expecting: total == 0: " );
         displaySuccessIfTrue( 0 == Tuple.IMPOSSIBLE.total() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

   }

  /**
   *  method to test the "isImpossible()" method
   */
   public static void test_isImpossible() {
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing isImpossible on Tuple.IMPOSSIBLE:" );
         System.out.print  ( "  Expecting: true: " );
         displaySuccessIfTrue( Tuple.IMPOSSIBLE.isImpossible() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing isImpossible on Tuple <23,37,41>:" );
         System.out.print  ( "  Expecting: false: " );
         int[] z = new int[] { 23, 37, 41 };
         Tuple t0 = new Tuple( z );
         displaySuccessIfTrue( !t0.isImpossible() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   *  method to test the "hashCode()" method
   */
   public static void test_hashCode() {
      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing hashCode on Tuple.IMPOSSIBLE:" );
         System.out.print  ( "  Expecting: zero: " );
         displaySuccessIfTrue( Tuple.IMPOSSIBLE.isImpossible() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

      try {
         System.out.println( "Test " + makeTwoDigits() + "    : testing hashCode on Tuple <23,37,41>:" );
         System.out.print  ( "  Expecting: 34891: " );
         int[] z = new int[] { 23, 37, 41 };
         Tuple t0 = new Tuple( z );
         displaySuccessIfTrue( 34891 == t0.hashCode() );
      } catch( Exception e ) {
         e.printStackTrace();
         displayFailure();
      }

   }
}
