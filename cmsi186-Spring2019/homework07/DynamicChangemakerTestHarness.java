/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * File name  :  DynamicChangemakerTestHarness.java
 * Purpose    :  Test harness for verification of the ChangeMaker class
 * @author    :  Professor Don Murphy
 * @author    :  B.J. Johnson totally ripped off from the original
 * Date       :  2017-04-19
 * Description:  This program provides a test harness for running tests to verify correct operaion of the
 *                "ChangeMaker.java" class.  This class is intended to be used as part of homework 7, the
 *                coin changemaker, which is a "Dynamic Programming" algorithm.
 * Notes      :  None
 * Warnings   :  None
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Revision History
 * ================
 *   Ver      Date     Modified by:  Reason for change or modification
 *  -----  ----------  ------------  ---------------------------------------------------------------------
 *  1.0.0  2017-04-19  B.J. Johnson  Initial release; stolen blatently from Professor Don Murphy with his
 *                                    express permission and blessing; just added this comment block
 *  1.1.0  2017-04-28  B.J. Johnson  Added complete JavaDocs; added "throws" clauses to the methods that
 *                                    use them; added explanatory notes to comments; added "testCount"
 *                                    field and "makeTwoDigits" method to implement automated test count
 *                                    during test runs; added MAX_DENOM_VALUE constant for testing. along
 *                                    with random Tuple generation, just for grins and giggles [not really
 *                                    test-able, since it's the Forrest Gump of Tuples]
 *  1.2.0  2017-05-01  B.J. Johnson  Added a few more test cases, running tests for euros and swiss francs
 *                                    as well as a couple of extra tests for bogus denomination values to
 *                                    check throwing exceptions and to verify that *something* returns an
 *                                    "Impossible tuple" result.  Ready to commit the final version.
 *  1.3.0  2018-04-25  B.J. Johnson  Added a few more test cases, checking for invalid inputs and for
 *                                    a couple more "odd" demonimations.  Corrected incorrect spellings
 *
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;

public class DynamicChangemakerTestHarness {

   public static final int MAX_DENOM_VALUE = 73;

   private static int attempts = 0;
   private static int successes = 0;
   private static int testCount = 0;

   private static ArrayList<Integer> list = new ArrayList<Integer>();

  /**
   *  main method just calls all the individual test methods
   *   test_thisthing(), test_thatthing(), test_theotherthing() and so on
   *   each test_whatever handles its own output and keeps adding to the pass/fail
   *   at the end, main prints out a tally of how many tests run/passed
   */
   public static void main( String[] args ) {
      attempts  = 0;
      successes = 0;

      System.out.println( "\n\n  TESTING CHANGEMAKER PROGRAM FUNCTIONALITY" +
                          "\n  =========================================" );

      test_USA();
      test_Euros();            // 1,2,5,10,20,50
      test_SwissFrancs();      // 5,10,20,50 (NO 1 CENT COIN!)

      System.out.println( "      creating random tuple: " + randomTuple( 7, true ) );
      System.out.println( "      creating random tuple: " + randomTuple( 11, false ) );

      test_BogusDenominations1();
      test_BogusDenominations2();
      test_BogusDenominations3();
      // test_BogusDenomintaions4();   this was removed permanently
      test_BogusDenominations5();

      System.out.println( "\n\nResults:\n      " + successes + "/" + attempts + " tests passed." );
   }

  /**
   *  method to display a success or failure
   *  @param  value  boolean value of something that evaluates success/failure
   *    note that this can be any expression, including a test or method, which is why it's here
   *    note that this method also increments the attempts and tracks the number of successes
   *    there is no returned value, only a print out line which displays the result
   */
   private static void displaySuccessIfTrue( boolean value ) {
      attempts++;
      successes += value ? 1 : 0;

      System.out.println(value ? "success" : "failure");
   }

  /**
   *  method to display a failure
   */
   private static void displayFailure() {
      displaySuccessIfTrue( false );
   }

  /**
   *  method to run tests on USA denominations of coins; we all know what they are...
   *   don't forget the 50 cent piece and the Sarah B. Anthony dollar [100-cent] coin!!
   */
   public static void test_USA() {

      int[] usaDenominations  = new int[] { 25, 10, 5, 1 };
      Tuple result = null;

      System.out.println( "\n\n  TESTING TO FIND OPTIMAL SOLUTION TO MAKING 99 cents USING US COINS" );
      System.out.println( "  ==================================================================" );
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 99 cents: " );

      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( usaDenominations, 99 );

      try {
        System.out.print( "      expecting Tuple: <3,2,0,4>: " + 
                          " calculated: " + result.toString() + " which is " +
                          result.total() + " coins : " );
        displaySuccessIfTrue( "<3,2,0,4>".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing that result using getElement(0): " );
      try {
         System.out.print( "      expecting 3 25-cent coins: " );
         displaySuccessIfTrue( 3 == result.getElement(0));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing that result using getElement(1): " );
      try {
         System.out.print( "      expecting 2 10-cent coins: " );
         displaySuccessIfTrue( 2 == result.getElement(1));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing that result using getElement(2): " );
      try {
         System.out.print( "      expecting 0  5-cent coins: " );
         displaySuccessIfTrue( 0 == result.getElement(2));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing that result using getElement(3): " );
      try {
         System.out.print( "      expecting 4  1-cent coins: " );
         displaySuccessIfTrue( 4 == result.getElement(3));
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      usaDenominations  = new int[] { 100, 50, 25, 10, 5, 1 };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 25789 cents: " );
      System.out.println( "        note: expanded denominations including 50 cent and Susan B. Anthony dollar" );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( usaDenominations, 25789 );
      try {
         System.out.print( "      expecting Tuple: <257,1,1,1,0,4>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "<257,1,1,1,0,4>".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n\n  TESTING TO FIND OPTIMAL SOLUTION USING NON-STANDARD DENOMINATIONS" );
      System.out.println( "  =================================================================" );
      int[] newDenominations  = new int[] { 2, 3 };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 5 cents using " + Arrays.toString( newDenominations ) + ": " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( newDenominations, 5 );
      try {
         System.out.print( "      expecting Tuple: <1,1>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "<1,1>".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      newDenominations  = new int[] { 2, 3, 7, 5, 51, 29, 11 };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 13579 cents using " + Arrays.toString( newDenominations ) + ": " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( newDenominations, 13579 );
      try {
         System.out.print( "      expecting Tuple: <1,0,0,0,266,0,1>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "<1,0,0,0,266,0,1>".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      newDenominations  = new int[] { 17, 23, 121, 47, 3 };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 13579 cents using " + Arrays.toString( newDenominations ) + ": " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( newDenominations, 13579 );
      try {
         System.out.print( "      expecting Tuple: <3,0,111,2,1>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "<3,0,111,2,1>".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      newDenominations  = new int[] { 1, 7, 9 };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 12 cents using " + Arrays.toString( newDenominations ) + ": " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( newDenominations, 12 );
      try {
         System.out.print( "      expecting Tuple: <3,0,1>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "<3,0,1>".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      newDenominations  = new int[] { 8, 13, 4, 9 };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing for impossible solution for 14 cents using " + Arrays.toString( newDenominations ) + ": " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( newDenominations, 14 );
      try {
         System.out.print( "      expecting Tuple: Impossible tuple: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "Impossible tuple".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      newDenominations  = new int[] { 11, 13, 17, 19, 23  };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing for optimalsolution for 1357911 cents using " + Arrays.toString( newDenominations ) + ": " );
      System.out.println( "      This will take a second or two - please be patient......" );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( newDenominations, 1357911 );
      try {
         System.out.print( "      expecting Tuple: <1,2,0,0,59038>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "<1,2,0,0,59038>".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      newDenominations  = new int[] { 23, 19, 17, 13, 11  };
      System.out.println( "\n    Test" + makeTwoDigits() + ": testing for optimalsolution for 1357911 cents using " + Arrays.toString( newDenominations ) + ": " );
      System.out.println( "      This will take a second or two - please be patient......" );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( newDenominations, 1357911 );
      try {
         System.out.print( "      expecting Tuple: <59037,2,0,0,2>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
         displaySuccessIfTrue( "<59037,2,0,0,2>".equals( result.toString() ) );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
   }

   public static void test_Euros() {

      int[] euroDenominations  = new int[] { 1, 2, 5, 10, 20, 50 };
      Tuple result = null;

      System.out.println( "\n\n  TESTING TO FIND OPTIMAL SOLUTION TO MAKING 99 cents USING EUROS" );
      System.out.println( "  ===============================================================" );

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 99 cents: " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( euroDenominations, 99 );
      try {
        System.out.print( "      expecting Tuple: <0,2,1,0,2,1>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
        displaySuccessIfTrue( "<0,2,1,0,2,1>".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 88 cents: " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( euroDenominations, 88 );
      try {
        System.out.print( "      expecting Tuple: <1,1,1,1,1,1>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
        displaySuccessIfTrue( "<1,1,1,1,1,1>".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 176 cents: " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( euroDenominations, 176 );
      try {
        System.out.print( "      expecting Tuple: <1,0,1,0,1,3>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
        displaySuccessIfTrue( "<1,0,1,0,1,3>".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

   }

   public static void test_SwissFrancs() {

      int[] francDenominations  = new int[] { 5, 10, 20, 50 };
      Tuple result = null;

      System.out.println( "\n\n  TESTING TO FIND OPTIMAL SOLUTION TO MAKING 99 cents USING FRANCS" );
      System.out.println( "  ================================================================" );

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 99 cents: " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( francDenominations, 99 );
      try {
        System.out.print( "      expecting Tuple: Impossible tuple: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
        displaySuccessIfTrue( "Impossible tuple".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 85 cents: " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( francDenominations, 85 );
      try {
        System.out.print( "      expecting Tuple: <1,1,1,1>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
        displaySuccessIfTrue( "<1,1,1,1>".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 105 cents: " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( francDenominations, 105 );
      try {
        System.out.print( "      expecting Tuple: <1,0,0,2>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
        displaySuccessIfTrue( "<1,0,0,2>".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

      System.out.println( "\n    Test" + makeTwoDigits() + ": testing optimal solution for 135 cents: " );
      result = DynamicChangeMaker.makeChangeWithDynamicProgramming( francDenominations, 135 );
      try {
        System.out.print( "      expecting Tuple: <1,1,1,2>: " + 
                           " calculated: " + result.toString() + " which is " +
                           result.total() + " coins : " );
        displaySuccessIfTrue( "<1,1,1,2>".equals( result.toString() ) ) ;
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }

   }

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  @param   d  int array from which to display the contents
   *  NOTE: may be changed to int[] or some other type based on requirements in code above
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public static void toArray( int[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
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
   *  method to generate a random Tuple containing a random number of values
   *  @param elementCount integer number of elements in the Tuple
   *  @param oneAllowed   boolean value which is true if the number "1" is allowed in the values
   *  Note that making change is more difficult [less possible] without a "1" in the list
   *  @return  a Tuple containing 'elementCount' of the random values ranging no higher than MAX_DENOM_VALUE
   */
   public static Tuple randomTuple( int elementCount, boolean oneAllowed ) {
      int start = oneAllowed ? 2 : 1;
      int[] myDenoms = new int[ elementCount ];

      System.out.println( "\n\n  TESTING RANDOM TUPLE GENERATION" );
      System.out.println( "  ===============================" );

      System.out.println( "\n    Test" + makeTwoDigits() + ": random Tuple generation with value 1 " + (oneAllowed ? "" : "not ") + "allowed: ");

      for( int i = start; i <= MAX_DENOM_VALUE; i++ ) {
         list.add( new Integer( i ) );
      }
      Collections.shuffle( list );
      for( int i = 0; i < myDenoms.length; i++ ) {
         myDenoms[i] = list.get( i );
      }
      try {
         System.out.print( "      expecting success : " );
         displaySuccessIfTrue( true );
      } catch (Exception e) {
         e.printStackTrace();
         displayFailure();
      }
      return new Tuple( myDenoms );
   }

  /**
   * method to test a bogus set of denominations which includes a negative amount
   */
   public static void test_BogusDenominations1() {
      System.out.println( "\n\n  TESTING OF TUPLE GENERATION FOR THREE BOGUS DENOMINATION SETS" );
      System.out.println( "  =============================================================" );

      int[] badDenominations = new int[] { 1, 2, 3, 4, -5, 6, 7 };
      System.out.println( "\n    Test " + makeTwoDigits() + ": testing first list of bogus denominations, containing a negative......" );
      System.out.println( "          expecting: BAD DATA and a message: " );
      System.out.print  ( "            and got: " );
      try {
         Tuple result = DynamicChangeMaker.makeChangeWithDynamicProgramming( badDenominations, 2345 );
         System.out.print( "           which is: " );
         displaySuccessIfTrue( result.toString().contains( "Impossible" ) ) ;
      }
      catch( Exception e ) {
         displaySuccessIfTrue( false );
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   * method to test a bogus set of denominations which includes a zero
   */
   public static void test_BogusDenominations2() {
      int[] badDenominations = new int[] { 2, 3, 5, 8, 13, 21, 0, 34 };
      System.out.println( "\n    Test " + makeTwoDigits() + ": testing second list of bogus denominations, containing a zero......" );
      System.out.println( "          expecting: BAD DATA and a message: " );
      System.out.print  ( "            and got: " );
      try {
         Tuple result = DynamicChangeMaker.makeChangeWithDynamicProgramming( badDenominations, 2345 );
         System.out.print( "           which is: " );
         displaySuccessIfTrue( result.toString().contains( "Impossible" ) ) ;
      }
      catch( Exception e ) {
         displaySuccessIfTrue( false );
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   * method to test a bogus set of denominations which includes repeats
   */
   public static void test_BogusDenominations3() {
      int[] badDenominations = new int[] { 2, 3, 2, 3 };
      System.out.println( "\n    Test " + makeTwoDigits() + ": testing third list of bogus denominations, containing repeats......" );
      System.out.println( "          expecting: BAD DATA and a message: " );
      System.out.print  ( "            and got: " );
      try {
         Tuple result = DynamicChangeMaker.makeChangeWithDynamicProgramming( badDenominations, 2345 );
         System.out.print( "           which is: " );
         displaySuccessIfTrue( result.toString().contains( "Impossible" ) ) ;
      }
      catch( Exception e ) {
         displaySuccessIfTrue( false );
         e.printStackTrace();
         displayFailure();
      }
   }

  /**
   * method to test a bogus set of denominations which includes repeats
   */
   public static void test_BogusDenominations5() {
      int[] badDenominations = new int[] { 2, 3, 17, 23 };
      System.out.println( "\n    Test " + makeTwoDigits() + ": testing bogus negative target amount......" );
      System.out.println( "          expecting: BAD DATA and a message: " );
      System.out.print  ( "            and got: " );
      try {
         Tuple result = DynamicChangeMaker.makeChangeWithDynamicProgramming( badDenominations, -2345 );
         System.out.print( "           which is: " );
         displaySuccessIfTrue( result.toString().contains( "Impossible" ) ) ;
      }
      catch( Exception e ) {
         displaySuccessIfTrue( false );
         e.printStackTrace();
         displayFailure();
      }
   }

}
