import java.util.Scanner;

class ClockwiseSpiral{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of rows and column :");
		int size = scan.nextInt();
		int array[][] = new int[size][size];
		array = assignElements(array);
		printArray(array);
	}
	static int[][] assignElements(int array[][]){
		int left = 0, right = array.length-1, top = 0, bottom = array.length-1, dir = 1, count=1;
		
		while(left<=right && top<=bottom){
			if(dir == 1){
				for(int i=left; i<=right; i++)
					array[top][i] = count++;
				top++;
				dir = 2;
			} else if(dir == 2){
				for(int i=top; i<= bottom; i++)
					array[i][right] = count++;
				right--;
				dir = 3;
			} else if(dir == 3){
				for(int i=right; i>=left; i--)
					array[bottom][i] = count++;
				bottom--;
				dir = 4;
			} else if(dir == 4){
				for(int i=bottom; i>=top; i--)
					array[i][left] = count++;
				left++;
				dir = 1;
			}
		}
		return array;
	}
	static void printArray(int array[][]){
		for(int i=0; i<array.length; i++){
			for(Integer a: array[i])
				System.out.printf("%3d ",a);
			System.out.println();
		}
	}
}
