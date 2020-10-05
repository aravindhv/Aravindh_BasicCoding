import java.util.Scanner;

class MoveAllZerosToLast{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Number of Array Elements : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		int result[] = new int[size];
		System.out.println("Enter Array Elements :");
		int jCount = 0;
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			if(array[i]!=0)
				result[jCount++] = array[i];
		}
		array = result;
		System.out.println("Resultant Array :");
		for(int i=0; i<size; i++)
			System.out.print(array[i]+" ");
	}
}
