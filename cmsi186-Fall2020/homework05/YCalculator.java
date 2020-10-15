/**
 *  filename: YCalculator
 *  purpose: calculate Y values for integration exercise homework05
 *  @author  Dr. Johnson
 *  @date    2020-10-15
 *  @version 1.0.0
 */

public class YCalculator {

  /** just a placeholder... */
   public YCalculator() {}

  /**
   *  method to calculate the yValue given a set of coefficients
   *  @param  coeffs double[] containing the coefficients of the equation in reverse order
   *  @param  midPoint double precision value of the midpoint of the "chunk"
   *  @return double value of the yValue at the midpoint of the chunk, given the coefficients
   */
   public double calculateY( double[] coeffs, double midPoint ) {
      double yValue = 0.0;
      if( 0 == coeffs.length ) {
         yValue = Math.pow( midPoint, 1 );
      } else {
         for( int i = 0; i < coeffs.length; i++ ) {
            yValue += coeffs[i] * Math.pow( midPoint, i );
         }
      }
      return yValue;
   }
}
