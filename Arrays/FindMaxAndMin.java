import java.util.Scanner;

class FindMaxAndMin{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be inserted :");
		int size = scan.nextInt();
		int min=0 , max = 0;
		int arr[] = new int[size];
		System.out.print("Enter the Array Elements :");
		arr[0] = scan.nextInt();
		max = arr[0];
		min = arr[0];
		for(int i=1; i<size; i++){
			arr[i] = scan.nextInt();
			if(arr[i]>max)
				max = arr[i];
			else if(arr[i] < min)
				min = arr[i];
		}
		System.out.println("Maximum value in the Array is "+max+" and Miimum is "+min);
	}
}
