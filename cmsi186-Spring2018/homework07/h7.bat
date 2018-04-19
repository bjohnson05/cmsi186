
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

@echo "running test harnesses for evaluation....."
@java TupleTestHarness >> testresults.txt
@java DynamicChangemakerTestHarness >> testresults.txt


@echo
@echo ...........done..............
@echo
