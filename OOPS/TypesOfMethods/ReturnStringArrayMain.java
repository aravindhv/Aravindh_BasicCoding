import java.util.Scanner;

class ReturnStringArray{
        Scanner scan = new Scanner(System.in);
        String []setStudentNames(int number){
                String names[] = new String[number];
                for(int i=0; i<number; i++){
                        System.out.print("Enter "+ (i+1) +" Name : ");
                        names[i] = scan.next();
                }
                return names;
        }
}
class ReturnStringArrayMain{
        public static void main(String args[]){
                Scanner scan = new Scanner(System.in);
                System.out.print("Enter number of students : ");
                ReturnStringArray stringArray = new ReturnStringArray();
                String name[] = stringArray.setStudentNames(scan.nextInt());
                System.out.println("\n\nStudents : ");
                for(String a : name)
                        System.out.println(a);
        }
}
