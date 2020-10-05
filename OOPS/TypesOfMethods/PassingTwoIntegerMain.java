import java.util.Scanner;

class PassingTwoInteger{
        void printRangeValues(int start, int end){
                for(int i=start; i<=end; i++){
                        System.out.println(i);
                }
        }
}
class PassingTwoIntegerMain{
        public static void main(String args[]){
                Scanner scan = new Scanner(System.in);
                System.out.println("Enter two range of values : ");
                PassingTwoInteger passingInteger = new PassingTwoInteger();
                passingInteger.printRangeValues(scan.nextInt(), scan.nextInt());
        }
}
