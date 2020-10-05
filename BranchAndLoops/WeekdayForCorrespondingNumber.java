import java.util.Scanner;

class WeekdayForCorrespondingNumber{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input Number :");
		int number = scan.nextInt();
	
		int generated = number % 7;
		String days[]={"Monday","Tuesday","Wednesday","Thursday","Friday","Saturday","Sunday"};
		System.out.println(generated > 0 ? days[generated-1]: days[generated+6]);
		scan.close();
	}
}
