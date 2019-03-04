# CMSI 186: Homework Assignment #3
## Problems About Clocks and Time [Discrete Simulations]
### Assignment Due: Wednesday,<br />2019-02-27 for section 05;<br />Thursday, 2019-02-28 for section 03
**This is part one of a two-part assignment.** In this first part, you will program a discrete simulation of an analog clock in order to answer some questions about its behavior.  For this homework, accomplish the following activities to make a Java program, **_ClockSolver.java_**, that determines all times during a twelve-hour day at which the two hands of a clock form a given angle.  You will run your program in the following way:

   **_java ClockSolver &lt;angle-value&gt; [time-slice]_**

1. The value given by &lt;angle-value&gt; which is in args[0] will specify an angle, in degrees. Your program must correctly handle **non-negative reals** that are less than 360.0 degrees.
1. If present, the optional [time-slice] value in args[1] will specify a time slice, in seconds. Your program must correctly handle **positive reals** that are less than 1800.0 seconds. If absent, your program should use a default time slice of 60.0 seconds.
1. As always, your program must check validity of the arguments.
1. There will be some natural opportunities for using Java objects; in particular, you must construct a **_Clock_** class, including appropriate methods such as **_tick()_**, **_getMinutes()_**, **_toString()_**, etc.  Empty versions of these are provided in the template files.
1. Test your program on all sorts of inputs.  What happens as the time slice gets very small, e.g., 0.00001 seconds and 0.0625 seconds?  Apart from the increased running time of the program, do you notice anything funny about the outputs?  Can you explain this behavior?
1. You can compare your program's results with mine — just download **_Clock.class_** and **_ClockSolver.class_**, then run **_ClockSolver_** in the usual way.

### Notes:

1. None at this time

### Submission Guidelines:
Make a sub-directory in your repository as mentioned above, called **_homework03_** and commit your source code into it. DON'T FORGET TO ADD A COMMIT COMMENT!
