import java.util.Scanner;
import static java.lang.System.out;
import java.util.InputMismatchException;
//import java.util.ArrayList;

interface Items{
	void setDeals(float dealPercent);
	//float getDiscountPrice();
}

class CalculateDiscount{
	static float getDiscountPrice(float priceInRs, float dealPercent){
		return priceInRs - (( priceInRs * dealPercent ) / 100); 
	}
}

class CartItems{
//	public final String category = "Electronics";
	String type;
	String brand;
	String model;
	float priceInRs;
	int itemCount;
	float discountPrice;
	CartItems(String type, String brand, String model, float priceInRs, int itemCount, float discountPrice){
		this.type = type;
		this.brand = brand;
		this.model = model;
		this.priceInRs = priceInRs;
		this.itemCount = itemCount;
		this.discountPrice = discountPrice;
	}
}
class Mobile{
	String type = "Mobile";
	String brand;
	String model;
	short RAM;
	float priceInRs;
	short storage;
	short batteryCapacity;
	short lauchYear;
	int stock;
	float discountPrice;
	private static float dealPercent;
	Mobile(String brand, String model, short RAM, float priceInRs, short storage, short batteryCapacity, short lauchYear, int stock){
		this.brand = brand;
		this.model = model;
		this.RAM = RAM;
		this.priceInRs = priceInRs;
		this.storage = storage;
		this.batteryCapacity = batteryCapacity;
		this.lauchYear = lauchYear;
		this.stock = stock;
		this.discountPrice = getDiscountPrice();
	}
	float getDiscountPrice(){
	//	float priceCopy = priceInRs;
	//	return CalculateDiscount.getDiscountPrice(priceCopy, dealPercent);
		return CalculateDiscount.getDiscountPrice(priceInRs, dealPercent);
	}
	static void setDeals(float adminDealPercent){
		dealPercent = adminDealPercent;
	}
}
class EarPhones{
	String type = "EarPhones";
	String brand;
	String connectivity;
	String withMic;
	String model;
	float priceInRs;
	int stock;
	float discountPrice;
	private static float dealPercent;
	EarPhones(String brand, String connectivity, String withMic, String model, float priceInRs, int stock){
		this.brand = brand;
		this.connectivity = connectivity;
		this.withMic = withMic;
		this.model = model;
		this.priceInRs = priceInRs;
		this.stock = stock;
	//	this.discountPrice = getDiscountPrice();
	}
	public float getDiscountPrice(){
	//	float priceCopy = priceInRs;
	//	float tempDealPercent = dealPercent;
	//	return CalculateDiscount.getDiscountPrice(priceCopy, dealPercent);
		return CalculateDiscount.getDiscountPrice(priceInRs, dealPercent);
	}
	public static void setDeals(float adminDealPercent){
		dealPercent = adminDealPercent;
		this.discountPrice = getDiscountPrice();
	}
}

class User{
	String name;
	String userId;
	String password;
	
	float cartAmount = 0;
	float cartMRP = 0;
	int itemsCount = 0;
	//ArrayList<CartItems> cartItems = new ArrayList<>();
	CartItems cartItems[] = new CartItems[10];
	
	User(String name, String userId, String password){
		this.name = name;
		this.userId = userId;
		this.password = password;
	}
	
	void showCart(User user){
		out.println("Amount to be Paid 	: "+ cartAmount);
		out.println("You Saved		: "+ (cartMRP - cartAmount));
		for(int i=0; i < itemsCount; i++){
			out.println("Category 		: "+cartItems[i].type);
			out.println("Brand 		\t: "+cartItems[i].brand);
			out.println("Model		\t: "+cartItems[i].model);
			out.println("Price		\t: "+cartItems[i].priceInRs);
			out.println("Number of Items 	\t: "+cartItems[i].itemCount);
		}
	}
	void addItems(User user){
		while(true){
			out.println("Choose Category to View Items.!");
			out.print("1. Mobile\n2. Headphones\n3. Back to Menu\nEnter Choice\t: ");
			int choice = Application.scan.nextInt();
			switch(choice){
				case 1: Application.listMobilePhones(user);
					break;
				case 2: Application.listEarPhones(user);
					break;
				case 3: return;
			}
		}
	}
}

class Admin{
	private String userId = "admin";
	private String password = "admin";
	Scanner scan = new Scanner(System.in);
	String getUserId(){
		return userId;
	}
	String getPassword(){
		return password;
	}
	void modifyItems(){
		while(true){
			out.print("\n1. Add Mobile Items\n2. Add Earphone Items\n3. Back to Main Menu\n4. Exit\nEnter Option : ");
			int option = Application.scan.nextInt();
			switch(option){
				case 1: Application.addMobile();
					break;
				case 2: Application.addEarphone();
					break;
				case 3: return;
				case 4: System.exit(0);
				default: out.println("Invalid Option.!");
			}
		}
	}
	void setDeals(){
		while(true){
			out.println("\n1. Set Deals for Items \n2. Back to Main \n3. Exit\nEnter Your Option\t: ");
			int option = scan.nextInt();
			switch(option){
				case 1: Application.setDealsForItems();
					break;
				case 2: return;
				case 3: System.exit(0);
				default: out.println("Invalid Option.!");
			}
		}
	}
}

class Application{
	static int userIndex = 0;
	static int earPhonesCount = 0;
	static int mobilesCount = 0;
	//ArrayList<User> user;
	User user[];
	Admin admin = new Admin();
	static Scanner scan = new Scanner(System.in);
	//static ArrayList<EarPhones> earPhones = new ArrayList<EarPhones>();
	static EarPhones[] earPhones = new EarPhones[10];
	//static ArrayList<Mobile> mobile = new ArrayList<Mobile>();
	static Mobile[] mobile = new Mobile[10];
	
	Application(){
		try{
			int userIndex = 0;
			//user = new ArrayList<User>();
			user = new User[10];
			while(true){
				out.println("\n1. Create New Customer Account\n2. Login as Admin\n3. Login as Customer\n4. Exit\nEnter Your Choice : ");
				int choice = scan.nextInt();
				scan.nextLine();
				switch(choice){
					case 1: createCustomerAccount();
						break;
					case 2: adminLogin();
						break;
					case 3: customerLogin();
						break;
					case 4: System.exit(0);
					default: out.println("Invalid Option.!!");
				}
			}
		} catch(InputMismatchException e){
			out.println("Input Mismatch found.!");
		}
	}
	void createCustomerAccount(){
		out.print("Enter Name     : ");
		String name = scan.nextLine();
		out.print("Enter User Id  : ");
		String userId = scan.next();
		boolean duplicateUser = true;
		checkUser:
		while(duplicateUser){
			for(int i = 0; i < userIndex ; i++){
				if(user[i].userId.equals(userId)){
					out.println("User Id already found.! Please try another User Id.!");
					out.print("Enter Another User Id  : ");
					userId = scan.next();
					continue checkUser;
				}
			}
			duplicateUser = false;
		}
		out.print("Enter Password : ");
		String password = scan.next();
		//user.add(new User(name, userId, password));
		
		/* User Array Length Increased while the Array Fills */
		if(userIndex == user.length){
			User tempUser[] = new User[(user.length * 3) / 2];
			for(int i=0; i < user.length; i++)
				tempUser[i] = user[i];
			user = tempUser;
		}
		user[userIndex++] = new User(name, userId, password);
	}
	static void setDealsForItems(){
		while(true){
			try{
				out.print("1. Mobile\n2. EarPhones\n3. Back to Main\nEnter Your Option\t: ");
				int option = scan.nextInt();
				switch(option){
					case 1: out.print("Enter Discount Percentage : ");
						Mobile.setDeals(scan.nextFloat());
						break;
					case 2: out.print("Enter Discount Percentage : ");
						EarPhones.setDeals(scan.nextFloat());
						break;
					case 3: return;
					default: out.println("Invalid Option");
				}
			} catch(InputMismatchException e){
				out.println("Input Mismatch found.!");
			}
		}
	}
	void adminLogin(){
		out.print("Enter Admin Id       : ");
		String adminId = scan.next();
		out.print("Enter Admin Password : ");
		String password = scan.next();
		if(admin.getUserId().equals(adminId) && admin.getPassword().equals(password)){
			out.println("\n\t\tWelcome Admin.!");
			while(true){
				try{
					out.print("\n1. Add Items\n2. Set Deals\n3. Logout\nEnter Option\t : ");
					int option = scan.nextInt();
					switch(option){
						case 1: admin.modifyItems();
							break;
						case 2: admin.setDeals();
							break;
						case 3: return;
					}
				} catch(InputMismatchException e){
					out.println("Input Mismatch found.!");
				}
			}
		} else {
			out.println("Invalid UserId Or Password.!");
		}
	}
	
	void customerLogin(){
		out.print("Enter User Id  : ");
		String userName = scan.next();
		out.print("Enter Password : ");
		String password = scan.next();
	/*	for(int i=0; i < user.size(); i++){
			if(user.get(i).userId.equals(userName) && user.get(i).password.equals(password)){
				out.println("\nWelcome "+ user.get(i).name+"\n");
				showCustomer(user.get(i));
			}
		}	*/
		for(int i=0; i<userIndex; i++){
			if(user[i].userId.equals(userName) && user[i].password.equals(password)){
				out.println("\n\t\tWelcome "+ user[i].name + "\n");
				showCustomer(user[i]);
			}
		}
	}
	
	void showCustomer(User user){
		while(true){
			try{
				out.println("1. Show Cart\n2. Add Items to Cart\n3. Back To Main\nEnter Choice\t: ");
				int choice = scan.nextInt();
				switch(choice){
					case 1: user.showCart(user);
						break;
					case 2: user.addItems(user);
						break;
					case 3: return;
					default: out.println("Invalid Option!");
				}
			} catch(InputMismatchException e){
				out.println("Input Mismatch found.!");
			}
		}
	}
	static void addMobile(){
		out.print("Enter Mobile Brand 		: ");
		String brand = scan.next();
		out.print("Enter Mobile Model		: ");
		String model = scan.next();
		out.print("Enter RAM(in GB)		: ");
		short RAM = scan.nextShort();
		out.print("Enter Storage(in GB)		: ");
		short storage = scan.nextShort();
		out.print("Enter Price			: ");
		float priceInRs = scan.nextFloat();
		out.print("Battery Capacity(in mAh)	: ");
		short batteryCapacity = scan.nextShort();
		out.print("Enter Launch Year		: ");
		short lauchYear = scan.nextShort();
		out.print("Enter Initial Stock		: ");
		int stock = scan.nextInt();
		
	//	mobile.add(new Mobile(brand, model, RAM, priceInRs, storage, batteryCapacity, lauchYear, stock));
		if(mobilesCount == mobile.length){
			Mobile[] tempMobile = new Mobile[(mobile.length * 3) / 2];
			for(int i=0; i<mobile.length; i++){
				tempMobile[i] = mobile[i];
			}
			mobile = tempMobile;
		}
		mobile[mobilesCount++] = new Mobile(brand, model, RAM, priceInRs, storage, batteryCapacity, lauchYear, stock);
		
	}
	static void addEarphone(){
		try{
			out.print("Enter Earphone Brand	\t: ");
			String brand = scan.next();
			out.print("Connectivity Type\n1. Wired 2. Bluetooth\nSelect Connectivity \t\t: ");
			short isWired = scan.nextShort();
			String connectivity;
			do{
				connectivity = (isWired==1 ? "Wired" : (isWired == 2) ? "Bluetooth" : "Invalid");
			} while(connectivity.equals("Invalid"));
			out.print("Is it Contains Mic : \n1. Yes\n2. No\nEnter Option	\t\t: ");
			short hasMic = scan.nextShort();
			String withMic;
			do{
				withMic = (hasMic == 1 ? "Yes" : (hasMic == 2) ? "No" : "Invalid");
			} while(withMic.equals("Invalid"));
			out.print("Enter Item Model 	\t: ");
			String model = scan.next();
			out.print("Enter Item Price 	\t: ");
			float priceInRs = scan.nextFloat();
			out.print("Enter Initial Stock	\t: ");
			int stock = scan.nextInt();
			if(earPhonesCount == earPhones.length){
				EarPhones[] tempEarPhones = new EarPhones[(earPhones.length * 3) / 2];
				for(int i=0; i<earPhones.length; i++)
					tempEarPhones[i] = earPhones[i];
				earPhones = tempEarPhones;
			}
		//	earPhones.add(new EarPhones(brand, connectivity, withMic, model, priceInRs, stock));
			earPhones[earPhonesCount++] = new EarPhones(brand, connectivity, withMic, model, priceInRs, stock);
		} catch(InputMismatchException e){
			out.println("Input Mismatch found.!");
		}
	}
	static void listMobilePhones(User user){
		
		while(true){
			int itemIndex;
			int choice;
			try{
				itemIndex = 0;
				out.print("\n\n1. List Items\n2. Add Item to Cart\n3. Back to Customer Page\nEnter Choice	: ");
				choice = scan.nextInt();
			
				switch(choice){
					case 1: for(int i=0; i<mobilesCount ; i++)
							out.println(
								"\nItem Number\t: "+ ++itemIndex 
								+ "\nBrand\t\t: " + mobile[i].brand 
								+ "\nModel\t\t: " + mobile[i].model 
								+"\nRAM\t\t: "+ mobile[i].RAM 
								+ "\nMRP Price\t: " + mobile[i].priceInRs 
								+ "\nOffer Price\t: "+ mobile[i].discountPrice 
								+ "\nStorage\t\t: " + mobile[i].storage 
								+ "\nBattery\t\t: " + mobile[i].batteryCapacity 
								+ "\nLaunch Year\t: " + mobile[i].lauchYear
								+ "\nStock\t\t: "+ mobile[i].stock
							);
							
						break;
					case 2: out.print("Enter Item Number to Add to Cart 	: ");
						int index = scan.nextInt();
					
						out.print("Enter Number of Items of Same Type	: ");
						int numOfItems = scan.nextInt();
						if(index-1 < earPhonesCount && numOfItems <= mobile[index-1].stock && mobile[index-1].stock - numOfItems >= 1){
				//			String type = mobile.get(index-1).type;
							String type = mobile[index-1].type;
				//			String brand = mobile.get(index-1).brand;
							String brand = mobile[index-1].brand;
				//			String model = mobile.get(index-1).model;
							String model = mobile[index-1].model;
				//			float priceInRs = mobile.get(index-1).priceInRs;
							float priceInRs = mobile[index-1].priceInRs;
						
							float discountPrice = mobile[index-1].discountPrice;
				//			user.cartAmount += (mobile.get(index-1).priceInRs)*numOfItems;
							user.cartAmount += (discountPrice * numOfItems);
							user.cartMRP += (priceInRs * numOfItems);
				//			earPhones.get(index-1).stock -= numOfItems;
							mobile[index-1].stock -= numOfItems;
				//			user.cartItems.add(new Electronics(type, brand, model, priceInRs, numOfItems));
							if(user.itemsCount == user.cartItems.length)
								user.cartItems = resize(user.cartItems);
							user.cartItems[user.itemsCount++] = new CartItems(type, brand, model, priceInRs, numOfItems, discountPrice);
						}
						else if(mobile[index-1].stock - numOfItems < 1)
							out.println("Out of Stock.!\t Please Check Items Stock Once Before Purchasing.!");
						break;
					case 3: return;
					default: out.println("Invalid Option.!");
				}
			
			} catch (ArrayIndexOutOfBoundsException e) {
				out.println("Someting went Wrong.!! Please Try Again Later.!!");
				break;
			} catch(InputMismatchException e){
				out.println("Input Mismatch found.!");
			} catch(NullPointerException e){
				out.println("No Items found.! Please Check Your Option.!");
			}
		}
	}
	static void listEarPhones(User user){
		while(true){
			try{
				int itemIndex = 0;
				out.print("\n\n1. List Items\n2. Add Item to Cart\n3. Back to Customer Page\nEnter Choice	: ");
				int choice = scan.nextInt();
			
				switch(choice){
					case 1: for(int i=0; i<earPhonesCount; i++)
							out.println(
								"\nItem Number\t: "+ ++itemIndex 
								+ "\nBrand \t\t: " + earPhones[i].brand 
								+"\nConnectivity\t: "+ earPhones[i].connectivity 
								+"\nWith MicroPhone\t: " + earPhones[i].withMic 
								+ "\nModel\t\t: " + earPhones[i].model 
								+ "\nMRP\t\t: "+ earPhones[i].priceInRs 
								+ "\nOffer Price\t: "+ earPhones[i].discountPrice 
								+"\nStock Left\t: "+ earPhones[i].stock+"\n"
							);
							
					case 2: out.print("Enter Item Number to Add to Cart 	: ");
						int index = scan.nextInt();
						out.print("Enter Number of Items of Same Type	: ");
						int numOfItems = scan.nextInt();
						if(index-1 < earPhonesCount && numOfItems <= earPhones[index-1].stock && earPhones[index-1].stock - numOfItems >= 1){
							String type = earPhones[index-1].type;
							String brand = earPhones[index-1].brand;
							String model = earPhones[index-1].model;
							float priceInRs = earPhones[index-1].priceInRs;
							float discountPrice = earPhones[index-1].discountPrice;
							user.cartAmount += (discountPrice * numOfItems);
							user.cartMRP += (priceInRs * numOfItems);
							earPhones[index-1].stock -= numOfItems;
				//			user.cartItems.add(new Electronics(type, brand, model, priceInRs, numOfItems));
							if(user.itemsCount == user.cartItems.length)
								user.cartItems = resize(user.cartItems);
							user.cartItems[user.itemsCount++] = new CartItems(type, brand, model, priceInRs, numOfItems, discountPrice);
						}
						else if(earPhones[index-1].stock - numOfItems < 1)
							out.println("Out of Stock.!\t Please Check Items Stock Once Before Purchasing.!");
						break;
					case 3: return;
					default: out.println("Invalid Option.!");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				out.println("Someting went Wrong.!! Please Try Again.!!");
				break;
			} catch(InputMismatchException e){
				out.println("Input Mismatch found.! Please Try Again.!");
			} catch(NullPointerException e){
				out.println("No Items found.! Please Check Your Option.!");
			}
		}
	}
	/*static Electronics[] resize(Electronics[] electronics){
		Electronics[] tempElectronics = new Electronics[electronics.length];
		for(int i=0; i < electronics.length; i++)
			tempElectronics[i] = electronics[i];
		return tempElectronics;
	}*/
	static CartItems[] resize(CartItems[] cartItems){
		CartItems[] tempCartItems = new CartItems[(cartItems.length * 3 ) / 2];
		for(int i=0; i < cartItems.length; i++)
			tempCartItems[i] = cartItems[i];
		return tempCartItems;
	}
}

class OnlineShopping {
	
	public static void main(String args[]){
		out.println("\n********* WELCOME TO ONLINE SHOPPING *********");
		Application app = new Application();
	}
}
