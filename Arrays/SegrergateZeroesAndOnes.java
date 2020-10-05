import java.util.Scanner;

class SegrergateZeroesAndOnes{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of elements to be inserted : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements : ");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		for(int i=0; i<size-1; i++){
			for(int j=i+1; j<size; j++){
				if(array[i] ==1 && array[j]==0)
				{
					array[i] = array[i]^array[j];
					array[j] = array[i]^array[j];
					array[i] = array[i]^array[j];
				}
			}
		}
		for(Integer i:array)
			System.out.print(i+" ");
		System.out.println();
	}
}
