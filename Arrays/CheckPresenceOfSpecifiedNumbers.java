import java.util.Scanner;

class CheckPresenceOfSpecifiedNumbers{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int scan = scan.nextInt();
		boolean isSixtyFive = false;
		boolean isSeventySeven = false;
		int []array = new int[size];
		System.out.println("Enter Array Elements : ");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			if(array[i] == 65)
				isSixtyFive = true;
			else if(array[i] == 77)
				isSeventySeven = true;
		}
		if(isSixtyFive && isSeventySeven)
			System.out.println("Both specified numbers are present.");
		else if(isSixtyFive)
			System.out.println("Only 65 is Present.");
		else if(isSeventySeven)
			System.out.println("Only 77 is present.");
		else
			System.out.println("None of both specified elements is present.");
	}
}
