/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Ball.java
 *  Purpose       :  Provides a class defining methods for the a Ball class for discrete simulations
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-03-09
 *  Description   :  This class models a soccer ball which is either moving or at rest.  The ball can be
 *                   on the field, or out of bounds.  The ball has a radius of 4.45 inches, weighs one
 *                   pound, and moves in an X,Y direction.  Friction causes the ball to slow down at the
 *                   rate of 1% of its speed per second.  The ball is used as part of a discrete
 *                   simulation.  The ball has an X and Y coordinate location for its cetner, and knows
 *                   if it is moving or not, and if it is in bounds or not.
 *
 *  Notes         :  The speed of the ball is in feet per second (FPS).  The ball is considered to be at
 *                   rest if the speed is less than or equal to 1 inch per second.
 *  Warnings      :  None
 *  Exceptions    :  None at this time
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-09  B.J. Johnson  Initial writing and release
 *  @version 2.0.0  2018-03-20  B.J. Johnson  Updated to new less complex version
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;

public class Ball {

   private static final double BALL_RADIUS          = 4.45;    // radius in inches as given by the problem
   private static final double BALL_WEIGHT          = 1.0;     // weight in pounds as given
   private static final double FRICTION_COEFFICIENT = 0.99;    // one percent slowdown per second due to friction
   public  static final int    X_INDEX              = 0;
   public  static final int    Y_INDEX              = 1;
   private static final int    TAB_OFFSET_INDEX     = 22;      // OCD move just to make output look lined up

   private boolean  isInBounds      = true;                    // all balls will start in bounds by default
   private double[] centerLocation  = new double[2];           // array containing both coordinate values
   private double[] currentSpeed    = new double[2];           // array containing both direction speed values
   private double   frictionValue   = FRICTION_COEFFICIENT;    // initialize for one secone default time slice

  /**
   * Constructor to make a new Ball, no parameters
   *  @param xLocation double-precision value of the X location of the ball
   *  @param yLocation double-precision value of the Y location of the ball
   *  @param xMovement double-precision value for the initial speed of the ball in X direction
   *  @param yMovement double-precision value for the initial speed of the ball in Y direction
   */
   public Ball( double xLocation, double yLocation, double xMovement, double yMovement ) {
      centerLocation[0] = xLocation;
      centerLocation[1] = yLocation;
      currentSpeed[0]   = xMovement;
      currentSpeed[1]   = yMovement;
   }

  /**
   *  method to fetch the current speed of the ball
   *  @return  double-precision two-element array of X and Y speed values
   */
   public double[] getCurrentSpeed() {
      return currentSpeed;
   }

  /**
   *  method to fetch the current position of the ball
   *  @return  double-precision two-element array of X and Y location values
   */
   public double[] getCurrentPosition() {
      return centerLocation;
   }

  /**
   *  method to determine if the ball is still moving
   *  @return  boolean true if ball is moving, false if at rest
   *  Note:    at rest is defined as speed <= 1.0 inch/second
   */
   public boolean isStillMoving() {
      return ( 1.0 <= Math.abs(currentSpeed[X_INDEX] * 12.0) );
   }

  /**
   *  method to flag the ball as "out of bounds" which will set its speed to zero and its
   *    "isInBounds" value to false so it will effectively no longer be in the simulation
   *  @param fieldWidth    double-precision value of 1/2 the designated field width
   *  @param fieldHeight   double-precision value of 1/2 the designated field height
   */
   public void setBallOutOfBounds( double fieldWidth, double fieldHeight ) {
      if( (Math.abs(centerLocation[X_INDEX]) >= (fieldWidth / 2.0)) ||
          (Math.abs(centerLocation[Y_INDEX]) >= (fieldHeight / 2.0)) ) {
         isInBounds = false;
         currentSpeed[X_INDEX] = 0.0;
         currentSpeed[Y_INDEX] = 0.0;
      }
   }

  /**
   *  method to update the speed of the ball for one slice of time
   *  @param timeSlice     double-precision value of time slace for simulation
   *  @return  double-precision two element array of new velocity values
   */
   public double[] updateSpeedsForOneTick( double timeSlice ) {
      frictionValue = Math.pow( 0.99, timeSlice );    // speed value decreases 'per second'
      currentSpeed[X_INDEX] *= frictionValue;
      currentSpeed[Y_INDEX] *= frictionValue;
      return currentSpeed;
   }

  /**
   *  method to update the ball's position and velocity
   *  @param timeSlice     double-precision value of time slace for simulation
   */
   public void move( double timeSlice ) {
      currentSpeed = updateSpeedsForOneTick( timeSlice );
      centerLocation[X_INDEX] += (currentSpeed[X_INDEX] * timeSlice);
      centerLocation[Y_INDEX] += (currentSpeed[Y_INDEX] * timeSlice);
   }

  /**
   * our venerable "toString()" representation
   *  @return  String-y version of what this Ball is
   */
   public String toString() {
      DecimalFormat dfp = new DecimalFormat( "#0.000");
      DecimalFormat dfv = new DecimalFormat( "#0.0000" );
      String output = "position <" + dfp.format( centerLocation[X_INDEX] ) + ", " +
                                     dfp.format( centerLocation[Y_INDEX] ) + ">";
      if( output.indexOf( ">" ) <= TAB_OFFSET_INDEX ) {
         output += "\t";
      }
      if( !isInBounds ) {
         output += "\t<out of bounds>";
      } else if( (1.0 > Math.abs(currentSpeed[X_INDEX] * 12.0)) ||
                 (1.0 > Math.abs(currentSpeed[Y_INDEX] * 12.0)) ) {
         output += "\t<at rest>";
      } else {
         output += "\tvelocity <" + dfv.format( currentSpeed[X_INDEX] ) + " X and " +
                                    dfv.format( currentSpeed[Y_INDEX] ) + " Y> ft/sec";
      }
      return output;
   }

  /**
   * a main method for testing -- pretty simple
   *  @param args[] String array of command line arguments
   */
   public static void main( String args[] ) {
      System.out.println( "\n   Testing the Ball class................" );
      Ball b1 = new Ball( 10.0, 50.0, 2.0, 6.0 );
      Ball b2 = new Ball( 20.0, 60.0, 3.0, 7.0 );
      Ball b3 = new Ball( 30.0, 70.0, 4.0, 8.0 );
      Ball b4 = new Ball( 40.0, 80.0, 5.0, 9.0 );
      System.out.println( "Ball b1: " + b1.toString() );
      System.out.println( "Ball b2: " + b2.toString() );
      System.out.println( "Ball b3: " + b3.toString() );
      System.out.println( "Ball b4: " + b4.toString() );
      System.out.println();
      b1.move( 1.0 );
      b2.move( 1.0 );
      b3.move( 1.0 );
      b4.move( 1.0 );
      System.out.println( "Ball b1: " + b1.toString() );
      System.out.println( "Ball b2: " + b2.toString() );
      System.out.println( "Ball b3: " + b3.toString() );
      System.out.println( "Ball b4: " + b4.toString() );
      System.out.println();
      b1.move( 0.1 );
      b2.move( 0.1 );
      b3.move( 0.1 );
      b4.move( 0.1 );
      System.out.println( "Ball b1: " + b1.toString() );
      System.out.println( "Ball b2: " + b2.toString() );
      System.out.println( "Ball b3: " + b3.toString() );
      System.out.println( "Ball b4: " + b4.toString() );
      System.out.println();
      b1.move( 2.0 );
      b2.move( 2.0 );
      b3.move( 2.0 );
      b4.move( 2.0 );
      System.out.println( "Ball b1: " + b1.toString() );
      System.out.println( "Ball b2: " + b2.toString() );
      System.out.println( "Ball b3: " + b3.toString() );
      System.out.println( "Ball b4: " + b4.toString() );
      System.out.println();
      b1.setBallOutOfBounds( 30.0, 30.0 );
      for( int i = 0; i < 250; i++ ) {
         b1.move( 2.0 );
         b2.move( 2.0 );
         b3.move( 2.0 );
         b4.move( 2.0 );
         System.out.println( "Ball b1: " + b1.toString() );
         System.out.println( "Ball b2: " + b2.toString() );
         System.out.println( "Ball b3: " + b3.toString() );
         System.out.println( "Ball b4: " + b4.toString() );

         if( b1.isStillMoving() || b2.isStillMoving() || b3.isStillMoving() || b4.isStillMoving() ) {
            System.out.println();
         } else {
            break;
         }
      }
   }

}
