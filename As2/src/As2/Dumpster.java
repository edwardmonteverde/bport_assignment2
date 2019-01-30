// MAIN CLASS
//
// package As2;
//
// import java.io.File;
//
// public class MainMonteVerdeA2 {
// // this variable is only for testing
// File inputFile;
//
// public static void main(String args[]) {
// // // FOR FUN CODE
// // check if file is entered and handle exception
// // try {
// // if (args.length > 0) {
// // File inputFile = new File(args[0]);
// // Scanner scan = new Scanner(inputFile);
// //
// // System.out.println("Processing file");
// // while (scan.hasNextLine())
// // System.out.println(scan.nextLine());
// //
// // } else {
// // System.out.println("No file entered.");
// // System.exit(1);
// // }
// //
// // } catch (Exception e) {
// // System.out.println("File failed to open.");
// // System.exit(1);
// // }
//
// // check if file is entered and handle exception
// try {
// if (args.length > 0) {
// File inputFile = new File(args[0]);
// // Scanner scan = new Scanner(inputFile);
// System.out.println("Processing file");
//
// // new SudokuBoardMonteVerde(new File(args[0]));
//
// SudokuBoardMonteVerde reducer = new SudokuBoardMonteVerde(inputFile);
//
// // SudokuBoardMonteVerde reducer = new SudokuBoardMonteVerde();
//
// // test methods
// reducer.read(inputFile);
// reducer.getHeight();
// reducer.getWidth();
// System.out.println("Cell 1 is: " + reducer.getCellValue(13));
// reducer.getNumCells();
// reducer.printBoard();
// reducer.getCellRow(29);
// reducer.getCellCol(7);
// reducer.getCellBox(18);
// // set and check to see if successful change
// reducer.setCell(9, 3);
// reducer.printBoard();
//
// } else {
// System.out.println("No file entered.");
// System.exit(1);
// }
//
// } catch (Exception e) {
// System.out.println("File failed to open.");
// System.exit(1);
// }
//
// }
//
// }
//
//// OLD SUDOKU BOARD CLASS!!!!!!!!!!!!!!!!!!!
//
// package As2;
//
// import java.io.File;
// import java.util.Scanner;
//
// public class SudokuBoardMonteVerde {
//
// int boxWidth, boxHeight, width, height, numCells;
// int[][] boardCells;
//
// public void read(File inputFile) throws Exception {
//
// Scanner scan = new Scanner(inputFile);
//
// boxWidth = Integer.parseInt(scan.next());
// boxHeight = Integer.parseInt(scan.next());
// // scan.nextLine();
//
// width = boxWidth * 3;
// height = boxHeight * 3;
// numCells = height * width;
// scan.nextLine();
// boardCells = new int[width][height];
//
// int numRow = 0;
// int numCol = 0;
//
// System.out.println(width + " " + height);
// while (scan.hasNextLine() && numRow < height) {
//
// String temp = scan.nextLine();
//
// String[] charArray = temp.split("\\s+");
//
// while (numCol < width) {
// boardCells[numRow][numCol] = Integer.parseInt(charArray[numCol++]);
// // System.out.println("Test print of current cell: " +
// // boardCells[numRow][numCol]);
// }
//
// numCol = 0;
// numRow++;
// }
// }
//
// public int getCellValue(int cellNum) {
// int counter = 0;
// int value = 0;
//
// OUTER_LOOP: for (int row = 0; row < boardCells.length; row++) {
// for (int col = 0; col < boardCells[row].length; col++) {
// counter++;
// if (cellNum == counter) {
// value = boardCells[row][col];
// break OUTER_LOOP;
// }
// }
// }
// System.out.println("Test print: Value of cell " + cellNum + " is " + value +
// ".");
// return value;
// }
//
// public int getCellRow(int cellNum) {
// int counter = 0;
// int row = 0;
//
// OUTER_LOOP: for (row = 0; row < boardCells.length; row++) {
// for (int col = 0; col < boardCells[row].length; col++) {
// counter++;
// if (cellNum == counter) {
//
// break OUTER_LOOP;
// }
// }
// }
// System.out.println("Test print: Row of cell " + cellNum + " is " + row +
// ".");
// return row;
// }
//
// public int getCellCol(int cellNum) {
// int counter = 0;
// int col = 0;
//
// OUTER_LOOP: for (int row = 0; row < boardCells.length; row++) {
// for (col = 0; col < boardCells[row].length; col++) {
// counter++;
// if (cellNum == counter) {
// break OUTER_LOOP;
// }
// }
// }
// System.out.println("Test print: Row of cell " + cellNum + " is " + col +
// ".");
// return col;
// }
//
// public int getCellBox(int cellNum) {
// int counter = 0;
// int box = 0;
//
// OUTER_LOOP: for (int row = 0; row < boardCells.length; row++) {
// for (int col = 0; col < boardCells[row].length; col++) {
// counter++;
// if (cellNum == counter) {
//
// // check for boxes 1-3
// if (row >= 0 && row <= 2) {
// // box 1
// if (col >= 0 && col <= 2)
// box = 1;
// // box 2
// if (col >= 3 && col <= 5)
// box = 2;
// // box 3
// if (col >= 6 && col <= 8)
// box = 3;
// }
//
// // check for boxes 4-6
// if (row >= 3 && row <= 5) {
// // box 4
// if (col >= 0 && col <= 2)
// box = 4;
// // box 5
// if (col >= 3 && col <= 5)
// box = 5;
// // box 6
// if (col >= 6 && col <= 8)
// box = 6;
// }
//
// // check for boxes 7-9
// if (row >= 6 && row <= 8) {
// // box 7
// if (col >= 0 && col <= 2)
// box = 7;
// // box 8
// if (col >= 3 && col <= 5)
// box = 8;
// // box 9
// if (col >= 6 && col <= 8)
// box = 9;
// }
//
// break OUTER_LOOP;
// }
// }
// }
// System.out.println("Test print: cell number " + cellNum + " is in box number
// " + box + ".");
// return box;
// }
//
// public void setCell(int cellNum, int cellValue) {
// int counter = 0;
// int printVar = 0;
//
// OUTER_LOOP: for (int row = 0; row < boardCells.length; row++) {
// for (int col = 0; col < boardCells[row].length; col++) {
// counter++;
// if (cellNum == counter) {
// boardCells[row][col] = cellValue;
// // assignment for printing to comfirm success
// printVar = boardCells[row][col];
//
// break OUTER_LOOP;
// }
// }
// }
// System.out.println("Test print: Value of cell " + cellNum + " is now " +
// printVar + ".");
// }
//
// public int getWidth() {
// System.out.println("Test: Box width is " + boxWidth + " \\ cell width is " +
// width);
// return boxWidth;
// }
//
// public int getHeight() {
// System.out.println("Test: Box height is " + boxHeight + " \\ cell height is "
// + height);
// return boxHeight;
// }
//
// public int getNumCells() {
// System.out.println("Test: Number of cells is " + numCells);
// return numCells;
// }
//
// public int getBoardSize() {
// System.out.println("Test: Board size is " + height + " by " + width);
// return height;
// }
//
// public int[][] getBoard() {
// return boardCells;
// }
//
// public void printBoard() {
// System.out.println("Printing board array: ");
// for (int[] x : boardCells) {
// for (int y : x) {
// System.out.print(y + " ");
// }
// System.out.println();
// }
// }
//
// // public void printBoard() {
// // System.out.println(Arrays.deepToString(boardCells).replace("], ",
// // "]\n"));
// // }
//
// }
//
// // OLD SUDOKUTOSATREDUCER CLASS!!!!!!!!!!!!!
//
// private void atLeastOneInCol(int j, int k) {
// for (int i = 0; i < bSize; i++)
// printer.print(reduce(i, j, k) + " ");
// printer.println("0");
// }
//
// private void atMostOneInCol(int j, int k){
// for (int i=0; i < bSize; i++){
// for (int x=i+1; x < bSize; x++){
// printer.print(-1 * reduce(i,j,k) + " ");
// printer.println(-1 * reduce(i,x,k) + "0");
// }
// }
// }
//
//// while (scan.hasNextLine() && row < bSize) {
//// String temp = scan.nextLine();
//// String[] charArray = temp.split("\\s+");
//// for (int x = 0; x < charArray.length; x++) {
//// board = Integer.parseInt(charArray[x]);
//// i++;
//// }
//// }
