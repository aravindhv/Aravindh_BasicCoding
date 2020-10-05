class DeleteSpecifiedCharInAStringApproach3{
	public static void main(String args[]){
		String batch = "AUSARTGEANTZZ'15";
		int index = 11;
		System.out.println("Modified Batch Name is : "+removeIndexedElement(index, batch));
	}
	private static String removeIndexedElement(int index, String batch){
		String temp = batch.substring(0,index) + batch.substring(index+1, batch.length());
		return temp;
	}
}
