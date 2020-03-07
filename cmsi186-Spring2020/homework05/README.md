
# CMSI 186: Homework Assignment #5
## Problems About Estimations
### Assignment Due: Wednesday, 2020-03-18

<blockquote>
Learning Outcomes: Students will (1) learn how to describe, explain, and use superclasses and subclasses in Java; (2) explain the mathematical notion of a function and its implementation; and (3) learn how to use looping constructs to subdivide a problem space.
</blockquote>

This assignment concerns a method of using randomized estimation to determine an area of a non-rectangular object. For this assignment you will make a program to calculate the amount of plywood required to construct a skateboard ramp, as discussed in class.

Make <code>SkateRamp.java</code>, which computes the area of the supports for the skateboard "half-pipe" as shown in [this picture](http://bjohnson.lmu.build/private/skateramp.jpg). Your program must be able to handle a description of the shape of the halfpipe using polynomials of arbitary degree, as well as trigonometric and other functions [log, exponential, etc.]. If the program is invoked incorrectly, it should, as usual, output a clear message to tell the user the proper way to run the program. Your program will be invoked as follows:

     <code>java SkateRamp args[0] args[1] args[2] … args[k-1] args[k] lowerBound upperBound percent%</code>
     
where <code>args[0]</code> is the name of a function type; <code>args[1] … args[k]</code> specify the coefficients of the x0 … xk terms of the polynomial; <code>lowerBound</code> and <code>upperBound</code> specify the lower and upper bounds of x, i.e., the range of the X-values that will be used for evaluating; and finally <code>percent%</code> indicates when the program should halt – specifically, the program should halt when two successive approximations are within <code>percent</code> percent of one another.
[NOTE: the "%" at the end is required; the value will be expressed as a number with the "%" at the end, i.e., "2.3%".]

The following additional conditions apply:

1. You must make program SkateRamp.Java, which can integrate various functions that are "built in" to your program. Here are some examples of how it might be invoked:

    <code>java SkateRamp poly 1.0 -2.1 3.2 -10.0 +5.0</code><br />
    [calculates a ramp using the polynomial 1.0 - 2.1x + 3.2x2 from x = -10. to x = 5.0]<br />
    <code>java SkateRamp poly 1.0 -2.1 3.2 -10.0 +5.0 1.0%</code><br />
    [calculates a ramp using the polynomial 1.0 - 2.1x + 3.2x2 from x = -10. to x = 5.0,<br />
    stopping when successive values are within 1% of each other.]<br />
    <code>java SkateRamp poly 0.0 8.0 -2.0 1.0 4.0 1e-6%</code><br />
    [calculates a ramp using the polynomial 8x - 2x2 from x = 1.0 to x = 4.0,<br />
    stopping when successive values are within 1*10^6% of each other.]<br />
    <code>java SkateRamp sin -0.27 +3.55</code><br />
    [calculates a ramp using the sin function from x = -0.27 to x = +3.55]<br />
    <code>java SkateRamp log 1.1 2.3</code><br />
    [calculates a ramp using the (natural) log function from x = 1.1 to x = 2.3]<br />
    <code>java SkateRamp exp 2.0 3.5</code><br />
    [calculates a ramp using the function ex from x = 2.0 to x = 3.5]<br />
    <code>java SkateRamp sqrt 1.0 2.0</code><br />
    [calculates a ramp using the function sqrt(x) from x = -1.0 to x = 2.0]

1. In general, the program will be invoked like this:

    <code>java SkateRamp functionName additionalDescriptors</code>

1. Note that some functions [e.g., polynomials] need the additional descriptors [for their coefficients], while other functions [like sin and sqrt] do not necessarily require them.
1. If the program is invoked incorrectly, it must output a clear, detailed message that explains precisely how to use it.
1. You may, if you wish, use a single file for this program; however, there are ample opportunities for using other classes as we've seen in previous assignments.
1. As always, a comprehensive set of tests should be written before you start coding the other key method(s). Since you need a main() method to run your program, put the tests in another method, e.g., <code>private static void runMyTests()</code>, and design your program so that <code>Java SkateRamp runtests</code> runs the tests.
1. Try to implement as many interesting functions as possible, including:
   * <code>polynomials</code> of at least degree 2 [you MUST start with this]
   * <code>polynomials</code> of arbitrary degree [which you may as well do when you have the first part working]
   * the <code>sin</code> function [you MUST implement this as well]
   * other trig functions like <code>cos</code>, <code>tan</code>
   * <code>log</code> and <code>exponentiation</code> functions
   * some composite functions, e.g., <code>sqrt (1 + cos(x) )</code> or <code>cos(x)cos(2x)</code>. Make sure that your lab report clearly explains how these should be invoked.


Notes:

1. The field size will be 1000 feet by 1000 feet. Note that this means the location specifications are in feet, and are ±500 feet in both the X and Y directions. 
1. The pole must be located on the field somewhere, but it's up to you as to where. It can be at a random location, a fixed location, and may have any dimensions you like, from a point up to the size of a ball [radius 4.45 inches].
1. Making the pole a point means you have to have a separate collision detection loop for the pole.

Submission Guidelines: Make a sub-directory in your repository as mentioned above, called "homework04" and commit your source code into it. DON'T FORGET TO ADD A COMMIT COMMENT!""
