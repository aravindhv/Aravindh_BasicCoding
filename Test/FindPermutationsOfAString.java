class FindPermutationsOfAString{
	static int count = 0;
	public static void main(String args[]){
		char array[] = {'a','b','c','d'};
		findPermutation(array, array.length, 0);
	}
	private static void findPermutation(char []array, int size, int n){
		if(size == 1 || size==0){
			System.out.println(array);
			return;
		}
		else if(n==size){
			System.out.println(array);
			//System.out.println(" "+ ++count);
			return;
		}
		else if(n < size){
			for(int i=n; i<size; i++){
				swap(array, n, i);
				findPermutation(array, size, n+1);
				swap(array, n, i);
			}
			return;
		}
	}
	private static void swap(char array[], int first, int second){
		char temp = array[first];
		array[first] = array[second];
		array[second] = temp;
		/*array[first] = (char)(array[first]^array[second]);
		array[second] = (char)(array[first]^array[second]);
		array[first] = (char)(array[first]^array[second]);*/
	}
	
}
