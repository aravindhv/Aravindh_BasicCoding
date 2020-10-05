import java.util.Scanner;

public class DisplayNAccordToMVal{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input a number :");
		int m = scan.nextInt();
		int num = (m > 0?1:(m < 0 ? -1: 0));
	
		System.out.println("The value of m = "+(float)m);
		System.out.println("The value of n = "+num);
		scan.close();
	}
}
