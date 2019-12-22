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
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim no args...        >> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim                              >> testresults.txt

@echo ... Testing SoccerSim one arg...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim one arg...        >> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10                           >> testresults.txt

@echo ... Testing SoccerSim two args...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim two args...       >> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 20                        >> testresults.txt

@echo ... Testing SoccerSim three args...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim three args...     >> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 20 30                     >> testresults.txt

@echo ... Testing SoccerSim six args...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim six args...       >> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 20 30 40 50 60            >> testresults.txt

@echo ... Testing SoccerSim out of bounds...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim out of bounds...  >> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim %2 %2 99 99                  >> testresults.txt

@echo ... Testing SoccerSim negative time slice...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim negative time slice...>> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  5  5 -1               >> testresults.txt

@echo ... Testing SoccerSim time slice too large...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim time slice too large...>> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  5  5 1800.1           >> testresults.txt

@echo ... Testing SoccerSim time slice value of zero...
@echo ...   Should throw exception that won't show in results
@echo ...   Or should output a message of some type
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim time slice value of zero...>> testresults.txt
echo ...   Should throw exception that won't show in results >> testresults.txt
echo ...   Or should output a message of some type >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  5  5 0.0              >> testresults.txt

@echo ... Testing SoccerSim valid ball should come to rest...
@echo ...  Should stop at about 4:42
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball should come to rest...>> testresults.txt
echo ...   Should stop at about 4:42           >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  1  1                  >> testresults.txt

@echo ... Testing SoccerSim check for collision...
@echo ...   Should collide at about 5 seconds
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim check for collision...>> testresults.txt
echo ...   Should collide at about 5 seconds   >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10  1  1 20 20 -1 -1      >> testresults.txt

@echo ... Testing SoccerSim valid ball should go out of bounds...
@echo ...   Speed *should* kick it out quickly
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball should go out of bounds...>> testresults.txt
echo ...   Speed *should* kick it out quickly  >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 10 10 1000 1000              >> testresults.txt

@echo ... Testing SoccerSim valid ball set six balls subsecond time slice...
@echo ...   Should collide Ball 1 and 4 in less than 1 sec
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball set six balls subsecond time slice...>> testresults.txt
echo ...   Should collide Ball 1 and 4 in less than 1 sec  >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 200 200 10 10 100 100 -100 -100 150 150 200 200 175 175 -110 -110 20 20 1 1 50 50 -5 -5 0.1 >> testresults.txt

@echo ... Testing SoccerSim valid ball set five balls 1.234 second time slice...
@echo ...   Should say "not possible @ 13:29.5
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball set five balls 1.234 second time slice...>> testresults.txt
echo ...   Should say "not possible @ 13:29.5  >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 200 200 10 10 100 100 -100 -100 150 150 200 200 175 175 -110 -110 20 20 1 1 50 50 -5 -5 1.234  >> testresults.txt

@echo ... Testing SoccerSim valid ball set ten balls 10 second time slice...
@echo ...   Should contact ball 1 and 8 @ 30 sec
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... Testing SoccerSim valid ball set ten balls 10 second time slice...>> testresults.txt
echo ...   Should contact ball 1 and 8 @ 30 sec  >> testresults.txt
echo ======================================  >> testresults.txt
@java SoccerSim 150 150 10 10 100 100 -100 -100 200 200 200 200 250 250 -110 -110 20 20 1 1 50 50 -5 -5 -100 -100 200 200 -200 -200 300 300 -110 -110 20 20 1 1 50 50 10.0 >> testresults.txt

@echo ... End of SoccerSim Testing ...
echo .                                       >> testresults.txt
echo .                                       >> testresults.txt
echo ======================================  >> testresults.txt
echo ... End of SoccerSim Testing...         >> testresults.txt
echo ======================================  >> testresults.txt
