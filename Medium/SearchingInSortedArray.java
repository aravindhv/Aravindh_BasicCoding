import java.util.Scanner;

class SearchingInSortedArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter array elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		System.out.print("Enter Key to Search : ");
		int key = scan.nextInt();
		search(array, key);
	}
	static void search(int []array, int key){
		int low = 0;
		int high = array.length-1;
		while(low<=high){
			int mid = (low + high)/2;
			if(array[mid] == key){
				System.out.println("Key found at "+ mid +"th Position.");
				return;
			}
			else if(array[mid] > key)
				high = mid;
			else if(array[mid] < key)
				low = mid;
		}
		System.out.println("Key Not Found.");
	}
}
