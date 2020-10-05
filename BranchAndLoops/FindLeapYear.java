import java.util.Scanner;

class FindLeapYear{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input the Year :");
		int year =scan.nextInt();
		System.out.println(year + " is " + (year%4==0?(year%100 == 0 ? (year%400== 0?"a leap year.":"not a leap year."): "a leap year."):"not a leap year."));
		scan.close();
	}
}
