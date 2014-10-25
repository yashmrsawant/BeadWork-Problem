BeadWork-Problem
================
System of three particles connected as described below

Particle A connected to particle B and particle B connected to particle C.
Initially the system is in equilibrium state but eventually any of the particle 
A or C is disturbed from its position. The system is assumed to be on the friction-less surface. 
After sometime the system will come to an equilibrium state because any of the particle A or C 
whichever is disturbed, is hold in its disturbed position forcibly. 


Solution :
    The solution can be achieved in the following way - 
        1) The Node C is strictly withheld in its position so no point in applying 
                forces for the Node C.
        2) The Node A and Node B gets affected because of the change.
        3) changes['A'] = true and also changes['B'] = true, therefore the effect
                differential change delta is from this state, in other words
                differential effect in A is totally independent of the differential
                effect in C.
        4) After the differential move...
