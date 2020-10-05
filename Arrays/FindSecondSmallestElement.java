import java.util.Scanner;

class FindSecondSmallestElement{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Number of Element to be inserted : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		array[0] = scan.nextInt();
		int min = array[0];
		int secondMin = Integer.MAX_VALUE;
		for(int i=1; i<size; i++){
			array[i] = scan.nextInt();
			if(min > array[i]){
				secondMin = min;
				min = array[i];
			} else if(min < array[i] && secondMin > array[i])
				secondMin = array[i];
		}
		System.out.println("Second smallest element in this Array is "+secondMin+" and Smallest value is "+min);
	}
}
