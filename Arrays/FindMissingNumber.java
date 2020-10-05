import java.util.Scanner;

class FindMissingNumber{
	static int diff = 0;
	static float ratio = 1;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Number of Elements to be entered : ");
		int size = scan.nextInt();
		int array[] = new int[size];
		int sum = 0;
		System.out.print("Enter Array Elements : ");
		for(int i=0; i<size; i++){
			array[i] = scan.nextInt();
			sum+=array[i];
		}
		if(isArithmeticProgression(array)){
			System.out.println("Missing Element is "+(((((float)size+1)/2)*((2*array[0]+size*diff)))-sum));
		}
		else if(isGeometricProgression(array))
			if(ratio != 1 && ratio > 1)
				System.out.println("Missing Element is "+((array[0]*((float)(1-Math.pow(ratio, size+1))/(1-ratio)))-sum));
			else if(ratio != 1 && ratio < 1)
				System.out.println("Missing Element is "+((array[0]*((float)(Math.pow(ratio, size+1)-1)/(ratio-1)))-sum));
	}
	
	static boolean isArithmeticProgression(int array[]){
		for(int i=0; i+2<array.length; i++){
			diff = array[i+1]-array[i];
			int diff2 = array[i+2]-array[i+1];
			if(diff == diff2)
				return true;
		}
		return false;
	}
	static boolean isGeometricProgression(int array[]){
		for(int i=0; i+2<array.length; i++){
			ratio = (float)array[i+1]/array[i];
			float ratio2 = (float)array[i+2]/array[i+1];
			if(ratio == ratio2)
				return true;
		}
		return false;
	}
}

//((size+1)/2)*((2*array[0]+size*diff));
//array[0]*((1-Math.pow(ratio, size+1))/(1-ratio))
//array[0]*((Math.pow(ratio, size+1)-1)/ratio-1)
