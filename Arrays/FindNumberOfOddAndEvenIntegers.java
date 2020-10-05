import java.util.Scanner;

class FindNumberOfOddAndEvenIntegers{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		int evenCount = 0;
		int oddCount = 0;
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			if(array[i] % 2 == 0) evenCount++;
			else oddCount++;
		}
		System.out.println("Odd Integers count is "+ oddCount +" Even Number Count is "+ evenCount);
	}
}
