import java.util.Scanner;

class FindLongestConsequetive{

	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter the number of Elements : ");
		short size = scan.nextShort();
		int array[] = new int[size];
		System.out.println("Enter "+size+" Elements :");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
		}
		System.out.println("Maximum length of Consequtive elements in array is "+findLongestConsequence(array));
	}
	
	static int findLongestConsequence(int array[]){
		int len = 0;
		for(int i=0; i<array.length; i++){
			int value = array[i];
			for(int k=0; k<array.length; k++){
				if(array[k] == value){
					value++;
					k=-1;
				}
			}
			len = (len>value-array[i])?len:value-array[i];
		}
		return len;
	}
}
