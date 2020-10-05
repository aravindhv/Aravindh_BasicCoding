class BinarySearchUsingRecursion{
	public static void main(String args[]){
		char letters[] = {'a','b','c','d','e','f','g','h'};
		char find = 'a';
		int index = searchKey(find, letters, 0, letters.length-1, letters.length/2);
		if(index != -1)
			System.out.println("Key found at "+ index +" index");
		else
			System.out.println("Key not found in this array.!");
	}
	private static int searchKey(char find, char []letters, int start, int end, int middle){
		if(start > end)
			return -1;
		else{
			if(letters[middle] == find)
				return middle;
			else if(letters[middle] > find)
				return searchKey(find, letters, start, middle-1, (start + end)/2);
			else if(letters[middle] < find)
				return searchKey(find, letters, middle+1, end, (start + end)/2);
		}
		return -1;
	}
}
