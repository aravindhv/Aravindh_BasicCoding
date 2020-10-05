import java.util.Scanner;

class Calculator{
        int number1;
        int number2;
        public Calculator(int number1, int number2){
                this.number1 = number1;
                this.number2 = number2;
        }
        void add(){
                System.out.println("\nAddition of "+ number1 +" and "+ number2 +" is "+ (number1 + number2)+"\n");
        }
        void sub(){
                System.out.println("\nSubtract of "+ number2 +" from "+ number1 +" is "+ (number1 - number2)+"\n");
        }
        void mul(){
                System.out.println("\nMultiplication of "+ number1 +" and "+ number2 +" is "+ (number1 * number2)+"\n");
        }
        void div(){
                System.out.println("\nDivision of "+ number1 +" and "+ number2 +" is "+ ((float)number1 / number2)+"\n");
        }
}

class CalculatorDemo{
        public static void main(String[] args){
                
                Calculator calc;
                Scanner scan = new Scanner(System.in);
                while(true){
                        System.out.println(" 1. Addition \n 2. Subtraction \n 3. Multiplication \n 4. Division \n 5. Exit\n");
                        System.out.println("Enter Your Choice : ");
                        int choice = scan.nextInt();
                        if(choice == 5)
                        	return;
                        else if(choice < 1 || choice > 5){
                        	System.out.println("\nInvalid Option.\n");
                                continue;
                        }
                        System.out.print("Enter number 1 : ");
                        int number1 = scan.nextInt();
                        System.out.print("Enter number 2 : ");
                        int number2 = scan.nextInt();
                        calc = new Calculator(number1, number2);
                        switch(choice){
                                case 1: calc.add();
                                        break;
                                case 2: calc.sub();
                                        break;
                                case 3: calc.mul();
                                        break;
                                case 4: calc.div();
                                        break;
                        }
                }
        }
}
