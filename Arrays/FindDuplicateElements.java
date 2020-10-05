import java.util.Scanner;

class FindDuplicateElements{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of Elements to be inserted :");
		int size = scan.nextInt();
		int arr[] = new int[size];
		int duplicate[] = new int[size];
		System.out.print("Enter elements to the Array :");
		for(int i=0; i<size; i++){
			arr[i] = scan.nextInt();
			duplicate[i] = -1;
		}
		System.out.println("Duplicates are :");
		duplicate = findDuplicate(arr,duplicate);
		for(int i=0; i<size; i++){
			if(duplicate[i]>1)
				System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	static int[] findDuplicate(int arr[],int []duplicate){
	
		for(int i=0; i<arr.length; i++){
			int count = 1;
			for(int j=i+1; j<duplicate.length; j++){
				if(arr[j] == arr[i]){
					count++;
					duplicate[j] = 0;
				}
			}
			if(duplicate[i] != 0)
				duplicate[i] = count;
		}
		return duplicate;
	}
}
