import java.util.Scanner;

class FindCommonStringsBetweenTwoArrays{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be inserted :");
		int size = scan.nextInt();
		String array1[] = new String[size];
		String array2[] = new String[size];
		int duplicate[] = new int[size];
		System.out.print("Enter String elements to the first Array :");
		for(int i=0; i<size; i++){
			array1[i] = scan.next();
			duplicate[i] = -1;
		}
		System.out.print("Enter String elements to the second Array :");
		for(int i=0; i<size; i++){
			array2[i] = scan.next();
		}
		String common[] = findCommonElements(array1, array2, duplicate);
		duplicate = findDuplicateInUnique(common, duplicate);
		for(int i=0; i<common.length; i++){
			if(duplicate[i]!=0 && common[i]!=null)
				System.out.print(common[i]+" ");
		}
		System.out.println();
	}
	
	static String[] findCommonElements(String array1[], String array2[], int duplicate[]){
		String common[] = new String[array1.length];
		for(int i=0; i<array1.length; i++){
			boolean isPresent = true;
			for(int j=0; j<array2.length; j++){
				if(array1[i].equals(array2[j])){
					common[i] = array1[i];
					isPresent = false;
				}
			}
			if(isPresent){
				common[i] = null;
			}
		}
		return common;
	}
	
	static int[] findDuplicateInUnique(String[] common, int[] duplicate){
		for(int i=0; i<common.length; i++){
			int count = 1;
			for(int j=i+1; j<common.length; j++){
				if(common[i] == common[j]){
					count++;
					duplicate[j] = 0;
				}
			}
			if(duplicate[i] != 0)
				duplicate[i] = count;
		}
		return duplicate;
	}
}
