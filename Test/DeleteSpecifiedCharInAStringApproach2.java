class DeleteSpecifiedCharInAStringApproach2{
	public static void main(String args[]){
		String name = "Assailaant";
		int index = 7;
		char name_elements[] = toCharArray(name);
		name = removeIndexedElement(index, name_elements);
		System.out.println("Name : "+name);
	}
	private static char[] toCharArray(String name){
		char[] temp = new char[name.length()];
		for(int i=0; i<name.length(); i++)
			temp[i] = name.charAt(i);
		return temp;
	}
	private static String removeIndexedElement(int index, char []name){
		String temp = "";//substring(0,index)+substring(index+1, name.length());
		for(int i=index; i<name.length-1; i++)
			name[i] = name[i+1];
		//System.arraycopy(name, index, name, index+1, name.length-index-1);
		for(int i=0; i<name.length-1; i++)
			temp += name[i];
		return temp;
	}
}
