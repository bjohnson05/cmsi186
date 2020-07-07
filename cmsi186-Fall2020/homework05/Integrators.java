/**
 * filename    : Integrators.java
 * purpose     : provides a class for integration methods
 * @author     : Dr. Johnson from a file by Dr. Phil Dorin
 * @date       : this version created from hardcopy on 2019-01-27
 * @version    : 1.0.0
 * Description : A class file with several different integration methods
 */

 public class Integrators {

  /**
   *  constructor
   */
   public Integrators() {}

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

  /**
   *  method to integrate the value of a polynomial equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integratePolynomial( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += yValue * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to integrate the value of the sine of an equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integrateSine( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += Math.sin(yValue) * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to integrate the value of the cosine of an equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integrateCosine( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += Math.cos(yValue) * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to integrate the value of the tangent of an equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integrateTangent( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += Math.tan(yValue) * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to integrate the value of the square root of an equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integrateSquareRoot( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += Math.sqrt(yValue) * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to integrate the value of the log of an equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integrateNaturalLog( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += Math.log(yValue) * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to integrate the value of "e" to the "x" of an equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integrateEtoX( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += Math.exp(yValue) * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to integrate the value of the log-base-10 of an equation given the bounds, coefficients, and the number
   *    of rectangles using Riemann Integration
   *  @param  lb double precision value of the lower bound of the integration
   *  @param  ub double precision value of the upper bound of the integration
   *  @param  coefficients double precision array containing the coefficients of the X terms
   *  @param  n integer number of blocks to use for the integration
   *  @return double precision value that is the area under the curve of the polynomial
   */
   public double integrateLogTen( double lb, double ub, double[] coefficients, int n ) {
      double midpt  = 0.0;
      double sum    = 0.0;
      double sliceWidth  = ((ub - lb) / n);
      double yValue = 0.0;
      for( int j = 0; j < n; j++ ) {
         yValue = 0.0;
         midpt = lb + (sliceWidth / 2.0) + (j * sliceWidth);
         yValue = calculateY( coefficients, midpt );
         sum += Math.log10(yValue) * sliceWidth;
      }
      return sum;
   }

  /**
   *  method to output the details of the function to be integrated
   *  @param function String of what function is being integrated
   *  @param coeffs double[] of the coefficients of the equation
   *  @param eqOrder int value of the order of the equation
   *  @param lb double precision value of the lower bound of the integration
   *  @param ub double precision value of the upper bound of the integration
   */
   public void printFunctionDescription( String function, double[] coeffs, int eqOrder, double lb, double ub ) {
      System.out.print( "\n   Integrating the " + function + ": "  );
      for( int i = eqOrder - 1; i >= 0; i-- ) {
         if( coeffs[i] > 0.0 ) {
            System.out.print( "+" + coeffs[i] + "X^" + i + " " );
         } else if( coeffs[i] != 0.0 ) {
            System.out.print( coeffs[i] + "X^" + i + " " );
         }
      }
      System.out.println( "from " + lb + " to " + ub );

   }


}
