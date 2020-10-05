import java.util.Scanner;

class AtTheRateSymbolPattern{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the number :");
		int rows = scan.nextInt();
		for(int i=0;i<=rows;i++){
			for(int j=0;j<i;j++)
				System.out.print("@");
			System.out.println();
		}
		scan.close();
	}
}
