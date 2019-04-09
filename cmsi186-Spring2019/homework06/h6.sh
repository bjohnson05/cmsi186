#!/bin/bash
echo "cleaning up for build....."
rm *.class
javac  *.java
rm testresults.txt

echo "creating javadocs....."
rm -R docs
mkdir docs
cp -p BrobInt.java docs/.
cp -p BrobIntTester.java docs/.
cp -p Collatz.java docs/.
cp -p Halver.java docs/.

pushd docs
javadoc *.*
popd
firefox docs/index.html

echo "running BrobInt test harness for evaluation....."
echo "running BrobInt test harness for evaluation....." >> testresults.txt
java BrobIntTester >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt
echo . >> testresults.txt

echo Running Collatz with 3691578348615318
echo Expecting 314 steps
echo Running Collatz with 3691578348615318 >> testresults.txt
echo Expecting 314 steps >> testresults.txt
java Collatz 3691578348615318 >> testresults.txt

echo Running Collatz with 147258369
echo Expecting 107 steps
echo Running Collatz with 147258369 >> testresults.txt
echo Expecting 107 steps >> testresults.txt
java Collatz 147258369 >> testresults.txt

echo Running Collatz with 159482673357869421789456123
echo Expecting 654 steps
echo Running Collatz with 159482673357869421789456123 >> testresults.txt
echo Expecting 654 steps >> testresults.txt
java Collatz 159482673357869421789456123 >> testresults.txt

echo Running Collatz with 75942615348675395174185296348152659
echo Expecting 776 steps
echo Running Collatz with 75942615348675395174185296348152659 >> testresults.txt
echo Expecting 776 steps >> testresults.txt
java Collatz 75942615348675395174185296348152659 >> testresults.txt

echo Running Collatz with 7594261534867539517418529634815265910200201075476883366222929291818181823413747890
echo Expecting 951 steps
echo Running Collatz with 7594261534867539517418529634815265910200201075476883366222929291818181823413747890 >> testresults.txt
echo Expecting 951 steps >> testresults.txt
java Collatz 7594261534867539517418529634815265910200201075476883366222929291818181823413747890 >> testresults.txt

echo
echo ...........done..............
echo
