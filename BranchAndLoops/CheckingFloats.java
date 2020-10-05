import java.util.Scanner;

class CheckingFloats{

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Input first floating point number :");
		float first = scan.nextFloat();
		System.out.print("Input second floating point number :");
		float second = scan.nextFloat();
		
		System.out.println("These numbers are "+ ((((int)(first/0.01f))==((int)(second/0.01f)))?"equal":"different"));
		scan.close();
	}
}
