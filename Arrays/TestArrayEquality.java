import java.util.Scanner;

class TestArrayEquality{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of elements to be entered : ");
		int size = scan.nextInt();
		int array1[] = new int[size];
		int array2[] = new int[size];
		boolean duplicate[] = new boolean[size];
		System.out.println("Enter Array 1 Elements :");
		for(int i=0; i<size; i++){
			array1[i] = scan.nextInt();
		}
		System.out.println("Enter Array 2 Elements :");
		for(int i=0; i<size; i++)
			array2[i] = scan.nextInt();
		if(checkEquality(array1, array2,duplicate))
			System.out.println("Both Arrays has Same Elements.");
		else
			System.out.println("Array Mismatching Elements found.");
	}
	
	static boolean checkEquality(int array1[], int array2[], boolean duplicate[]){
		boolean present[] = new boolean[array1.length];
		for(int i=0; i<array1.length; i++){
			for(int j=0; j<array2.length; j++){
				if(array1[i] == array2[j] && !duplicate[j]){
					present[i] = true;
					duplicate[j] = true;
					break;
				}
			}
			if(present[i] == false)
				return false;
		}
		return true;
	}
}
