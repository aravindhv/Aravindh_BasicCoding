class FirstNonRepeatedCharacterInAString{
	public static void main(String args[]){
		String word = "ARAVINDH";
		for(int i=0; i < word.length(); i++){
			for(int j = word.length()-1; j>=i; j--){
				if(i!=j && word.charAt(i)==word.charAt(j))
					break;
				else if(i==j){
					System.out.println("First non repeated character is " + word.charAt(i));
					return;
				}
			}
		}
	}
}
