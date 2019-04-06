/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.
 *
 *  Notes         :  Note that several calculations are included intrinsically.  For example, the number of
 *                   degrees that the hands move in one second are defined as constants.  so are the default
 *                   time slice value, and the maximum degree value.  Remember that the max degrees is to
 *                   be STRICTLY less than 360.0 degrees; reaching that value as you go around the clock
 *                   puts you back at zero degrees again.  Also, it is possible to figure out the time from
 *                   the degrees and the number of seconds elapsed using the equation:
 *
 *                      targetAngle = |(totalSeconds * 0.00834) - (totalSeconds * 0.1)|
 *
 *                   where the "|'s" indicate absolute value.  As a correctness check, this means an angle
 *                   of 30 degrees will occur nominally at 327.297 seconds, which is 5 minutes, 27.297
 *                   seconds.  Going the other way, the number of seconds times 0.009166 will give you the
 *                   angle, so for example, doubling the value above gives:
 *
 *                      totalSeconds = 654.954 so that (654.954 * 0.009166) = 60.03308364 degrees
 *
 *                   This class is meant to be used for two things: 1) to validate the arguments that are
 *                   passed on the command line to the "ClockSolver" program; and 2) to provide all the
 *                   operations that the Clock needs to produce the times at which the target angle has been
 *                   reached.  Note that there are several issues that need to be taken into account, such
 *                   as the fact that the exact angle may not be reached, due to the resolution of number
 *                   representations in memory, the resolutions or granularity of the calculation, the idea
 *                   of comparisons of double precision values not equating, and the bracketing effect that
 *                   can be observed in the output, where the real time is actually between to reported time
 *                   values.
 *
 *  Warnings      :  None
 *  Exceptions    :  IllegalArgumentException or NumberFormatException when the input arguments are "hinky"
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  Revision Histor
 *  ---------------
 *            Rev      Date     Modified by:  Reason for change/modification
 *           -----  ----------  ------------  -----------------------------------------------------------
 *  @version 1.0.0  2017-02-28  B.J. Johnson  Initial writing and release
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
import java.text.DecimalFormat;

public class Clock {
  /**
   *  Class field definintions go here
   *    CONSTANTS first
   */
   private static final double DEFAULT_TIME_SLICE_IN_SECONDS = 60.0;
   private static final double INVALID_ARGUMENT_VALUE = -1.0;
   private static final double MAXIMUM_DEGREE_VALUE = 360.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

  // private fields
   private double[] timeJunque = new double[3];       // [0] = seconds, [1] = minutes, [2] = hours
   private static double totalSeconds = 0.0;
   private static double hourHandDegrees = 0.0;
   private static double minuteHandDegrees = 0.0;

  /**
   *  Constructor
   *   Not really anything to do here, so just call the "super()"
   *     which for this is Java's "Object"<br />
   *   Note that this isn't really NEEDED, but it's here to tell
   *     posterity I actually THOUGHT about it...
   */
   public Clock() {
      super();
   }

  /**
   *  Method to calculate the next tick from the time increment<br />
   *     each "tick" will be the number of seconds in the time slice
   *  @param  seconds   double-precision value of the current seconds of the time
   *  @param  minutes   double-precision value of the current minutes of the time
   *  @param  hours     double-precision value of the current hours of the time
   *  @param  timeSlice double-precision value of the time slice being used
   *  @return three-element double array containing new seconds, minutes, and hours
   */
   public double[] tick( double seconds, double minutes, double hours, double timeSlice ) {
      totalSeconds += timeSlice;
      double[] returnValue = new double[3];
      timeJunque[0]  = totalSeconds % 60;
      timeJunque[1]  = (int)(totalSeconds / 60) % 60;
      timeJunque[2]  = (int)totalSeconds / 3600;
      returnValue[0] = totalSeconds % 60;
      returnValue[1] = (int)(totalSeconds / 60) % 60;
      returnValue[2] = (int)totalSeconds / 3600;
      return returnValue;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   *  @throws  IllegalArgumentException
   */
   public static double validateAngleArg( String argValue ) throws NumberFormatException,
                                                            IllegalArgumentException {
      double returnValue = 0.0;
      try {
         returnValue = Double.parseDouble( argValue );
      }
      catch( NumberFormatException nfe ) {
         throw new NumberFormatException( " [converting degree value failed]");
      }
      if( ( 0.0 > returnValue ) || (360.0 <= returnValue) ) {
         throw new IllegalArgumentException( " [degree value out of range]" );
      }
      return returnValue;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param   argValue  String from the main programs args[1] input
   *  @return  double-precision value of the argument or -1.0 if invalid
   *  @throws  NumberFormatException
   *  @throws  IllegalArgumentException
   *  Note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!<br />
   *  Note: remember that the time slice, if it is small, will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public static double validateTimeSliceArg( String argValue ) throws NumberFormatException,
                                                                IllegalArgumentException {
      double returnValue = 0.0;
      try {
         returnValue = Double.parseDouble( argValue );
      }
      catch( NumberFormatException nfe ) {
         throw new NumberFormatException( " [converting time slice value failed]");
      }
      if( (0.0 >= returnValue) || (1800.0 < returnValue) ) {
         throw new IllegalArgumentException( " [time slice value out of range]" );
      }
      return returnValue;
   }

  /**
   *  Method to calculate and return the current position of the hour hand
   *  @return double-precision value of the hour hand location
   *  NOTE:  the hour hand moves 360 degrees in 43200 seconds, which works out to be
   *         0.00834 degrees per second
   */
   public double getHourHandAngle() {
      hourHandDegrees = HOUR_HAND_DEGREES_PER_SECOND * totalSeconds;
      return hourHandDegrees;
   }

  /**
   *  Method to calculate and return the current position of the minute hand
   *  @return double-precision value of the minute hand location
   *  NOTE:  the minute hand moves 360 degrees in 3600 seconds, which works out to be
   *         0.1 degrees per second
   */
   public double getMinuteHandAngle() {
      minuteHandDegrees = MINUTE_HAND_DEGREES_PER_SECOND * ((timeJunque[1] * 60.0) + timeJunque[0]);
      return minuteHandDegrees;
   }

  /**
   *  Method to calculate and return the angle between the hands
   *  @return double-precision value of the angle between the two hands
   */
   public double getHandAngle() {
      double angle = Math.abs( getHourHandAngle() - getMinuteHandAngle() ) ;
      if( angle > 180.0 ) {
         angle = 360.0 - angle;
      }
      return angle;
   }

  /**
   *  Method to fetch the total number of seconds
   *   we can use this to tell when 12 hours have elapsed
   *  @return double-precision value the total seconds private variable
   */
   public double getTotalSeconds() {
      return totalSeconds;
   }

  /**
   *  Method to display the current time in "HH : MM : SS.SSS" format
   *  @return String value of the time, formatted using "DecimalFormat" class
   */
   public String toString() {
      DecimalFormat dfs = new DecimalFormat( "#00.000" );
      DecimalFormat dfhm = new DecimalFormat( "00" );
      return "   " + dfhm.format(timeJunque[2]) + " : " + dfhm.format(timeJunque[1]) + " : " + dfs.format(timeJunque[0]);
   }

  /**
   *  The main program starts here to run tests<br />
   *     remember the constraints from the project description
   *     also remember these are *COMPREHENSIVE* not EXHAUSTIVE tests
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests &mdash;
   *     remember you are trying to BREAK your code, not just prove it works!
   */
   public static void main( String args[] ) {
      System.out.println( "\nCLOCK CLASS TESTER PROGRAM\n" +
                          "--------------------------\n" );
      System.out.println( "  Creating a new clock: " );
      Clock clock = new Clock();
      System.out.println( "    New clock created: " + clock.toString() );
      System.out.println( "\n    Testing validateAngleArg()....");
      System.out.print( "      sending '  0 degrees', expecting double value   0.0" );
      try { System.out.println( (0.0 == clock.validateAngleArg( "0.0" )) ? " - got   0.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending ' 30 degrees', expecting double value  30.0" );
      try { System.out.println( (30.0 == clock.validateAngleArg( "30.0" )) ? " - got  30.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending ' 60 degrees', expecting double value  60.0" );
      try { System.out.println( (60.0 == clock.validateAngleArg( "60.0" )) ? " - got  60.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending ' 90 degrees', expecting double value  90.0" );
      try { System.out.println( (90.0 == clock.validateAngleArg( "90.0" )) ? " - got  90.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '120 degrees', expecting double value 120.0" );
      try { System.out.println( (120.0 == clock.validateAngleArg( "120.0" )) ? " - got 120.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '150 degrees', expecting double value 150.0" );
      try { System.out.println( (150.0 == clock.validateAngleArg( "150.0" )) ? " - got 150.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '180 degrees', expecting double value 180.0" );
      try { System.out.println( (180.0 == clock.validateAngleArg( "180.0" )) ? " - got 180.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '270 degrees', expecting double value 270.0" );
      try { System.out.println( (270.0 == clock.validateAngleArg( "270.0" )) ? " - got 270.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '359.999999 degrees', expecting double value 359.999999" );
      try { System.out.println( (359.999999 == clock.validateAngleArg( "359.999999" )) ? " - got 359.999999" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '-10 degrees', expecting IllegalArgumentException" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "-10.0" )) ? " - got INVALID_ARGUMENT_VALUE" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending 'ABC degrees', expecting NumberFormatException" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "ABC" )) ? " - got exception" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '360 degrees', expecting IllegalArgumentException" );
      try { System.out.println( (360.0 == clock.validateAngleArg( "390.0" )) ? " - got 390.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '390 degrees', expecting IllegalArgumentException" );
      try { System.out.println( (390.0 == clock.validateAngleArg( "390.0" )) ? " - got 390.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "\n    Testing validateTimeSliceArg()....");
      System.out.print( "      sending '   0.0 seconds', expecting IllegalArgumentException" );
      try { System.out.println( (0.0 == clock.validateTimeSliceArg( "0.0" )) ? " - got exception" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '  10.0 seconds', expecting double value   10.0" );
      try { System.out.println( (10.0 == clock.validateTimeSliceArg( "10.0" )) ? " - got   10.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '  30.0 seconds', expecting double value   30.0" );
      try { System.out.println( (30.0 == clock.validateTimeSliceArg( "30.0" )) ? " - got   30.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '   ABC seconds', expecting NumberFormatException" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "ABC" )) ? " - got exception" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '  90.0 seconds', expecting double value   90.0" );
      try { System.out.println( (90.0 == clock.validateTimeSliceArg( "90.0" )) ? " - got   90.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending ' 500.0 seconds', expecting double value  500.0" );
      try { System.out.println( (500.0 == clock.validateTimeSliceArg( "500.0" )) ? " - got  500.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '1000.0 seconds', expecting double value 1000.0" );
      try { System.out.println( (1000.0 == clock.validateTimeSliceArg( "1000.0" )) ? " - got 1000.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '1800.0 seconds', expecting double value 1800.0" );
      try { System.out.println( (1800.0 == clock.validateTimeSliceArg( "1800.0" )) ? " - got 1800.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.print( "      sending '1805.0 seconds', expecting IllegalArgumentException" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "1805.0" )) ? " - got INVALID_ARGUMENT_VALUE" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "\n    Testing toString()....");
      System.out.print( "      expecting string with zeros for all hours, minutes, and seconds values" );
      System.out.println( clock.toString() );
      try { System.out.println( (clock.toString().equals("   00 : 00 : 00.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "\n    Testing tick(), time slice is 10.0 seconds....");
      double timeSlice = 10.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and minutes, and 10.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 00 : 10.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and minutes, and 20.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 00 : 20.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and minutes, and 30.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 00 : 30.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and seconds, and 1.0 minutes values" );
      try { System.out.println( (clock.toString().equals("   00 : 01 : 00.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and seconds, and 2.0 minutes values" );
      try { System.out.println( (clock.toString().equals("   00 : 02 : 00.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 100.0 seconds....");
      timeSlice = 100.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours, 3.0 minutes, and 40.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 03 : 40.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours, 5.0 minutes, and 20.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 05 : 20.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 7 minutes
      System.out.print( "      expecting string with 0.0 for hours, 7.0 minutes, and 0.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 07 : 00.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  8:40
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 10:20
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 12:00
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 13:40
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 15:20
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 17:00
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 18:40
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 20:20
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 22:00
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 23:40
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 25:20
      System.out.print( "      expecting string with 0.0 for hours, 25.0 minutes, and 20.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 25 : 20.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 1507.0 seconds....");
      timeSlice = 1507.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 50:27
      System.out.print( "      expecting string with 0.0 for hours, 50.0 minutes, and 27.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   00 : 50 : 27.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 1:15:34
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 1:40:41
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 2:05 48
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 2:30:55
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 2:56:02
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 3:21:09
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 3:46:16
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 4:11:23
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 4:36:30
      System.out.print( "      expecting string with 4.0 for hours, 36.0 minutes, and 30.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   04 : 36 : 30.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 1789.0 seconds....");
      timeSlice = 1789.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 5:06:19
      System.out.print( "      expecting string with 5.0 for hours, 6.0 minutes, and 19.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   05 : 06 : 19.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 5:36:08
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.000 seconds values" );
      try { System.out.println( (clock.toString().equals("   06 : 05 : 57.000")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 0.123 seconds....");
      timeSlice = 0.123;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.1230
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.123 seconds values" );
      try { System.out.println( (clock.toString().equals("   06 : 05 : 57.123")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.2460
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.3690
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.369 seconds values" );
      try { System.out.println( (clock.toString().equals("   06 : 05 : 57.369")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.4920
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.6150
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.7380
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.8610
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.9840
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:58.1070
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 58.107 seconds values" );
      try { System.out.println( (clock.toString().equals("   06 : 05 : 58.107")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "\n    Testing getHourHandAngle() for current time 06:05:58.107....");
      System.out.print( "      expecting double angle value of approximately 183.131" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHourHandAngle() - 183.131))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "\n    Testing getMinuteHandAngle() for current time 06:05:58.107....");
      System.out.print( "      expecting double angle value of approximately 35.811" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getMinuteHandAngle() - 35.811))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "\n    Testing getHandAngle() for current time 06:05:58.107....");
      System.out.print( "      expecting double angle value of approximately 147.321 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 147.321))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      System.out.println( "\n    Continue testing getHandAngle(), time slice is 1800.0 seconds, new time....");
      timeSlice = 1800.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:35:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.print( "      expecting string with 6.0 for hours, 35.0 minutes, and 58.107 seconds values" );
      try { System.out.println( (clock.toString().equals("   06 : 35 : 58.107")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 17.668 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 17.668))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 7:05:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.print( "      expecting string with 7.0 for hours, 5.0 minutes, and 58.107 seconds values" );
      try { System.out.println( (clock.toString().equals("   07 : 05 : 58.107")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 177.344 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 177.344))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 7:35:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.print( "      expecting string with 7.0 for hours, 35.0 minutes, and 58.107 seconds values" );
      try { System.out.println( (clock.toString().equals("   07 : 35 : 58.107")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 12.356 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 12.356))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  8:05:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  8:35:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  9:05:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  9:35:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 10:05:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.println( "        getHandAngle returns: " + clock.getHandAngle() );
      System.out.print( "      expecting string with 10.0 for hours, 5.0 minutes, and 58.107 seconds values" );
      try { System.out.println( (clock.toString().equals("   10 : 05 : 58.107")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 92.584 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 92.584))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n            " + e.toString() ); }

     System.exit( 0 );
   }
}
