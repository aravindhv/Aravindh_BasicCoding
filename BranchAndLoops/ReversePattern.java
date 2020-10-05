import java.util.Scanner;

class ReversePattern{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input the Number :");
		int rows = scan.nextInt();
		for(int i=0;i<rows;i++){
			for(int j=rows;j>i;j--)
				System.out.print("*");
			System.out.println();
		}
		scan.close();
	}
}
