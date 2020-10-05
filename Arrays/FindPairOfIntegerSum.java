import java.util.Scanner;

class FindPairOfIntegerSum{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of Elements to be inserted :");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter the Array Elements :");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
		}
		System.out.print("Enter the Element to be Specified :");
		int element = scan.nextInt();
		for(int i=0; i<size; i++){
			for(int j=i+1; j<size; j++){
				if(array[i]+array[j] == element)
					System.out.println("("+ array[i] +","+ array[j] +")");
			}
		}
	}
}
