import java.util.Scanner;

class IncreasedElementPattern{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input Number of Rows :");
		int number = scan.nextInt();
		int count =0;
		for(int i=0; i<number; i++){
	
			for(int j=0;j<i;j++)
				System.out.print(++count + " ");
			System.out.println();
		}
		scan.close();
	}
}
