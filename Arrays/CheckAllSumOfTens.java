import java.util.Scanner;

class CheckAllSumOfTens{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		System.out.println("Enter Array Elements :");
		int sum = 0;
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			if(array[i] % 10 == 0)
				sum += array[i];
		}
		System.out.println(checkThirty(sum)?"Sum of Tens is Thirty.":"Sum of Tens is Not Thirty");
	}
	static boolean checkThirty(int sum){
		if(sum == 30)
			return true;
		return false;
	}
}
