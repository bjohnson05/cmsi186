/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *  File name     :  Clock.java
 *  Purpose       :  Provides a class defining methods for the ClockSolver class
 *  @author       :  B.J. Johnson
 *  Date written  :  2017-02-28
 *  Description   :  This class provides a bunch of methods which may be useful for the ClockSolver class
 *                   for Homework 4, part 1.  Includes the following:
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
 * @ version 2.0.0  2018-03-20  B.J. Johnson  Update to new slightly less complicated version
 *                                              expanded test count somewhat, tweaked test values a bit
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
   private static final double MAXIMUM_TIMESLICE_VALUE = 1800.0;
   private static final double HOUR_HAND_DEGREES_PER_SECOND = 0.00834;
   private static final double MINUTE_HAND_DEGREES_PER_SECOND = 0.1;

  // private fields
   private double[] timeJunque = new double[3];       // [0] = seconds, [1] = minutes, [2] = hours
   private static double totalSeconds = 0.0;
   private static double hourHandDegrees = 0.0;
   private static double minuteHandDegrees = 0.0;

  /**
   *  Constructor
   *   Not really anything to do here, so just call the "super()"  which is "Object"
   */
   public Clock() {
      super();
   }

  /**
   *  Method to calculate the next tick from the time increment
   *   each "tick" will be the number of seconds in the time slice
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
      return timeJunque;
   }

  /**
   *  Method to validate the angle argument
   *  @param   argValue  String from the main programs args[0] input
   *  @return  double-precision value of the argument
   *  @throws  NumberFormatException
   */
   public double validateAngleArg( String argValue ) throws NumberFormatException, IllegalArgumentException {
      double returnValue = 0;
      try {
         returnValue = Double.parseDouble( argValue );
      }
      catch( NumberFormatException nfe ) {
         throw new NumberFormatException( " [degree value not a number]");
      }
      if( 0.0 > returnValue ) {
         throw new IllegalArgumentException( " [degree value out of range]" );
      }
      if( MAXIMUM_DEGREE_VALUE <= returnValue ) {
         throw new IllegalArgumentException( " [degree value out of range]" );
      }
      return returnValue;
   }

  /**
   *  Method to validate the optional time slice argument
   *  @param  argValue  String from the main programs args[1] input
   *  @return double-precision value of the argument or -1.0 if invalid
   *  note: if the main program determines there IS no optional argument supplied,
   *         I have elected to have it substitute the string "60.0" and call this
   *         method anyhow.  That makes the main program code more uniform, but
   *         this is a DESIGN DECISION, not a requirement!
   *  note: remember that the time slice, if it is small will cause the simulation
   *         to take a VERY LONG TIME to complete!
   */
   public double validateTimeSliceArg( String argValue ) throws NumberFormatException {
      double returnValue = 0;
      try {
         returnValue = Double.parseDouble( argValue );
      }
      catch( NumberFormatException nfe ) {
         throw new NumberFormatException( " [time slice value not a number]");
      }
      if( 0.0 >= returnValue ) {
         throw new IllegalArgumentException( " [time slice value out of range] " );
      }
      if( MAXIMUM_TIMESLICE_VALUE < returnValue ) {
         throw new IllegalArgumentException( " [time slice value out of range] " );
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

   public String toString() {
      DecimalFormat df = new DecimalFormat( "#0.0000" );
      return "   " + timeJunque[2] + " hours, " + timeJunque[1] + " minutes, " + df.format(timeJunque[0]) + " seconds";
   }

   public String toStringColons() {
      DecimalFormat df  = new DecimalFormat( "00.0000" );
      DecimalFormat dfi = new DecimalFormat( "00" );
      return dfi.format(timeJunque[2]) + ":" + dfi.format(timeJunque[1]) + ":" + df.format(timeJunque[0]);
   }

  /**
   *  The main program starts here
   *  remember the constraints from the project description
   *  @see  http://bjohnson.lmu.build/cmsi186web/homework04.html
   *  be sure to make LOTS of tests!!
   *  remember you are trying to BREAK your code, not just prove it works!
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
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending ' 30 degrees', expecting double value  30.0" );
      try { System.out.println( (30.0 == clock.validateAngleArg( "30.0" )) ? " - got  30.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending ' 60 degrees', expecting double value  60.0" );
      try { System.out.println( (60.0 == clock.validateAngleArg( "60.0" )) ? " - got  60.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending ' 90 degrees', expecting double value  90.0" );
      try { System.out.println( (90.0 == clock.validateAngleArg( "90.0" )) ? " - got  90.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '120 degrees', expecting double value 120.0" );
      try { System.out.println( (120.0 == clock.validateAngleArg( "120.0" )) ? " - got 120.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '150 degrees', expecting double value 150.0" );
      try { System.out.println( (150.0 == clock.validateAngleArg( "150.0" )) ? " - got 150.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '180 degrees', expecting double value 180.0" );
      try { System.out.println( (180.0 == clock.validateAngleArg( "180.0" )) ? " - got 180.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '270 degrees', expecting double value 270.0" );
      try { System.out.println( (270.0 == clock.validateAngleArg( "270.0" )) ? " - got 270.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '360 degrees', expecting double value 360.0" );
      try { System.out.println( (360.0 == clock.validateAngleArg( "360.0" )) ? " - got 360.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '-10 degrees', expecting INVALID_ARGUMENT_VALUE" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "-10.0" )) ? " - got INVALID_ARGUMENT_VALUE" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending 'ABC degrees', expecting NumberFormatException" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateAngleArg( "ABC" )) ? " - got exception" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '390 degrees', expecting double value 390.0" );
      try { System.out.println( (390.0 == clock.validateAngleArg( "390.0" )) ? " - got 390.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.println( "\n    Testing validateTimeSliceArg()....");
      System.out.print( "      sending '   0.0 seconds', expecting INVALID_ARGUMENT_VALUE" );
      try { System.out.println( (0.0 == clock.validateTimeSliceArg( "0.0" )) ? " - got exception" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '  10.0 seconds', expecting double value   10.0" );
      try { System.out.println( (10.0 == clock.validateTimeSliceArg( "10.0" )) ? " - got   10.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '  30.0 seconds', expecting double value   30.0" );
      try { System.out.println( (30.0 == clock.validateTimeSliceArg( "30.0" )) ? " - got   30.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '   ABC seconds', expecting NumberFormatException" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "ABC" )) ? " - got exception" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '  90.0 seconds', expecting double value   90.0" );
      try { System.out.println( (90.0 == clock.validateTimeSliceArg( "90.0" )) ? " - got   90.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending ' 500.0 seconds', expecting double value  500.0" );
      try { System.out.println( (500.0 == clock.validateTimeSliceArg( "500.0" )) ? " - got  500.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '1000.0 seconds', expecting double value 1000.0" );
      try { System.out.println( (1000.0 == clock.validateTimeSliceArg( "1000.0" )) ? " - got 1000.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '1800.0 seconds', expecting double value 1800.0" );
      try { System.out.println( (1800.0 == clock.validateTimeSliceArg( "1800.0" )) ? " - got 1800.0" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.print( "      sending '1805.0 seconds', expecting INVALID_ARGUMENT_VALUE" );
      try { System.out.println( (INVALID_ARGUMENT_VALUE == clock.validateTimeSliceArg( "1805.0" )) ? " - got exception" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t " + e.toString() ); }

      System.out.println( "\n    Testing toString()....");
      System.out.print( "      expecting string with 0.0 for all hours, minutes, and seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 0.0 minutes, 0.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "\n    Testing tick(), time slice is 10.0 seconds....");
      double timeSlice = 10.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and minutes, and 10.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 0.0 minutes, 10.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and minutes, and 20.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 0.0 minutes, 20.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and minutes, and 30.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 0.0 minutes, 30.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and seconds, and 1.0 minutes values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 1.0 minutes, 0.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours and seconds, and 2.0 minutes values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 2.0 minutes, 0.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 100.0 seconds....");
      timeSlice = 100.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours, 3.0 minutes, and 40.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 3.0 minutes, 40.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );
      System.out.print( "      expecting string with 0.0 for hours, 5.0 minutes, and 20.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 5.0 minutes, 20.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 7 minutes
      System.out.print( "      expecting string with 0.0 for hours, 7.0 minutes, and 0.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 7.0 minutes, 0.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

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
      System.out.print( "      expecting string with 0.0 for hours, 25.0 minutes, and 20.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 25.0 minutes, 20.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 1507.0 seconds....");
      timeSlice = 1507.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 50:27
      System.out.print( "      expecting string with 0.0 for hours, 50.0 minutes, and 27.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   0.0 hours, 50.0 minutes, 27.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 1:15:34
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 1:40:41
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 2:05 48
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 2:30:55
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 2:56:02
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 3:21:09
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 3:46:16
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 4:11:23
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 4:36:30
      System.out.print( "      expecting string with 4.0 for hours, 36.0 minutes, and 30.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   4.0 hours, 36.0 minutes, 30.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 1789.0 seconds....");
      timeSlice = 1789.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 5:06:19
      System.out.print( "      expecting string with 5.0 for hours, 6.0 minutes, and 19.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   5.0 hours, 6.0 minutes, 19.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 5:36:08
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.0000 seconds values" );
      try { System.out.println( (clock.toString().equals("   6.0 hours, 5.0 minutes, 57.0000 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "    Continue testing tick(), time slice is 0.123 seconds....");
      timeSlice = 0.123;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.1230
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.1230 seconds values" );
      try { System.out.println( (clock.toString().equals("   6.0 hours, 5.0 minutes, 57.1230 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.2460
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.3690
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 57.3690 seconds values" );
      try { System.out.println( (clock.toString().equals("   6.0 hours, 5.0 minutes, 57.3690 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.4920
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.6150
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.7380
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.8610
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:57.9840
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:05:58.1070
      System.out.print( "      expecting string with 6.0 for hours, 5.0 minutes, and 58.1070 seconds values" );
      try { System.out.println( (clock.toString().equals("   6.0 hours, 5.0 minutes, 58.1070 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "\n    Testing getHourHandAngle() for current time 06:05:57.1070....");
      System.out.print( "      expecting double angle value of approximately 183.131" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHourHandAngle() - 183.131))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "\n    Testing getMinuteHandAngle() for current time 06:05:57.1070....");
      System.out.print( "      expecting double angle value of approximately 35.811" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getMinuteHandAngle() - 35.811))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "\n    Testing getHandAngle() for current time 06:05:57.1070....");
      System.out.print( "      expecting double angle value of approximately 147.321 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 147.321))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      System.out.println( "\n    Continue testing getHandAngle(), time slice is 1800.0 seconds, new time....");
      timeSlice = 1800.0;
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 6:35:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.print( "      expecting string with 6.0 for hours, 35.0 minutes, and 58.1070 seconds values" );
      try { System.out.println( (clock.toString().equals("   6.0 hours, 35.0 minutes, 58.1070 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 17.668 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 17.668))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 7:05:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.print( "      expecting string with 7.0 for hours, 5.0 minutes, and 58.1070 seconds values" );
      try { System.out.println( (clock.toString().equals("   7.0 hours, 5.0 minutes, 58.1070 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 177.344 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 177.344))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 7:35:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.print( "      expecting string with 7.0 for hours, 35.0 minutes, and 58.1070 seconds values" );
      try { System.out.println( (clock.toString().equals("   7.0 hours, 35.0 minutes, 58.1070 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 12.356 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 12.356))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  8:05:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  8:35:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  9:05:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   //  9:35:58.1070
      clock.timeJunque = clock.tick( clock.timeJunque[0], clock.timeJunque[1], clock.timeJunque[2], timeSlice );   // 10:05:58.1070
      System.out.println( "        time now is: " + clock.toString() );
      System.out.println( "        getHourHandAngle returns: " + clock.getHourHandAngle() );
      System.out.println( "        getMinuteHandAngle returns: " + clock.getMinuteHandAngle() );
      System.out.println( "        getHandAngle returns: " + clock.getHandAngle() );
      System.out.print( "      expecting string with 10.0 for hours, 5.0 minutes, and 58.1070 seconds values" );
      try { System.out.println( (clock.toString().equals("   10.0 hours, 5.0 minutes, 58.1070 seconds")) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }
      System.out.print( "      expecting double angle value of approximately 92.584 degrees" );
      try { System.out.println( (0.1 >= (Math.abs(clock.getHandAngle() - 92.584))) ? " - got true" : " - no joy" ); }
      catch( Exception e ) { System.out.println ( " - Exception thrown:\n\t" + e.toString() ); }

     System.exit( 0 );
   }
}
