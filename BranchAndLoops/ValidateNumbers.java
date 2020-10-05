import java.util.Scanner;

class ValidateNumbers{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		int number = scan.nextInt();
		System.out.println("Number is "+(number==0?"zero":number<0?"negative":"positive"));
		scan.close();
	}
}
