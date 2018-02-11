/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuffTester.java
 *  Purpose       :  A test harness file for testing out the methods in the "StringStuff.java" class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-25
 *  Description   :  This file provides the "test harness" for checking out the methods which are part of
 *                   the homework02 assignment.  It also provides examples of proper documentation, and
 *                   uses the source file header template as specified in the "Greeter.java" template file
 *                   for use in CMSI 186, Spring 2017.
 *  Notes         :  TEMPLATE FILE ONLY: Your job is to fill in as many test cases as you think are needed
 *                   to thoroughly and completely test your StringStuff class.
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-25  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2017-02-08  B.J. Johnson  Added code to run tests, based on CalendareStuffTester.java
 *  @version 2.0.1  2018-02-03  B.J. Johnson  Updated to correct a missing character in one test
 *                                              also tests for "removeDupes()" commented out, not required
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class StringStuffTester {

  /**
   * the main method which calls all of the test methods in the class
   * @param args String[] array containing command line parameters
   * @return void
   */
   public static void main ( String [] args ) {
      System.out.println( "\nA TOTAL OF SIXTY-SEVEN TESTS TO CHECK OPERATION OF THE STRINGSTUFF CLASS METHODS");
      test_containsVowel();      // fourteen tests
      test_isPalindrome();       // eight tests
      test_evensOnly();          // fill in how many tests
      test_oddsOnly();           // fill in how many tests
      test_evensOnlyNoDupes();   // fill in how many tests
      test_oddsOnlyNoDupes();    // fill in how many tests
      test_reverse();            // fill in how many tests
      //test_removeDupes();        // fill in how many tests
   }

  /**
   * test method to test out the operation of the containsVowel method
   */
   public static void test_containsVowel() {
      System.out.println( "\nFIFTEEN TESTS FOR containsVowel():" );
      System.out.print( "   Test for all lowercase vowels: " );
      try { System.out.println( StringStuff.containsVowel( "The quick brown fox." ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for all uppercase vowels: " );
      try { System.out.println( StringStuff.containsVowel( "JUMPED OVER THE LAZY DOG." ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting lowercase 'a': " );
      try { System.out.println( StringStuff.containsVowel( "a" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting uppercase 'A': " );
      try { System.out.println( StringStuff.containsVowel( "A" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting lowercase 'e': " );
      try { System.out.println( StringStuff.containsVowel( "e" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting uppercase 'E': " );
      try { System.out.println( StringStuff.containsVowel( "E" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting lowercase 'i': " );
      try { System.out.println( StringStuff.containsVowel( "i" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting uppercase 'I': " );
      try { System.out.println( StringStuff.containsVowel( "I" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting lowercase 'o': " );
      try { System.out.println( StringStuff.containsVowel( "o" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting uppercase 'O': " );
      try { System.out.println( StringStuff.containsVowel( "O" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting lowercase 'u': " );
      try { System.out.println( StringStuff.containsVowel( "u" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting uppercase 'U': " );
      try { System.out.println( StringStuff.containsVowel( "U" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting lowercase 'y': " );
      try { System.out.println( StringStuff.containsVowel( "y" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting uppercase 'Y': " );
      try { System.out.println( StringStuff.containsVowel( "Y" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for detecting there are none: " );
      try { System.out.println( StringStuff.containsVowel( "bdBDBDbd" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Test for string containing numbers and symbols with 'a' at the end: " );
      try { System.out.println( StringStuff.containsVowel( "1234567890!@#$%^&*()a" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the isPalindrome method
   */
   public static void test_isPalindrome() {
      System.out.println( "\nTEN TESTS FOR isPalindrome():" );
      System.out.print( "   Testing 'a' should return true: " );
      try { System.out.println( StringStuff.isPalindrome( "a" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'ab' should return false: " );
      try { System.out.println( StringStuff.isPalindrome( "ab" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'aba' should return true: " );
      try { System.out.println( StringStuff.isPalindrome( "aba" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'amanaplanacanalpanama' should return true: " );
      try { System.out.println( StringStuff.isPalindrome( "amanaplanacanalpanama" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'ABBA' should return true: " );
      try { System.out.println( StringStuff.isPalindrome( "ABBA" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'RaCeCaR' should return true: " );
      try { System.out.println( StringStuff.isPalindrome( "RaCeCaR" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'madamiamadam' should return false: " );
      try { System.out.println( StringStuff.isPalindrome( "madamiamadam" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'abcdefghigfedcba' should return false: " );
      try { System.out.println( StringStuff.isPalindrome( "abcdefghigfedcba" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'abcdefgh gfedcba' should return false: " );
      try { System.out.println( StringStuff.isPalindrome( "abcdefgh gfedcba" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing '1!2@3#4$5%5$4#3@2!1' should return true: " );
      try { System.out.println( StringStuff.isPalindrome( "1!2@3#4$5%5$4#3@2!1" ) ? "true" : "false" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the evensOnly method
   */
   public static void test_evensOnly() {
      System.out.println( "\nNINE TESTS FOR evensOnly():" );
      System.out.print( "   Testing 'REHEARSALSZ' should return RHRLZ: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "REHEARSALSZ" ).compareTo( "RHRLZ" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'REhearSALsz' should return RhrLz: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "REhearSALsz" ).compareTo("RhrLz")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' should return BDFHJLNPRTVXZ: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ).compareTo("BDFHJLNPRTVXZ")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'abcdefghijklmnopqrstuvwxyz' should return bdfhjlnprtvxz: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "abcdefghijklmnopqrstuvwxyz" ).compareTo("bdfhjlnprtvxz")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'AbCdEfGhIjKlMnOpQrStUvWxYz' should return bdfhjlnprtvxz: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "AbCdEfGhIjKlMnOpQrStUvWxYz" ).compareTo("bdfhjlnprtvxz")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'ACEGIKMOQSUWY' should return empty string: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "ACEGIKMOQSUWY" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'acegikmoqsuwy' should return empty string: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "acegikmoqsuwy" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing empty string should return empty string: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'REhe12ar^^SALsz' should return RhrLz: " );
      try { System.out.println( (0 == StringStuff.evensOnly( "REhe12ar^^SALsz" ).compareTo("RhrLz")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the oddsOnly method
   */
   public static void test_oddsOnly() {
      System.out.println( "\nNINE TESTS FOR oddsOnly():" );
      System.out.print( "   Testing 'xylophones' should return yooes: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "xylophones" ).compareTo( "yooes" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'XYloPHonES' should return YooES: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "XYloPHonES" ).compareTo("YooES")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'ABCDEFGHIJKLMNOPQRSTUVWXYZ' should return ACEGIKMOQSUWY: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "ABCDEFGHIJKLMNOPQRSTUVWXYZ" ).compareTo("ACEGIKMOQSUWY")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'abcdefghijklmnopqrstuvwxyz' should return bdfhjlnprtvxz: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "abcdefghijklmnopqrstuvwxyz" ).compareTo("acegikmoqsuwy")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'AbCdEfGhIjKlMnOpQrStUvWxYz' should return bdfhjlnprtvxz: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "AbCdEfGhIjKlMnOpQrStUvWxYz" ).compareTo("ACEGIKMOQSUWY")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'BDFHJLNPRTVXZ' should return empty string: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "BDFHJLNPRTVXZ" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'bdfhjlnprtvxz' should return empty string: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "bdfhjlnprtvxz" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing empty string should return empty string: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'xy$%lo23ph((on97es' should return yooes: " );
      try { System.out.println( (0 == StringStuff.oddsOnly( "xylophones" ).compareTo( "yooes" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the evensOnlyNoDupes method
   */
   public static void test_evensOnlyNoDupes() {
      System.out.println( "\nEIGHT TESTS FOR evensOnlyNoDupes():" );
      System.out.print( "   Testing 'xylophones' should return xlphn: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "xylophones" ).compareTo( "xlphn" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'XYloPHonES' should return XlPHn: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "XYloPHonES" ).compareTo("XlPHn")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'AAAABBBBAAAA' should return B: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "AAAABBBBAAAA" ).compareTo("B")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'shshshshshshshsh' should return h: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "shshshshshshshsh" ).compareTo("h")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'AAbbAAbbCCddCCdd' should return bd: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "AAbbAAbbCCddCCdd" ).compareTo( "bd" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing empty string should return empty string: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'California' should return lfrn: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "California" ).compareTo("lfrn")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'ACEGIKMOQSUWYACEGIKMOQSUWY' should return the empty string: " );
      try { System.out.println( (0 == StringStuff.evensOnlyNoDupes( "ACEGIKMOQSUWYACEGIKMOQSUWY" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the oddsOnlyNoDupes method
   */
   public static void test_oddsOnlyNoDupes() {
      System.out.println( "\nEIGHT TESTS FOR oddsOnlyNoDupes():" );
      System.out.print( "   Testing 'xylophones' should return yoes: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "xylophones" ).compareTo( "yoes" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'XYloPHonES' should return YoES: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "XYloPHonES" ).compareTo("YoES")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'AAAABBBBAAAA' should return A: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "AAAABBBBAAAA" ).compareTo("A")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'shshshshshshshsh' should return h: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "shshshshshshshsh" ).compareTo("s")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'AAbbAAbbCCddCCdd' should return bd: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "AAbbAAbbCCddCCdd" ).compareTo( "AC" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing empty string should return empty string: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'California' should return Caio: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "California" ).compareTo("Caio")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'BDFHJLNPRTVXBDFHJLNPRTVX' should return the empty string: " );
      try { System.out.println( (0 == StringStuff.oddsOnlyNoDupes( "BDFHJLNPRTVXBDFHJLNPRTVX" ).compareTo("")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the reverse method
   */
   public static void test_reverse() {
      System.out.println( "\nFOUR TESTS FOR reverse():" );
      System.out.print( "   Testing 'xylophones' should return senohpolyx: " );
      try { System.out.println( (0 == StringStuff.reverse( "xylophones" ).compareTo( "senohpolyx" )) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'XYloPHonES' should return SEnoHPolYX: " );
      try { System.out.println( (0 == StringStuff.reverse( "XYloPHonES" ).compareTo("SEnoHPolYX")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'AmanAplanAcAnalpAnamA' should return AmanAplanAcAnalpAnamA: " );
      try { System.out.println( (0 == StringStuff.reverse( "AmanAplanAcAnalpAnamA" ).compareTo("AmanAplanAcAnalpAnamA")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

      System.out.print( "   Testing 'shut the front door 1234567890' should return 0987654321 rood tnorf eht tuhs: " );
      try { System.out.println( (0 == StringStuff.reverse( "shut the front door 1234567890" ).compareTo("0987654321 rood tnorf eht tuhs")) ? "got it" : "don't got it" ); }
      catch( Exception e ) { System.out.println ( false ); }

   }

  /**
   * test method to test out the operation of the removeDupes method
   */
   //public static void test_removeDupes() {
   //   System.out.println( "\nFOUR TESTS FOR removeDupes():" );
   //   System.out.print( "   Testing 'xylophones' should return xylophnes: " );
   //   try { System.out.println( (0 == StringStuff.removeDupes( "xylophones" ).compareTo( "xylophnes" )) ? "got it" : "don't got it" ); }
   //   catch( Exception e ) { System.out.println ( false ); }

   //   System.out.print( "   Testing 'XYloPHonES' should return XYloPHnES: " );
   //   try { System.out.println( (0 == StringStuff.removeDupes( "XYloPHonES" ).compareTo("XYloPHnES")) ? "got it" : "don't got it" ); }
   //   catch( Exception e ) { System.out.println ( false ); }

    //  System.out.print( "   Testing 'AmanAplanAcAnalpAnamA' should return Amanplc: " );
    //  try { System.out.println( (0 == StringStuff.removeDupes( "AmanAplanAcAnalpAnamA" ).compareTo("Amanplc")) ? "got it" : "don't got it" ); }
    //  catch( Exception e ) { System.out.println ( false ); }

     // System.out.print( "   Testing 'shutTheFrontDoor11233455677890' should return shutTeFronD1234567890: " );
     // try { System.out.println( (0 == StringStuff.removeDupes( "shutTheFrontDoor11234567890" ).compareTo("shutTeFronD1234567890")) ? "got it" : "don't got it" ); }
     // catch( Exception e ) { System.out.println ( false ); }

   //}

}
