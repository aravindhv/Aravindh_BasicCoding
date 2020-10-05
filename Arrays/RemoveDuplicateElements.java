import java.util.Scanner;

class RemoveDuplicateElements{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the Number of Elements to be Inserted : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		int duplicate[] = new int[size];
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			duplicate[i] = -1;
		}
		duplicate = findDuplicte(array, duplicate);
		int count=0;
		for(int i=0; i<duplicate.length; i++)
			if(duplicate[i] != 0)
				count++;
		int unique[] = new int[count];
		count = 0;
		for(int i=0; i<size; i++){
			if(duplicate[i] != 0)
				unique[count++] = array[i];
		}
		array = unique;
		for(Integer i : array)
			System.out.print(i+" ");
		System.out.println();
		System.out.println("Length of the Array is "+ array.length);
	}
	
	static int[] findDuplicte(int array[], int duplicate[]){
		for(int i=0; i<array.length; i++){
			int count = 1;
			for(int j=i+1; j<array.length; j++){
				if(array[i] == array[j]){
					count++;
					duplicate[j] = 0;
				}
			}
			if(duplicate[i] != 0){
				duplicate[i] = count;
			}
		}
		return duplicate;
	}
}
