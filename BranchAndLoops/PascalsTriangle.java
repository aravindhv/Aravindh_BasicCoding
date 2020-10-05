import java.util.Scanner;

class PascalsTriangle{

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Input Number as Rows :");
		int rows = scan.nextInt();
		int c = 0;
		
		for(int i=0;i<rows;i++){
		
			for(int j=0;j<=i;j++){
				if(i==j || j==0)
					c = 1;
				else
					c=(c*(i-j+1))/j;
				System.out.print(c+" ");
			}
			System.out.println();
		}
		scan.close();
	}
}
