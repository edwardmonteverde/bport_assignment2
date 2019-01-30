# bport_assignment2
Contains JAVA code for taking Sudoku board input, checking if it is valid, and 
converting it to an equivalent SAT instance

Sudoku board is read in with two digits indicating the size of the Sudoku board, 
and then subsequent lines of plain text numbers. Code then tests to check
if it's a valid Sudoku board (only 1 instance of each number 1-9 in each row and
column). The code then receives the Sudoku board as input to output an 
equivalent boolean expression file in DIMACS format
