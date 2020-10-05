import java.util.Scanner;

class FindValueInArray{

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Size of the Array :");
		int size = scan.nextInt();
		int arr[] = new int [size];
		System.out.print("Enter Array Elements : ");
		for(int i=0; i<size; i++){
			arr[i] = scan.nextInt();
		}
		System.out.print("Enter a Key to Find :");
		System.out.println((isFound(scan.nextInt(),arr))?"Key Found.":"Key Not Found.");
	}
	static boolean isFound(int number,int arr[]){
		for(int i=0; i<arr.length ; i++){
			if(arr[i]==number) return true;
		}
		return false;
	}
}
