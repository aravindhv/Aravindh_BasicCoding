import java.util.Scanner;

class FindCombinations{
	public static void main(String args[]){
		//Scanner scan = new Scanner(System.in);
		int numbers[] = new int[]{2,3};
		String keyPad[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
		char []result = new char[numbers.length];
		//System.out.print("Enter Keypad Number to find all Combinations : ");
		//int number = scan.nextInt();
		findCombinations(0, numbers, keyPad, result);		
	}
	static void findCombinations(int index, int[]numbers, String []keyPad, char []result){
		if(index == result.length){
			System.out.println(result);
			return;
		}
		for(int i=0; i< keyPad[numbers[index]].length(); i++){
			result[index] = keyPad[numbers[index]].charAt(i);
			findCombinations(index+1, numbers, keyPad, result);
		}
	}
}
