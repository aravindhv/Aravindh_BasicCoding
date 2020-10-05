import java.util.Scanner;

class FindLeadersInAnArray{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter "+size+" Elements :" );
		for(int i=0; i<size; i++)
			array[i] = scan.nextInt();
		findLeaders(array);
		
	}
	static void findLeaders(int array[]){
		int max = array[array.length-1];
		System.out.print(max+" ");
		for(int i=array.length-1; i>=0; i--){
			if(array[i] > max){
				System.out.print(array[i]+" ");
				max = array[i];
			}
		}
		System.out.println();
	}
}
