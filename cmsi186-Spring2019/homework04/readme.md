
# CMSI 186: Homework Assignment #4
## Problems About Soccer Balls [Discrete Simulations]
### Assignment Due: Monday,<br />2019-03-18 for section 05;<br />Tuesday, 2019-03-19 for section 03

<strong>This is a two-part assignment</strong>. In this second part of the assignment, you will program a discrete simulation of a physical system in order to answer some questions about its behavior. For this homework, accomplish the following activities to make a Java program, <code>SoccerSim</code>, that solves the following problem:

Simultaneously, on a perfectly flat playground, at time 00:00:00.0 (hrs:mins:secs), an arbitrary number of soccer balls are kicked, all at different speeds and directions. We wish to find out, via a discrete simulation of the system, whether a collision will ever take place, and, if so, where and when. Each ball has a radius of 4.45 inches and weighs one pound. The center of the playground is presumed to be the point (x,y) = (0.0,0.0). The following additional conditions apply:

1. Friction acts to slow each ball down until it comes to rest. Your program should simulate friction as a force that continuously decreases each ball's speed at the rate of one per cent per second until it is traveling less than one inch per second, at which point it comes to rest.
1. Data about each ball will be given to your program via four consecutive args, namely the x- and y-coordinates of the ball's starting position [measured in feet], followed by its speeds in the x- and y-directions [in feet per second].
1. If present, a final arg specifies the time slice [in seconds]. If missing, your program should use a default time slice of one second.
1. There must be a pole, a stationary object somewhere on the field.
1. As always, your program should check validity of the args.
1. Your program should output:<br />
   * An initial report that gives the locations of all objects, including the initial velocity of each ball<br />
   * After every time slice, a report showing the location and velocity of every ball<br />
   * A final report indicating the simulated time of the first collision, the objects involved and their locations; OR, the message NO COLLISION IS POSSIBLE, giving the simulated time at which the program made that discovery.
1. A typical invocation of your program might look like this:

    <code>java SoccerSim 300 300 -1 -2 5 10 3 6 10.0</code>

    which indicates one ball initially at (300, 300), moving at the rate of one foot west and two feet south per second; just one other ball initially at (5, 10), moving at the rate of three feet east and six feet north per second; with the simulation to be driven by a ten-second time slice.
1. As in Part One, <code>ClockSolver</code> there will be some natural opportunities for using Java objects. For example, you will probably want to reuse some portion of your Clock class, along with a new public class Ball.
1. Although you may not collaborate with classmates about the code itself, you are encouraged to add to the construction of test cases for the simulation.
1. You can compare your program's results with Dr. Dorin's Simulation — just download "Ball.class" and "Timer.class" and "SoccerSim.class", then run SoccerSim in the usual way.

Notes:

1. The field size can be anything you want, big or small, in feet or light years, with the stipulation that it must be big enough so that placing a random number of balls at the start doesn't cause the simulation to immediately end.
1. The pole must be located on the field somewhere, but it's up to you as to where. It can be at a random location, a fixed location, and may have any dimensions you like, from a point up to the size of a ball [radius 4.45 inches].

Submission Guidelines: Make a sub-directory in your repository as mentioned above, called "homework04" and commit your source code into it. DON'T FORGET TO ADD A COMMIT COMMENT!""
