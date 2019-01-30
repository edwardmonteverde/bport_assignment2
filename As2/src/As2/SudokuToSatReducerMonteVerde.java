package As2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Scanner;
import java.util.regex.Pattern;

public class SudokuToSatReducerMonteVerde {

	SudokuBoardMonteVerde board;
	int boxWidth, boxHeight, bSize, numCells;
	Scanner scan;
	// StringBuffer buffer;
	File outFileName;
	Writer writer;
	TimerMonteVerde timer;

	public SudokuToSatReducerMonteVerde(File inputFile) throws Exception {
		board = createBoard(inputFile);

		int size = board.getBoardSize();
		int filledIn = board.getNonEmpties();
		int numClauses = ((1 + (size * (size - 1) / 2)) * (size * size) * 4) + filledIn;

		makeOutFile("output2.cnf");
		write("p cnf ");
		String numVars = String.valueOf(getNumberOfVariables());
		write(numVars + " " + numClauses);
		write("\n");
		board.getNonEmpties();
		System.out.println("testtttttt");
		timer = new TimerMonteVerde();
		timer.start();
		reduceBoard(board);
		timer.stop();
		System.out.println(timer.getDuration());

	}

	public SudokuBoardMonteVerde createBoard(File inFile) throws Exception {

		try {
			scan = new Scanner(inFile);
		} catch (Exception e) {
			System.out.println("Failed because" + e);
			System.exit(1);
		}

		// get to end of c's in file and begin reading ints

		Pattern pattern = Pattern.compile("c");
		while (scan.findInLine(pattern) != null)
			scan.nextLine();

		boxWidth = Integer.parseInt(scan.next());
		boxHeight = Integer.parseInt(scan.next());

		board = new SudokuBoardMonteVerde(boxWidth, boxHeight);
		scan.nextLine();

		bSize = boxWidth * boxHeight;
		numCells = bSize * bSize;

		for (int i = 0; i < board.getNumCells(); i++) {
			board.setCell(i, scan.nextInt());
		}

		System.out.println(board.toString());

		return board;

	}

	private int reduce(int i, int j, int k) {

		return (i * bSize * bSize + j * bSize + k);
	}

	private void reduceBoard(SudokuBoardMonteVerde board) {

		System.out.println("test line");

		for (int k = 1; k <= 9; k++) {
			for (int i = 0; i < 9; i++) {

				atLeastOneInRow(i, k);
				atMostOneInRow(i, k);
			}

			for (int j = 0; j < 9; j++) {
				atLeastOneInCol(j, k);
				atMostOneInCol(j, k);
			}
		}

		for (int i = 0; i < numCells; i++) {
			atLeastOneInCell(i);
			atMostOneInCell(i);
		}

		atLeastOneInBox();
		atMostOneInBox();

	}

	private void atLeastOneInRow(int i, int k) {

		for (int j = 0; j < 9; j++) {
			write(reduce(i, j, k) + " ");
		}
		write(" 0\n");
	}

	private void atMostOneInRow(int i, int k) {

		for (int j = 0; j < bSize; j++) {
			for (int x = j + 1; x < bSize; x++) {
				write(-1 * reduce(i, j, k) + " ");
				write(-1 * reduce(i, x, k) + " ");
				write("0\n");
			}
		}
	}

	private void atLeastOneInCol(int j, int k) {
		for (int i = 0; i < bSize; i++) {
			write(reduce(i, j, k) + " 0\n");
		}
	}

	private void atMostOneInCol(int j, int k) {

		for (int i = 0; i < bSize; i++) {
			for (int x = i + 1; x < bSize; x++) {
				write(-1 * reduce(i, j, k) + " ");
				write(-1 * reduce(i, x, k) + " ");
				write("0\n");
			}
		}
	}

	private void atLeastOneInBox() {

		for (int k = 1; k <= bSize; k++) {
			for (int m = 1; m <= bSize; m += 3) {
				for (int n = 1; n <= bSize; n += 3) {
					// boxes
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							write((m + i) + "" + (n + j) + "" + k + " ");
						}
					}
					write("0\n");
				}
			}
		}
	}

	private void atMostOneInBox() {

		StringBuffer buffer = new StringBuffer();

		for (int k = 1; k <= bSize; k++) {
			for (int m = 1; m <= bSize; m = m + 3) {
				for (int n = 1; n <= bSize; n = n + 3) {
					String[] temp = new String[bSize];
					int x = 0;

					// create new temp array to separate boxes
					for (int i = 0; i < 3; i++) {
						for (int j = 0; j < 3; j++) {
							temp[x] = (m + i) + "" + (n + j) + "" + k;
							x++;
						}
					}

					// check the new temp array
					for (int j = 0; x <= temp.length; x++) {
						int counter = 1;
						for (int i = j; i < temp.length - 1; i++) {
							write("-" + temp[j] + " ");
							write("-" + temp[j + counter] + " ");
							write("0\n");
							counter++;
						}
					}
				}
			}
		}
	}

	private void atLeastOneInCell(int cell) {

		int cellRow = board.getCellRow(cell);
		int cellCol = board.getCellCol(cell);

		for (int k = 1; k <= bSize; k++) {
			String temp = String.valueOf(reduce(cellRow, cellCol, k));
			write(temp);
		}
		write("0\n");
	}

	private void atMostOneInCell(int cell) {

		int cellRow = board.getCellRow(cell);
		int cellCol = board.getCellCol(cell);
		for (int i = 0; i < bSize; i++) {
			for (int j = bSize; j > i; j--) {
				write("-" + reduce(cellRow, cellCol, i));
				write("-" + reduce(cellRow, cellCol, j) + " 0\n");
			}
			write("0\n");

		}
	}

	private void makeOutFile(String outFile) {
		outFileName = new File(outFile);
		try {
			writer = new PrintWriter(outFileName);
		} catch (FileNotFoundException e) {
			System.exit(1);
		}
	}

	private void write(String string) {
		try {
			// System.out.println("String = " + writer);
			writer.write(string);
			writer.flush();
		} catch (IOException e) {
			System.exit(1);
		}

	}

	private int getExistingValues() {
		int counter = 0;
		for (int i = 0; i < board.getNumCells(); i++) {
			int var = board.getCellValue(i);
			if (var > 0) {
				counter++;
			}
		}
		return counter;
	}

	private int getNumberOfVariables() {
		int numVars = board.getBoardSize() * board.getBoardSize() * board.getBoardSize();
		return numVars;
	}

	private long numberOfClauses() {
		long result = ((4 * board.getNumCells()) + (4 * board.getNumCells() * 36) + getExistingValues());
		return result;
	}

	// public void printBoard() {
	// System.out.println(Arrays.toString(board));
	// }
}