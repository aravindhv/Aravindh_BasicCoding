import java.util.Scanner;

class CheckArrayDoesnotContainsValue{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Number of VAlues to be inserted : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter the Array Elements : ");
		boolean minusOne = false;
		boolean zero = false;
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			if(!minusOne && array[i] == -1)
				minusOne = true;
			else if(!zero && array[i] == 0)
				zero = true;
		}
		if(minusOne && zero)
			System.out.println("Yes, Both -1 and 0 is Present in the Array.");
		else if(minusOne)
			System.out.println("Only -1 element is Present.");
		else if(zero)
			System.out.println("Only 0 element is present.");
		else
			System.out.println("No 0's or -1's present in this Array.");
		
	}
}
