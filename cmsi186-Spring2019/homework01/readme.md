# CMSI 186: Homework Assignment #1
## Problems About Calendars and Dates [Familiarity with Java]

### You need to construct two classes for this assignment…

One class must be named **_CalendarStuff.java_** and the other must be named **_CountTheDays.java_**. There is a test harness, called **_CalendarStuffTester_.java**, along with an empty **_CalendarStuff.java_** template file located in my repo for homework01.  There are also several files in that folder which show you how to do things like get command line arguments and do some logical and computational operations.

### For this homework, accomplish at a minimum the following activities:

1. Make method **_public static boolean isLeapYear( long year )_**, which returns returns true if and only if [iff] the specified year is a Leap Year.  Make sure that you understand the definition for Leap Year!
2. Make method **_public static long daysInMonth( long month, long year )_**, which returns the number of days in the specified month.
3. Make method **_public static boolean isValidDate( long month, long day, long year )_**, which returns true iff the arguments constitute a valid date. [Some examples of invalid dates are 0/15/2010, 1/-5/2012, 2/29/1700, 3/32/2001, 4/31/2014, 5/1/-2000, 16/16/2009, dog/cat/fish, etc.]
4. Make method **_public static long daysBetween( long month0, long day0, long year0, long month1, long day1, long year1 )_**, which returns the absolute number of days between the two given dates. For example:

"daysBetween( 3, 1, 2000, 3, 1, 1999)" should return 366, and

"daysBetween( 3, 2, 1999, 5, 1, 2001)" should return 791

5. Make a complete program, **_CountTheDays_**, int its own class file which outputs the absolute number of days between two given dates. The dates will be specified via args[0] through args[5]. [As before, the order of the two dates is irrelevant.] This program will certainly make use of most, if not all, of the preceding methods.

###Notes:
1. In item 4, the order in which the dates are specified is irrelevant, but the order of the parts of the dates is specific and must be month first, day second, and year last.
2. The program in item 5 will be contained in its own class file called **_CountTheDays.java_**.
3. Submission Guidelines: Make a sub-directory in your repository as mentioned above, called homework01 and commit your source code into it. DON'T FORGET TO ADD A COMMIT COMMENT! You can commit as many times as you want, so commit early and commit often…
4. You should also make several other methods which will help do the operations you need for the methods listed.  Check the template code to see what is there and fill in **ALL** the methods there.
