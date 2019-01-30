package As2;

public class SudokuBoardMonteVerde {

	int boxWidth, boxHeight, boardSize, width, height, numCells;
	int[] boardCells;

	public SudokuBoardMonteVerde(int boxWidth, int boxHeight) {
		this.boxWidth = boxWidth;
		this.boxHeight = boxHeight;
		boardSize = boxHeight * boxWidth;
		numCells = boardSize * boardSize;
		boardCells = new int[numCells];
	}

	public int getCellValue(int cellNum) {
		int cellVal = boardCells[cellNum];
		return boardCells[cellNum];
	}

	public int getCellRow(int cellNum) {
		int cellRow = cellNum / boardSize;

		return cellRow;
	}

	public int getCellCol(int cellNum) {
		int cellCol = cellNum % boardSize;

		return cellCol;
	}

	public int getCellBox(int cellNum) {

		int row = getCellRow(cellNum) / boxHeight;
		int col = getCellCol(cellNum) / boxHeight;

		int box = row * boxHeight + col;

		return box;
	}

	public void setCell(int cellNum, int cellValue) {

		boardCells[cellNum] = cellValue;

	}

	public int getWidth() {

		return boxWidth;
	}

	public int getHeight() {

		return boxHeight;
	}

	public int getNumCells() {

		return numCells;
	}

	public int getBoardSize() {

		return boardSize;
	}

	public String toString() {

		StringBuilder builder = new StringBuilder();

		for (int i = 0; i < numCells; i++) {

			builder.append(boardCells[i]);

			if (((i + 1) % (boardSize)) == 0)
				builder.append("\n");
			else
				builder.append(" ");
		}

		return builder.toString();

	}

	public int getNonEmpties() {
		int count = 0;
		for (int i = 0; i < numCells; i++) {
			if (boardCells[i] != 0)
				count++;
		}
		System.out.println("Count is " + count);
		return count;
	}

	// public void printBoard() {
	// System.out.println("Printing board array: ");
	// System.out.println(Arrays.toString(boardCells));
	// }

}
