import java.util.Scanner;

class SumOfNaturalNumbers{

	public static void main(String args[]){
	
		Scanner scan= new Scanner(System.in);
		System.out.print("Input the number : ");
		int number = scan.nextInt();
	
		System.out.println("Input number : \n"+ number);
		int sum = 0;
		int temp = 0;
		System.out.println("The irst n natural number are : \n"+ number);
		while(++temp<=number) {
			sum+=temp;
			System.out.println(temp);
		}
		System.out.println("The Sum of Natural Number upto n terms :\n"+number + "" + sum);
		scan.close();
	}
}
