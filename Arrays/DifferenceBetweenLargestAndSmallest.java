import java.util.Scanner;

class DifferenceBetweenLargestAndSmallest{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array elements :");
		array[0] = scan.nextInt();
		int max = array[0];
		int min = array[0];
		for(int i=1; i<size; i++){
			array[i] = scan.nextInt();
			if(min > array[i])
				min = array[i];
			else if(max < array[i])
				max = array[i];
		}
		System.out.println("Difference between Largest and Smallest Integers is "+(max-min));
	}
}
