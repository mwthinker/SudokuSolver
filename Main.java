package sudoku;

public class Main {
	public static void main(String[] args) {
		int[] board = {2, 0, 4, 0, 0, 8, 0, 6, 0,
					   7, 6, 9, 0, 0, 0, 3, 0, 1,
					   1, 0, 0, 0, 6, 7, 0, 4, 5,
					   0, 8, 2, 4, 9, 0, 1, 5, 7,
					   4, 1, 0, 0, 5, 3, 6, 0, 0,
					   0, 0, 5, 7, 2, 0, 0, 0, 0,
					   0, 0, 3, 0, 7, 9, 4, 1, 0,
					   0, 0, 6, 0, 0, 2, 0, 0, 0,
					   5, 0, 0, 0, 0, 0, 9, 2, 8};
		
		Gameboard gameboard = new Gameboard(board);		
		
		System.out.println(gameboard);
		SudokuSolver solver = new SudokuSolver(gameboard);		
		solver.solve();
		System.out.println(solver.getGameboard());
	}
}
