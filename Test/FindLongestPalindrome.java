class FindLongestPalindrome{
	public static void main(String args[]){
		String word = "dadmymaamknowmalaya";
		String longestPalindrome = "";
		int maxSize = 0;
		int currentSize = -1;
		for(int i=0; i<word.length(); i++){
			for(int j=word.length()-1; j>=i; j--){
				if(word.charAt(i)==word.charAt(j))
					currentSize = checkIsStringOrNot(word.substring(i,j+1));
				if(maxSize < currentSize){
					maxSize = currentSize;
					longestPalindrome = word.substring(i,j+1);
				}
			}
		}
		System.out.println("Longest Palindrome is "+longestPalindrome);
	}
	private static int checkIsStringOrNot(String string){
		int i=0, j=string.length()-1;
		while(i<=j && string.charAt(i) == string.charAt(j)){
			i++;
			j--;
		}
		if(i>=j)
			return string.length()-1;
		else
			return -1;
	}
}
