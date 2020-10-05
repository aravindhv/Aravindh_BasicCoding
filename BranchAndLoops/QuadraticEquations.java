import java.util.Scanner;

class QuadraticEquations{
	
	public static double squareRoot(double number){
	
		double sqrRt = number / 2;
		double temp = 0;
		while(sqrRt != temp){
			temp = sqrRt;
			sqrRt = ((number / temp) + temp)/2;
		}
		return sqrRt;
	}
	
	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("a = ");
		float a=scan.nextInt();
		System.out.print("b = ");
		float b=scan.nextInt();
		System.out.print("c = ");
		float c=scan.nextInt();
		
		double sqrRtVal = squareRoot((b*b)-(4*a*c));
		if(sqrRtVal == 0.0f)
			System.out.println("The Roots are "+ -b/(2*a) + " and "+ b/(2*a));
		else if(sqrRtVal > 0){
			double root1 = (-b-sqrRtVal)/(2*a);
			double root2 = (-b+sqrRtVal)/(2*a);
			System.out.println("The roots are "+ root2 + " and " + root1);
		}
		else
			System.out.println("The roots are "+ (-b/(2*a)) +"+i"+ sqrRtVal/(2*a) +" and "+(b/(2*a))+"+i"+ sqrRtVal/(2*a));
		scan.close();
	}
}
