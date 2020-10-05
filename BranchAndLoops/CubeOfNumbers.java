import java.util.Scanner;

class CubeOfNumbers{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input number of terms :");
		int terms = scan.nextInt();
	
		for(int i=1;i<=terms;i++)
			System.out.println("Number is : "+ i +" and cube of "+ i +" is : "+(i*i*i));
		scan.close();
	}
}
