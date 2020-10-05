import java.util.Scanner;

class CountNumberOfRotations{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		System.out.println("Array elemets are "+countRotations(array)+" times.");
	}
	
	static int countRotations(int array[]){
		int count = 0, ref_value = array[0];
		for(int i=0; i<array.length; i++){
			if(ref_value > array[i]){
				ref_value = array[i];
				count = i;
			}
		}
		return count;
	}
}
