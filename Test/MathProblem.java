class MathProblem{
	static int count = 0;
	public static void main(String args[]){
		String pattern = "(35+(8*(8/4+10/5))-20)";
		int start = 0;
		int count = 0;
		int modifiedLength = pattern.length();
		int originalLength = pattern.length();
		int end = pattern.length()-1;
		int resultLength = 0;
		System.out.println("Given that \t\t:"+pattern);
		while(true){
			label:
			for(int i=0; i<pattern.length(); i++){
				if(pattern.charAt(i)=='('||pattern.charAt(i)==')'||pattern.charAt(i)=='+'||pattern.charAt(i)=='-'||pattern.charAt(i)=='*' || pattern.charAt(i)=='/')
					count++;
				if(pattern.contains("(")){
					if(pattern.charAt(i)=='(')
						start = i;
					if(pattern.charAt(i)==')'){
						end = i;
						originalLength = pattern.length();
						pattern = validBraces(pattern, start, end);
						modifiedLength = pattern.length();
						end = end-(originalLength - modifiedLength);
						originalLength = modifiedLength;
						pattern = appendResult(pattern, start-1, end, pattern.substring(start+1,end));
						resultLength = pattern.length();
						i = -1;
					}
				}
			}
			if(count==0)
				break;
			count = 0;
		}
	}
	static String validBraces(String pattern, int start, int end){
		int prevIndex = start;
		int modifiedLength = pattern.length();
		int originalLength = pattern.length();
		String temp = "";
		for(int i=start+1; i<end; i++){
			if(pattern.contains("/")){
				if((pattern.charAt(i)<48 || pattern.charAt(i)>57) && pattern.charAt(i)!='/')
					prevIndex = i;
				if(pattern.charAt(i)=='/'){
					pattern = performDiv(pattern, i, prevIndex);
					System.out.println("End of Division \t:"+pattern);
				}
			}
		}
		prevIndex = start;
		modifiedLength = pattern.length();
		end = end-(originalLength - modifiedLength);
		originalLength = modifiedLength;
		for(int i=start+1; i<end; i++){
			if(pattern.contains("*")){
				if((i!=pattern.length()) && (pattern.charAt(i)<48 || pattern.charAt(i)>57) && pattern.charAt(i)!='*'){
					prevIndex = i;
				}
				if((i!=pattern.length()) && pattern.charAt(i)=='*'){
					pattern = performMul(pattern, i, prevIndex);
					System.out.println("End of Multiplication \t:"+pattern);
				}
			}
		}
		prevIndex = start;
		modifiedLength = pattern.length();
		end = end-(originalLength - modifiedLength);
		originalLength = modifiedLength;
		//int count = 0;
		for(int i=start+1; i<end; i++){
			if(pattern.contains("+")){
		//		System.out.println("Count : "+ ++count);
				if((pattern.charAt(i)<48 || pattern.charAt(i)>57) && pattern.charAt(i)!='+'){
					prevIndex = i;
				}
				if(pattern.charAt(i)=='+'){
					pattern = performAdd(pattern, i, prevIndex);
					System.out.println("End of Addition \t:"+pattern);
					prevIndex = start;
					modifiedLength = pattern.length();
					end = end-(originalLength - modifiedLength);
					originalLength = modifiedLength;
				}
			}
		}
		prevIndex = start;
		modifiedLength = pattern.length();
		end = end-(originalLength - modifiedLength);
		originalLength = modifiedLength;
		for(int i=start+1; i<end; i++){
			if(pattern.contains("-")){
				if((pattern.charAt(i)<48 || pattern.charAt(i)>57) && pattern.charAt(i)!='-'){
					//System.out.println("Check Point : \nstart : "+prevIndex+"\n Check Exists : "+pattern.contains("-"));
					prevIndex = i;
				}
				if(pattern.charAt(i)=='-'){
					pattern = performSub(pattern, i, prevIndex);
					System.out.println("End of Subtraction \t:"+pattern);
					prevIndex = start;
					modifiedLength = pattern.length();
					end = end-(originalLength - modifiedLength);
					originalLength = modifiedLength;
				}
			}
		}
		if(!pattern.contains("+") && !pattern.contains("-") && !pattern.contains("*") && !pattern.contains("/")){
			pattern = appendResult(pattern, start-1, end, pattern.substring(start+1,end));
		}
		return pattern;
	}
	static String performDiv(String pattern, int pos, int prevIndex){
		String tempBckwd = "";
		String tempFwd = "";
		for(int i=prevIndex+1; i<pos && pattern.charAt(i)>=48 && pattern.charAt(i)<=57; i++)
			tempBckwd += pattern.charAt(i);
		for(int i=pos+1; (i!=pattern.length())&&(pattern.charAt(i)>=48 && pattern.charAt(i)<=57); i++){
			tempFwd +=pattern.charAt(i);
			pos++;
		}
		String result = Integer.toString(Integer.parseInt(tempBckwd)/Integer.parseInt(tempFwd));
		result = appendResult(pattern, prevIndex, pos, result);
		return result;
	}
	static String performMul(String pattern, int pos, int prevIndex){
		String tempBckwd = "";
		String tempFwd = "";
		for(int i=prevIndex+1; i<pos && pattern.charAt(i)>=48 && pattern.charAt(i)<=57; i++)
			tempBckwd += pattern.charAt(i);
		for(int i=pos+1; (i!=pattern.length())&&(pattern.charAt(i)>=48 && pattern.charAt(i)<=57); i++){
			tempFwd +=pattern.charAt(i);
			pos++;
		}
		String result = Integer.toString(Integer.parseInt(tempBckwd)*Integer.parseInt(tempFwd));
		result = appendResult(pattern, prevIndex, pos, result);
		return result;
	}
	static String performAdd(String pattern, int pos, int prevIndex){
		String tempBckwd = "";
		String tempFwd = "";
		for(int i=prevIndex+1; i<pos && pattern.charAt(i)>=48 && pattern.charAt(i)<=57; i++)
			tempBckwd += pattern.charAt(i);
		for(int i=pos+1; (i!=pattern.length())&&(pattern.charAt(i)>=48 && pattern.charAt(i)<=57); i++){
			tempFwd +=pattern.charAt(i);
			pos++;
		}
		String result = Integer.toString(Integer.valueOf(tempBckwd) + Integer.valueOf(tempFwd));
		//System.out.println("Finally : "+result);
		result = appendResult(pattern, prevIndex, pos, result);
		return result;
	}
	static String performSub(String pattern, int pos, int prevIndex){
		String result = "";
		try{
		String tempBckwd = "";
		String tempFwd = "";
		for(int i=prevIndex+1; i<pos && pattern.charAt(i)>=48 && pattern.charAt(i)<=57; i++)
			tempBckwd += pattern.charAt(i);
		for(int i=pos+1; (i!=pattern.length())&&(pattern.charAt(i)>=48 && pattern.charAt(i)<=57); i++){
			tempFwd +=pattern.charAt(i);
			pos++;
		}
		result = Integer.toString(Integer.parseInt(tempBckwd)-Integer.parseInt(tempFwd));
		//System.out.println("Finally : "+result);
		result = appendResult(pattern, prevIndex, pos, result);
		}
		catch(Exception e){
			System.exit(0);
		}
		return result;
	}
	static String appendResult(String pattern, int prevIndex, int pos, String result){
		String temp = "";
		for(int i=0; i<=prevIndex; i++){
			temp+=pattern.charAt(i);
		}
		temp +=result;
		for(int i=pos+1; i<pattern.length();i++)
			temp+=pattern.charAt(i);
		return temp;
	}
}

