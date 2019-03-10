
# CMSI 186: Homework Assignment #7
## Problems About Money [Familiarity with Dynamic Programming]
### Assignment Due:<br />Wednesday, 2019-05-08 for section 05<br />Thursday, 2019-05-09 for section 03

<strong>For this assignment</strong>:<br />
You will develop a Java program that solves the general problem of making change; specifically, you will make program <strong><code>DynamicChangeMaker</code></strong>, which takes as input arguments a sequence of coin denominations [distinct positive integers in no particular order], followed by an arbitrary amount of money [a non-negative integer], and which outputs the optimal way of making change for that amount using those denominations [optimal meaning the minimum number of coins], or if change cannot be made, outputs the message <em>IMPOSSIBLE</em>.

### For this homework, use the following ground rules to accomplish the activities:
1. Your program should implement the basic algorithm outlined in class for Dynamic Programming.
1. Assume there's an unlimited supply of each type of coin.
1. You may not assume anything about the ordering of the denominations; in particular, you may not assume that they are sorted.
1. There are no duplicate denominations allowed.
1. There might not be a one-cent coin!
1. In the event of a tie between minimal [optimal] solutions, any minimal solution will do.
1. Per our discussion in class, your program will have to make use of special objects called <em><code>tuples</code></em>. There is an implementation of that class to save you some implementation time on my GitHub repository.  I totally copied it from Former Professor Murphy, with his consent.  Feel free to download it and use it.
1. There is also a test harness for the <code>Tuple</code> class, called <em><code>TupleTestHarness.java</code></em> which provides tests for the <code>Tuple.java</code> class.  You should run this test harness at least a couple of times to see how it works.  Looking at the code in detail will also show you several things about testing philosophy that were explained in class.  Take the time to look it over.
1. Your program must reject bad data such as missing or malformed arguments, denomination values that are not positive, duplicated denominations, and negative amounts.
1. The class file <em><code>DynamicChangeMaker.java</code></em> is for you to write yourself.  You must follow all the good programming guidelines that have been discussed in class, such as good variable names, properly and consistently indenting code, commenting code, and so forth.
1. Your <em><code>DynamicChangeMaker.java</code></em> file <strong>MUST CONTAIN</strong> a method called <code>makeChangeWithDynamicProgramming()</code> that takes two arguments; an integer array of denominations, and an integer containing the target amount of cents.  <strong>YOU MUST USE THIS METHOD NAME!</strong> Failure to do so will cause there to be no evaluation for this assignment.
1. You must JavaDoc your code for this assignment.
1. You are responsible for putting in JavaDoc comments in this code. I will run JavaDocs against it as part of the evaluation process.  This is part of normal professional programming practice, so you may as well learn it now.  <q>If it ain't there, you ain't gettin' credit for it&hellip;</q>
1. I have written a test harness which you can use to check your code.  The test harness is also in my GitHub repository, and is called <code>DynamicChangemakerTestHarness.java</code>.  You should download a copy of this code and use it to test your DynamicChangeMaker code, because <em>I</em> will be using it to test your DynamicChangeMaker code.
1. As illustrated below, your program must reject bad data such as missing or malformed arguments, denominations that aren't positive, duplicated denominations, and negative amounts.  This is also part of good programming practice, checking your arguments and letting the user know when something is hinky.
1. <strong>OPTIONALLY</strong>: you may write your code for the DynamicChangeMaker class file to include a <code>main()</code> method that allows the program to be run with command line arguments.  Doing so can get you two points of extra credit for the assignment.

### Here are some examples to get you started and give you an idea of expected inputs/outputs:
* <code>java DynamicChangeMaker 8,13,4,9 14</code> should output <q>IMPOSSIBLE</q> because you can't make 14 cents with the denominations given.
* <code>java DynamicChangeMaker 3,1,9,8 14</code> should output:<br />
    14 cents can be made with 3 coins as follows:<br />
      2 x 3 cent<br />
      0 x 1 cent<br />
      0 x 9 cent<br />
      1 x 8 cent<br />
      TOTAL 3 coins<br />
* <code>java DynamicChangeMaker 3</code> should output <q>BAD DATA</q> because there are not enough arguments.
* <code>java DynamicChangeMaker 3,12 -4</code> should output <q>BAD DATA</q> because the arguments contain a negative number
* <code>java DynamicChangeMaker 0,12,3 63</code> should output <q>BAD DATA</q> because the arguments contain a nonsensical denomination of zero
* <code>java DynamicChangeMaker 10,12,3,12 63</code> should output <q>BAD DATA</q> because there are two copies of the 12 cent coin

## Notes:
1. Instead of simply displaying BAD DATA you might consider displaying some meaninful error message that tells the user what is wrong with the input arguments.
1. If you did a version of this problem in Professor Johnson's CMSI 185 class, this is not the same problem! Yes, it is similar, but that problem was focused on just coming up with a way to make change, NOT NECESSARILY the OPTIMAL solution of the minimum number of coins.
1. PLEASE follow all guidelines as to file names and method names for this assignment. This request is made to ensure that standard baseline tests can be run on your work, so that everyone gets evaluated based on the same metrics. If you do not submit the properly named files, you will get a zero on this assignment!
1. Remember that the real focus of this assignment is the Dynamic Programming Algorithm, NOT the fact that we are making change. There are any number of ways to make optimal change given a set of amounts. This is one of them.
1. Submission Guidelines: Make a sub-directory in your repository as mentioned above, called homework07 and commit your source code into it.  DON'T FORGET TO ADD A COMMIT COMMENT!
