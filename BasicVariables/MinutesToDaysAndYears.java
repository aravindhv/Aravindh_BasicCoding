import java.util.Scanner;

class MinutesToDaysAndYears{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input the number of minutes: ");
		int minutes=scan.nextInt();
		int days = minutes/(24*60);
		int years = (int)(minutes / (365*24*60));
		System.out.println(minutes +" minutes is approximately "+ years + " years and "+ (int)(days-(years * 365)) +" days.");
		scan.close();
	}
}
