class SortStringsWithThierLength{
	public static void main(String args[]){
		String names[] = {"aravindh", "arunkumar", "ravi", "kumar", "krishnan"};
		for(int i=0; i<names.length-1; i++){
			for(int j=i+1; j<names.length; j++){
				if(names[i].length() > names[j].length()){
					String temp = names[i];
					names[i] = names[j];
					names[j] = temp;
				}
			}
		}
		for(String i : names)
			System.out.print(i+" ");
		System.out.println();
	}
}
