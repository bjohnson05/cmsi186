/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  StringStuff.java
 *  Purpose       :  A file full of stuff to do with the Java String class
 *  Author        :  B.J. Johnson
 *  Date          :  2017-01-19
 *  Description   :  This file presents a bunch of String-style helper methods.  Although pretty much
 *                   any and every thing you'd want to do with Strings is already made for you in the
 *                   Jave String class, this exercise gives you a chance to do it yourself [DIY] for some
 *                   of it and get some experience with designing code that you can then check out using
 *                   the real Java String methods [if you want]
 *  Notes         :  None
 *  Warnings      :  None
 *  Exceptions    :  None
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision History
 *  ----------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-01-19  B.J. Johnson  Initial writing and release
 *  @version 1.1.0  2017-01-22  B.J. Johnson  Fill in methods to make the program actually work
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Set;
import java.util.LinkedHashSet;

public class StringStuff {

  /**
   * Method to determine if a string contains one of the vowels: A, E, I, O, U, and sometimes Y.
   * Both lower and upper case letters are handled.  In this case, the normal English rule for Y means
   * it gets included.
   *
   * @param   s String containing the data to be checked for &quot;vowel-ness&quot;
   * @return  boolean which is true if there is a vowel, or false otherwise
   */
   public static boolean containsVowel( String s ) {

     // Data for which to search within the input string
      String[] vowels = { "A", "E", "I", "O", "U", "Y", "a", "e", "i", "o", "u", "y" };

     // Loop that stops immediately when any vowel is found in the string
      for( int i = 0; i < vowels.length; i++ ) {
         if( s.contains( vowels[i] ) ) {
            return true;
         }
      }
      return false;
   }

  /**
   * Method to determine if a string is a palindrome.  Does it the brute-force way, checking
   * the first and last, second and last-but-one, etc. against each other.  If something doesn't
   * match that way, returns false, otherwise returns true.
   *
   * @param   s String containing the data to be checked for &quot;palindrome-ness&quot;
   * @return  boolean which is true if this a palindrome, or false otherwise
   */
   public static boolean isPalindrome( String s ) {
      int i = 0;
      int j = s.length() - 1;
      while( i < (s.length() / 2) ) {
         if( s.charAt(i) == s.charAt(j) ) {
            i++;
            j--;
         } else {
            return false;
         }
      }
      return true;
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet.  The letters B, D, F, H, J, L, N, P, R, T, V, X, and Z are even,
   * corresponding to the numbers 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, and 26.
   *
   * NOTE: this is yet another way to accomplish this task, using a character array instead of
   *       a String.  This method makes it a bit easier to do the comparison, sinc you are
   *       comparing a character with a character and you don't have to worry about the type
   *       conversion.  However, it does make the logic a bit more complex, because you need
   *       nested loops to check all the characters against each other.  This method may [or
   *       may NOT] be easier to understand, but it IS less efficient.
   *
   * @param   s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input
   */
   public static String evensOnly( String s ) {
      char[] evens  = { 'B', 'D', 'F', 'H', 'J', 'L', 'N', 'P', 'R', 'T', 'V', 'X', 'Z',
                        'b', 'd', 'f', 'h', 'j', 'l', 'n', 'p', 'r', 't', 'v', 'x', 'z'};
      char[] output = new char[s.length()];
      int k = 0;
      for( int i = 0; i < s.length(); i++ ) {
         for( int j = 0; j < evens.length; j++ ) {
            if( s.charAt(i) == evens[j] ) {
               output[k] = s.charAt(i);
               k++;
               break;   // note that this only breaks out of the INNER loop!
            }
         }
      }
      return new String( output ).trim();
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet.  The letters A, C, E, G, I, K, M, O, Q, S, U, W, and Y are odd,
   * corresponding to the numbers 1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, and 25.
   *
   * NOTE:  Same comment as the note in the above method for "evensOnly()"
   *
   * @param   s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input
   */
   public static String oddsOnly( String s ) {
      char[] odds   = { 'A', 'C', 'E', 'G', 'I', 'K', 'M', 'O', 'Q', 'S', 'U', 'W', 'Y',
                        'a', 'c', 'e', 'g', 'i', 'k', 'm', 'o', 'q', 's', 'u', 'w', 'y'};
      char[] output = new char[s.length()];
      int k = 0;
      for( int i = 0; i < s.length(); i++ ) {
         for( int j = 0; j < odds.length; j++ ) {
            if( s.charAt(i) == odds[j] ) {
               output[k] = s.charAt(i);
               k++;
               break;   // note that this only breaks out of the INNER loop!
            }
         }
      }
      return new String( output ).trim();
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;EVEN&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * NOTE: "heavy lifting" is done by the "removeDupes()" method
   *
   * @param   s String containing the data to be parsed for &quot;even&quot; letters
   * @return  String containing the &quot;even&quot; letters from the input without duplicates
   */
   public static String evensOnlyNoDupes( String s ) {
      return new String( removeDupes( evensOnly( s ) ) );
   }

  /**
   * Method to return the characters in a string that correspond to the &quot;ODD&quot; index
   * numbers of the alphabet, but with no duplicate characters in the resulting string.
   *
   * NOTE: "heavy lifting" is done by the "removeDupes()" method
   *
   * @param   s String containing the data to be parsed for &quot;odd&quot; letters
   * @return  String containing the &quot;odd&quot; letters from the input without duplicates
   */
   public static String oddsOnlyNoDupes( String s ) {
      return new String( removeDupes( oddsOnly( s ) ) );
   }

  /**
   * Method to return the reverse of a string passed as an argument
   *
   * @param   s String containing the data to be reversed
   * @return  String containing the reverse of the input string
   */
   public static String reverse( String s ) {
      int j = s.length() - 1;
      char[] output = new char[s.length()];
      for( int i = 0; i < s.length(); i++ ) {
         output[i] = s.charAt(j);
         j-- ;
      }
      return new String( output );
   }

  /**
   * Method to return a string with all duplicate characters removed.
   * Illustrates the use of StringBuilder, Set, LinkedHashSet, for(c:c) loop, and generics
   *
   * NOTE: the method here is to use lots of type conversion stuff to let the JVM do all the
   *       "heavy lifting" for you.  We declare a StringBuilder, and we turn the input String
   *       into an array of characters.  Next, we create a character *set* which is made out
   *       of a LinkedHashSet [using the <Character> "generic"].  We then loop through all of
   *       the characters in our charRA, one at a time, and add them to the set.  Remember
   *       that in set theory, sets only have ONE of any "thing" that is in the set; thus if
   *       we add something that is a duplicate, it is basically thrown away since there is
   *       already one of those in the set.  Next, we go through the resulting set and pull
   *       out each ofthe characters in turn, and add them to the StringBuilder we declared
   *       at the start of the method.  Finally, we call the "toString()" method from the
   *       StringBuilder, so that we are returning the String data type which the method
   *       advertises as its return type.   Voila!
   *
   * @param   s String containing the data from which to remove duplicates
   * @return  String containing the input string with all duplicate characters removed
   */
   public static String removeDupes( String s ) {
      StringBuilder sb = new StringBuilder();
      char[] charRA    = s.toCharArray();
      Set<Character> charSet = new LinkedHashSet<Character>();
      for( char c : charRA ) {
          charSet.add( c );
      }
      for( Character myChar : charSet ) {
          sb.append( myChar );
      }
      return sb.toString();
   }

  /**
   * Method to count the number of times a particular character occurs in a string
   *
   * @param   c  char    the character for which to look
   * @param   s  String  the string to search to count the occurrences
   * @return  long value containing the count of "c" contained in "s"
   */
   public static long characterCounter( char c, String s ) {
      long count = 0;
      for( int i = 0; i < s.length(); i++ ) {
         if( c == s.charAt(i) ) {
            count++;
         }
      }
      return count;
   }
}
