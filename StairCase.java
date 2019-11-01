import java.util.Scanner;

class StairCase{
	static int countSteps = 0;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of stairs : ");
		int stairs = scan.nextInt();
		System.out.print("Enter number of Possible ways : ");
		int possiblities = scan.nextInt();
		System.out.print("Enter Possible Steps : ");
		int ways[] = new int[possiblities];
		for(int i = 0; i < possiblities; i++)
			ways[i] = scan.nextInt();
		String path = "";
		checkStairs(path, stairs, ways);
		
		System.out.println("\nTotal Number of Possiblities : "+ countSteps +".");
	}
	static void checkStairs(String path, int stairs, int ways[]){
		if(stairs == 0){
			countSteps++;
			System.out.println(path);
			return;
		}
		for(int i=0; i < ways.length; i++)
			if(stairs >= 0)
				checkStairs(path+ways[i]+" ", stairs-ways[i], ways);
		return;
	}
}
