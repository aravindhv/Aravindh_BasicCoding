import java.util.Scanner;

class Summa{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Your Name : ");
		String name = scan.nextLine();
		System.out.print("Enter Your Favourite : ");
		String fav = scan.nextLine();
		System.out.println("Your Name is : "+ name);
		System.out.println("Your Favourite is : "+ fav);
	}
}
