import java.util.Scanner;

class LargestProductOfThreeElements{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be inserted : ");
		int size = scan.nextInt();
		if(size < 3){
			System.out.println("Invalid Array Size for this Operation.");
			return;
		}
		int array[] = new int[size];
		System.out.println("Enter array elements :");
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		findPossibleMultiples(array);
	}
	static void findPossibleMultiples(int array[]){
		int max = array[0]*array[1]*array[2];
		int product[] = new int[3];
		product[0] = 0;
		product[1] = 1;
		product[2] = 2;
		for(int i=0; i<array.length-2; i++)
			for(int j=i+1; j<array.length-1; j++)
				for(int k=j+1; k<array.length; k++)
					if(array[i]*array[j]*array[k] > max){
						product[0] = i;
						product[1] = j;
						product[2] = k;
						max = array[i]*array[j]*array[k];
					}
		System.out.println("Products of "+ array[product[0]] +","+ array[product[1]] +" and "+ array[product[2]] +" is "+ max);
	}
}
