import java.util.Scanner;

class HalfDiamond{

	public static void main(String[] args){
	
		Scanner scan = new Scanner(System.in);
		System.out.println("Input number of rows (half of the diamond) :");
		int rows = scan.nextInt();
		for(int i=0;i<rows;i++){
			for(int j=1;j<=((2*i)+1);j++)
				System.out.print("*");
			System.out.println();
		}
		for(int i=rows-2;i>=0;i--){
			for(int j=0;j<rows-1;j++)
				System.out.print(" ");
			for(int j=((2*i)+1);j>=1;j--)
				System.out.print("*");
			System.out.println();
		}
		scan.close();
	}
}
