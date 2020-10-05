import java.util.Scanner;

class FindNthPerfectNumber{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter n value to find nth Perfect number : ");
		int n = scan.nextInt();
		System.out.println(n +"th Perfect Number is "+findNthPerfect(n));
	}
	static int findNthPerfect(int n){
		int count = 0;
		for(int current = 19;true;current+=9){
			int sum = 0;
			for(int x=current; x>0; x/=10)
				sum +=(x%10);
			if(sum == 10)
				count++;
			if(count == n)
				return current;
		}
	}
}
