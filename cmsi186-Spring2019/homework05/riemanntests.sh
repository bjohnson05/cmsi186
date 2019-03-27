rm testresults.txt
# ============================================================================
# filename: riemanntests.bat
# purpose: provide a unified test sequence for the Riemann Integration Project
# @see http://bjohnson.lmu.build/cmsi186web/homework05.html for details
# ============================================================================
echo off
@del testresults.txt
echo .
echo =====================================================
echo Testing the Riemann Ingetration Project Homework # 05
echo =====================================================
echo ... Running built-in tests in the Riemann class
echo ...   should either throw exceptions which will not appear in the output file
echo ...     but which should be caught to keep the test program running
echo ...   or preferably output error messages which SHOULD appear there
echo .                                                                              >> testresults.txt
echo =====================================================                          >> testresults.txt
echo Testing the Riemann Ingetration Project Homework  05                           >> testresults.txt
echo =====================================================                          >> testresults.txt
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ... Running built-in tests in the Riemann class                                >> testresults.txt
echo ...   should either throw exceptions which will not appear in the output file  >> testresults.txt
echo ...     but which should be caught to keep the test program running            >> testresults.txt
echo ...   or preferably output error messages which SHOULD appear there            >> testresults.txt
@java Riemann runtests                                                              >> testresults.txt

echo .
echo Testing bogus function name \`bogus\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing bogus funtion name \`bogus\`                                           >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann bogus                                                                 >> testresults.txt

echo .
echo Testing bogus function name \`bogus\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing bogus funtion name \`bogus\`                                           >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly

echo .
echo Testing valid function name \`poly\` with only one arg
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with only one arg                          >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 1

echo .
echo Testing valid function name \`poly\` with only two args
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with only two args                         >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 1 2

echo .
echo Testing valid function name \`poly\` with three args
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with three args                            >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 1 2

echo .
echo Testing valid function name \`poly\` with four args with negative final arg
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with four args with negative final arg     >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 1 2 -1

echo .
echo Testing valid function name \`poly\` with four args with zero final arg
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with four args with zero final arg         >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 1 2 0

echo .
echo Testing valid function name \`poly\` with test case parabola args and percent
echo ...should produce a result close to \`18.0000\`
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with test case parabola args and percent   >> testresults.txt
echo ...should produce a result close to \`18.0000\`                                >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 8 -2 1 4 1e-6%

echo .
echo Testing valid function name \`poly\` with test case parabola args and default
echo ...should produce a result close to \`18.0000\`
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with test case parabola args and default   >> testresults.txt
echo ...should produce a result close to \`18.0000\`                                >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 8 -2 1 4

echo .
echo Testing valid function name \`poly\` with web page args and default
echo ...should produce a result close to \`1293.75\`
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`poly\` with web page args and default             >> testresults.txt
echo ...should produce a result close to \`1293.75\`                                >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann poly 0 8 -2 1 4

echo .
echo Testing valid function name \`sin\` with web page args and default
echo ...should produce a result close to \`1.8815\`
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`sin\` with web page args and default              >> testresults.txt
echo ...should produce a result close to \`1.8815\`                                 >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin -0.27 +3.55

echo .
echo Testing valid function name \`sin\` with args -3.45 6.789 and 1.5e-4%
echo ...should produce a result close to \`−1.8276\`
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`sin\` with args 0.0 -5.0 3.0 and 1e-7%            >> testresults.txt
echo ...should produce a result close to \`−1.8276\`                                >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin -3.45 6.789 1.5e-4%

echo .
echo Testing valid function name \`sin\` with args -17.0 1.0 -23.0 23.0 and 1e-7%
echo ...should produce a result close to \`−1.6271\`
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`sin\` with args -17.0 1.0 -23.0 23.0 and 1e-7%    >> testresults.txt
echo ...should produce a result close to \`−1.6271\`                                >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sin -17.0 1.0 -23.0 23.0 1e-7%

echo .
echo Testing valid function name \`sqrt\` with args 23.0 -3.0 7.0 1.0 7.0 and 1e-6
echo ...should output a result close to 67.8939
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`sqrt\` with args 23.0 -3.0 7.0 1.0 7.0 and 1e-6   >> testresults.txt
echo ...should output a result close to 67.8939                                     >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sqrt 23.0 -3.0 7.0 1.0 7.0 1e-6

echo .
echo Testing valid function name \`sqrt\` with args 100.0 0.0 1.0 and 1e-8%
echo ...should output a result close to 10.0
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`sqrt\` with args 100.0 0.0 1.0 and 1e-8%          >> testresults.txt
echo ...should output a result close to 10.0                                        >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sqrt 100.0 0.0 1.0 1e-6%

echo .
echo Testing valid function name \`sqrt\` with args -100.0 0.0 1.0 and 1e-8%
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`sqrt\` with args -100.0 0.0 1.0 and 1e-8%         >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann sqrt -100.0 0.0 1.0 1e-8%

echo .
echo Testing valid function name \`log\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`log\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann log  1e-6%

echo .
echo Testing valid function name \`log\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`log\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann log 1e-6%

echo .
echo Testing valid function name \`exp\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`exp\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann exp 1e-6%

echo .
echo Testing valid function name \`exp\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`exp\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann exp 1e-6%

echo .
echo Testing valid function name \`log2\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`log2\`                                            >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann log2 1e-6%

echo .
echo Testing valid function name \`log2\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`log2\`                                            >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann log2 1e-6%

echo .
echo Testing valid function name \`cos\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`cos\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann cos 1e-6%

echo .
echo Testing valid function name \`cos\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`cos\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann cos 1e-6%

echo .
echo Testing valid function name \`tan\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`tan\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann tan 1e-6%

echo .
echo Testing valid function name \`tan\`
echo ...should either throw exceptions which will not appear in the output file
echo ...  or will output an error message which SHOULD appear there, then quit
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo Testing valid funtion name \`tan\`                                             >> testresults.txt
echo ...should either throw an exception which will not appear in the output file   >> testresults.txt
echo ...  or will output an error message which SHOULD appear there, then quit      >> testresults.txt
echo ============================================================================   >> testresults.txt
@java Riemann tan 1e-6%

echo .
echo ============================================================================
echo End of testing
echo ============================================================================
echo .                                                                              >> testresults.txt
echo .                                                                              >> testresults.txt
echo ============================================================================   >> testresults.txt
echo End of Testing                                                                 >> testresults.txt
echo ============================================================================   >> testresults.txt
