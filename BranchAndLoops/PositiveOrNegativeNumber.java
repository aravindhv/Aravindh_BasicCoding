import java.util.Scanner;

class PositiveOrNegativeNumber{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input number :");
		int number = scan.nextInt();
		System.out.println("Number is "+(number>0?"positive":"negative"));
		scan.close();
	}
}
