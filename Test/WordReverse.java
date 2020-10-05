class WordReverse{
	public static void main(String args[]){
		String word = "I LOVE INDIA.";
		String arr[] = splitWords(word);
		for(int i=0;i<arr.length; i++)
			System.out.print(arr[arr.length-i-1]+" ");
		System.out.println();
	}
	static String[] splitWords(String word){
		String []str = new String[0];
		for(int i=0; i<word.length(); i++){
			String temp = "";
			while((i+1)!=word.length() && word.charAt(i)!=' '){
				temp+=word.charAt(i);
				i++;
			}
			str = setStringArray(temp, str);
		}
		return str;
	}
	static String [] setStringArray(String temp, String []str){
		String tempArr[] = new String[str.length+1];
		for(int i=0; i<str.length; i++){
			tempArr[i] = str[i];
		}
		tempArr[tempArr.length-1] = temp;
		return tempArr;
	}
}
