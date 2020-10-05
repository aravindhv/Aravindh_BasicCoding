import java.util.Scanner;

class ReplaceWithRightLargest{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of elements to be enetered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter array elements : ");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		array = replcaeWithNextLargest(array);
		System.out.println("Resultant Array :");
		for(Integer i: array)
			System.out.print(i+" ");
		System.out.println();
	}
	
	static int[] replcaeWithNextLargest(int []array){
		int largest ;
		for(int i=0; i<array.length-1; i++){
			largest = array[i];
			for(int j=i+1; j<array.length; j++){
				if(array[j] > largest)
					largest = array[j];
			}
			for(int j=i+1; j<array.length; j++){
				if(array[j] > array[i] && largest > array[j])
					largest = array[j];
			}
			array[i] = largest;
		}
		return array;
	}
}
