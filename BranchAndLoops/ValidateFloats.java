import java.util.Scanner;

class ValidateFloats{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input floating point number :");
		float num1 = scan.nextFloat();
		System.out.print("Input floating-point another number :");
		float num2 = scan.nextFloat();
	
		if((int)(num1/0.001) == (int)(num2/0.001))
			System.out.println("They are same.");
		else 
			System.out.println("They are different.");
		scan.close();
	}
}
