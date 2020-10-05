class ArmstrongNumber{
	public static void main(String args[]){
		int number = 9474;
		int temp = number;
		int sum = 0;
		short countDigits = 0;
		while(temp > 0){
			temp/=10;
			countDigits++;
		}
		temp = number;
		while(temp > 0){
			int lastDigit = temp%10;
			int tempProduct = 1;
			for(int i=0; i<countDigits; i++){
				tempProduct *= lastDigit;
			}
			sum += tempProduct;
			temp/=10;
		}
		if(sum == number)
			System.out.println("Armstrong Number.!");
		else
			System.out.println("Not an Armstrong number.!");
	}
}
