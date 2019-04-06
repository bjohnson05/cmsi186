/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  ClockSolver.java
 *  Purpose       :  The main program for the ClockSolver class
 *  @see
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.
 *
 *                   Refer to the Clock.java file for complete details of the Clock portion of the simulation.
 *
 *  Notes         :  None right now.  I'll add some as they occur.
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */

public class ClockSolver {
  /**
   *  Class field definintions go here
   */
   private final double MAX_TIME_SLICE_IN_SECONDS  = 1800.00;
   private final double DEFAULT_TIME_SLICE_SECONDS = 60.0;
   private final double EPSILON_VALUE              = 0.1;      // small value for double-precision comparisons

   private double seconds     = 0.0;               // the currentseconds value
   private double minutes     = 0.0;               // the current minutes value
   private double hours       = 0.0;               // the current hours value
   private double targetAngle = 0.0;               // the angle being looked for
   private double actualAngle = 0.0;               // the current angle the hands make
   private double timeSlice   = 0.0;               // time slice value of each tick of the clock
   private double anglewindow = 0.1;               // window of time for angle comparisons in degrees

  /**
   *  Constructor
   *  This just calls the superclass constructor, which is "Object"
   */
   public ClockSolver() {
      super();
   }

  /**
   *  Method to handle all the input arguments from the command line
   *   this sets up the variables for the simulation
   */
   public void handleInitialArguments( String args[] ) {
     // args[0] specifies the angle for which you are looking
     //  your simulation will find all the angles in the 12-hour day at which those angles occur
     // args[1] if present will specify a time slice value; if not present, defaults to 60 seconds
     // you may want to consider using args[2] for an "angle window"

      System.out.println( "\n   Hello world, from the ClockSolver program!!\n\n" ) ;
      if( 0 == args.length ) {
         System.out.println( "   Sorry you must enter at least one argument\n" +
                             "   Usage: java ClockSolver <angle> [timeSlice]\n" +
                             "   Please try again..........." );
         System.exit( 1 );
      }
      Clock clock = new Clock();
      try {
         targetAngle = clock.validateAngleArg( args[0] );
         String passString = ( 2 <= args.length ) ? args[1] : "60.0";
         timeSlice = clock.validateTimeSliceArg( passString );
         if( args.length == 3 ) {
            anglewindow = Double.parseDouble( args[2] );
         }
      }
      catch( NumberFormatException nfe ) {
         System.out.println( "   Sorry, your arguments are invalid.\n" +
                             "     Please use real numbers [e.g., '90.0' for 90 degrees]\n\n" +
                             "     Please try again..........." );
         System.exit( 1 );
      }
      catch( IllegalArgumentException iae ) {
         System.out.println( "\n\n   Sorry, your arguments are invalid.\n" +
                             "     " + iae.toString() + "\n" +
                             "     Please try again..........." );
         System.exit( 1 );
      }
      System.out.println( "   Your simulation is running,\n" +
                          "     looking for angles of " + targetAngle + " degrees\n" +
                          "     with a time slice of "  + timeSlice   + " seconds and\n" +
                          "     with an EPSILON_VALUE " + anglewindow + "\n\n" );
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  @param  args  String array of the arguments from the command line
   *                args[0] is the angle for which we are looking
   *                args[1] is the time slice; this is optional and defaults to 60 seconds
   */
   public static void main( String args[] ) {
      ClockSolver cs = new ClockSolver();
      Clock clock    = new Clock();
      double[] timeValues = new double[3];
      cs.handleInitialArguments( args );
      if( args.length == 3 ) {
         cs.anglewindow = Double.parseDouble( args[2] );
      } else {
         cs.anglewindow = cs.EPSILON_VALUE;
      }
      while( true ) {
         timeValues = clock.tick( cs.seconds, cs.minutes, cs.hours, cs.timeSlice );
         cs.actualAngle = clock.getHandAngle();
         if( cs.anglewindow >= Math.abs(cs.targetAngle - cs.actualAngle) ) {
            System.out.println( "Found target angle of " + cs.targetAngle + " at time: " + clock.toString() );
         }
         if( 43200.0 <= clock.getTotalSeconds() ) {
            break;
         }
      }

      System.exit( 0 );
   }
}
