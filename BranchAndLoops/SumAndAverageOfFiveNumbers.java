import java.util.Scanner;

class SumAndAverageOfFiveNumbers{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the 5 numbers :");
		int numbers[] = new int[5];
		int sum = 0;
		for(int i=0;i<5;i++)
			sum+=numbers[i] = scan.nextInt();
		System.out.println("Input the 5 numbers : ");
		for(int i=0;i<5;i++)
			System.out.println(numbers[i]);
		System.out.println("The sum of 5 no is :"+ sum);
		System.out.println("The average is "+((float)sum/5));
		scan.close();
	}
}
