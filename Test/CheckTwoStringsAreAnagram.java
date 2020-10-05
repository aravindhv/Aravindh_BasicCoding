import static java.lang.System.out;

class CheckTwoStringsAreAnagram{
	public static void main(String arsg[]){
		String word1 = "bad credit";
		String word2 = "debit card";
		if(word1.length() != word2.length()){
			out.println("Not a Anagram.!");
			return;
		}
		boolean check[] = new boolean[word1.length()];
		for(int i=0; i < word1.length(); i++){
			for(int j=0; j < word2.length(); j++){
				if(word1.charAt(i)==word2.charAt(j) && check[j]==false){
					check[j] = true;
					break;
				}
			}
		}
		for(boolean i: check)
			if(i==false){
				out.println("Not a Anagram.!");
			}
		out.println(word1 +" and "+ word2 +" are Anagrams.!");
	}
}
