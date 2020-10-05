import java.util.Scanner;

class CopyArrayElementsWithIteration{
	public static void main(String args[]){
		
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be Inserted :");
		int size = scan.nextInt();
		int arr[] = new int[size];
		int copy[] = new int[size];
		
		for(int i=0; i<size; i++)
			arr[i] = scan.nextInt();
		
		for(int i=0; i<size; i++)
			copy[i] = arr[i];
		System.out.println("Copied Array ;");
		for(Integer i: copy)
			System.out.print(i+" ");
		System.out.println();
	}
}
