import java.util.Scanner;

class PatternGrid{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input Number of rows of grids :");
		int number = scan.nextInt();
		for(int i=1;i<=number;i++){
			for(int j=1;j<=number;j++)
				System.out.print("-");
			System.out.println();
		}
		scan.close();
	}
}
