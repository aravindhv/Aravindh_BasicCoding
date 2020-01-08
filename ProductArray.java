import java.util.Scanner;

public class ProductArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of elements to be entered : ");
		int size = scan.nextInt();
		int product = 1;
		int array[] = new int[size];
		System.out.println("Enter array elements : ");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			product *= array[i];
		}
		array = createNewArray(array, product);
		for(Integer i: array)
			System.out.print(i+" ");
		System.out.println();
	}
	private static int[] createNewArray(int []array, int product){
		int length = array.length;
		int left[] = new int[length];
		int right[] = new int[length];
		left[0] = right[length-1] = 1;
		for(int i=1; i<length; i++)
			left[i] = left[i-1] * array[i-1];
		for(int i=length-2; i>=0; i--)
			right[i] = right[i+1] * array[i+1];
		for(int i=0; i<length; i++)
			array[i] = left[i] * right[i];
		return array;
	}
}
