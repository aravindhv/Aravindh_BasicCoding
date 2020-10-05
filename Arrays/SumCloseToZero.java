import java.util.Scanner;

class SumCloseToZero{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements : ");
		array[0] = scan.nextInt();
		array[1] = scan.nextInt();
		int minimumSum = array[0] + array[1];
		int currentSum, firstIndex = 0, secondIndex = 0;
		for(int i=2; i<size; i++)
			array[i] = scan.nextInt();
		for(int i=0; i<size-1; i++){
			for(int j=i+1; j<size; j++){
				currentSum = array[i]+array[j];
				if(Math.abs(currentSum) < Math.abs(minimumSum)){
					minimumSum = currentSum;
					firstIndex = i;
					secondIndex = j;
				}
			}
		}
		System.out.println("Sum Nearest to Zero :");
		for(int i=0; i<size-1; i++){
			for(int j=i+1; j<size; j++){
				if(Math.abs(minimumSum) == Math.abs(array[i]+array[j]))
					System.out.println("("+ array[i] +","+ array[j] +")");
			}
		}
		
//		System.out.println("The Minimum Number Sum nearly to Zeroes are "+ array[firstIndex] +" and "+ array[secondIndex]);
	}
}
