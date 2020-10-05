class CheckArrayIsSorted{
	public static void main(String args[]){
		char names[] = {'A','D','W','R','V'};
		if(isSorted(names, names.length))
			System.out.println("Array is in sorted Order.");
		else
			System.out.println("Array in Unsorted Order.!");
	}
	private static boolean isSorted(char []names, int last){
		if(last==0 || last==1)
			return true;
		if(names[last-2]>names[last-1])
			return false;
		else
			return isSorted(names, last-1);
	}
}
