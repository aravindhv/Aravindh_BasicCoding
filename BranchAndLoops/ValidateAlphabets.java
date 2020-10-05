import java.util.Scanner;

class ValidateAlphabets{

	public static void main(String args[]){
	
		Scanner scan=new Scanner(System.in);
		System.out.print("Input an alphabet :");
		String alpha = scan.next();
		if(alpha.length()==1){
	
			if((alpha.charAt(0)>='a' && alpha.charAt(0)<='z') || (alpha.charAt(0)>='A'&&alpha.charAt(0)<='Z'))
				switch(alpha.charAt(0)){
					case 'a':
					case 'e':
					case 'i':
					case 'o':
					case 'u':
					case 'A':
					case 'E':
					case 'I':
					case 'O':
					case 'U': System.out.println("Input letter is Vowel."); 
						  break;
					default : System.out.println("Input letter is Consonant.");
				}
			else
				System.out.println("Only Character type data is allowded.");
	
		else 
			System.out.println("Only one Character is allowed.");
		scan.close();
	}
}
