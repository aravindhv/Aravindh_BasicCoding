import java.util.Scanner;

public class TwoIntegerFunctions{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input 1st integer :");
		int firstNum=scan.nextInt();
		
		System.out.print("Input 2nd integer :");
		int secondNum=scan.nextInt();
		
		System.out.println("Sum of two integers :"+(firstNum + secondNum));
		System.out.println("Difference of two integers :"+(firstNum - secondNum));
		System.out.println("Product of two integers :"+(firstNum*secondNum));
		System.out.println("Average of two integers :"+((float)(firstNum+secondNum))/2);
		System.out.println("Distance of two integers :"+(firstNum>secondNum?firstNum-secondNum:secondNum-firstNum));
		System.out.println("Max integer :"+(firstNum>secondNum?firstNum:secondNum));
		System.out.println("Min integer :"+(firstNum>secondNum?secondNum:firstNum));
		scan.close();
	}
}
