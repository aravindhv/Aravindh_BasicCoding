import java.util.Scanner;

class ReturnVoid{
        void printValue(String name){
                System.out.println("Welcome "+ name +"..!!");
        }
}
class ReturnVoidMain{
        public static void main(String args[]){
                ReturnVoid returnVoid = new ReturnVoid();
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter Your Name : ");
                returnVoid.printValue(scan.nextLine());
        }
}
