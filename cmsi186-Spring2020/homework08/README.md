# CMSI 186: Homework Assignment #
## Problems About Space and Time Translation
### Assignment Due: Monday, 2020-05-04

<blockquote>
Learning Outcomes: Students will (1) get practice with converting decimal numbers to String objects that represent binary values; (2) learn to use Java to perform File I/O; (3) get more practice documenting their code using the <q>javadocs</q> tool; (4) get more practice creating test script files [either batch files or shell scripts] to test their code; and (5) end the semester with a positive win on their programming skills.
</blockquote>

#### For this homework, you must accomplish the following activities:

For this assignment, there are *TWO* problems, since these are a bit easier. <em>Don't forget to Javadoc your code&hellip;

### The Problem #1:
Two circles may intersect at a single point, at two points, or at an unlimited number of points when the two circles are coincident (on top of each other).  If the circles do NOT intersect, on circle may be contained entirely within the other, or they may be completely separate.  Your task is to write a program in Java that obtains the parameters for two circles and reports whether they intersect.  For each circle, the inputs should be the X and Y coordinate (on a Cartesian grid) for the center, and the radius of the circle.  The output should be one and only one of the possible configurations listed above, as well as the distance between the two center points.

1. Make a Java program, <code>CirclekSolver.java</code>, that determines if two circles intersect.  Your program must:
   1. Read the circle parameters from a file.</li>
   1. Each line in the file will give parameters for one circle.</li>
   1. File lines will be formatted with the X-coordinate, then the Y-coordinate, then the radius of the circle, IN THAT ORDER, separated by spaces
   1. Alternatively, you can make your program read one file and use each pair of lines as input to the program for two circles at a time.
   1. Your program must output the parameters for each circle pair that includes the X and Y value of the center and the radius of each circle.
   1. Your program must output whether the circles intersect, and at how many points they meet.  If they meet at more than one point, just state that fact.
1. You must write a script file called <q>circletest.bat</q> [for windows] or <q>circletest.sh</q> [for mac] that runs your program 20 times with different circle file inputs.
1. You *MUST* have at least 1 of your 25 test cases check an invalid file name and output a meaningful error message when that occurs
1. You *MUST* have your script file write the results to a <q>testresults.txt</q> file as we've seen in the past

### The Problem #2:
The digital clock in my office has several rows of LED lights on it.  Some of you may have seen it on my bookshelves before the whole COVID-19 situation struck.  This problem is to write a program that will be a duplicate of sorts of that clock's operation.  The clock has three rows of LED's.  The top row is for hours, the middle row is for minutes, and the bottom row is for seconds.

1. Make a Java program, <code>BinaryClockSolver.java</code>, for displaying the time on a binary clock.  A <q>binary</q> clock displays the hours, minutes, and seconds in binary number format rather than in the decimal numbers we're used to seeing.  Specifically, your program must:

   1. Take in a decimal time string as argument from the command line
   1. The time string must be formatted as <q><code>HH:MM:SS</code></q> meaning a two-digit number of hours, followed by a colon, then a two-digit number of minutes and another colon, then a two-digit number of seconds.
   1. You will translate these numbers to binary and display them as a pattern of lights
   1. You may use a <q>star</q> [the asterisk character or shift+8 on the keyboard] as an indicator that a light is <q>ON</q>
   1. You may use a <q>lower-case o</q> as an indicator that a light is <q>OFF</q>
   1. Feel free to be creative with this, using the unicode characters for things; do some research and find out what some of them are and have fun putting them on your simulation.
   1. You may use other characters if you wish, as long as they are able to show the difference                          between ON and OFF
   1. Your program should output a blank line, followed by a row of lights for the hours, then a second line of lights for the minutes, then a third line of lights for the seconds, followed by another blank line.
   1. You *MUST* error check the input to make sure that no number is greater than or less than the allowed values for hours, minutes, or seconds.
1. You must write a script file called <q>clocktest.bat</q> [for windows] or <q>clocktest.sh</q> [for mac] that runs your program 25 times with different time inputs.
1. Make your clocktest script file send the output of your program to the <q>testresults.txt</q> file as before
1. You <em class='underline'>MUST</em> have at least 5 of your 25 test cases check invalid time strings and output a meaningful error message when invalid times are input.
1. Part of this problem is for you to do some research and find out if there is an easy way to turn the decimal numbers into String objects that represent the binary equivalents.

### Solution Submission
As always, commit your solutions to your repo.  For this assignment you will need at least seven files:
1. CircleSolver.java</li>
1. circletest.bat or circletest.sh test file</li>
1. ClockSolver.java</li>
1. clocktest.bat or clocktest.sh test file</li>
1. the circle definition file or files that you use with your CircleSolver program</li>
1. the two <q>testresults.txt</q> files that contain the test outputs.  Name them as you wish so you can tell them apart.
   
### Notes
1. No notes for this assignment at this time.
1. 

Submission Guidelines: Make a sub-directory in your repository as mentioned above, called <q>homework08<q> and commit your source code into it.  DON'T FORGET TO ADD A COMMIT COMMENT!</p>
