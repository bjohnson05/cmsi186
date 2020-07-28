/**
 *  file: HelloSayer.java
 *  purpose: demonstrate a simple file so we can see byte code
 */

public class HelloSayer {

   public static void main( String [] args ) {
      if( args.length == 0 ) {
         System.out.println( "\n   Hello, nobody!" );
      } else {
         System.out.println( "\n   Hello, " + args[0] + "!" );
      }
      System.exit( 0 );
   }
}
