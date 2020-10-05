import java.util.Scanner;

class DistanceByTime{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input distance in meters :");
		int distance = scan.nextInt();
		
		System.out.print("Input Hour :");
		int hours =scan.nextInt();
		
		System.out.print("Input minutes :");
		int minutes = scan.nextInt();
		
		System.out.print("Input seconds :");
		int seconds = scan.nextInt();
		
		int totalSeconds = seconds + (minutes * 60) + (hours * 3600);
		float meterBySeconds = (float)distance/totalSeconds;
		float totalHours = hours+((float)minutes/60)+((float)seconds/3600);
		System.out.println("Your Speed in meters/second is "+ meterBySeconds);
		
		float kmph=(((float)distance)/1000)/totalHours;
		System.out.println("Your speed in km/h is "+kmph);
		
		float mph = (float)((float)distance/1609)/totalHours;
		System.out.println("Your speed in m/h is "+mph);
		
		scan.close();
	}

}
