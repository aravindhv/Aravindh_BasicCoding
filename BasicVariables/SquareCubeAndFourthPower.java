import java.util.Scanner;

public class SquareCubeAndFourthPower{
	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Sample Input :");
		int num=scan.nextInt();
		int product = num;
		for(int i=0;i<3;i++){
			product*=num;
			if(i==0)
				System.out.println("Square :"+product);
			else if(i==1)
				System.out.println("Cube :"+product);
			else if(i==2)
				System.out.println("Fourth Power :"+product);
		}
		scan.close();
	}

}
