import java.util.Scanner;

class CommonElementsBetweenArrays{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be inserted : ");
		int size = scan.nextInt();
		String array1[] = new String[size];
		String array2[] = new String[size];
		int isPresent[] = new int[size];
		System.out.print("Enter Array 1 Elements : ");
		for(int i=0; i<size; i++)
			array1[i] = scan.next();
		System.out.print("Enter Array 2 Elements : ");
		for(int i=0; i<size; i++) {
			array2[i] = scan.next();
			isPresent[i] = -1;
		}
		isPresent = checkElement(isPresent, array1, array2);
		for(int i=0; i<size; i++){
			if(isPresent[i]==0)
				System.out.print(array1[i]+" ");
		}
	}
	
	static int[] checkElement(int isPresent[], String array1[], String array2[]) {
		for(int i=0; i<array1.length; i++){
			for(int j=0; j<array2.length; j++){
				if(array1[i].equals(array2[j]))
					isPresent[j] = 0;
			}
		}
		return isPresent;
	}
}
