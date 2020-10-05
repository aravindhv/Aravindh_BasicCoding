import java.util.Scanner;

class ReplaceAnIntegerToGetNonDecreasingOrder{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		if(size == 1){
			System.out.println("Invalid Array Size.!");
			return;
		}
		int array[] = new int[size];
		System.out.println("Enter array elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		array = replaceArray(array);
		System.out.println("We can make an array in non-decreasing order by replacing an element.!");
		System.out.println("Sorted Array is :");
		for(Integer i: array)
			System.out.print(i+" ");
		System.out.println();
	}
	
	static int[] replaceArray(int []array){
		int count = 1;
		for(int i=0; i<array.length; i++){
			if(count > 2) failed();
			else if(i==0 && array[i]>array[i+1]){
				array[0] = array[i+1]-1;
				if(++count > 2) failed();
			}
			else if(i == array.length-1 && array[i]<array[i-1]){
				array[i] = array[i-1]+1;
				if(++count > 2) failed();
			}
			else if((i>0 && i<array.length-1) && array[i] > array[i+1]){
				array[i] = (array[i+1]+array[i-1])/2;
				//System.out.println(i+"->"+array[i]);
				if(++count > 2) failed();
				//i=-1;
			}
		}
		/*for(Integer i: array)
			System.out.println(i);*/
		return array;
	}
	static void failed(){
		System.out.println("Cannot perform the operation.!");
		System.exit(0);
	}
}
