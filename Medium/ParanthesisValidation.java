import java.util.Scanner;

class Stack{
	int size;
	char arr[];
	int top;
	public Stack(int size){
		this.size = size;
		arr = new char[size];
		top = -1;
	}
	public void push(char value){
		if(top < size)
			arr[++top] = value;
		else 
			System.out.println("Stack overflow..!");
	}
	public char pop(){
		if(top >= 0){
			char temp = arr[top--];
			arr[top+1] = ' ';
			return temp;
		} else {
			System.out.println("Stack is Empty..!!");
			return ' ';
		}
	}
	public boolean empty(){
		if(top==-1)
			return true;
		else
			return false;
	}
}

class ParanthesisValidation{
	static Stack stack;
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter number of elements to be entered : ");
		int size = scan.nextInt();
		stack = new Stack(size);
		System.out.println("Enter Array Elements :");
		validation(((scan.next()).toCharArray()));
	}
	static void validation(char array[]){
		char current;
		int count = 0;
		for(char c:array){
			if(c == '{' || c == '(' || c == '['){
				System.out.println(++count);
				stack.push(c);
			}
			else if(c == '}' || c == ')' || c == ']'){
				if(stack.empty()){
					System.out.println("Unbalanced Paranthesis..!");
					return;
				}
				else if(c == '}'){
					current = stack.pop();
					if(current != '{'){
						System.out.println("Unbalanced Paranthesis..!");
						return;
					}
				}else if(c == ']'){
					current = stack.pop();
					if(current != '['){
						System.out.println("Unbalanced Paranthesis..!");
						return;
					}
				}else if(c == ')'){
					current = stack.pop();
					if(current != ')'){
						System.out.println("Unbalanced Paranthesis..!");
						return;
					}
				}
			}
		}
		if(stack.empty())
			System.out.println("Balanced Parenthesis..!");
		else
			System.out.println("Unbalanced Paranthesis..!");
	}
}
