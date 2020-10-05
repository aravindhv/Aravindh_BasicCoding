import java.util.Scanner;

class PossibleWays{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of rows and columns : ");
		int m = scan.nextInt();
		int n = scan.nextInt();
		System.out.println("Total number of ways are "+numberOfWays(0, 0, m, n));
	}
	static int numberOfWays(int x_axis, int y_axis, int m, int n){
		if(x_axis == m || y_axis == n)
			return 1;
		else
			return numberOfWays(x_axis+1, y_axis, m, n) + numberOfWays(x_axis, y_axis+1, m, n);
	}
}
