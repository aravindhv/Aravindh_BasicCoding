import java.util.Scanner;

class Tables{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the number (Table to be calculated) : Input number of terms : ");
		int number = scan.nextInt();
		for(int i=0;i<=number;i++)
			System.out.println(number +" X "+ i +" = "+(number * i));
		scan.close();
	}
}
