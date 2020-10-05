import java.util.Scanner;

class BreakAnInteger{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input six non-negative digits :");
		String num = scan.next();
		char numArr[]=new char[num.length()];
		for(int i=0;i<num.length();i++)
			numArr[i]=(char)(num.charAt(i)-'0');
		for(Character i:numArr)
			System.out.print((int)i+" ");
		System.out.println();
		scan.close();
	}
}
