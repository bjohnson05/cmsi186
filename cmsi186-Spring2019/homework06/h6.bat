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

@echo Running Collatz with 3691578348615318
@echo Expecting 314 steps
echo Running Collatz with 3691578348615318 >> testresults.txt
echo Expecting 314 steps >> testresults.txt
java Collatz 3691578348615318 >> testresults.txt

@echo Running Collatz with 147258369 
@echo Expecting 107 steps
echo Running Collatz with 147258369 >> testresults.txt
echo Expecting 107 steps >> testresults.txt
java Collatz 147258369 >> testresults.txt

@echo Running Collatz with 159482673357869421789456123 
@echo Expecting 654 steps
echo Running Collatz with 159482673357869421789456123 >> testresults.txt
echo Expecting 654 steps >> testresults.txt
java Collatz 159482673357869421789456123 >> testresults.txt

@echo Running Collatz with 75942615348675395174185296348152659 
@echo Expecting 776 steps
echo Running Collatz with 75942615348675395174185296348152659 >> testresults.txt
echo Expecting 776 steps >> testresults.txt
java Collatz 75942615348675395174185296348152659 >> testresults.txt

@echo Running Collatz with 7594261534867539517418529634815265910200201075476883366222929291818181823413747890 
@echo Expecting 951 steps
echo Running Collatz with 7594261534867539517418529634815265910200201075476883366222929291818181823413747890 >> testresults.txt
echo Expecting 951 steps >> testresults.txt
java Collatz 7594261534867539517418529634815265910200201075476883366222929291818181823413747890 >> testresults.txt

@echo
@echo ...........done..............
@echo


