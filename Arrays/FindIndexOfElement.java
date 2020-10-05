import java.util.Scanner;

class FindIndexOfElement{

	public static void main(String args[]){
	
		Scanner scan= new Scanner(System.in);
		System.out.print("Enter the size of Array :");
		int size  = scan.nextInt();
		int arr[] = new int[size];
		System.out.print("Enter the Array Elements :");
		for(int i = 0;i<size ;i++)
			arr[i] = scan.nextInt();
		System.out.print("Enter the key to search :");
		int index = isFound(scan.nextInt(),arr);
		System.out.println(size>index?("Key Found at "+ (index+1) +"th index."):"Key Not Found.");
	}
	static int isFound(int key,int arr[]){
		int i=0;
		for(i=0;i<arr.length;i++)
			if(arr[i]==key) return i;
		return i;
	}
}
