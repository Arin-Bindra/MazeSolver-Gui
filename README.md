# MazeSolver-Gui

Program It loads a maze from a maze text file then program walks through the maze and finds the path from starting node to the exiting node.

Maze text file format: 
Number of linkers, Number of columns, number of rows (Header of maze) 
Node’s name, x position, y position, next linked node name, next linked node name 
… 
Node’s name, x position, y position, next linked node name, next linked node name

Example: 
22,7,6 
START,0,2,B,A 
B,1,2,C,K 
C,1,3,D,E 
… 
V,4,1,N,A 
EXIT,6,2,A,A 

“A” means not next linked node on this path (this path has no exit). 
“W” links to exit. 
