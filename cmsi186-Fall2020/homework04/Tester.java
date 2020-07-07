public class Tester {

   public static void main( String [] args ) {
      double velocity = 5.43;
      double time = 2.0;
      double value = velocity - (0.01 * (velocity * time));
      System.out.println( "value with 2.0 second time slice is: " + value );
      time = 1.0;
      value = velocity - (0.01 * (velocity * time));
      System.out.println( "value with 1.0 second time slice is: " + value );
      time = 0.5;
      value = velocity - (0.01 * (velocity * time));
      System.out.println( "value with 0.5 second time slice is: " + value );
      time = 10.0;
      value = velocity - (0.01 * (velocity * time));
      System.out.println( "value with 10. second time slice is: " + value );

   }
}
