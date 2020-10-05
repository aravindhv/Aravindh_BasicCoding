class CheckIfAPalindrome{
	public static void main(String args[]){
		String word = "a";
		if(checkRecursion(word, 0, word.length()-1))
			System.out.println(word + " is a Palindrome.");
		else
			System.out.println(word +" is not a Palindrome.");
	}
	private static boolean checkRecursion(String word, int first_index, int last_index){
		if(word.length() == 1)
			return true;
		else if(first_index == last_index)
			return true;
		if(first_index < last_index){
			if(word.charAt(first_index) == word.charAt(last_index) || word.charAt(first_index)-32 == word.charAt(last_index)||word.charAt(first_index)+32 == word.charAt(last_index))
				return checkRecursion(word, first_index+1, last_index-1);
			else if(word.charAt(first_index) != word.charAt(last_index))
				return false;
		}	
		return true;
	}
}
