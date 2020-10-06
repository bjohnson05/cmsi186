/**
 *  File name     :  SoccerSim.java
 *  Purpose       :  Provides a class defining a soccer ball simulation
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-03-09
 *  Description   :  This class models a soccer field on which a number of soccer balls are placed and
 *                   can move, and on which a pole has been set up.  The field has a "starting point",
 *                   which is used as the origin, and has an x-width and a y-width, as well as an
 *                   orientation offset in degrees, such that 0.0° corresponds to north being straight
 *                   up and down, putting due south at 180°.
 *
 *  Notes         :  From the assignment web page at:<br />
 *  <a href='http://bjohnson.lmu.build/cmsi186web/homework05.html'>http://bjohnson.lmu.build/cmsi186web/homework05.html</a><br />
 *                   Simultaneously, on a perfectly flat playground, at time 00:00:00.0 (hrs:mins:secs),
 *                   an arbitrary number of soccer balls are kicked, all at different speeds and
 *                   directions. We wish to find out, via a discrete simulation of the system, whether
 *                   a collision will ever take place, and, if so, where and when. Each ball has a
 *                   radius of 4.45 inches and weighs one pound. The center of the playground is presumed
 *                   to be the point (x,y) = (0.0,0.0). The following additional conditions apply:<br />
 *                   1) Friction acts to slow each ball down until it comes to rest.  Your program should
 *                      simulate friction as a force that continuously decreases each ball's speed at the
 *                      rate of one per cent per second until it is traveling less than one inch per
 *                      second, at which point it comes to rest.<br />
 *                   2) Data about each ball will be given to your program via four consecutive args,
 *                      namely the x- and y-coordinates of the ball's starting position [measured in
 *                      inches], followed by its speeds in the x- and y-directions [in feet per second].<br />
 *                   3) If present, a final arg specifies the time slice [in seconds].  If missing, your
 *                      program should use a default time slice of one second.<br />
 *                   4) As always, your program should check validity of the args.<br />
 *                   5) Your program should output:<br />
 *                      a) An initial report that gives the locations of all objects, including the
 *                         initial velocity of each ball<br />
 *                      b) After every time slice, a report showing the location and velocity of every ball<br />
 *                      c) A final report indicating the simulated time of the first collision, the objects
 *                         involved and their locations; or, the message NO COLLISION IS POSSIBLE, giving
 *                         the simulated time at which the program made that discovery.v
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-03-09  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;

public class SoccerSimEmpty {

   private static final double DEFAULT_FIELD_WIDTH   = 1000.0;
   private static final double DEFAULT_FIELD_HEIGHT  = 1000.0;
   private static final double DEFAULT_POLE_X_POS    = 321.0;
   private static final double DEFAULT_POLE_Y_POS    = 543.0;
   private static final double DEFAULT_TIME_SLICE    = 1.0;

   private boolean  initialReport      = true;
   private boolean  stillMoving        = true;
   private boolean  timeSliceDefault   = true;
   private double   timeSlice          = DEFAULT_TIME_SLICE;
   private double   totalTimeSecs      = 0.0;
   private double[] fieldSizes         = null;
   private double[] poleLocation       = null;
   private int      ballCount          = 0;

   private Ball[]   soccerBalls        = null;
   private Clock    c                  = null;

   private static final String USAGE_MESSAGE         = "\n  Usage:" +
         "\n    java SoccerSim <ball-parameters> ... <ball-parameters> [timeslice]" +
         "\n      where EACH <ball-parameters> field is a 4-tuple of the values:" +
         "\n            starting-x, starting-y, start-speed-x, start-speed-y" +
         "\n" +
         "\n    try running with three soccer balls: <10 10 1 1>, <18 18 -1 -1>, and <311 311 1 1>" +
         "\n    this should produce a collision between the first two balls in about four iterations." +
         "\n\n  Please try again.";

  /**
   *  constructor
   */
   public SoccerSimEmpty() {

   }

  /**
   *  Method to validate the input arguments
   *  @param arguments String array of the arguments supplied to the program
   */
   public void validateArgsAndSetupSim( String arguments[] ) throws NumberFormatException,
                                                                    IllegalArgumentException {
      int ballcount = 0;

     // no arguments specified, so dispay usage message
      if( 0 == arguments.length ) {
         System.out.println( USAGE_MESSAGE );
         System.exit( 0 );

     // validation: if count % 4 is 1, assume last is timeslice in seconds
      } else {
         if( 1 == (arguments.length % 4) ) {       // optional time slice argument exists

         }

        // now handle and validate the ball arguments
        //  also check if the timeSlice is the default value or not
         ballcount = 0;
         if( timeSliceDefault ) {

         } else {

         }

        // next is a loop to create all the soccerBalls and put them into the array
        //  you will need to replace "true" with the proper condition
         while( true ) {

         }

      }
   }

  /**
   *  method to report the status of the simulation for every clock tick
   *  @param  c  Clock object which keeps track of time
   *  NOTE: this method calls the clock.tick() method to get one second to elapse
   */
   public void report() {
      String output = "";
      if( initialReport ) {
         initialReport = false;
        //  put in some code here to output the report at time zero

      } else {

        // put in some code here to output the report at all other times
      }
      System.out.println( output );
   }

  /**
   *  method to move the balls in the soccerBall array
   *
   */
   public void simUpdate() {

   }

  /**
   *  method to check for a collision
   *
   */
   public int[] collisionCheck() {
      int[] ballsCollided = new int[2];
      ballsCollided[0]  = -99;
      ballsCollided[1]  = -99;

      return ballsCollided;
   }

  /**
   *  method to check if at LEAST one ball is still moving
   *
   */
   public boolean atLeastOneBallStillMoving() {
      return false;
   }

  /**
   *  main method of the simulation
   *  @param  args  String array of the command line arguments
   */
   public static void main( String args[] ) {
      System.out.println( "\n  Hello, world, from the SoccerSim program!" );
      SoccerSim ss = new SoccerSim();
      try {
         ss.validateArgsAndSetupSim( args );
      }
      catch( NumberFormatException nfe ) {
         System.out.println( USAGE_MESSAGE );
         System.exit( 1 );
      }
      catch( IllegalArgumentException iae ) {
         System.out.println( USAGE_MESSAGE );
         System.exit( 2 );
      }

      ss.report();
      int iterations = 1;             // this is optional
      int[] collision = new int[2];
      while( true ) {
         // call the "tick" method to increment the time
         // call the "simUpdate" method or "move" method or what have you to move all the soccer balls
         // call the "report" method or otherwise output the report
         // check for a collision
         // check if any ball is still moving



         iterations++;
      }
      // System.out.println( "Simulation required " + iterations + " iterations to complete." );
   }
}

