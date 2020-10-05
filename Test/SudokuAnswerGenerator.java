class SudokuAnswerGenerator{
	public static void main(String args[]){
		int [][]puzzle = {{5,3,4,6,7,0,9,1,2},
				  {6,7,2,1,9,5,3,4,0},
				  {1,9,8,3,0,2,5,6,7},
				  {0,5,9,7,6,1,4,2,3},
				  {4,2,6,0,5,3,7,9,1},
				  {7,1,3,9,2,4,0,5,6},
				  {9,6,1,5,3,7,2,0,4},
				  {2,0,7,4,1,9,6,3,5},
				  {3,4,5,2,0,6,1,7,9}};
		for(int i=0; i<puzzle.length; i++){
			for(int j=0; j<puzzle[i].length; j++){
				if(puzzle[i][j]==0)
					generateValue(puzzle, i, j);
			}
		}
	}
	static int generateValue(int [][]puzzle, int row, int col){
		
	}
}
