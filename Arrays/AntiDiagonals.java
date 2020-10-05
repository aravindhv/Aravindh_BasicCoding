import java.util.Scanner;

class AntiDiagonals{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		//System.out.print("Enter Number of elements to be entered : ");
		int size = 5;//scan.nextInt();
		int array[][] = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		//{{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20},{21,22,23,24,25}};
		//new int[size][size];
		int count = 2*size-1;
		int generalArray[][] = new int[count][];

		System.out.println("Enter Array Elements :");
		/*for(int i=0; i<size; i++)
			for(int j=0; j<size; j++){
				System.out.print("Enter array["+ (i+1) +"]["+ (j+1) +"] = ");
				array[i][j] = scan.nextInt();
		}*/

		for(int i=0; i<count; i++)
			if(i < (count/2)+1)
				generalArray[i] = new int[i+1];
			else
				generalArray[i] = new int[count-i];
		
		System.out.println();
		System.out.println("Anti Diagonal Elements are :");
		for(int i=0; i<size; i++){
			for(int j=0; j<=i; j++){
				generalArray[i][j] = array[j][i-j];
				System.out.printf("%3d",generalArray[i][j]);
			}
			System.out.println();
		}
		for(int i=size; i<count; i++){
			int column = 0;
			for(int j=0; j<size; j++){
				for(int k=0; k<size; k++){
					if(j+k == i){
						generalArray[i][column] = array[j][k];
						System.out.printf("%3d",generalArray[i][column]);
						column++;
						break;
					}
				}
			}
			System.out.println();
		}
	}
}
