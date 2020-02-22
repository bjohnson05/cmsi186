@echo off
@del testresults.txt
REM ============================================================================
REM filename: riemanntests.bat
REM purpose: provide a unified test sequence for the Riemann Integration Project
REM @see http://bjohnson.lmu.build/cmsi186web/homework05.html for details
REM ============================================================================
@echo .
@echo =====================================================
@echo Testing the Riemann Ingetration Project Homework # 05
@echo =====================================================
@echo ... Running built-in tests in the Riemann class
@echo ...   should either throw exceptions which will not appear in the output file
@echo ...     but which should be caught to keep the test program running
@echo ...   or preferably output error messages which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo =====================================================                          >> testresults.txt
echo Testing the Riemann Ingetration Project Homework # 05                          >> testresults.txt
echo =====================================================                          >> testresults.txt
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ... Running built-in tests in the Riemann class                                >> testresults.txt
echo ...   should either throw exceptions which will not appear in the output file  >> testresults.txt
echo ...     but which should be caught to keep the test program running            >> testresults.txt
echo ...   or preferably output error messages which SHOULD appear there then quit  >> testresults.txt
java Riemann runtests                                                               >> testresults.txt

@echo .
@echo Testing bogus function name 'bogus'
@echo ...should either throw exceptions which will not appear in the output file
@echo ...  or preferably ouput error messages which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing bogus function name 'bogus'                                            >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or preferably ouput error messages which SHOULD appear there, then quit  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann bogus                                                                 >> testresults.txt

@echo .
@echo Testing bogus function name 'poly' with no arguments
@echo ...should either throw exceptions which will not appear in the output file
@echo ...  or preferably ouput error messages which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing bogus function name 'poly' with no arguments                           >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or preferably ouput error messages which SHOULD appear there, then quit  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly                                                                  >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with only one arg
@echo ...should either throw exceptions which will not appear in the output file
@echo ...  or preferably ouput error messages which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with only one arg                           >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or preferably ouput error messages which SHOULD appear there, then quit  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 1                                                               >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with only two args
@echo ...should either throw exceptions which will not appear in the output file
@echo ...  or preferably ouput error messages which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with only two args                          >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or preferably ouput error messages which SHOULD appear there, then quit  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 1 2                                                              >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with four args with negative final arg
@echo ...should either throw exceptions which will not appear in the output file
@echo ...  or preferably ouput error messages which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with four args with negative final arg      >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or preferably ouput error messages which SHOULD appear there, then quit  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 2 1 2 -1                                                         >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with four args with zero final arg
@echo ...should either throw exceptions which will not appear in the output file
@echo ...  or preferably ouput error messages which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with four args with zero final arg          >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or preferably ouput error messages which SHOULD appear there, then quit  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 1 2 0                                                          >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with three args and default percentage
@echo ...should produce a result close to '0.0000'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with three args and default percentage      >> testresults.txt
echo ...should produce a result close to '0.0000'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 1 2                                                            >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with three args with final arg 1e-6%%
@echo ...should produce a result close to '2.0000'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with three args with final arg 1e-6%%       >> testresults.txt
echo ...should produce a result close to '2.0000'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 2 1 2 1e-6%%                                                     >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with test case parabola args and 1e-6%%
@echo ...should produce a result close to '18.0000'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with test case parabola args and 1e-6%%     >> testresults.txt
echo ...should produce a result close to '18.0000'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0.0 8.0 -2.0 1.0 4.0 1e-6%%                                      >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with test case parabola args and default
@echo ...should produce a result close to '18.0000'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with test case parabola args and default    >> testresults.txt
echo ...should produce a result close to '18.1800'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 8 -2 1 4                                                       >> testresults.txt

@echo .
@echo Testing valid function name 'poly' with web page args and default
@echo ...should produce a result close to '1268.75'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' with web page args and default              >> testresults.txt
echo ...should produce a result close to '1268.75'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 1.0 -2.1 3.2 -10.0 5.0                                           >> testresults.txt

@echo .
@echo Testing valid function name 'poly' for x\^5 - 2X\^3 - X\^2 - 7X - 3
@echo    from 0 to 2 with 1e-6%%
@echo ...should produce a result close to '-20.00'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'poly' for x\^5 - 2X\^3 - X\^2 - 7X - 3            >> testresults.txt
@echo    from 0 to 2 with 1e-6%%                                                    >> testresults.txt
echo ...should produce a result close to '-20.00'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly -3.0 -7.0 -1.0 -2.0 0.0 1.0 0.0 2.0 1e-6%%                       >> testresults.txt

@echo .
@echo Testing valid function name 'sin' with web page args and default
@echo ...should produce a result close to '1.9137'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sin' with web page args and default               >> testresults.txt
echo ...should produce a result close to '1.9137'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin -0.27 +3.55                                                       >> testresults.txt

@echo .
@echo Testing valid function name 'sin' with args -3.45 6.789 and 1.5e-4%%
@echo ...should produce a result close to '-1.8278'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sin' with args -3.45 6.789 and 1.5e-4%%           >> testresults.txt
echo ...should produce a result close to '-1.8278'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin -3.45 6.789 1.5e-4%%                                              >> testresults.txt

@echo .
@echo Testing valid function name 'sin' with args 0.0 1.0 -3.45 6.789 and 1.5e-4%%
@echo ...should produce a result close to '-1.8278'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sin' with args 0.0 1.0 -3.45 6.789 and 1.5e-4%%   >> testresults.txt
echo ...should produce a result close to '-1.8278'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin 0.0 1.0 -3.45 6.789 1.5e-4%%                                      >> testresults.txt

@echo .
@echo Testing valid function name 'sin' with args -17.0 3.0 -11.0 11.0 and 1e-7%%
@echo ...should produce a result close to '0.6409'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sin' with args -17.0 3.0 -11.0 11.0 and 1e-7%%    >> testresults.txt
echo ...should produce a result close to '0.6409'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin -17.0 3.0 -11.0 11.0 1e-7%%                                       >> testresults.txt

@echo .
@echo Testing valid function name 'sin' with args -17.0 1.0 -23.0 23.0 and 1e-4%%
@echo ...should produce a result close to '-1.6276'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sin' with args -17.0 1.0 -23.0 23.0 and 1e-4%%    >> testresults.txt
echo ...should produce a result close to '-1.6276'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin -17.0 1.0 -23.0 23.0 1e-4%%                                       >> testresults.txt

@echo .
@echo Testing valid function name 'sqrt' with args 23.0 -3.0 7.0 1.0 7.0 and 1e-6%%
@echo ...should output a result close to 67.8939
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sqrt' with args 23.0 -3.0 7.0 1.0 7.0 and 1e-6%%  >> testresults.txt
echo ...should output a result close to 67.8939                                     >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sqrt 23.0 -3.0 7.0 1.0 7.0 1e-6%%                                     >> testresults.txt

@echo .
@echo Testing valid function name 'sqrt' with args 100.0 0.0 1.0 and 1e-8%%
@echo ...should output a result close to 10.0
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sqrt' with args 100.0 0.0 1.0 and 1e-8%%          >> testresults.txt
echo ...should output a result close to 10.0                                        >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sqrt 100.0 0.0 1.0 1e-8%%                                             >> testresults.txt

@echo .
@echo Testing valid function name 'sqrt' with args -100.0 0.0 1.0 and 1e-8%%
@echo ...should either throw exceptions which will not appear in the output file
@echo ...  or preferably ouput error messages which SHOULD appear there, then quit
@echo ...  Also acceptable is the java output of 'NaN'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sqrt' with args -100.0 0.0 1.0 and 1e-8%%         >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or preferably ouput error messages which SHOULD appear there, then quit   >> testresults.txt
echo ...  Also acceptable is the java output of 'NaN'                               >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sqrt -100.0 0.0 1.0 1e-8%%                                            >> testresults.txt

@echo .
@echo Testing valid function name 'sqrt' with args 2.0 0.0 1.0 and 1e-3%%
echo ...should output a result close to 1.4142
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'sqrt' with args 2.0 0.0 1.0 and 1e-3%%            >> testresults.txt
echo ...should output a result close to 1.4142                                      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sqrt 2.0 0.0 1.0 1e-3%%                                               >> testresults.txt

@echo .
@echo Testing valid function name 'cos' with web page args and default
@echo ...should produce a result close to '-0.1326'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'cos' with web page args and default               >> testresults.txt
echo ...should produce a result close to '-0.1326'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann cos -0.27 +3.55                                                       >> testresults.txt

@echo .
@echo Testing valid function name 'cos' with args -3.45 6.789 and 1.5e-4%%
@echo ...should produce a result close to '0.1810'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'cos' with args -3.45 6.789 and 1.5e-4%%           >> testresults.txt
echo ...should produce a result close to '0.1810'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann cos -3.45 6.789 1.5e-4%%                                              >> testresults.txt

@echo .
@echo Testing valid function name 'cos' with args 0.0 1.0 -3.45 6.789 and 1.5e-4%%
@echo ...should produce a result close to '0.1810'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'cos' with args 0.0 1.0 -3.45 6.789 and 1.5e-4%%   >> testresults.txt
echo ...should produce a result close to '0.1810'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann cos 0.0 1.0 -3.45 6.789 1.5e-4%%                                      >> testresults.txt

@echo .
@echo Testing valid function name 'cos' with args -17.0 3.0 -11.0 11.0 and 1e-7%%
@echo ...should produce a result close to '-0.1834'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'cos' with args -17.0 3.0 -11.0 11.0 and 1e-7%%    >> testresults.txt
echo ...should produce a result close to '-0.1834'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann cos -17.0 3.0 -11.0 11.0 1e-7%%                                       >> testresults.txt

@echo .
@echo Testing valid function name 'cos' with args -17.0 1.0 -23.0 23.0 and 1e-4%%
@echo ...should produce a result close to '0.4658'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'cos' with args -17.0 1.0 -23.0 23.0 and 1e-4%%    >> testresults.txt
echo ...should produce a result close to '0.4658'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann cos -17.0 1.0 -23.0 23.0 1e-4%%                                       >> testresults.txt

@echo .
@echo Testing valid function name 'tan' with args -0.5 1.25 and default
@echo ...should produce a result close to '1.0029'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'tan' with args -0.5 1.25 and default              >> testresults.txt
echo ...should produce a result close to '1.0029'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann tan -0.5 1.25                                                         >> testresults.txt

@echo .
@echo Testing valid function name 'tan' with args -0.5 1.25 and 1.5e-4%%
@echo ...should produce a result close to '1.0235'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'tan' with args -0.5 1.25 and 1.5e-4%%             >> testresults.txt
echo ...should produce a result close to '1.0235'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann tan -0.5 1.25 1.5e-4%%                                                >> testresults.txt

@echo .
@echo Testing valid function name 'tan' with args 0.0 1.0 1.1 2.3 and 1.5e-4%%
@echo ...should produce a result close to '1.0235'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'tan' with args 0.0 1.0 -0.5 1.25 and 1.5e-4%%     >> testresults.txt
echo ...should produce a result close to '1.0235'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann tan 0.0 1.0 -0.5 1.25 1.5e-4%%                                        >> testresults.txt

@echo .
@echo Testing valid function name 'log' with args 0.0 1.0 1.1 2.3 and 1e-5%%
@echo ...should produce a result close to '0.6109'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'log' with args 0.0 1.0 1.1 2.3 and 1e-5%%         >> testresults.txt
echo ...should produce a result close to '0.6109'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann log 0.0 1.0 1.1 2.3 1e-5%%                                            >> testresults.txt

@echo .
@echo Testing valid function name 'log' with args 1.1 2.3 and default prct
@echo ...should produce a result close to '0.6140'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'log'                                              >> testresults.txt
echo ...should produce a result close to '0.6140'                                   >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann log 1.1 2.3                                                           >> testresults.txt

@echo .
@echo Testing valid function name 'exp' with web page args and default prct
@echo ...should produce a result close to '25.5763'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'exp' with web page args and default prct          >> testresults.txt
echo ...should produce a result close to '25.5763'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann exp 2.0 3.5                                                           >> testresults.txt

@echo .
@echo Testing valid function name 'exp' with web page args and 1.6e-7%%
@echo ...should produce a result close to '25.7264'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'exp' with web page args and 1.6e-7%%              >> testresults.txt
echo ...should produce a result close to '25.7264'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann exp 2.0 3.5 1.6e-7%%                                                  >> testresults.txt

@echo .
@echo Testing valid function name 'exp' with 0.0 1.0 2.0 3.5 and 1e-7%%
@echo ...should produce a result close to '25.7264'
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid function name 'exp' with 0.0 1.0 2.0 3.5 and 1e-7%%              >> testresults.txt
echo ...should produce a result close to '25.7264'                                  >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann exp 0.0 1.0 2.0 3.5 1e-7%%                                            >> testresults.txt

@echo .
@echo ============================================================================
@echo End of testing
@echo ============================================================================
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo End of Testing                                                                 >> testresults.txt
echo ============================================================================   >> testresults.txt
