package sudoku;

/**
 * Represents a 9x9 sudoku board.
 */
public class Gameboard {
	private int[] board = new int[9*9];
	
	public Gameboard() {
	}
	
	public Gameboard(int[] board) {
		// Copies the elements of the given board
		for (int i = 0; i < 81; ++i) {
			this.board[i] = board[i];			
		}
	}
	
	public String toString() {
		String str = "";
		for (int row = 0; row < 9; ++row) {
			for (int column = 0; column < 9; ++column) {
				str += board[toIndex(row,column)] + "  ";
			}
			str += "\n";
		}
		
		return str;
	}
	
	public int findNextEmptyIndex(int index) {
		while (++index < 81) {
			if (board[index] == 0) {
				return index;
			}
		}
		return -1;
	}
	
	public int toIndex(int row, int column) {
		return row*9+column;
	}
	
	public int row(int index) {
		return index / 9;
	}
	
	public int column(int index) {
		return index % 9;
	}
	
	public Gameboard clone() {
		Gameboard gameboard = new Gameboard();
		for (int i = 0; i < 81; ++i) {
			gameboard.board[i] = board[i];
		}
		
		return gameboard;
	}
	
	public void changeNumber(int index, int number) {
		board[index] = number;
	}
	
	public int number(int row, int column) {
		return board[toIndex(row,column)];
	}
	
	public int number(int index) {
		return board[index];
	}
}
