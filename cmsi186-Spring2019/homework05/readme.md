
# CMSI 186: Homework Assignment #5
## Problems About Riemann Ingegration [Randomized Estimations]
### Assignment Due:<br />Monday, 2019-04-01 for section 05<br />Tuesday, 2019-04-02 for section 03

## For this homework, accomplish the following activities:
This assignment concerns a method of using <strong>randomized estimation</strong> to determine the area under a curve. For this assignment you will make programs for integrating polynomials, as discussed in class.

You will make the program <strong><code>Riemann.java</code></strong>, which computes definite integrals using Riemann integration. Your program must be able to handle polynomials of arbitary degree. If the program is invoked incorrectly, it should output a clear, appropriate error message along with a message to tell the user the proper way to run the program.

Your program will be invoked as follows:

java Riemann args[0] args[1] args[2] … args[k] &lt;lowerBound&gt; &lt;upperBound&gt; &lt;percentage&gt;

where args[0] is the name of a function type; args[1] … args[k] specify the coefficients of the x0 … xk terms of the polynomial; &lt;lowerBound&gt; and &lt;upperBound&gt; specify the lower and upper bounds of x, i.e., the range within which the integral should be evaluated; and finally &lt;percentage&gt; indicates when the program should halt – specifically, the program should halt when two successive approximations are within percent <q><code>percentage</code></q> of one another.

NOTE: there are NO OPTIONAL ARGUMENTS for this assignment.  All input to the program <strong>MUST COME FROM THE COMMAND LINE!</strong>

The following additional conditions apply:

1. You must make program Riemann.Java, which can integrate various functions that are built in to your program. Here are some examples of how it might be invoked:<br />
<code>java Riemann poly 1.0 -2.1 3.2 -10.0 +5.0</code> [integrates the polynomial 1.0 - 2.1x + 3.2x<sup>2</sup> from x = -10. to x = 5.0]<br />
<code>java Riemann poly 1.0 -2.1 3.2 -10.0 +5.0 1.0%</code> [integrates the polynomial 1.0 - 2.1x + 3.2x<sup>2</sup> from x = -10.0 to x = 5.0, stopping when successive values are within 1% of each other]<br />
<code>java Riemann poly 0.0 8.0 -2.0 1.0 4.0 1e-6%</code> [integrates the polynomial 8.0x - 2.0x<sup>2</sup> from x = 1.0 to x = 4.0, stopping when successive values are within 1*10<sup>-6</sup>% of each other]<br />
<code>java Riemann sin -0.27 +3.55</code> [integrates the sin function from x = -0.27 to x = +3.55]<br />
<code>java Riemann log 1.1 2.3</code> [integrates the (natural) log function from x = 1.1 to x = 2.3]<br />
<code>java Riemann exp 2.0 3.5</code> [integrates the function ex from x = 2.0 to x = 3.5]<br />
<code>java Riemann sqrt 1.0 2.0</code> [integrates the function sqrt(x) from x = -1.0 to x = 2.0]<br />

1. In general, the program will be invoked like this:<br />
<code>Java Riemann functionName additionalDescriptors lowerBound upperBound</code>

1. Note that some functions [e.g., polynomials] need the additional descriptors [for their coefficients], while other functions [like sin and sqrt] do not.
1. If the program is invoked incorrectly, it must output a clear, detailed message that explains precisely how to use it.
1. As always, a <strong>comprehensive set of tests</strong> should be written <em>before you start coding</em> the other key method(s). Since you need a main() method to run your program, put the tests in another method, e.g., private static void runMyTests(), and design your program so that the command line <code>Java Riemann</code> runtests runs the tests.
1. Try to implement as many interesting functions as possible, including:
   * polynomials of at least degree 2 [you MUST start with this]
   * polynomials of arbitrary degree [which you may as well do when you have the first part working]
   * the sin function [you must implement this as well]
   * trig functions like cos, tan;
   * log and exponentiation functions;
   * some composite functions, e.g., sqrt (1 + cos(x) ) or cos(x)cos(2x). Make sure that your lab report clearly explains how I am supposed to invoke these.
   
## Notes:

1. You MUST at a minimum be able to do the polynomial and sin integrations. Start with degree two, then use that as the starting point to get an arbitrary degree.
1. Once polynomials are working, add on the sin trigonometric function.  Then add on some of the others.  Don't worry, for these I won't go crazy with composite functions, just the regular ones will do. At a minimum, you MUST get integration of the sin function to work.
1. Anything else you are able to complete will provide you with one point of extra credit for this assignment. Yes, that means it is possible to get higher than 100% on this project.
**Submission Guidelines**: Make a sub-directory in your repository as mentioned above, called homework05 and commit your source code into it. <strong>DON'T FORGET TO ADD A COMMIT COMMENT!</strong>

