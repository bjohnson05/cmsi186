@echo off
@echo "cleaning up for build....."
@del *.class
@javac  *.java
@del testresults.txt

@echo "running BrobInt test harness for evaluation....."
echo "running BrobInt test harness for evaluation....." >> testresults.txt
java BrobIntTester >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt

@echo Running Neptune with 1234 as a simple test case
echo Running Neptune with 1234 as a simple test case >> testresults.txt
java Neptune 1234 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Neptune with 3691578348615318
echo Running Neptune with 3691578348615318 >> testresults.txt
java Neptune 3691578348615318 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Neptune with 147258369
echo Running Neptune with 147258369 >> testresults.txt
java Neptune 147258369 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Neptune with 53049529258442
echo Running Neptune with 53049529258442 >> testresults.txt
java Neptune 53049529258442 >> testresults.txt

@echo
@echo ...........done..............
echo ...........done.............. >> testresults.txt
@echo


