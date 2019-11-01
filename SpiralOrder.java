import java.util.Scanner;

class SpiralOrder{
	public static void main(String args[]){
		int array[][] = {{1 ,2 ,3 ,4 ,5},
				 {6 ,7 ,8 ,9 ,10},
				 {11,12,13,14,15},
				 {16,17,18,19,20}};
				/*{{1 ,2 ,3 ,4 ,5},
				 {6 ,7 ,8 ,9 ,10},
				 {11,12,13,14,15},
				 {16,17,18,19,20},
				 {21,22,23,24,25}};*/
		
		int top = 0, bottom = array.length-1, left = 0, right = array[0].length-1, dir = 1;
		while(top<=bottom && left<=right){
			if(dir == 1){
				for(int j=left; j<=right; j++)
					System.out.print(array[top][j]+" ");
				top++;
				dir = 2;
			}
			else if(dir == 2){
				for(int i=top; i<=bottom; i++)
					System.out.print(array[i][right]+" ");
				right--;
				dir = 3;
			}
			else if(dir == 3){
				for(int j=right; j>=left; j--)
					System.out.print(array[bottom][j]+" ");
				bottom--;
				dir = 4;
			}
			else if(dir == 4){
				for(int i=bottom; i>=top; i--)
					System.out.print(array[i][left]+" ");
				left++;
				dir = 1;
			}
		}
		System.out.println();
	}
}
