/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  filename: Doofus.java
 *  description: demonstrator for parsing a long string into what fits in an array of "int"s
 *  author: B.J. Johnson
 *  date: 2018-04-04 (in memorium, MLK)
 *  revision: 1.0.0 initial release
 *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.util.Arrays;

public class Doofus {

   private static final int CHARS_THAT_FIT = 8;
   private int[] values = null;

  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
   *  Method to display an Array representation of this BrobInt as its bytes
   *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
   public void toArray( int[] d ) {
      System.out.println( "Array contents: " + Arrays.toString( d ) );
   }

   public static void main( String [] args ) {

      System.out.println( "Biggest Integer value is: " + Integer.MAX_VALUE );
      System.out.println( "Smallest Integer value is: " + Integer.MIN_VALUE );
      System.out.println( "Biggest LONG value is: " + Long.MAX_VALUE );
      System.out.println( "Smallest Integer value is: " + Long.MIN_VALUE );
      System.out.println( "Input value [string] is:\n" + args[0] );

      Doofus d = new Doofus();
      int i = 0;
      int length = args[0].length();
      int start  = length - CHARS_THAT_FIT;
      int size   = (int)(Math.ceil( length / CHARS_THAT_FIT ) + 1);
      d.values = new int[ size ];

      StringBuffer sb = new StringBuffer( args[0] ).reverse();
      System.out.println( "Current State: length = " + length + "\n" +
                          "       buffered value = " + sb.toString() );
      while( length >= 8 ) {
         d.values[i] = Integer.parseInt( args[0].substring( start, length ) );
         start -= CHARS_THAT_FIT;
         length -= CHARS_THAT_FIT;
         System.out.print( " length: " + length + ", start: " + start );
         System.out.println( "  -- converted values[" + i + "] is: " + d.values[i] );
         i++;
      }
      if( length > 0 ) {
         d.values[i] = Integer.parseInt( args[0].substring( 0, length ) );
         System.out.print( " length: " + length + ", start: " + start );
         System.out.println( "  -- converted values[" + i + "] is: " + d.values[i] );
      }
      d.toArray( d.values );
      System.exit( 0 );
   }
}
