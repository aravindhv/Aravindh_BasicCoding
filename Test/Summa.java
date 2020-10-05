class Summa{
	public static void main(String args[]){
		String line = "Sometimes (when I nest them (my parentheticals) too much (like this (and this))) they get confusing.";
		for(int i=0; i<line.length(); i++){
			if(line.charAt(i)=='(')
				System.out.println("Position : "+i);
		}
	}
}
