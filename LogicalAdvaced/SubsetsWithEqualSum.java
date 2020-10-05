import java.util.Scanner;

class SubsetsWithEqualSum{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		int total = 0;
		System.out.println("Enter Array Elements :");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			total += array[i];
		}
		if(total%2==0){
			int sum = total/2;
			if(hasEqualHalves(array, sum, array.length))
				System.out.println("Can Split into two halves with equal input.!");
			else
				System.out.println("Cannot Split into two halves with equal sum.!");
		} else {
			System.out.println("Cannot Split into two halves with equal sum.!");
		}
				
	}
	static boolean hasEqualHalves(int []array, int sum, int index){
		if(sum == 0)
			return true;
		if(index==0 && sum!=0)
			return false;
		if(array[index-1]>sum)
			return hasEqualHalves(array, sum, index-1);
		return hasEqualHalves(array, sum, index-1) || hasEqualHalves(array, sum-array[index-1], index-1);
	}
}
