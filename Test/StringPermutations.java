class StringPermutations{
	public static void main(String args[]){
		String password = "password";
		findPermutations(password.toCharArray(), 0);
	}
	private static void findPermutations(char array[], int index){
		if(index == array.length){
			System.out.println(array);
			return;
		}
		for(int i=index; i<array.length; i++){
			char temp = array[index];
			array[index] = array[i];
			array[i] = temp;
			findPermutations(array, index+1);
		}
	}
}
