public class GameStrategy {
	private boolean placedQueens[][] = new boolean[8][8];
	private int numQueens = 0;

	private int getColumn(int cellId) {
		// WRITE YOUR LOGIC HERE...................................		

		return cellId % 8;	// just for the heck of it
	}
	
	private int getRow(int cellId) {
		// WRITE YOUR LOGIC HERE....................................
		
		return cellId / 8;	// just for the heck of it
	}

	public boolean isValidPosition(int cellId) {
		boolean isValid = true;

		if(numQueens == 8) throw new GameOverException();	// just return out of the method

		// the game is still on, so let us continue...
		
		int col = getColumn(cellId);
		
		int row = getRow(cellId);
		
		/*
			WRITE YOUR LOGIC HERE...............................

		*/
		int i, j;
		
		// Check if row contains queen		
		for (int c = 0; c < 8 && isValid; c++) {
			if (this.placedQueens[row][c])
				isValid = false;
		}
		
		// Check if column contains queen
		for (int r = 0; r < 8 && isValid; r++) {
			if (this.placedQueens[r][col])
				isValid = false;
		}
		
		// Check top left diagonal
		i = row-1;
		j = col-1;
		while (i >= 0 && j >= 0 && isValid) {
			if (this.placedQueens[i--][j--])
				isValid = false;
		}
		
		// Check to top right diagonal
		i = row-1;
		j = col+1;
		while (i >= 0 && j < 7 && isValid) {
			if (this.placedQueens[i--][j++])
				isValid = false;
		}
		
		// Check to bottom left diagonal
		i = row+1;
		j = col-1;
		while (i < 7 && j >= 0 && isValid) {
			if (this.placedQueens[i++][j--])
				isValid = false;
		}
		
		// Check to bottom right diagonal
		i = row+1;
		j = col+1;
		while (i < 7 && j < 7 && isValid) {
			if (this.placedQueens[i++][j++])
				isValid = false;
		}

		this.placedQueens[row][col] = true;
		this.numQueens++;
		return isValid;
	}
}














