class DaughterAgesLoopApproach{
	public static void main(String args[]){
		for(int i=0; i<110; i++)
			for(int j=0; j<110; j++)
				for(int k=0; k<110; k++)
					if(i<k && j<k && i+j+k==14 && i*j*k==72)
						System.out.println(i+" "+j+" "+k);
	}
}
