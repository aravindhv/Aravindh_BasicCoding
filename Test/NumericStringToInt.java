class NumericStringToInt{
	public static void main(String args[]){
		String numeric = "8264898";
		int number = 0;
		int length = 0;
		while(length <= numeric.length()-1){
			number*=10;
			number+=numeric.charAt(length++)-'0';
		}
		System.out.println("Converted Integer : "+number);
	}
}
