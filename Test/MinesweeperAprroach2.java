import java.util.Scanner;
import static java.lang.System.out;
import java.util.Arrays;

class MinesweeperAprroach2{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		out.println("\n\n\n###########__ WELCOME TO MINESWEEPER ADVENTURES GAME..!__###########");
		out.print("\nEnter Board size : ");
		int size = scan.nextInt();
		char board[][] = new char [size][size];
		for(int i=0; i < board.length; i++)
			Arrays.fill(board[i], '0');
		out.print("Enter number of mines to be entered : ");
		int mines = scan.nextInt();
		out.println("Enter "+ mines +" mines position (0-"+ (size-1) +") : ");
		for(int i=0; i<mines; i++){
			out.print("Mine "+ (i+1) +" Position : ");
			int row = scan.nextInt();
			int column = scan.nextInt();
			if(row < 0 || row > board.length-1 || column < 0 || column > board.length-1){
				out.println("Invalid Mine Position..!!\nPlease Enter Valid Mine Position..!");
				i--;
				continue;
			}
			board[row][column] = 'X';
		}
		checkMines(board);
		printBoard(board);
	}
	
	private static void checkMines(char [][]array){
		for(int row=0; row < array.length; row++){
			for(int column=0; column < array[row].length; column++){
				if(array[row][column]!='X'){
					getMinesCount(array, row, column, row-1, column-1);
					getMinesCount(array, row, column, row-1, column);
					getMinesCount(array, row, column, row-1, column+1);
					getMinesCount(array, row, column, row, column+1);
					getMinesCount(array, row, column, row+1, column+1);
					getMinesCount(array, row, column, row+1, column);
					getMinesCount(array, row, column, row+1, column-1);
					getMinesCount(array, row, column, row, column-1);
				}
			}
		}
	}
	
	private static void getMinesCount(char array[][], int x_axis, int y_axis, int row, int column){
		if(row < 0 || column < 0 || row == array.length || column == array.length)
			return;
		else if(array[row][column] == 'X')
			array[x_axis][y_axis]++;
	}
	
	private static void printBoard(char board[][]){
		out.println("\n\n*******RESULTANT MINESWEEPER BOARD*******\n");
		for(int i=0; i < board.length; i++){
			for(int j=0; j < board[i].length; j++)
				//if(board[i][j] == '0')
				//	out.printf("%3c", ' ');
				//else
					out.printf("%3c", board[i][j]);
			out.println();
		}
	}
}
