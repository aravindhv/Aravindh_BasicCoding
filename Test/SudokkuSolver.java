import java.util.Scanner;

class SudokkuSolver{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		int sudoku[][] = {{1,2,3},
				  {2,0,1},
				  {3,1,0}};
		System.out.print("Enter two missing Numbers : ");
		int answers[] = new int[2];
		answers[0] = scan.nextInt();
		answers[1] = scan.nextInt();
		if((answers[0]>3||answers[0]<0) || (answers[1]>3||answers[1]<0)){
			System.out.println("Wrong Answer.!");
			return;
		}
		validateAnswers(sudoku, answers);
	}
	static void validateAnswers(int array[][], int answers[]){
		int count = -1;
		boolean isOk[] = new boolean[2];
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[i].length; j++){
				if(array[i][j] == 0){
					++count;
					isOk[count] = checkIsValid(answers[count], i, j, array);
					if(!isOk[count]){
						System.out.println("Wrong Answer.!");
						return;
					}
				}
			}
		}
		if(isOk[0] && isOk[1])
			System.out.println("Correct Answer.!");
	}
	static boolean checkIsValid(int answer, int row, int col, int array[][]){
		for(int i=0; i<array[row].length; i++){
			if(array[row][i]==answer)
				return false;
			if(array[i][col]==answer)
				return false;
		}
		return true;
	}
}
