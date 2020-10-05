import java.util.Scanner;

class FindCommonElementInThreeArrays{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of elements to be entered : ");
		int size = scan.nextInt();
		System.out.println("Enter Array 1 Elements :");
		int array1[] = getInput(size);
		System.out.println("Enter Array 2 Elements :");
		int array2[] = getInput(size);
		System.out.println("Enter Array 3 Elements :");
		int array3[] = getInput(size);
		System.out.println("Common Elements are :");
		commonElements(array1, array2, array3);
		System.out.println();
	}
	
	static int[] getInput(int size){
		int array[] = new int[size];
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		return array;
	}
	static void commonElements(int array1[], int array2[], int array3[]){
		int i=0, j=0, k=0;
		while(i<array1.length && j<array2.length && k<array3.length){
			if(array1[i]==array2[j] && array2[j]==array3[k]){
				System.out.print(array1[i]+" ");
				i++;
				j++;
				k++;
			}
			else if(array1[i] < array2[j])
				i++;
			else if(array2[j] < array3[k])
				j++;
			else
				k++;
		}
	}
}
