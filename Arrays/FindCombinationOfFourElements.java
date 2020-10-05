import java.util.Scanner;

class FindCombinationOfFourElements{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		if(size < 4){
			System.out.println("Invalid Array Size..!");
			return;
		}	
		int array[] = new int[size];
		System.out.println("Enter Array Elements : ");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		System.out.print("Enter Specifed Value : ");
		int target = scan.nextInt();
		boolean isPresent = getCombinations(array, "", 0, 0,target);
		/*for(int i=0; i<size-3; i++)
			for(int j=i+1; j<size-2; j++)
				for(int k=j+1; k<size-1; k++)
					for(int l=k+1; l<size; l++)
						if(target == array[i] + array[j] + array[k] + array[l]){
							System.out.println("["+ array[i] +","+ array[j] +","+ array[k] +","+ array[l]+"]");
							isPresent = false;
						}*/
		if(isPresent)
			System.out.println("No four Combinations sum found for your Specified Number.");
	}
	private static boolean getCombinations(int []array, String combination, int sum, int index, int target){
		if(sum == target){
			System.out.println(combination);
			return true;
		} else if(index == array.length)
			return false;
		else
			for(int i = index; i < array.length; i++){
				sum += array[i];
				getCombinations(array, combination+array[i], sum, index+1, target);
			}
		return false;
	}
}
