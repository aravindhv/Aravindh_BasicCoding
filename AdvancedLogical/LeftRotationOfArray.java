import java.util.Scanner;

class LeftRotationOfArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		System.out.print("Number of Rotations to be perfomed : ");
		int rotations = scan.nextInt();
		array = rotateArray(array, rotations);
		for(Integer i: array)
			System.out.print(i+" ");
		System.out.println();
	}
	static int[] rotateArray(int array[], int rotations){
		for(int i=0; i<rotations; i++){
			int temp = array[0];;
			for(int j=0; j<array.length-1; j++){
				array[j] = array[j+1];
			}
			array[array.length-1] = temp;
		}
		return array;
	}
}
