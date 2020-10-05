import java.util.Scanner;

class AverageOfArrayElements{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Size of Array :");
		int size =  scan.nextInt();
		int array[] = new int[size];
		int sum = 0;
		System.out.print("Enter Array Elements :");
		for(int i=0;i<size; i++){
			array[i] = scan.nextInt();
			sum += array[i];
		}
		System.out.println("Average of Array Elemets : "+((float)sum/size));
	}
}
