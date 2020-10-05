class SudokuSolverUsingBackTracking{
	private static int [][]sudoku =      {{3, 0, 6, 5, 0, 8, 4, 0, 0},  
					      {5, 2, 0, 0, 0, 0, 0, 0, 0},  
					      {0, 8, 7, 0, 0, 0, 0, 3, 1},  
					      {0, 0, 3, 0, 1, 0, 0, 8, 0},  
					      {9, 0, 0, 8, 6, 3, 0, 0, 5},  
					      {0, 5, 0, 0, 9, 0, 6, 0, 0},  
					      {1, 3, 0, 0, 0, 0, 2, 5, 0},  
					      {0, 0, 0, 0, 0, 0, 0, 7, 4},  
					      {0, 0, 5, 2, 0, 6, 3, 0, 0}};  
	private static final int empty = 0;
	private static final int size = 9;
	private static boolean solveBoard(){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++){
				if(sudoku[i][j] == empty){
					for(int number=1; number <= size; number++){
						if(isOk(i, j, number)){
							sudoku[i][j] = number;
							if(solveBoard())
								return true;
							 else
								sudoku[i][j] = empty;
						}
					}
					return false;
				}
			}
		}
		return true;
	}
	private static boolean isOk(int row, int column, int number){
		if(!isInRow(row,number) && !isInColumn(column, number) && !isInSubMatrix(row, column, number))
			return true;
		return false;
	}
	private static boolean isInRow(int row, int number){
		for(int i=0; i<size; i++)
			if(sudoku[row][i] == number)
				return true;
		return false;
	}
	private static boolean isInColumn(int column, int number){
		for(int i=0; i<size; i++)
			if(sudoku[i][column] == number)
				return true;
		return false;
	}
	private static boolean isInSubMatrix(int row, int column, int number){
		int r = row - row % 3;
		int c = column - column % 3;
		for(int i=r; i<r+3; i++)
			for(int j=c; j<c+3; j++)
				if(sudoku[i][j] == number)
					return true;
		return false;
	}
	private static void displayBoard(){
		for(int i=0; i<size; i++){
			for(int j=0; j<size; j++)
				System.out.printf("%3d",sudoku[i][j]);
			System.out.println();
		}
	}
	public static void main(String args[]){
		System.out.println("Before Solving.!");
		displayBoard();
		solveBoard();
		System.out.println("After Solving.!");
		displayBoard();	
	}
}
