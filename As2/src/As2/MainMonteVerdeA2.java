package As2;

import java.io.File;

public class MainMonteVerdeA2 {

	public static void main(String args[]) {

		// check if file is entered and handle exception

		try {
			if (args.length > 0) {
				System.out.println("Processing file");

				new SudokuToSatReducerMonteVerde(new File(args[0]));

			} else {
				System.out.println("No file entered.");
				System.exit(1);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
		}

	}
}
