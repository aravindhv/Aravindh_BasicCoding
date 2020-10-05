import java.util.Scanner;

class FloydsTriangle{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input number of rows :");
		int number = scan.nextInt();
		for(int i=1;i<=number ;i++){
			for(int j=1;j<=i;j++)
				System.out.print((i+j)%2==0?1:0);
			System.out.println();
		}
		scan.close();
	}
}
