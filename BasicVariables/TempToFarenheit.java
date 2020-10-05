import java.util.Scanner;

class TempToFarenheit {
	
	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input a degree in Farenheit :");
		float degree=scan.nextFloat();
		float celcius = (degree - 32.0f)*(5.0f/9);
		System.out.printf("%1.1f degree Frenheit is equal to %1.1f in Celcius.\n",degree,celcius);
		scan.close();
	}
}
