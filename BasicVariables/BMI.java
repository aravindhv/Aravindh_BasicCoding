import java.util.Scanner;

class BMI{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input weight in pounds : ");
		int weight = scan.nextInt();
		
		System.out.print("Input height in inches : ");
		int height=scan.nextInt();
		
		double bmi = (weight*0.45359237)/(height*0.0254*height*0.0254);
		System.out.println("Body Mass Index is :"+bmi);
		
		scan.close();
	}
}
