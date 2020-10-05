import java.util.Scanner;

class IntegerArray{
        Scanner scan = new Scanner(System.in);
        int[] getMarks(int number){
                int marks[] = new int[number];
                for(int i=0; i<number; i++){
                        System.out.print("Enter Subject "+ (i+1) +" Mark : ");
                        marks[i] = scan.nextInt();
                }
                return marks;
        }
}
class IntegerArrayMain{
        public static void main(String args[]){
                Scanner scan = new Scanner(System.in);
                IntegerArray intArr = new IntegerArray();
                System.out.println("Enter total number of Subjects : ");
                int []mark = intArr.getMarks(scan.nextInt());
                System.out.println("Mark List : ");
                for(int i=0; i< mark.length; i++)
                        System.out.println("Mark of Subject"+ i +" is "+ mark[i]);
        }
}
