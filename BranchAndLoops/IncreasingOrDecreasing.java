import java.util.Scanner;

class IncreasingOrDecreasing{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input first number :");
		int first = scan.nextInt();
		System.out.print("Input Second Number :");
		int second = scan.nextInt();
		System.out.print("Input Third number :");
		int third = scan.nextInt();
		
		System.out.println((first<second && second<third)?"Increaing order":(first>second && second>third)?"Decreasing Order":"Neither increasing or Decreasing Order.");
		scan.close();
	}
}
