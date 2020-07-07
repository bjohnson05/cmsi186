/**
 * filename    : Integratable.java
 * purpose     : provides an interface for an integratable function
 * @author     : Dr. Johnson from a file by Dr. Phil Dorin
 * @date       : this version created from hardcopy on 2019-01-27
 * @version    : 1.0.0
 * Description : An object may possess an integratable function,
 *
 *    <code>f: double -> double</code>
 *
 *    as long as its class implements the Integratable interface.
 *    For example, if we have:
 *
 *    <pre>
 *    class SquaringFunction implements IntegratableFunction {
 *       public double f( double x ) {
 *          return x * x;
 *       }
 *    }
 *    </code>
 *
 *    then the code line
 *
 *    <code>SquaringFunction sqrf = new SquaringFunction();</code>
 *
 *    creates a new object referred to by the token <q>sqrf</q> which
 *    possesses an instance method referred to by the token <q>f</q>,
 *    which is a function that can be evaluated at a given point
 *    [the value of the argument <q>x</q>] as in
 *
 *    <code>double result1 = sqrf.f( 3.14159 );</code>
 *
 *    <code>double result2 = sqrf.f( Math.random() );</code>
 *
 *    etc.
 */

public interface Integratable {
   public double f( double x );
}
