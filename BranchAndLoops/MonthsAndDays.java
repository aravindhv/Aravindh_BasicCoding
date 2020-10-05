import java.util.Scanner;

class MonthsAndDays{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		String months[]={"","January","February","March","April","May","June","July","August","september","October","November","December"};
		System.out.print("Input a month number :");
		int month = scan.nextInt();
	
		System.out.print("Input a year :");
		int year = scan.nextInt();
		int day=0;
		if(month==2)
			day = year%4==0?(year%100 == 0 ? (year%400== 0?29:28): 29):28;
		else if(month > 0 && month <=12)
			switch (month){
				case 1:
				case 5:
				case 7:
				case 8:
				case 10:
				case 12: day = 31;
					break;
				case 3:
				case 4:
				case 6:
				case 9:
				case 11: day = 30;
					break;
			}
		else
			System.out.println("Invalid month number .!");

		System.out.println(months[month] + " " + year +" has "+ day +" days.");
		scan.close();
	}
}
