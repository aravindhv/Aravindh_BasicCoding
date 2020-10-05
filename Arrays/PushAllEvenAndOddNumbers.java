import java.util.Scanner;

class PushAllEvenAndOddNumbers{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements : ");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
		}
		array = sortWithOddOrEven(array);
		for(Integer i: array)
			System.out.print(i+" ");
		System.out.println();
	}
	static int[] sortWithOddOrEven(int array[]){
		for(int i=0; i<array.length-1; i++){
			for(int j=i+1; j<array.length; j++){
				if(array[i]%2!=0 && array[j]%2==0){
					array[i] = array[i]^array[j];
					array[j] = array[i]^array[j];
					array[i] = array[i]^array[j];
				}
			}
		}
		return array;
	}
}
