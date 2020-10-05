import java.util.Scanner;

class CharacterRhombusStructure{

	public static void main(String args[]){
	
		Scanner scan= new Scanner(System.in);
		System.out.print("Input the numbers :");
		int number = scan.nextInt();
		for(int i=0;i<=(2*number+1)/2;i++){
			char c = 'A';
			for(int j=0;j<=(2*i+1)/2;j++)
				System.out.print(c++);
			c--;
			for(int j=((2*i+1)/2);j<=2*i-1;j++)
				System.out.print(--c);
			System.out.println();
		} for(int i=(2*number+1)/2;i>0;i--) {
			char c ='A';
			for(int j=(2*i+1)-1;j>(2*i+1)/2;j--)
				System.out.print(c++);
			c--;
			for(int j=((2*i+1)/2)-1;j>0;j--)
				System.out.print(--c);
			System.out.println();
		}
		scan.close();
	}
}
