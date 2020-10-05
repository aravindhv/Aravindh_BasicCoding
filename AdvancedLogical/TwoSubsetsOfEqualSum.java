import java.util.Scanner;

class TwoSubsetsOfEqualSum{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		int sum = 0, total = 0;
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			total += array[i];
		}
		sum = total/2;
		if(total%2 != 0)
			System.out.println("Cannot find Subsets with Equal Sum.!");
		else 
			if(findEqualSubsets("", array, sum, array.length))
				System.out.println("It is possible to split the Array with two subsets with equal sums.!");
			else
				System.out.println("Cannot find Subsets with Equal Sum.!");
	}
	static boolean findEqualSubsets(String subset, int []array, int sum, int index){
		if(sum == 0){
			System.out.println(subset);
			return true;
		}
		if(index == 0 && sum!=0)
			return false;
		if (array[index-1] > sum)
			return findEqualSubsets(subset, array, sum, index-1);
		return findEqualSubsets(subset, array, sum, index-1) || findEqualSubsets(subset+array[index-1]+" ", array, sum-array[index-1], index-1);
	}
}
