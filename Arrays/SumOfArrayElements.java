import java.util.Scanner;

class SumOfArrayElements{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Size of Array :");
		int size = scan.nextInt();
		int arr[] = new int[size];
		int sum = 0;
		for(int i=0;i<size;i++){
			arr[i] = scan.nextInt();
			sum+=arr[i];
		} System.out.println("Sum of Array Elements : "+ sum);
	}
}
