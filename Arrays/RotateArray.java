import java.util.Scanner;

class RotateArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Integer :");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements : ");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		int temp = array[size-1];
		for(int i=size-1; i>0; i--){
			array[i] = array[i-1];
		}
		array[0] = temp;
		System.out.println("Rotated Array :");
		for(Integer i : array)
			System.out.print(i+" ");
		System.out.println();
	}
}
