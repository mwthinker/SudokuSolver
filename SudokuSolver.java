package sudoku;

/**
 * Solves the 9*9 sudoku board by using a recursive backtracking algorithm.
 */
public class SudokuSolver {
	private Gameboard gameboard;
	
	public SudokuSolver(Gameboard gameboard) {
		this.gameboard = gameboard.clone();
	}
	
	public void solve() {
		solve(gameboard.findNextEmptyIndex(-1));		
	}
	
	public Gameboard getGameboard() {
		return gameboard;
	}
	
	public void setGameboard(Gameboard gameboard) {
		this.gameboard = gameboard;
	}
	
	/**
	 * Solves the sudoku board. By using a recursive backtracking algorithm.
	 * @param index First empty square, where the algorithm starts from.
	 * @return True if the board is solved else false.
	 */
	private boolean solve(int index) {
		int row = gameboard.row(index);
		int column = gameboard.column(index);
		
		// Base case i.e. no empty squares available.
		if (index < 0) {			
			return true; // Succeeded!
		}
		
		// Assume number 1 to 9, and if valid board go to next number.
		for (int i = 1; i <= 9; ++i) {
			if (isNumberFreeInRow(i,row) && isNumberFreeInColumn(i,column)
					&& isNumberFreeIn3x3Square(i,row,column)) {
				gameboard.changeNumber(index,i);
				
				// Goes to next square.
				if (solve(gameboard.findNextEmptyIndex(index))) {
					return true; // Succeeded!
				}
			}
		}
		
		// Number 1 to 9 failed, go back and change previous square.
		gameboard.changeNumber(index,0);
		return false;
	}	

	private boolean isNumberFreeInRow(int number, int row) {		
		for (int column = 0; column < 9; ++column) {
			if (gameboard.number(row, column) == number) {
				return false;
			}
		}		
		return true;
	}
	
	private boolean isNumberFreeInColumn(int number, int column) {		
		for (int row = 0; row < 9; ++row) {
			if (gameboard.number(row, column) == number) {
				return false;
			}
		}		
		return true;
	}	

	private boolean isNumberFreeIn3x3Square(int number, int row, int column) {		
		row = (row / 3) * 3;
		column = (column / 3) * 3;
		for (int i = 0; i < 3; ++i) {
			for (int j = 0; j < 3; ++j) {
				if (gameboard.number(row+i, column+j) == number) {
					return false;
				}
			}
		}
		return true;
	}
}
