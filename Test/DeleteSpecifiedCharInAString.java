class DeleteSpecifiedCharInAString{
	public static void main(String args[]){
		String name = "Aravindh";
		int index = 7;
		name = removeElementFromString(name, index);
		System.out.println("Modfied String is : "+name);
	}
	static String removeElementFromString(String name, int index){
		String temp = "";
		for(int i=0; i<index; i++)
			temp += name.charAt(i);
		for(int i=index+1; i<name.length(); i++)
			temp+=name.charAt(i);
		return temp;
	}
}
