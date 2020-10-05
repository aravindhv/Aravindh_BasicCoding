import static java.lang.System.out;
import java.util.Scanner;
import java.util.Arrays;

class Minesweeper{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		out.println("******MINESWEEPER GAME (8X8) ******");
		char UIMatrix[][] =  new char[8][8];
		for(int i=0; i<8; i++)
			Arrays.fill(UIMatrix[i], '0');
		out.print("Enter number of mines to be entered : ");
		int mines = scan.nextInt();
		out.println("Enter "+ mines +" positions :");
		for(int i=0; i<mines; i++){
			out.print("Enter mine position in row and Column(0-"+ (UIMatrix.length-1) +") : ");
			int row = scan.nextInt();
			int column = scan.nextInt();
			if(row < 0 || row > UIMatrix.length-1 || column < 0 || column > UIMatrix.length-1){
				out.println("Invalid Positions.!");
				return;
			}
			UIMatrix[row][column] = 'X';
		}
		getMinesCount(UIMatrix);
		out.println("\n\nYour UI will be looks like :");
		for(int i=0; i<UIMatrix.length; i++){
			for(int j=0; j<UIMatrix.length; j++)
				out.printf("%3c",UIMatrix[i][j]);
			out.println();
		}
	}
	private static void getMinesCount(char array[][]){
		for(int i = 0; i < array.length; i++){
			for(int j = 0; j < array.length; j++){
				if(array[i][j]!=-1){
					if(i == 0 && j == 0){
						for(int pos = 4; pos<=6; pos++)
							countMines(array, pos, i, j);
					} else if(i==0 && j!=array.length-1){
						for(int pos = 4; pos<=6; pos++)
							countMines(array, pos, i, j);
						for(int pos = 7; pos<=8; pos++)
							countMines(array, pos, i, j);
					} else if(i==0 && j==array.length-1){
						for(int pos = 6; pos<=8; pos++)
							countMines(array, pos, i, j);
					} else if(j==0 && i!=array.length-1){
						for(int pos = 2; pos<=6; pos++)
							countMines(array, pos, i, j);	
					} else if(j==0 && i==array.length-1){
						for(int pos = 2; pos<=4; pos++)
							countMines(array, pos, i, j);
					} else if(i == array.length-1 && j == array.length-1){
						for(int pos = 1; pos<=2; pos++)
							countMines(array, pos, i, j);
						countMines(array, 8, i, j);
					} else if(j == array.length-1){
						countMines(array, 1, i, j);
						countMines(array, 2, i, j);
						for(int pos = 6; pos<=8; pos++)
							countMines(array, pos, i, j);
					} else if(i == array.length-1 && j!=0 && j!=array.length-1){
						for(int pos = 1; pos<=4; pos++)
							countMines(array, pos, i, j);
						countMines(array, 8, i, j);
					} else {
						for(int pos=1; pos<=8; pos++)
							countMines(array, pos, i, j);
					}
				}
			}
		}
	}
	private static void countMines(char array[][], int position, int row, int column){
		switch(position){
		case 1: if(array[row-1][column-1]=='X')
				array[row][column]++;
			break;
		case 2: if(array[row-1][column]=='X')
				array[row][column]++;
			break;
		case 3: if(array[row-1][column+1]=='X')
				array[row][column]++;
			break;
		case 4: if(array[row][column+1]=='X')
				array[row][column]++;
			break;
		case 5: if(array[row+1][column+1]=='X')
				array[row][column]++;
			break;
		case 6: if(array[row+1][column]=='X')
				array[row][column]++;
			break;
		case 7: if(array[row+1][column-1]=='X')
				array[row][column]++;
			break;
		case 8: if(array[row][column-1]=='X')
				array[row][column]++;
			break;
		}
	}
}
