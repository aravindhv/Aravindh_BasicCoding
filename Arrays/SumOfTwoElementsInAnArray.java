import java.util.Scanner;

class SumOfTwoElementsInAnArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
		}
		System.out.print("Enter Specified Value : ");
		int value = scan.nextInt();
		for(int i=0; i<size; i++){
			for(int j=i+1; j<size; j++){
				if(array[i]+array[j] == value)
					System.out.println("("+array[i]+","+array[j]+")");
			}
		}
	}
}
