import java.util.Scanner;

class AddTwoMatrices{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter Number of Rows and Columns :");
		int rows = scan.nextInt();
		int column = scan.nextInt();
		int array1[][] = new int[rows][column];
		System.out.println("Enter Array 1 Elements :");
		for(int i=0; i<rows; i++){
			for(int j=0; j<column; j++){
				System.out.print("Array1 ["+i+"]["+j+"] = ");
				array1[i][j] = scan.nextInt();
			}
		}
		int array2[][] = new int[rows][column];
		for(int i=0; i<rows; i++){
			for(int j=0; j<column; j++){
				System.out.print("Array2 ["+i+"]["+j+"] = ");
				array2[i][j] = scan.nextInt();
			}
		}
		System.out.println("Sum od Two Matrices :");
		for(int i=0; i<rows; i++){
			for(int j=0; j<column; j++){
				System.out.print(array1[i][j]+array2[i][j]+" ");
			}
			System.out.println();
		}
	}
}
