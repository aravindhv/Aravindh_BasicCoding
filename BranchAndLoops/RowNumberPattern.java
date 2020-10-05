import java.util.Scanner;

class RowNumberPattern{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input Number of Rows :");
		int number = scan.nextInt();
		for(int i=1;i<=number;i++){
			for(int j=1;j<=i;j++)
				System.out.print(i);
			System.out.println();
		}
		scan.close();
	}
}
