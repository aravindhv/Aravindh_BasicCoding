import java.util.Scanner;

public class InchToMeter{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input a value for inch : ");
		float inch=scan.nextFloat();
		System.out.printf("%1.1f inch is %1.1f meters.\n",inch,(inch * 0.0254));
		scan.close(); 
	}
}
