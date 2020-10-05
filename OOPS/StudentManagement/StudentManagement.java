import java.util.Scanner;

class Student{
        String name;
        int marks[];
        int total = 0;
        Student(String name, int marks[]){
        	this.name = name;
        	this.marks = marks;
        	for(int i=0; i<marks.length; i++)
        		total += marks[i];
        }
}
class Manager{

	static Scanner scan = new Scanner(System.in);
        int numberOfStudents;
        String []subject;
        Student student[];

        Manager(){
        	System.out.print("Enter number of Students : ");
                numberOfStudents = scan.nextInt();
                
                System.out.print("Enter Number of Subjects : ");
                int totalSubjects = scan.nextInt();
                
                subject = new String[totalSubjects];
                
                System.out.println("Enter Subjects : ");
                for(int i=0; i<totalSubjects; i++)
                	subject[i] = scan.next();
                
                student = new Student[numberOfStudents];
		
		System.out.println("\n\nEnter Student Details : ");
		for(int i=0; i<numberOfStudents; i++){
			
			System.out.println("\nEnter Student "+ (i+1)+" Details : ");
			System.out.print("Enter Name  : ");
			String name = scan.next();
			
			int marks[] = new int[subject.length];
			
			System.out.print("::::: ENTER MARKS ::::: \n");
			for(int j=0; j<subject.length; j++){
				System.out.print(subject[j] +" mark : ");
				marks[j] = scan.nextInt();
			}
			student[i] = new Student(name, marks);
		}
        }
        
        void printSubjectNames(){
        	System.out.println("\nSUBJECT NAMES\n");
        	for(String i: subject)
        		System.out.println(i);
        }
        void printStudentNames(){
        	System.out.println("\nSTUDENT NAMES:\n");
        	for(Student i: student)
        		System.out.println(i.name);
        }
        void getTopFiveStudents(){
        	System.out.println("TOP 5 STUDENTS : ");
        	for(int i=0; i<numberOfStudents-1; i++){
        		for(int j=i+1; j<numberOfStudents; j++){
        			if(student[i].total < student[j].total){
        				Student temp = student[i];
        				student[i] = student[j];
        				student[j] = temp;
        			}
        		}
        	}
        	int count = -1;
        	System.out.printf("%-15s%-8s","Student Name","Total");
        	while(++count < 5){
        		System.out.printf("\n%-15s%-8d",student[count].name,student[count].total);
        	}
        }
        void getPassedStudents(boolean isPassed){
        	System.out.printf("%-15s","Student Name");
        	for(int i=0; i<subject.length; i++)
        		System.out.printf("%-7s",subject[i]);
        	for(int i=0; i<numberOfStudents; i++){
	        	boolean isTrue = isPassed;
        		for(int j=0; j<subject.length; j++){
        			if(student[i].marks[j] < 35){
        				isTrue = !isPassed;
        				break;
        			}
        		}
        		if(isTrue){
        			System.out.printf("\n%-15s",student[i].name);
        			for(int j=0; j<subject.length; j++){
        				System.out.printf("%-7d",student[i].marks[j]);
        			}
        		}
        	}
        }
        
        void getSubjectWiseHighestMarks(){
        	System.out.printf("%-15s%-15s%-7s\n","Subject Name","Student Name","Marks");
        	for(int i=0; i<subject.length; i++){
        		int maxMark = student[0].marks[i];
        		for(int j=0; j< numberOfStudents; j++){
        			if(maxMark < student[j].marks[i])
        				maxMark = student[j].marks[i];
        		}
        		for(int j=0; j<numberOfStudents; j++)
        			if(student[j].marks[i] == maxMark)
        				System.out.printf("%-15s%-15s%-7d\n",subject[i],student[j].name,student[j].marks[i]);
        	}
        }
}
class StudentManagement{
        public static void main(String args[]){
        	
        	Scanner scan = new Scanner(System.in);
                Manager manager = new Manager();
                while(true){
			System.out.println("\n1.Print Subject Names\n2.Print Student Names\n3.Top 5 Students\n4.Passed Students\n5.Failed Students\n6.Subject Wise Highest mark\n7.Exit\n");
		        System.out.print("\nEnter Your Choice : ");
			int choice = scan.nextInt();
			switch(choice){
				case 1: manager.printSubjectNames();
					break;
				case 2: manager.printStudentNames();
					break;
				case 3: manager.getTopFiveStudents();
					break;
				case 4: manager.getPassedStudents(true);
					break;
				case 5: manager.getPassedStudents(false);
					break;
				case 6: manager.getSubjectWiseHighestMarks();
					break;
				default: System.out.println("Invalid Choice.!");
			}
		}
        }
}
