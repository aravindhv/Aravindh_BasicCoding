class NQueensProblem{
	static final int N = 4;
	static int[][] board = new int [N][N];
	private static void printBoard(){
		for (int i = 0; i < N; i++) { 
			for (int j = 0; j < N; j++)
		    		if(board[i][j] == 0) 
		        		System.out.printf("  %d  ", board[i][j]);
		        	else if(board[i][j] == 1)
		        		System.out.printf(" %s ","[Q]");
            		System.out.println(); 
        	} 
	}
	private static boolean checkPosition(int row, int col){
		int i=0, j=0;
		for(i=0; i<col; i++)
			if(board[row][i] == 1)
				return false;
		for(i=0; i<col; i++)
			if(board[i][col] == 1)
				return false;
		for(i=row, j=col; i>=0 && j>=0; i--, j--)
			if(board[i][j] == 1)
				return false;
		for(i=row, j=col; i<N && j>=0; i++, j--)
			if(board[i][j] == 1)
				return false;
		return true;
	}
	private static boolean solveNQueensUntil(int col){
		if(col>=N)
			return true;
		for(int i=0; i<N; i++){
			if(checkPosition(i, col)){
				board[i][col] = 1;
				if(solveNQueensUntil(col + 1))
					return true;
				board[i][col] = 0;
			}
		}
		return false;
	}
	private static void solveNQueens(){
		if(!solveNQueensUntil(0)){
			System.out.println("Unsolvable Pattern.!");
			return;
		}
		printBoard();
	}
	public static void main(String args[]){
		solveNQueens();
	}
}
