import java.util.Scanner;

class RhombusStructure{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input the number : ");
		int number = scan.nextInt();
	
		for(int i=0; i<=(2*number-1)/2; i++){
			int temp = i+1;
		
			for(int j=0; j<(number-1-i); j++)
				System.out.print(" ");
		
			for(int j=0;j<=((2*i)+1)/2;j++)
				System.out.print(temp--);
		
			temp++;
		
			for(int j=((2*i)-1)/2;j<((2*i)-1);j++)
				System.out.print(++temp);
		
			System.out.println();
		}
		for(int i=((2*number-1)/2); i>0; i--){
		
			int temp = i;
		
			for(int j=0; j<(number-i); j++)
				System.out.print(" ");
		
			for(int j=0;j<=((2*i)-1)/2;j++)
				System.out.print(temp--);
		
			temp++;
		
			for(int j=(((2*i)-1)/2);j<((2*i)-1)-1;j++)
				System.out.print(++temp);
		
			System.out.println();
		}
		scan.close();
	}
}
