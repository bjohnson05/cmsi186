@echo off
@del testresults.txt
@echo ... Testing Ball class ...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing Ball class ...              >> testresults.txt
echo ======================================  >> testresults.txt
@java Ball                                   >> testresults.txt
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt

@echo ... Testing %1 class ...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing %1 class ...                >> testresults.txt
echo ======================================  >> testresults.txt
@java %1                                     >> testresults.txt

@echo ... Testing SoccerSim no args...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim no args...        >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim                              >> testresults.txt

@echo ... Testing SoccerSim one arg...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim one arg...        >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10                           >> testresults.txt

@echo ... Testing SoccerSim two args...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim two args...       >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 20                        >> testresults.txt

@echo ... Testing SoccerSim three args...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim three args...     >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 20 30                     >> testresults.txt

@echo ... Testing SoccerSim six args...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim six args...       >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 20 30 40 50 60            >> testresults.txt

@echo ... Testing SoccerSim out of bounds...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim out of bounds...  >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim %2 %2 99 99                  >> testresults.txt

@echo ... Testing SoccerSim negativve time slice...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim negativve time slice...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  5  5 -1               >> testresults.txt

@echo ... Testing SoccerSim time slice too large...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim time slice too large...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  5  5 1800.1           >> testresults.txt

@echo ... Testing SoccerSim time slice value of zero...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim time slice value of zero...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  5  5 0.0              >> testresults.txt

@echo ... Testing SoccerSim valid ball should come to rest...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball should come to rest...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  1  1                  >> testresults.txt

@echo ... Testing SoccerSim check for collision...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim check for collision...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  1  1 20 20 -1 -1      >> testresults.txt

@echo ... Testing SoccerSim valid ball should go out of bounds...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball should go out of bounds...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10 1000 1000              >> testresults.txt

@echo ... Testing SoccerSim valid ball set six balls subsecond time slice...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball set six balls subsecond time slice...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 200 200 10 10 100 100 -100 -100 150 150 200 200 175 175 -110 -110 20 20 1 1 50 50 -5 -5 0.1 >> testresults.txt

@echo ... Testing SoccerSim valid ball set five balls 1.234 second time slice...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball set five balls 1.234 second time slice...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 200 200 10 10 100 100 -100 -100 150 150 200 200 175 175 -110 -110 20 20 1 1 50 50 -5 -5 1.234  >> testresults.txt

@echo ... Testing SoccerSim valid ball set ten balls 10 second time slice...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball set ten balls 10 second time slice...>> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 150 150 10 10 100 100 -100 -100 200 200 200 200 250 250 -110 -110 20 20 1 1 50 50 -5 -5 -100 -100 200 200 -200 -200 300 300 -110 -110 20 20 1 1 50 50 10.0 >> testresults.txt

@echo ... End of SoccerSim Testing ...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... End of SoccerSim Testing...         >> testresults.txt
echo ======================================  >> testresults.txt
