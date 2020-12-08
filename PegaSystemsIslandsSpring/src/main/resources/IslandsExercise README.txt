ISLANDS


INTRO:
For your first assignment as a researcher in a space exploration company, you've been assigned to the Cartography department with the goal of analyzing map data they received from their satellites. 
The most recent scans from these satellites have been focused on identifying islands that exist on far away planets.

DATA:

These satellites return a multidimensional array of 1's and 0's indicating land as a 1 and water as a 0.

As an example:

A					  B
[ 0 0 0 0 0 0 0 0 ]   [ 1 1 1 1 0 0 0 0 ]
[ 0 0 1 0 0 0 0 0 ]   [ 1 1 1 0 0 0 0 0 ]
[ 0 1 1 0 0 0 1 0 ]   [ 1 1 0 0 0 0 1 0 ]
[ 0 1 0 0 0 0 0 0 ]   [ 1 0 0 0 0 1 0 1 ]
[ 0 0 0 0 1 0 0 0 ]   [ 0 0 0 0 1 0 0 1 ]
[ 0 0 0 1 0 1 0 0 ]   [ 0 0 0 1 0 0 1 0 ]
[ 1 0 0 1 0 0 0 1 ]   [ 0 0 0 0 1 1 0 0 ]
[ 0 0 0 0 0 0 0 1 ]   [ 0 0 0 0 1 1 0 0 ]

C			D 			E
[ 0 1 0 ] 	[ 0 1 1 ]	[ 0 0 0 ]
[ 1 0 1 ]	[ 1 0 1 ]	[ 0 1 0 ]
[ 0 1 0 ]	[ 1 1 0 ]	[ 0 0 0 ]


RULES:

What is an island?
Given how imprecise the terrain details are as a grid of 0s and 1s, the company wants us to evaluate each map two different ways:

OMNIDIRECTIONAL: Islands can be orthogonally and/or diagonally adjacent
In this evaluation, an island is defined as a set of 1s which are orthogonally and/or diagonally adjacent, that is, a group of 1s who are adjacent to one another in any direction. 
1s that are diagonal to one another count as a single island.

There is only one island in each of these examples as the 1s are attached diagonally or orthogonally.
[ 1 0 ]		[ 1 0 ]		[ 1 0 ] 	[ 1 1 ]
[ 0 0 ]		[ 1 0 ]		[ 0 1 ]		[ 0 1 ]

Using the OMNIDIRECTIONAL evaluation of the above maps, the number of found islands are: A=5, B=2, C=1, D=1, E=1


ORTHOGONAL: Islands can only be orthogonally adjacent
In this evaluation, an island is defined as a set of 1's which are only orthogonally adjacent, that is, a group of 1s connected up, down, left, and right of other 1s.
There is no assumed connection between 1s that are diagonal to one another and as such are to be treated as separate islands

These maps show two islands since the 1s are not fully orthogonally adjacent (each is divided by diagonal 0s (water)
[ 1 0 ]		[ 0 1 1 ] 
[ 0 1 ]		[ 1 0 1 ]
			[ 1 1 0 ]

Using the ORTHOGONAL evaluation of the above maps, the number of found islands are: A=7, B=8, C=4, D=2, E=1


Note: It is assumed that any land (1s) on the edge of the map is surrounded by water (0s) in the spaces we do not have data for (assume there is a border of water around the whole map when making your calculations). 

ASSIGNMENT

Your assignment is to write an algorithm which takes any map and evaluates how many islands there are given an evaluation strategy.
They aren't looking for a user interface, rather, only an API that can be called to get the numbers for a given map. Users of the API expect to provide you both the map and evaluation strategy. 
You are free to design the API and backend code as you please.

For test data, feel free to make your own or you can plug in the below cases into your system.


public class IslandTestGrids {

    // Omni=7, ortho=7
    public int[][] grid1 = {
            { 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 1, 1, 1, 0, 0, 0, 0 },
            { 0, 1, 1, 0, 0, 0, 1, 0 },
            { 0, 0, 1, 0, 0, 0, 1, 0 },
            { 1, 0, 0, 0, 0, 0, 0, 0 },
            { 1, 0, 0, 0, 1, 0, 1, 0 },
            { 0, 0, 0, 0, 0, 0, 1, 0 },
            { 0, 0, 1, 0, 1, 0, 0, 0 } };

    // Omni=3, ortho=14
    public int[][] grid2 = {
            { 0, 0, 1, 0, 0, 0, 1, 0 },
            { 0, 1, 0, 1, 0, 0, 1, 0 },
            { 1, 0, 1, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 1, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 1, 0, 1, 0 },
            { 0, 1, 0, 0, 0, 1, 0, 0 },
            { 1, 0, 0, 0, 0, 1, 0, 0 },
            { 0, 1, 1, 1, 1, 0, 0, 1 } };

    // Omni=1, ortho=1
    public int[][] grid3 = {
            { 0, 0, 0 },
            { 0, 1, 0 },
            { 0, 0, 0 } };

    // Omni=1, ortho=4
    public int[][] grid4 = {
            { 0, 1, 0 },
            { 1, 0, 1 },
            { 0, 1, 0 } };

    // Omni=1, ortho=2
    public int[][] grid5 = {
            { 0, 1, 1 },
            { 1, 0, 1 },
            { 1, 1, 0 } };
			
}




