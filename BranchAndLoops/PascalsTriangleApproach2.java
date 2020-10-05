import java.util.Scanner;
import static java.lang.System.out;

class PascalsTriangleApproach2{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		out.print("Enter number of lines : ");
		int length = scan.nextInt();
		int array[][] = new int[length][length];
		for(int i=0; i<length; i++){
			for(int j=0; j<length-i-1; j++){
				out.print(" ");
			}
			for(int j=0; j<=i; j++){
				if(j==0 || i==j)
					array[i][j] = 1;
				else
					array[i][j] = array[i-1][j-1]+array[i-1][j];
				out.print(array[i][j]+" ");
			}
			out.println();
		}
	}
}
