import java.util.Scanner;

class ZigZag{
	static int traverseCount = 0;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String str = "thisisazigzag";
		int n = 4;
		fun(str, n);
	}
	static void fun(String str, int n){
		int row = 0;
		int len = str.length();
		boolean down = true;
		char [][]a = new char[n][len];
		for(int i=0; i<len; i++){
			a[row][i] = str.charAt(i);
			if(row == n-1)
				down = false;
			else if(row == 0)
				down = true;
			if(down)
				row++;
			else
				row--;
		}
		for(int i=0; i<n; i++){
			for(int j=0; j<len; j++){
				System.out.printf(a[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
