@echo off
@echo "cleaning up for build....."
@del /Q *.class
@javac  *.java
@del testresults.txt

@echo "creating javadocs....."
@rmdir /Q /S docs
@mkdir docs
@copy BrobInt.java docs\.
@copy BrobIntTester.java docs\.
@copy Collatz.java docs\.
@copy Halver.java docs\.
@pushd docs
@javadoc -html4 *.java
@popd
@start "C:\Program Files (x86)\Mozilla Firefox\firefox.exe" .\docs\index.html

@echo "running BrobInt test harness for evaluation....."
echo "running BrobInt test harness for evaluation....." >> testresults.txt
java BrobIntTester >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt

@echo Running Collatz with 17 as a simple test case
@echo Expecting 12 steps
echo Running Collatz with 17 as a simple test case >> testresults.txt
echo Expecting 12 steps >> testresults.txt
java Collatz 17 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Collatz with 3691578348615318
@echo Expecting 326 steps
echo Running Collatz with 3691578348615318 >> testresults.txt
echo Expecting 326 steps >> testresults.txt
java Collatz 3691578348615318 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Collatz with 147258369
@echo Expecting 216 steps
echo Running Collatz with 147258369 >> testresults.txt
echo Expecting 216 steps >> testresults.txt
java Collatz 147258369 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Collatz with 53049529258442
@echo Expecting 286 steps
echo Running Collatz with 53049529258442 >> testresults.txt
echo Expecting 286 steps >> testresults.txt
java Collatz 53049529258442 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Collatz with 159482673357869421789456123
@echo [note that https://www.mathcelebrity.com/collatz.php can't process this number]
@echo [without resorting to exponential notation, which loses precision so steps are off]
@echo Expecting 661 steps [website gets 405]
echo Running Collatz with 159482673357869421789456123 >> testresults.txt
echo [note that https://www.mathcelebrity.com/collatz.php can't process this number]
echo [without resorting to exponential notation, which loses precision so steps are off]
echo Expecting 661 steps [website gets 405] >> testresults.txt
java Collatz 159482673357869421789456123 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Collatz with 75942615348675395174185296348152659
@echo [note that https://www.mathcelebrity.com/collatz.php can't process this number]
@echo [without resorting to exponential notation, which loses precision so steps are off]
@echo Expecting 995 steps [website gets 478]
echo Running Collatz with 75942615348675395174185296348152659 >> testresults.txt
echo [note that https://www.mathcelebrity.com/collatz.php can't process this number]
echo [without resorting to exponential notation, which loses precision so steps are off]
echo Expecting 995 steps [website gets 478] >> testresults.txt
java Collatz 75942615348675395174185296348152659 >> testresults.txt

echo . >> testresults.txt
echo . >> testresults.txt
@echo Running Collatz with 7594261534867539517418529634815265910200201075476883366222929291818181823413747890
@echo [note that https://www.mathcelebrity.com/collatz.php can't process this number]
@echo [without resorting to exponential notation, which loses precision so steps are off]
@echo Expecting 1831 steps [website gets 567]
echo Running Collatz with 7594261534867539517418529634815265910200201075476883366222929291818181823413747890 >> testresults.txt
echo [note that https://www.mathcelebrity.com/collatz.php can't process this number]
echo [without resorting to exponential notation, which loses precision so steps are off]
echo Expecting 1831 steps [website gets 567] >> testresults.txt
java Collatz 7594261534867539517418529634815265910200201075476883366222929291818181823413747890 >> testresults.txt

@echo
@echo ...........done..............
echo ...........done.............. >> testresults.txt
@echo


