import java.util.Scanner;

class FindDuplicateStrings{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be Inserted : ");
		int size = scan.nextInt();
		String arr[] = new String[size];
		int duplicate[] = new int[size];
		System.out.print("Enter the Array Elemets : ");
		for(int i=0; i<size; i++){
			arr[i] = scan.next();
			duplicate[i] = -1;
		}
		System.out.println("Duplicate Strings are :");
		duplicate = findDuplicateStrings(arr,duplicate);
		for(int i=0; i<size; i++){
			if(duplicate[i]>1)
				System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	static int[] findDuplicateStrings(String arr[], int duplicate[]){
		for(int i=0; i<arr.length; i++){
			int count = 1;
			for(int j=i+1; j<duplicate.length; j++){
				if(arr[j].equals(arr[i])){
					count++;
					duplicate[j] =0;
				}
			}
			if(duplicate[i] != 0) {
				duplicate[i] = count;
			}
		}
		return duplicate;
	}
}
