import java.util.Scanner;

class CountDigits{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input an integer number less than ten billion :");
		long number = scan.nextLong();
		if(number < 10000000000L){
			int count = 0;
			long temp = number;
			while(temp!=0){
				count++;
				temp/=10;
			}
			System.out.println("Number of digits in this number: "+ count);
		} else
			System.out.println("Invalid Input.!");
		scan.close();
	}
}
