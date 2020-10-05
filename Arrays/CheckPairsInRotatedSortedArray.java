import java.util.Scanner;

class CheckPairsInRotatedSortedArray{
	static int indexCount = 0;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements : ");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		System.out.print("Enter number to be specified : ");
		int target = scan.nextInt();
		int diff = findAscendingOrDescending(array);
		
//		if(diff >= 0){
			for(int i=indexCount-1; i<size-1; i++){
				if(array[i]+array[i+1] == target){
					System.out.println("Pairs found.\n["+ array[i] +","+ array[i+1]+"]");
					break;
				}
			}
			if(array[size-1]+array[0] == target)
				System.out.println("Pairs found.\n["+ array[0] +","+ array[size-1]+"]");
			else
				for(int i=0; i<indexCount; i++){
					System.out.println("Pairs found.\n["+ array[i] +","+ array[i+1]+"]");
					break;
				}
		/*}
		else if(diff < 0 && diff!=Integer.MIN_VALUE){
			for(int i=0; i>=indexCount-1; i--)
		}
		else{
			
		}*/
		
	}
	static int findAscendingOrDescending(int array[]){
		for(int i=0; i<array.length-2; i++){
			indexCount++;
			int diff = array[i+2]-array[i+1];
			if(array[i+1]-array[i] > 0 &&  diff>0)
				return diff;
		}
		return Integer.MIN_VALUE;
	}
}
