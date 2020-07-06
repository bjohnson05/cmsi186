# CMSI 186: Homework Assignment #2
## Problems About Estimation
### [Familiarity with Monte Carlo Simulations]
### Assignment Due: Tuesday, 2020-09-22

<blockquote>

<strong>Learning Outcomes</strong>: Students will (1) write scripts in the Java programming language with variables, assignments, if-statements, etc.; (2) employ random number generators in Java; (3) build Java programs with multiple methods; (4) use command line arguments in Java; (5) convert between strings and numbers in Java; (6) know when and how to check arguments to methods and throw IllegalArgumentException when necessary; (7) build programs against a test suite; and (8) understand a basic algorithm development process.

</blockquote>

#### For this homework, you must accomplish the following activities

Make a Java program, <em><code>PiSolver.java</code></em>, for estimating the value of PI using the basic approach and control structure discussed in class.  Specifically, your program should:
* throw lots of random darts at a circle of radius <q>1</q> inscribed within a square
* then determine the percentage of darts that fell within the circle
* finally use the formula that we derived to calculate an estimate for PI
* if present, args[0] will specify the number of darts to be thrown [default value = 1000]

### Notes:
1. Try several different values for the number of darts thrown
1. Try writing a command line <q>shell script</q> file to run the program many times and display the output of each run
1. Try repeating tests with the same number of darts to see if your program outputs consistent results
1. Investigate to see how the number of darts thrown affects the results; does your observed output make sense logically to you?

Submission Guidelines: Make a sub-directory in your repository as mentioned above called homework02, and commit your source code into it. DON'T FORGET TO ADD A COMMIT COMMENT!
