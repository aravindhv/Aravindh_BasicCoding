class MergeSort{
	public static void main(String args[]){
		int array[] = {7,4,2,9,5,3,1};
		System.out.println("Before Sorting : ");
		printArray(array);
		array = splitArray(array);
		System.out.println("After Sorting : ");
		printArray(array);
	}
	private static int[] splitArray(int []array){
		if(array.length == 1)
			return array;
		int mid = array.length / 2;
		int left[] = new int[mid];
		int right[];
		if(array.length%2 != 0)
			right = new int[mid + 1];
		else
			right = new int[mid];
		int i = 0;
		for(i=0; i<left.length; i++)
			left[i] = array[i];
		for(int j=0; j<right.length; j++){
			right[j] = array[i++];
		}
		left = splitArray(left);
		right = splitArray(right);
		array = mergeArray(left, right);
		
		return array;
	}
	private static int[] mergeArray(int []left, int []right){
		int array[] = new int[left.length + right.length];
		int rightPointer, leftPointer, arrayPointer;
		rightPointer = leftPointer = arrayPointer = 0;
		while(rightPointer < right.length || leftPointer < left.length){
			while(rightPointer < right.length && leftPointer < left.length){
				if(left[leftPointer] < right[rightPointer]){
					array[arrayPointer++] = left[leftPointer++];
				} else {
					array[arrayPointer++] = right[rightPointer++];
				}
			}
			while(rightPointer < right.length){
				array[arrayPointer++] = right[rightPointer++];
			}
			while(leftPointer < left.length)
				array[arrayPointer++] = left[leftPointer++];
		}
		return array;
	}
	private static void printArray(int array[]){
		for(int i=0; i<array.length; i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
}
