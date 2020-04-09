# CMSI 186: Homework Assignment #7
## More Problems About Estimation
### Assignment Due: Monday, 2019-04-20

<blockquote>
Learning Outcomes: Students will (1) implement probability calculation which solves a well-known problem; (2) be able to write their own test framework code from scratch; (3) get a chance to think analytically about a problem and use their program to verify their thinking; and (4) get practice documenting their code using the <q>javadocs</q> tool. 
</blockquote>

#### For this homework, you must accomplish the following activities:

Make a Java program, <em><code>BirthdaySolver.java</code></em>, for estimating the probability that among <code>N</code> randomly chosen people, at least two share a birthday.
* The value of <code><em>N</em></code> will be specified as a command line argument
* You should ignore birthdays that fall on February 29, e.g., assume that they have been uniformly distributed among the other 365 days of the year
* Solve this problem analytically in your head, as well as programmatically &ndash; and make sure that your program and your analysis confirm one another!
* Your program should be able to simulate one million experiments or more, and provide feedback to the user if it is taking a long time.  The number of experiments will be specified as a second command line argument, with a default value of 100,000.
* Make sure that you handle any errors that arise from user input, as usual.  NOTE: my test script will check for input errors that your code should catch!
* You are free to write as few or as many extra methods as you see fit
* Your program must output TWO NUMBERS:
   * the actual probability calculation as described in class
   * the approximation made using the number of experiments
* Create a <q>test harness</q> batch file or shell script that will run your program at least 20 times, with varying values for <code>N</code> and <code>number of experiments</code> and output the results to a <q>testresults.txt</q> file using the redirection operator from the command line ["<code>&gt;&gt;</code>"].
* Write a short research report that explains, in one paragraph, how your mental analysis of the problem helped you develop your program.
* Use the <q>javadocs</p> tool to produce a set of documentation for this project; make sure there are no errors when you run the tool on your program code.

You will submit your program, your testresults.txt file, your test harness script, and your research report as the products for this assignment.

### Notes:
1. No notes for this assignment at this time.

Submission Guidelines: Make a sub-directory in your repository as mentioned above, called homework07 and commit your source code into it. DON'T FORGET TO ADD A COMMIT COMMENT!

