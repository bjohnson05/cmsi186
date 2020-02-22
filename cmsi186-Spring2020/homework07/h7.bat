
@echo "cleaning up for build....."
@del /Q *.class
@javac  *.java
@del testresults.txt

@echo "creating javadocs....."
@rmdir /Q /S docs
@mkdir docs
@copy  DynamicChangeMaker.java docs\.
@copy  DynamicChangemakerTestHarness.java docs\.
@copy  Tuple.java docs\.
@copy  TupleTestHarness.java docs\.
@pushd docs
@javadoc *.java
@popd
@start "C:\Program Files (x86)\Mozilla Firefox\firefox.exe" docs\index.html
@echo .

@echo "running test harnesses for evaluation....."
@echo "running TupleTestHarnesses for evaluation....."
@echo "running TupleTestHarnesses for evaluation....." >> testresults.txt
java TupleTestHarness >> testresults.txt
@echo .
@echo .
@echo . >> testresults.txt
@echo . >> testresults.txt
@echo "running DynamicChangemakerTestHarness for evaluation....."
@echo "running DynamicChangemakerTestHarness for evaluation....." >> testresults.txt
java DynamicChangemakerTestHarness >> testresults.txt

@echo .
@echo .
@echo .
@echo . >> testresults.txt
@echo . >> testresults.txt
@echo . >> testresults.txt
@echo "running standalone programs to test extra credit operations"
@echo "running standalone programs to test extra credit operations" >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 8,13,4,9 14"
@echo "running java DynamicChangeMaker 8,13,4,9 14" >> testresults.txt
java DynamicChangeMaker 8,13,4,9 14 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 2,3 5"
@echo "running java DynamicChangeMaker 2,3 5" >> testresults.txt
java DynamicChangeMaker 2,3 5 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 2,3,7,5,51,29,11 13579"
@echo "running java DynamicChangeMaker 2,3,7,5,51,29,11 13579" >> testresults.txt
java DynamicChangeMaker 2,3,7,5,51,29,11 13579 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 17,23,121,47,3 13579"
@echo "running java DynamicChangeMaker 17,23,121,47,3 13579" >> testresults.txt
java DynamicChangeMaker 17,23,121,47,3 13579 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 1,7,9 12"
@echo "running java DynamicChangeMaker 1,7,9 12" >> testresults.txt
java DynamicChangeMaker 1,7,9 12 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 11,13,17,19,23 1357911"
@echo "running java DynamicChangeMaker 11,13,17,19,23 1357911" >> testresults.txt
java DynamicChangeMaker 11,13,17,19,23 1357911 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 23,19,17,13,11 1357911"
@echo "running java DynamicChangeMaker 23,19,17,13,11 1357911" >> testresults.txt
java DynamicChangeMaker 23,19,17,13,11 1357911 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 3,1,9,8 14"
@echo "running java DynamicChangeMaker 3,1,9,8 14" >> testresults.txt
java DynamicChangeMaker 3,1,9,8 14 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 3"
@echo "running java DynamicChangeMaker 3" >> testresults.txt
java DynamicChangeMaker 3 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 3,12 -4"
@echo "running java DynamicChangeMaker 3,12 -4" >> testresults.txt
java DynamicChangeMaker 3,12 -4 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 0,12,3 63"
@echo "running java DynamicChangeMaker 0,12,3 63" >> testresults.txt
java DynamicChangeMaker 0,12,3 63 >> testresults.txt
@echo .
@echo . >> testresults.txt
@echo "running java DynamicChangeMaker 10,12,3,12 63"
@echo "running java DynamicChangeMaker 10,12,3,12 63" >> testresults.txt
java DynamicChangeMaker 10,12,3,12 63 >> testresults.txt
@echo . >> testresults.txt

@echo . >> testresults.txt
@echo ...........done.............. >> testresults.txt
@echo . >> testresults.txt
@echo
@echo ...........done..............
@echo
