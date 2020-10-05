import java.util.Scanner;

class FindSimilarity{

	public static void main(String args[]){
	
		Scanner scan = new Scanner(System.in);
		System.out.print("Input first number :");
		int first = scan.nextInt();
		System.out.print("Input second number :");
		int second = scan.nextInt();
		System.out.print("Input third number :");
		int third = scan.nextInt();
		
		System.out.println((first==second && second==third)?"All numbers are equal":(first==second || second==third || first==third)?"Neither all are equal or different":"All numbers are different.");
		scan.close();
	}
}
