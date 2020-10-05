import java.util.Scanner;

class FindSecondLargestElement{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Number of Elements to be Inserted : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter the Array Elements : ");
		array[0] = scan.nextInt();
		int max = array[0];
		int secondMax = Integer.MIN_VALUE;
		for(int i=1; i<size; i++){
			array[i] = scan.nextInt();
			if(array[i] > max){
				secondMax = max;
				max = array[i];
			}
			else if(array[i]<max && array[i]>secondMax)
				secondMax = array[i];
		}
		System.out.println("Second Maximum Element in this array is "+secondMax);
	}
}
