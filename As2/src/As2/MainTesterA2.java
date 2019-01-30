package As2;

import java.io.File;

public class MainTesterA2 {
	// this variable is only for testing
	File inputFile;

	public static void main(String args[]) {
		// // FOR FUN CODE
		// check if file is entered and handle exception
		// try {
		// if (args.length > 0) {
		// File inputFile = new File(args[0]);
		// Scanner scan = new Scanner(inputFile);
		//
		// System.out.println("Processing file");
		// while (scan.hasNextLine())
		// System.out.println(scan.nextLine());
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

		// check if file is entered and handle exception
		try {
			if (args.length > 0) {
				File inputFile = new File(args[0]);
				// Scanner scan = new Scanner(inputFile);
				System.out.println("Processing file");

				// new SudokuBoardMonteVerde(new File(args[0]));

				SudokuToSatReducerMonteVerde reducer = new SudokuToSatReducerMonteVerde(inputFile);

				// test methods
				reducer.createBoard(inputFile);
				// reducer.printBoard();

			} else {
				System.out.println("No file entered.");
				System.exit(1);
			}

		} catch (Exception e) {
			System.out.println("File failed to open.");
			System.exit(1);
		}

	}

}