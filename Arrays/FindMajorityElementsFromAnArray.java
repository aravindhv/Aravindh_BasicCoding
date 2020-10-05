import java.util.Scanner;

class FindMajorityElementsFromAnArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
		}
		int longest = 0;
		int longestIndex = -1; 
		int count = 0;
		int maxCount = 0;
		for(int i=0; i<size-1; i++){
			for(int j=i+1; j<size; j++){
				if(array[i] == array[j]){
					count++;
					if(count > array.length/2){
						longest = array[i];
						longestIndex = i;
						maxCount = count;
					}
				}
			}
		}
		
		if(longestIndex!=-1)
			System.out.println("Majority Element in this array is "+array[longestIndex]+" repeated for "+ maxCount +" times.");
		else
			System.out.println("No Majority elements in this array.");
	}
}
