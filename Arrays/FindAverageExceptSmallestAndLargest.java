import java.util.Scanner;

class FindAverageExceptSmallestAndLargest{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements to be inserted : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements :");
		array[0] = scan.nextInt();
		int min = array[0];
		int max = array[0];
		for(int i=1; i<size; i++){
			array[i] = scan.nextInt();
			if(array[i] < min)
				min = array[i];
			else if(array[i] > max)
				max = array[i];
		}
		float sum = 0;
		for(int i=0; i<size; i++){
			if(array[i] != max && array[i]!= min)
				sum+=array[i];
		}
		System.out.println("Average of Elements except Maximum and Minimum elements is "+ (sum/(size-2)));
	}
}
