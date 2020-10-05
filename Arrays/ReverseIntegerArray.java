import java.util.Scanner;

class ReverseIntegerArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be Inserted :");
		int size = scan.nextInt();
		System.out.println("Enter the Array Elements :");
		int arr[] = new int[size];
		int rev[] = new int[size];
		for(int i=0; i<size; i++){
			arr[i] = scan.nextInt();
			rev[size-i-1] = arr[i];
		}
		arr = rev;
		for(Integer i:arr)
			System.out.print(i+" ");
	}
}
