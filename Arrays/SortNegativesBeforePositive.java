import java.util.Scanner;

class SortNegativesBeforePositive{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter array elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		array = sortPositiveAndNegative(array);
		for(Integer i: array)
			System.out.print(i+" ");
		System.out.println();
	}
	static int[] sortPositiveAndNegative(int array[]){
		for(int i=0; i<array.length-1; i++){
			for(int j=i+1; j<array.length; j++){
				if(array[i]>=0 && array[j]<0){
					array[i] = array[i]^array[j];
					array[j] = array[i]^array[j];
					array[i] = array[i]^array[j];
				}
			}
		}
		return array;
	}
}
