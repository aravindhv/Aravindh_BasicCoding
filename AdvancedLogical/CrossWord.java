import java.util.Scanner;

class CrossWord{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		char puzzle[][] = new char[][]{{'F', 'A', 'C', 'I'}, 
					       {'O', 'B', 'Q', 'P'},
					       {'A', 'N', 'O', 'B'},
					       {'M', 'A', 'S', 'S'}};
		System.out.print("Enter value to find : ");
		String value = scan.next();
		findWord(value, puzzle);
	}

	static void findWord(String word, char [][]puzzle){
		boolean nothingFound = true;
		for(int i=0; i<puzzle.length; i++){
			for(int j=0; j<puzzle[i].length; j++){
				int traverseMatrix = j-1;
				int traverseWord = -1;
				if(puzzle[i][j] == word.charAt(0)){
					if(j+word.length() <= puzzle[i].length){
						while((traverseWord+1 <	 word.length() && traverseMatrix+1 < puzzle[i].length) && (word.charAt(traverseWord+1) == puzzle[i][traverseMatrix+1])){
							++traverseWord;
							++traverseMatrix;
						}
						if(traverseWord+1 == word.length()){
							System.out.println("<"+ i +","+ j +"> to <"+ i +","+ traverseMatrix +">");
							nothingFound = false;
						}
					}
				}
				traverseWord = -1;
				traverseMatrix = i-1;
				if(puzzle[i][j] == word.charAt(0)){
					if(i+word.length() <= puzzle.length){
						traverseMatrix = i-1;
						while((traverseWord+1 <	 word.length() && traverseMatrix+1 < puzzle.length) && (word.charAt(traverseWord+1) == puzzle[traverseMatrix+1][j])){
							traverseWord++;
							traverseMatrix++;
						}
						if(traverseWord+1 == word.length()){
							System.out.println("<"+ i +","+ j +"> to <"+ traverseMatrix +","+ j +">");
							nothingFound = false;
						}
					}
				}
			}
		}
		if(nothingFound)
			System.out.println("Cannot find any Words in this Puzzle.!");
	}
}
