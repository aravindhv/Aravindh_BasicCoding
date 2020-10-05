import java.util.Scanner;

class SumOfDigits{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input an integer between 0 and 1000:");
		int num = scan.nextInt();
		int temp=num;
		int dig=0;
		for(int i=0;i<3;i++){
			dig+=num%10;
			num=num/10;
		}
		System.out.println("The sum of all digits in "+ temp +" is "+dig);
		scan.close();
	}
}
