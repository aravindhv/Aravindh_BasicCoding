import java.util.Scanner;

class FindLargeOrSmall{

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Input a number :");
		float number = scan.nextFloat();
		System.out.println((number == 0.0f)?"Zero":(number<0.0f?"Negative":(number>1000000.0f?"Positive Large":(number<1.0f)?"Positive Small":"Positive")));
		scan.close();
	}
}
