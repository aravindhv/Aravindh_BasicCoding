class QuickSort{
	public static void main(String args[]){
		int array[] = new int[]{3,2,5,4,1};
		quickSort(array, 0, array.length-1);
		System.out.println("Sorted Array ");
		for(int i=0; i < array.length; i++)
			System.out.print(array[i]+" ");
		System.out.println();
	}
	private static void quickSort(int []array, int left, int right){
		int index = getPartition(array, left, right);
		if(left < index-1)
			quickSort(array, left, index - 1);
		if(index < right)
			quickSort(array, index, right);
	}
	private static int getPartition(int []array, int left, int right){
		int pivot = array[(left + right)/2];
		while(left <= right){
			while(array[left] < pivot) left++;
			while(array[right] > pivot) right--;
			if(left <= right){
				int temp = array[right];
				array[right] = array[left];
				array[left] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
}
