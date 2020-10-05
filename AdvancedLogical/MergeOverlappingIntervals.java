import java.util.Scanner;
import java.util.Arrays;

class MergeOverlappingIntervals{
	static int size = 0;
	static int remove[] = new int[1];
	public static void main(String args[]){
		int intervals[][] = {{1,2},{1,10},{2,20},{7,9}};
		/*{{1,3},
				     {5,8},
				     {4,10},
				     {0,25}};
		
		/* 		    {{5,6},
				     {1,2},
				     {1,10},
				     {5,7},
				     {7,10}};
		//{{1,3},{5,8},{4,10},{20,25}};
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of sets to be entered : ");
		int size = scan.nextInt();
		int intervals[][] = new int[size][2];
		System.out.println("Enter interval values :");
		for(int i=0; i<size; i++)
			for(int j=0; j<2; j++){
				System.out.print("arr ["+(i+1)+"]["+(j+1)+"]= ");
				intervals[i][j] = scan.nextInt();
			}	*/
		mergeIntervals(intervals);
		intervals = mergedIntervalsArray(intervals);
		for(int i=0;i < intervals.length; i++){
			for(Integer j: intervals[i])
				System.out.print(j+" ");
			System.out.println();
		}
	}
	static void mergeIntervals(int [][]array){
		size = array.length;
		remove = new int[size];
		Arrays.fill(remove,-1);
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array.length; j++)
			if((remove[i] != 0 && i!=j && remove[j]==-1 )&& (array[i][0] <= array[j][0] && array[i][1] >= array[j][1])){
				remove[j] = 0;
				size--;
			}
		}
	}
	static int[][] mergedIntervalsArray(int [][]intervals){
		int array[][] = new int[size][2];
		int count = 0;
		for(int i=0; i<intervals.length; i++){
			if(remove[i]==-1){
				array[count][0] = intervals[i][0];
				array[count][1] = intervals[i][1];
				count++;
			}
		}
		return array;
	}
} 
