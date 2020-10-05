import java.util.Scanner;

class Summa{
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[]){
		CheckStatic arr[] = new CheckStatic[10];
		for(int i=0; i < 10; i++){
			arr[i] = new CheckStatic(i);
			CheckStatic.count = i;
			System.out.println("Instance Count : "+ arr[i].num);
		}
		System.out.println("static count   : "+ CheckStatic.count);
		System.out.println("Enter Number to Change arr[5] : ");
		CheckStatic.count = scan.nextInt();
		arr[5].cal();
		System.out.println("Calculated Value : "+arr[5].num);
	}
}
class CheckStatic{
	int num;
	static int count = 5;
	CheckStatic(int num){
		this.num = num;
	}
	void cal(){
		num +=count;
	}
}
