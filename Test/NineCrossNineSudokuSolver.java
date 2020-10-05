import java.util.Scanner;

class NineCrossNineSudokuSolver{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int [][]sudoku = {{3,1,6,5,0,8,4,9,2},
				  {5,2,9,1,3,4,7,6,8},
				  {4,8,7,6,2,9,5,3,1},
				  {2,6,3,4,1,0,9,8,7},
				  {9,0,4,8,6,3,1,2,5},
				  {8,5,1,7,9,2,6,4,3},
				  {1,3,8,9,4,7,2,0,6},
				  {0,9,2,3,5,1,8,7,4},
				  {7,4,5,2,8,6,3,1,0}};
		int answers[] = new int[9];
		System.out.println("Enter answers : ");
		/*for(int i=0; i<sudoku.length; i++){
			answers[i] = scan.nextInt();
			if(answers[i] < 1 || answers[i] > 9){
				System.out.println("Wrong Answer.!");
				return;
			}
		}*/
		displayPuzzle(sudoku);
		checkIsValid(answers, sudoku);
		displayPuzzle(sudoku);
	}
	private static void checkIsValid(int []answers, int [][]array){
		boolean isOk = false;
		int count = -1;
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				if(array[i][j] == 0){
					int value = 0;
					count++;
					int iteration = 0;
					while(!isOk && value <=  8){
						isOk = checkIsCorrect(array, i, j, value+1);// && checkInSubMatrix(array, i, j, value+1);
						if(!isOk && value+1 <= 9)
							value++;
						System.out.println("Iterations "+ ++iteration + "value "+ value);
					}
					isOk = false;
					array[i][j] = ++value;
				}
			}
		}
		System.out.println("Correct Answer.!");
	}
	private static boolean checkIsCorrect(int [][]array, int row, int col, int answer){
		//System.out.println("("+row+","+col+")");
		for(int i=0; i<array.length; i++){
			if(array[row][i] == answer)
				return false;
			if(array[i][col] == answer)
				return false;
			if(((row == col) && array[i][i] == answer) || (col == array.length-row-1 && array[i][array.length-i-1] == answer))
				return false;
		}
		return true;
	}
	private static boolean checkInSubMatrix(int [][]array, int row, int col, int answer){
		int i = row <= 2 ? 0:(row <= 5)?3:6;
		int rowMax = i+3;
		int j = col <= 2 ? 0:(col <= 5)?3:6;
		int colMax = j+3;
		for(i=i; i<rowMax; i++){
			for(j=j; j<colMax; j++)
				if(array[i][j]==answer)
					return false;
		}
		return true;
	}
	private static void displayPuzzle(int [][]array){
		for(int i=0; i < array.length; i++){
			for(int j=0; j < array[i].length; j++)
				System.out.printf("%3d", array[i][j]);
			System.out.println();
		}
	}
}
