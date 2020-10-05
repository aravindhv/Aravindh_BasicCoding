import java.util.Arrays;
import static java.lang.System.out;
import java.util.Scanner;

class XOXGame{
	private static Scanner scan = new Scanner(System.in);
	public static void main(String args[]){
	
		char board[][] = new char[3][3];
		int steps = 0;
		for(char arr[] : board)
			Arrays.fill(arr, '-');
		out.println("\nBOARD VIEW :\n");
		displayBoard(board);
		while(isPending(board)){
			steps++;
			letsPlay(board, steps);
		}
		out.println("\n\n================= Match Drawn =================\n\n");
	}
	private static void letsPlay(char [][]board, int steps){
		out.println((steps % 2 == 0)? "Player Two : ":"Player One : ");
		out.print("Enter Position : ");
		int row = scan.nextInt();
		int column = scan.nextInt();
		if(row > 2 || row < 0 || column > 2 || row < 0){
			out.println(" *** Invalid Position *** \n *** Try other Position *** ");
			letsPlay(board, steps);
			return;
		}
		if(board[row][column] != '-'){
			out.println(" *** Position Already Occupied *** \n *** Try other Position *** ");
			letsPlay(board, steps);
			return;
		}
		board[row][column] = (steps % 2 == 0 ? 'X':'O');
		displayBoard(board);
		if(justifyLastMove(board, row, column)){
			out.println(steps % 2 == 0 ? "\n================= Player 2 Wins..!! =================\n": "\n================= Player 1 Wins..!!!=================\n");
			System.exit(0);
		}
	}
	private static boolean isPending(char [][]board){
		int count = 0;
		for(char[] line: board)
			for(char elements: line)
				if(elements != '-')
					count++;
		if(count != board.length*board.length)
			return true;
		return false;
	}
	private static void displayBoard(char [][]board){
		for(char i[] :board){
			for(char j : i)
				out.print(j+" ");
			out.println();
		}
	}
	private static boolean justifyLastMove(char [][]board, int row, int column){
		int count = 1;
		if(row == 0 && column == 0 || row == 2 && column == 2 || row == 2 && column == 0 || row == 0 && column == 2 || row == 1 && column == 1){
			count = topLeftToBottomRight(board, board[row][column]);
			if(checkWinOrNot(count))return true;
			count = topRightToBottomLeft(board, board[row][column]);
			if(checkWinOrNot(count))return true;
			count = rightToLeft(board, board[row][column], row);
			if(checkWinOrNot(count))return true;
			count = topToDown(board, board[row][column], column);
			if(checkWinOrNot(count))return true;
		} else {
			count = rightToLeft(board, board[row][column], row);
			if(checkWinOrNot(count))return true;
			count = topToDown(board, board[row][column], column);
			if(checkWinOrNot(count))return true;
		}
		return false;
	}
	private static boolean checkResult(char [][]board, int row, int column, int y_axis, int x_axis){
		if(x_axis < 0 || x_axis >= board.length || y_axis < 0 || y_axis >= board.length)
			return false;
		else if(board[row][column] == board[y_axis][x_axis])
			return true;
		return false;
	}
	private static boolean checkWinOrNot(int count){
		if(count == 3)
			return true;
		return false;
	}
	private static int topLeftToBottomRight(char board[][], char element){
		int count = 0;
		for(int i=0; i<3; i++)
			if(board[i][i] == element)
				count++;
			else
				return count;
		return count;
	}
	private static int topRightToBottomLeft(char [][]board, char element){
		int count = 0;
		for(int i=0; i<3; i++)
			if(board[i][board.length-i-1] == element)
				count++;
			else
				return count;
		return count;
	}
	private static int rightToLeft(char [][]board, char element, int row){
		int count = 0;
		for(int i=0; i<3; i++){
			if(board[row][i] == element)
				count++;
			else
				return count;
		}
		return count;
	}
	private static int topToDown(char [][]board, char element, int column){
		int count = 0;
		for(int i=0; i<3; i++){
			if(board[i][column] == element)
				count++;
			else
				return count;
		}
		return count;
	}
}
