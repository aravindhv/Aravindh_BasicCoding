import java.util.Scanner;

class MyString{
	String string;
	MyString(String string){
		this.string = string;
	}
	String concat(String str){
		string +=str;
		return string;
	}
	char charAt(int index){
		char []array = string.toCharArray();
		for(int i=0; i<string.length(); i++){
			if(i == index)
				return array[i];
		}
		System.out.println("String index out Of Bounds.!");
		return '\u0000';
	}
	boolean endsWith(String suffix){
		int stringLen = string.length();
		int suffixLen = suffix.length();
		while(suffixLen > 0 ){
			if(string.charAt(--stringLen) != suffix.charAt(--suffixLen))
				return false;
		}
		return true;
	}
	static String copyValueOf(char []data){
		String str = "";
		for(char i : data)
			str += i;
		return str;
	}
	int indexOf(String str){
		for(int i=0; i< string.length(); i++){
			if(str.charAt(0) == string.charAt(i)){
				int localCount = 0;
				for(int j=0; j<str.length(); j++){
					if(str.charAt(j) != string.charAt(i+j)){
						break;
					}
					localCount++;
				}
				if(localCount == str.length()){
					return i;
				}
			}
		}
		return -1;
	}
	boolean startsWith(String prefix){
		if(prefix.length() > string.length()) return false;
		for(int i=0; i<prefix.length(); i++){
			if(string.charAt(i)!=prefix.charAt(i))
				return false;
		}
		return true;
	}
	String substring(int beginIndex){
		String temp = "";
		for(int i=beginIndex; i<string.length(); i++)
			temp+=string.charAt(i);
		return temp;
	}
}
class MyStringMain{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter Primary String : ");
		MyString string = new MyString(scan.next());
		while(true){
			System.out.print("\n1.Concat\n2.CharAt\n3.endsWith\n4.startsWith\n5.copyValueOf\n6.indexOf\n7.subString\n8.Exit\nEnter Choice : ");
			int choice = scan.nextInt();
			switch(choice){
				case 1:	System.out.print("Enter String to Concat : ");
					System.out.println(string.concat(scan.next()));
					break;
				case 2: System.out.print("Enter Index Of String : ");
					char index = string.charAt(scan.nextInt());
					System.out.println(index != ' ' ? index : "Not Found.!");
					break;
				case 3: System.out.print("Enter Suffix to Check : ");
					System.out.println(string.endsWith(scan.next()));
					break;
				case 4: System.out.print("Enter Prefix to Check : ");
					System.out.println(string.startsWith(scan.next()));
					break;
				case 5: System.out.print("Enter Array Size : ");
					char[] array = new char[scan.nextInt()];
					for(int i=0; i<array.length; i++)
						array[i] = scan.next().charAt(0);
					System.out.println(MyString.copyValueOf(array));
					break;
				case 6: System.out.print("Enter substring to check index : ");
					int position = string.indexOf(scan.next());
					System.out.println(position != -1 ? position : "Not Found.!");
					break;
				case 7:	System.out.print("Enter Index to Check : ");
					System.out.println(string.substring(scan.nextInt()));
					break;
				case 8: System.exit(0);
				default: System.out.println("Invalid Input Choice..!");
			}
		}
	}
}
