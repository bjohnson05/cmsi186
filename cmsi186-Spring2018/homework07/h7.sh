#!/bin/bash
echo "cleaning up for build....."
rm *.class
javac  *.java
rm testresults.txt

echo "creating javadocs....."
rm -R docs
mkdir docs
cp -p DynamicChangeMaker.java docs
cp -p DynamicChangemakerTestHarness.java docs
cp -p Tuple.java docs
cp -p TupleTestHarness.java docs
pushd docs
javadoc *.*
popd
firefox docs/index.html

echo "running test harnesses for evaluation....."
java TupleTestHarness >> testresults.txt
java DynamicChangemakerTestHarness >> testresults.txt

echo
echo ...........done..............
echo
