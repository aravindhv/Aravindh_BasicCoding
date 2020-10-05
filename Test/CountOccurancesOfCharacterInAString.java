class CountOccurancesOfCharacterInAString{
	public static void main(String args[]){
		String word = "aravindhan";
		char letter = 'a';
		int count = 0;
		for(int i=0; i < word.length(); i++){
			if(word.charAt(i) == letter)
				count++;
		}
		System.out.println("Total occurances of "+ letter +" in "+ word +" is "+ count);
	}
}
