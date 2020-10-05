import java.util.Scanner;

public class FindGreatest{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input the 1st number :");
		int first = scan.nextInt();
		System.out.print("Input the 2nd number :");
		int second = scan.nextInt();
		System.out.print("Input the 3rd number :");
		int third = scan.nextInt();
	
		if(first > second && first > third)
			System.out.println("The greatest : " + first);
		else if(second > first)
			if(second > third)
				System.out.println("The greatest : " + second);
			else if(third > first)
				System.out.println("The greatest : " + third);
		scan.close();
	}
}
