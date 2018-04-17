



@echo off
@del /Q *.class
@javac  *.java
@del testresults.txt
@rmdir /Q /S docs
@mkdir docs
@copy *.java docs\.
@pushd docs
@javadoc *.java
@popd
@start "C:\Program Files (x86)\Mozilla Firefox\firefox.exe" docs\index.html

@java TupleTestHarness >> testresults.txt
@java DynamicChangemakerTestHarness >> testresults.txt



