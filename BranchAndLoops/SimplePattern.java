import java.util.Scanner;

class SimplePattern{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input number of rows : ");
		int number = scan.nextInt();
		for(int i=1;i<=number;i++){
			for(int j=1;j<=i;j++)
				System.out.print(j);
			System.out.println();
		}
		scan.close();
	}
}
