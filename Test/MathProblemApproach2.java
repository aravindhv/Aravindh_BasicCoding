import java.util.Scanner;
import static java.lang.System.out;

class MathProblemApproach2{
	static String temp = "";
	static String array[] = new String[0];
    	private static Scanner scan = new Scanner(System.in);
    	public static void main(String args[]){
        	int start = 0;
        	int end = 0;
        	out.print("Enter equation : ");
        	String number = scan.next();
        	storeInArray(number);
        	out.println("Given Equation \t:");
        	for(String i: array)
        	    out.print(i);
        	out.println();
        	while(true) {
			int count = 0;
			if(arrayContains(start, end, "/")!=-1 || arrayContains(start, end, "*")!=-1 || arrayContains(start, end, "+")!=-1 || arrayContains(start, end, "-")!=-1)
				count++;
			for(int i=0; i<array.length; i++){
			   if(array[i] .equals("("))
			       start = i;
			   else if(array[i] .equals(")")){
			       end = i;
			       validateBraces(start, end);
			       alterArraySize(start+1);
			       break;
			   }
			}
			validateBraces(-1, array.length);
			if(count == 0)
				break;
        	}
        	out.println("Resultant Equation \t:");
        	for(String i: array)
        	   out.print(i);
        	out.println();
    	}
    	private static void storeInArray(String number){
        	int i=0;
        	while(i<number.length()){
        	    temp = "";
        	    if(number.charAt(i)>=48 && number.charAt(i)<=57){
        	        i = concatNumbers(i, number);
        	        splitIntoArray(temp);
        	        temp = "";
        	    }
        	    if((i==0 && number.charAt(i)=='-') || (i>0 && i<number.length() && number.charAt(i)=='-' && number.charAt(i-1)=='(')){
        	        temp = "-";
        	        i = concatNumbers(++i, number);
        	        splitIntoArray(temp);
        	        temp = "";
        	    }
        	    if((i < number.length()-1 && number.charAt(i)=='-') && (i !=0 && number.charAt(i-1)==')' && number.charAt(i+1)>=48 && number.charAt(i+1)<=57)){
        	        temp = "+";
        	        splitIntoArray(temp);
        	        temp = "-";
        	        i = concatNumbers(++i, number);
        	        splitIntoArray(temp);
        	        temp = "";
        	    }
        	    if(i != number.length() && (number.charAt(i)<48 || number.charAt(i)>57)){
        	        temp += number.charAt(i++);
        	        splitIntoArray(temp);
        	        temp = "";
        	    }
        	}
    	}
    	private static void splitIntoArray(String number){
    		    String arr[] = new String[array.length+1];
    		    for(int i=0; i<array.length; i++)
    		        arr[i] = array[i];
    		    arr[arr.length-1] = number;
    		    array = arr;
    	}
    	private static int concatNumbers(int i, String number){
    		    while(i != number.length() && (number.charAt(i)>=48 && number.charAt(i)<=57))
    		        temp += number.charAt(i++);
    		    return i;
    	}
    	private static void validateBraces(int start, int end){
    	    int prevLength = array.length;
    	    label:
    	    while(true){
	    	    int count = 0;
	    	    int index = arrayContains(start, end, "/");
	    	    if(index!=-1) {
	    		    count++;
	    		    prevLength = array.length;
	       		    performDivision(index);
	       		    printArray();
	       		    end = end - (prevLength - array.length);
	       		    continue label;
	       	    }
	       	    index = arrayContains(start, end, "*");
	       	    if(index!=-1) {
	       	    	count++;
        		prevLength = array.length;
                	performMultiplication(index);
                	printArray();
           		end = end - (prevLength - array.length);
           		continue label;
	   	    }
		    index = arrayContains(start, end, "+");
		    if(index!=-1) {
			count++;
			prevLength = array.length;
			performAddition(index);
			printArray();
	   		end = end - (prevLength - array.length);
	   		continue label;
		    }
        	    index = arrayContains(start, end, "-");
		    if(index!=-1) {
			count++;
			prevLength = array.length;
			performSubtraction(index);
			printArray();
		   	end = end - (prevLength - array.length);
		   	continue label;
		    }
		    if(count==0)
			break;
	}
    }
	private static void printArray() {
		for(String a: array)
			out.print(a);
		out.println();
	}
	private static void performSubtraction(int index) {
	    array[index] = Integer.toString(Integer.parseInt(array[index-1])-Integer.parseInt(array[index+1]));
		alterArraySize(index);
	}
	private static void performAddition(int index) {
	    array[index] = Integer.toString(Integer.parseInt(array[index-1])+Integer.parseInt(array[index+1]));
		alterArraySize(index);
	}
	private static void performMultiplication(int index) {
	    array[index] = Integer.toString(Integer.parseInt(array[index-1])*Integer.parseInt(array[index+1]));
		alterArraySize(index);
	}
	private static int arrayContains(int start, int end, String string) {
		for(int i=start+1; i<end; i++)
		if(array[i].equals(string))
			return i;
		return -1;
	}
	private static void performDivision(int index){
        	array[index] = Integer.toString(Integer.parseInt(array[index-1])/Integer.parseInt(array[index+1]));
        	alterArraySize(index);
    	}
    	private static void alterArraySize(int index){
		String temp = array[index];
		String tempArr[] = new String[array.length-2];
		int i=0;
		for(i=0; i<index-1; i++)
		    tempArr[i] = array[i];
		tempArr[i++] = temp;
		for(int j=index+2; j<array.length; j++)
		    tempArr[i++] = array[j];
		array = tempArr;
		//printArray();
    }
}
//-12+(-10/5)-13
