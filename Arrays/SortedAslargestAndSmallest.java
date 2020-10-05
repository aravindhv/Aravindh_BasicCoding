import java.util.Scanner;

class SortedAslargestAndSmallest{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter array elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		array = sortedArray(array);
		System.out.println("Resultant Array :");
		for(Integer i: array)
			System.out.print(i+" ");
		System.out.println();
	}
	static int[] sortedArray(int array[]){
		int referenceArray[] = new int[array.length];
		for(int i=0; i<array.length-1; i++){
			for(int j=i+1; j<array.length; j++){
				if(array[i]<array[j]){
					array[i] = array[i]^array[j];
					array[j] = array[i]^array[j];
					array[i] = array[i]^array[j];
				}
			}
		}
		int i=0, j=array.length-1, index=0,count=1;
		while(i<=j){
			referenceArray[index++] = array[i++];
//			System.out.println("Index = "+ index +" i = "+ i + " j = "+j);
			if(i<j)
				referenceArray[index++] = array[j--];
//			System.out.println("Index = "+ index +" i = "+ i + " j = "+j);
		}
		return referenceArray;
	}
}
