import java.util.Scanner;

class LargestProduct{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		long array[]= new long[size];
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextLong();
		System.out.println("Maximum product from the given array is "+ maximumProduct(array));
	}
	static long maximumProduct(long []array){
		long max = Long.MIN_VALUE;
		for(int i=0; i<array.length-2; i++)
			for(int j=i+1; j<array.length-1; j++)
				for(int k=i+2; k<array.length; k++)
					if(array[i] * array[j] * array[k] > max)
						max = array[i] * array[j] * array[k];
		return max;
	}
}
