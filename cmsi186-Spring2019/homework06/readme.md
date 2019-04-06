
# CMSI 186: Homework Assignment #6
## Problems About Giant-sized Integer Numbers
### Assignment Due:<br />Wednesday, 2019-04-24 for section 05<br />Thursday, 2019-04-25 for section 03

## For this homework:
You will develop public class <strong>BrobdingnagianInt</strong>, whose objects model arbitrarily-large integers.  Basically, you are being asked to re-invent some of the material of <code>java.math.BigInteger</code> to accomplish the following activities.

### Ground Rules
1. You must implement your class from first principles; in particular, you may not make use of java.math.BigInteger or any related device, except for testing purposes if you want to check on the correctness of your test results for your <code>BrobdingnagianInt</code> class.
1. In the descriptions that follow, the word this refers to an instantiated object of your <code>BrobdingnagianInt</code> class.
1. It is recommended for testing purposes that you abbreviate <strong>BrobdingnagianInt</strong> as <strong>BrobInt</strong> which will be much easier to type.  You will be typing this over and over and over and over, so it is best if you get used to the shorter name from the start.
1. Although it can contain more methods [see java.math.BigInteger for more ideas], your class must include <strong>at least</strong> the following items:
    1. <code>public BrobInt( String value )</code><br />
// mimics one of the several java.math.BigInteger constructors<br />
    1. <code>public BrobInt add( BrobInt value )</code><br />
// returns a BrobInt whose value is the sum of this plus the argument<br />
    1. <code>public BrobInt subtract( BrobInt value )</code><br />
// returns a BrobInt whose value is the difference of this minus the argument<br />
    1. <code>public BrobInt multiply( BrobInt value )</code><br />
// returns a BrobInt whose value is the product of this times the argument<br />
    1. <code>public BrobInt divide( BrobInt value )</code><br />
// returns a BrobInt whose value is the quotient of this divided by the argument<br />
    1. <code>public BrobInt remainder( BrobInt value )</code><br />
// returns a BrobInt whose value is the remainder of this divided by the argument<br />
    1. <code>public String toString()</code><br />
// returns the decimal string represention of this BrobInt<br />
    1. <code>public int compareTo( BrobInt value )</code><br />
// returns -1/0/1 as this BrobInt is numerically less than/equal to/greater than the value passed as the argument<br />
    1. <code>public boolean equals( Object x )</code><br />
// returns true iff x is a BrobInt whose value is numerically equal to this BrobInt<br />
    1. <code>public static BrobInt valueOf( long value )</code><br />
// a BrobInt "static factory" for constructing BrobInt out of longs<br />
    1. <code>public static final BrobInt ZERO</code><br />
// a BrobInt classwide constant for zero<br />
    1. <code>public static final BrobInt ONE</code><br />
// a BrobInt classwide constant for one<br />
    1. <code>public static final BrobInt TEN</code><br />
// a BrobInt classwide constant for ten<br />
1. Following the programming practice known as Test Driven Development [TDD] you must first construct unit tests for the above items <em>before coding the methods themselves</em>.  Use the main() method of your class to invoke these unit tests. [In other words, the command <code>java BrobIntTester</code> will run your unit tests.]  Try using Java's <code>assert</code> statement in the tests you write; or even better, use <strong>JUnit</strong>.
1. Complete as many of the items as possible. All incomplete items must throw an exception; use <strong><code>UnsupportedOperationException</code></strong>.
1. For part two of this assignment, create program <strong>Collatz.java</strong> which takes in a number and determines the number of steps in the Collatz Sequence.  This is the sequence we saw in the CMSI 185 homework that takes an integer number as input, then generates a sequence of values based upon whether the current value is even or odd; if it is even, the value is divided by 2, and if it is odd, the value is multiplied by three then one is added to that result.  The program should output both the sequence and the number of steps.
## Notes and Suggestions:
1. <strong>Do not be fooled by appearances</strong>: this assignment is a lot more challenging than it looks. The good news is that for each operation, you already have detailed knowledge of some algorithm — although you will discover that expressing the algorithms in a computer programming language is a whole new can of worms!
1. <strong>There will be at least three Java files for this assignment</strong>:<br />
   1. The <code>BrobInt.java</code> file containing the methods listed above, as well as any other helper methods or extra things you may want to implement
   1. The <code>BrobIntTester.java</code> file containing your tests, which <em>may</em> end up in your main program of your BrobInt.java file, but it is highly recommended that this be a separate file
   1. The <code>Collatz.java</code> program file in which you implement your BrobInt to display a very large Collatz sequence and step number
1. <strong>There are alternatives</strong> to some of the time-honored algorithms, [e.g., Russian Peasant multiplication], which tend to be easier to program.  [This is especially true if you have taken CMSI 185 with Dr. Johnson.  You may even come to decide that they are easier to use in practice!]  Feel free to implement them, instead of the time-honored techniques.
1. Similarly, arithmetic is easier in some bases than others, e.g., binary vs. decimal.  You should consider this when you decide on an internal representation for your objects.
1. Feel free to create versions of your methods that can act recursively; possessing such facility can be a handy tool for all kinds of things involving repetitive calculations.
1. NEW: [Here](https://github.com/bjohnson05/cmsi186/blob/master/cmsi186-Spring2019/homework06/BrobIntTester.java) is a test program that you can use/adapt for your purposes.  Note that this program simply tests several of the methods in the class, it DOES NOT catch any exceptions thrown, so it will stop with the first un-implemented method test. You may want to modify this to allow the test program to continue and recover gracefully from those exceptions, more like what happens in the real world.  You have a model of this already in the Date and String assignments you did earlier in the semester.
1. Don't forget the three most important rules for software success:
    * Commit early and commit often
    * Test, test, and test again
    * Start assignments early, using an iterative approach to your development
1. If you do any searching for things on your own, feel free to share them with me and with each other, <strong>AS LONG AS THEY ARE ALGORITHMIC DESCRIPTIONS AND NOT YOUR ACTUAL CODE</strong>.
1. Submission Guidelines: Make a sub-directory in your repository as mentioned above, called homework06 and commit your source code into it. DON'T FORGET TO ADD A COMMIT COMMENT!
