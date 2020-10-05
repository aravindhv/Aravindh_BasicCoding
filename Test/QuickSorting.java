class QuickSorting{
	public static void main(String args[]){
		int array[] = {7,4,2,9,5,3,1};
		System.out.println("Before Sorting : ");
		printArray(array);
		quickSort(array, 0, array.length-1);
		System.out.println("After Sorting : ");
		printArray(array);
	}
	private static void quickSort(int array[], int left, int right){
		int pivot = array[(left + right)/2];
		int i = left;
		int j = right;
		while(i <= j){
			while(array[i] < pivot) i++;
			while(array[j] > pivot) j--;
			if(i <= j){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				i++;
				j--;
			}
		}
		if(left < j) quickSort(array, left, j);
		if(right > i) quickSort(array, i, right);
	}
	private static void printArray(int array[]){
		for(int i: array)
			System.out.print(i+" ");
		System.out.println();
	}
}
