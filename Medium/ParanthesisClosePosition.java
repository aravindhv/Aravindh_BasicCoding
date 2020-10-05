import java.util.Scanner;

class ParanthesisClosePosition{
	static char stack[] = new char[0];
	static int index[] = new int[0];
	static int top = -1;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		String line = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
		System.out.println("Open Parenthesis : ");
		for(int i=0; i<line.length(); i++)
			if(line.charAt(i) == '(')
				System.out.print(i + " ");
		System.out.println();
		System.out.println("Enter the Open Parenthesis Number : ");
		int position = scan.nextInt();
		stack = new char[line.length()/2];
		index = new int[line.length()/2];
		for(int i=0; i<line.length(); i++){
			if(line.charAt(i)=='(')
				push('(', i);
			else if(line.charAt(i)==')')
				if(pop() == position){
					System.out.println("Answer : "+ i);
					return;
				}
		}
	}
	static void push(char data, int pos){
		if(top+1 >= stack.length)
			System.out.println("Irregular parenthesis.!");
		else{
			stack[++top] = data;
			index[top] = pos;
		}
	}
	static int pop(){
		if(top-1 < -1){
			System.out.println("Cannot Found.!");
			return -1;
		}
		else{
			int popped = index[top--];
			stack[top+1] = ' ';
			index[top+1] = -1;
			return popped;
		}
	}
}
