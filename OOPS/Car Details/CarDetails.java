import java.util.Scanner;

class Car{
	String brand;
	int price;
	short speed;
	String color;
	public Car(String brand, int price, short speed, String color){
		this.brand = brand;
		this.price = price;
		this.speed = speed;
		this.color = color;
	}
	String returnObject(){
		return "Brand : "+ brand +" Price : "+ price +" Speed : "+speed+" Color : "+color;
	}
}
class CarDetails{
	public static void main(String args[]){
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter number of car details to be added : ");
		int totalCars = scan.nextInt();
		Car[] car = new Car[totalCars];
		for(int i=0; i<totalCars; i++){
			System.out.println("Car "+(i+1)+" th Car Details :");
			System.out.print("Enter car brand : ");
			String brand = scan.next();
			System.out.print("Enter car Price : ");
			int price = scan.nextInt();
			System.out.print("Enter Car's maximum speed : ");
			short speed = scan.nextShort();
			System.out.print("Enter Car's Color : ");
			String color = scan.next();
			car[i] = new Car(brand, price, speed, color);
		}
		System.out.println("\n\nEntered Car Details are :\n\n");
		for(int i=0; i<totalCars; i++){
			System.out.println(car[i].returnObject());
		}
	}
}
