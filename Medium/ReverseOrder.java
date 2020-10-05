import java.util.Scanner;

class ReverseOrder{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		char array[] = new char[size];
		System.out.println("Enter array elements : ");
		for(int i=0; i<size; i++)
			array[i] = scan.next().charAt(0);
		array = reverse(array);
		for(Character i:array)
			System.out.print(i+" ");
		System.out.println();
	}
	static char[] reverse(char []array){
		char []reversed = new char[array.length];
		for(int i=0; i<array.length; i++){
			reversed[array.length-i-1] = array[i];
		}
		return reversed;
	}
}
