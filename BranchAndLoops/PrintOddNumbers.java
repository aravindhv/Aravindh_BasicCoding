import java.util.Scanner;

class PrintOddNumbers{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input number of terms is :");
		int terms = scan.nextInt();
		int sum = 0;
		System.out.println("The odd numbers are :");
		for(int i=0;i<terms;i++){
			sum+=(2*i)+1;
			System.out.println((2*i)+1);
		}
		System.out.println("The Sum of odd Natural Number upto "+ terms +" terms is: "+ sum);
		scan.close();
	}
}
