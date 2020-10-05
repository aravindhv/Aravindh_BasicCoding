import java.util.Scanner;
import static java.lang.System.out;
import java.util.InputMismatchException;

class Products{

	private String type;
	private String brand;
	private String model;
	private float priceInRs;
	private int stock;
	private int numberOfItems;
	private String retailerName;
	private float discountPrice;
	Products(String type, String brand, String model, float priceInRs, int stock, int numberOfItems, float discountPrice, String retailerName){
		this.type = type;
		this.model = model;
		this.brand = brand;
		this.priceInRs = priceInRs;
		this.stock = stock;
		this.numberOfItems = numberOfItems;
		this.discountPrice = discountPrice;
		this.retailerName = retailerName;
	}
	int getNumberOfItems(){
		return numberOfItems;
	}
	String getRetailerName(){
		return retailerName;
	}
	String getType(){
		return type;
	}
	String getBrand(){
		return brand;
	}
	String getModel(){
		return model;
	}
	float getPrice(){
		return priceInRs;
	}
	int getStock(){
		return stock;
	}
	float getDiscountPrice(){
		return discountPrice;
	}
	void setDiscountPrice(float discountPrice){
		this.discountPrice = discountPrice;
	}
}

class Mobile{
	private String type = "Mobile";
	private String retailerName;
	private String brand;
	private String model;
	private short RAM;
	private float priceInRs;
	private short storage;
	private short batteryCapacity;
	private short launchYear;
	
	private int stock;
	private float discountPrice;
	private static float dealPercent;
	
	Mobile(String retailerName, String brand, String model, short RAM, float priceInRs, short storage, short batteryCapacity, short launchYear, int stock){
		this.retailerName = retailerName;
		this.brand = brand;
		this.model = model;
		this.RAM = RAM;
		this.priceInRs = priceInRs;
		this.storage = storage;
		this.batteryCapacity = batteryCapacity;
		this.launchYear = launchYear;
		this.stock = stock;
		discountPrice = priceInRs;
	}
	String getAdminName(){
		return retailerName;
	}
	String getType(){
		return type;
	}
	String getBrand(){
		return brand;
	}
	String getModel(){
		return model;
	}
	short getRAM(){
		return RAM;
	}
	float getPrice(){
		return priceInRs;
	}
	short getStorage(){
		return storage;
	}
	short getBatteryCapacity(){
		return batteryCapacity;
	}
	short getLaunchYear(){
		return launchYear;
	}
	void newStock(int newStock){
		stock += newStock;
	}
	int getStock(){
		return stock;
	}
	void setDiscountPercent(float dealPercent){
		this.dealPercent = dealPercent;
	}
	void setDiscount(){
		discountPrice = priceInRs - ((priceInRs * dealPercent)/100);
	}
	float getDiscountPrice(){
		return discountPrice;
	}
}

class EarPhone{
	private String type = "EarPhones";
	private String retailerName;
	private String brand;
	private String connectivity;
	private String withMic;
	private String model;
	private float priceInRs;
	private int stock;
	private float discountPrice;
	private static float dealPercent;
	
	EarPhone(String retailerName, String brand, String connectivity, String withMic, String model, float priceInRs, int stock){
		this.retailerName = retailerName;
		this.brand = brand;
		this.connectivity = connectivity;
		this.withMic = withMic;
		this.model = model;
		this.priceInRs = priceInRs;
		this.stock = stock;
		this.discountPrice = priceInRs;
	}
	String getType(){
		return type;
	}
	String getAdminName(){
		return retailerName;
	}
	String getBrand(){
		return brand;
	}
	String getConnectivity(){
		return connectivity;
	}
	String getWithMic(){
		return withMic;
	}
	String getModel(){
		return model;
	}
	float getPrice(){
		return priceInRs;
	}
	void newStock(int newStock){
		this.stock += newStock;
	}
	int getStock(){
		return stock;
	}
	void setDiscountPercent(float dealPercent){
		this.dealPercent = dealPercent;
	}
	void setDiscount(){
		discountPrice = priceInRs - ((priceInRs * dealPercent)/100);
	}
	float getDiscountPrice(){
		return discountPrice;
	}
}

class Admin{
	private String name;
	private String adminId;
	private String password;
	private int numberOfItemsUploaded;
	private int earPhonesCount;
	private int mobilesCount;
	private Mobile[] mobiles = new Mobile[10];
	private EarPhone[] earPhones = new EarPhone[10];
	private float moneyEarned = 0;
	
	Admin(String name, String adminId, String password){
		this.name = name;
		this.adminId = adminId;
		this.password = password;
	}
	String getName(){
		return name;
	}
	String getAdminId(){
		return adminId;
	}
	String getPassword(){
		return password;
	}
	int getNumberOfItemsUploaded(){
		return numberOfItemsUploaded;
	}
	Mobile[] getMobiles(){
		return mobiles;
	}
	EarPhone[] getEarPhones(){
		return earPhones;
	}
	void setMobiles(Mobile mobiles[]){
		this.mobiles = mobiles;
	}
	void setEarPhones(EarPhone earPhones[]){
		this.earPhones = earPhones;
	}
	int getEarPhonesCount(){
		return earPhonesCount;
	}
	int getMobilesCount(){
		return mobilesCount;
	}
	void setMobilesValue(Mobile items){
		if(mobilesCount == mobiles.length){
			Mobile []tempMobiles = new Mobile[mobilesCount + 10];
			for(int i = 0; i < mobilesCount; i++)
				tempMobiles[i] = mobiles[i];
			mobiles = tempMobiles;
		}
		mobiles[mobilesCount++] = items;
		numberOfItemsUploaded++;
	}
	void setEarPhonesValue(EarPhone items){
		if(earPhonesCount == earPhones.length){
			EarPhone []tempEarPhones = new EarPhone[earPhonesCount + 10];
			for(int i = 0; i < earPhonesCount; i++)
				tempEarPhones[i] = earPhones[i];
			earPhones = tempEarPhones;
		}
		earPhones[earPhonesCount++] = items;
		numberOfItemsUploaded++;
	}
	float getMoneyEarned(){
		return moneyEarned;
	}
	void setMoneyEarned(float money){
		this.moneyEarned += money;
	}
}

class User{
	private String name;
	private String userId;
	private String password;
	private int numberOfItemsInCart = 0;
	private int numberOfUniqueItems = 0;
	private double amountToBePaid = 0;
	private Products[] cart = new Products[10];
	private int orderedItemsCount = 0;
	User(String name, String userId, String password){
		this.name = name;
		this.userId = userId;
		this.password = password;
	}
	
	String getName(){
		return name;
	}
	String getUserId(){
		return userId;
	}
	String getPassword(){
		return password;
	}
	void resetCart(){
		numberOfUniqueItems = 0;
		numberOfItemsInCart = 0;
		amountToBePaid = 0;
		cart = new Products[10];
	}
	void setNumberOfItemsInCart(int numOfItems){
		numberOfItemsInCart += numOfItems;
	}
	int getNumberOfItemsInCart(){
		return numberOfItemsInCart;
	}
	int getNumberOfUniqueItems(){
		return numberOfUniqueItems;
	}
	void addItemsToCart(Products product){
		if(numberOfItemsInCart == cart.length){
			Products[] tempCart = new Products[numberOfItemsInCart + 10];
			for(int i=0; i < numberOfItemsInCart; i++)
				tempCart[i] = cart[i];
			cart = tempCart;
		}
		numberOfItemsInCart += product.getNumberOfItems();
		amountToBePaid += (product.getNumberOfItems() * product.getDiscountPrice());
		cart[numberOfUniqueItems++] = product;
	}
	Products[] getCartItems(){
		return cart;
	}
	double getAmountToBePaid(){
		return amountToBePaid;
	}
}


class ShoppingApplication{

	private User[] user = new User[10];
	private Admin[] admin = new Admin[10];
	private static Mobile[] mobiles = new Mobile[10];
	private static EarPhone[] earPhones = new EarPhone[10];
	int userIndex = 0, adminIndex = 0, mobilesIndex = 0, earPhonesIndex = 0;
	
	ShoppingApplication(){
		out.println("\n\t**** WELCOME TO ONLINE SHOPPING ****\n");
	}
	
	User getUser(int userIndex){
		return user[userIndex];
	}
	
	Admin getAdmin(int adminIndex){
		return admin[adminIndex];
	}
	
	void showCart(int userIndex){
		try{
			Products[] cart = user[userIndex].getCartItems();
			int itemsCount = user[userIndex].getNumberOfItemsInCart();
			out.printf("Amount to be Paid     : %.2f\n", user[userIndex].getAmountToBePaid());
			for(int i=0; i < itemsCount; i++){
				out.println("\nType           : "+ cart[i].getType()
					   +"\nBrand          : "+ cart[i].getBrand()
					   +"\nModel          : "+ cart[i].getModel()
					   +"\nSold By        : "+ cart[i].getRetailerName()
					   +"\nCount          : "+ cart[i].getNumberOfItems()
					   +"\nMRP            : "+ cart[i].getPrice()
					   +"\nDiscount Price : "+ cart[i].getDiscountPrice()
					   +"\nStock          : "+ cart[i].getStock()
				);
			}
		} catch(NullPointerException e){
			out.println("Something went Wrong.!");
		} catch(ArrayIndexOutOfBoundsException e){
			out.println("------ ****** -------");
		}
	}
	
	void setUserId(User user){
		if(userIndex == this.user.length){
			User tempUser[] = new User[userIndex + 10];
			for(int i = 0; i < userIndex; i++)
				tempUser[i] = this.user[i];
			this.user = tempUser;
		}
		this.user[userIndex++] = user;
		out.println("\nUser Account Created Successfully..!");
	}
	
	void setAdminId(Admin admin){
		if(adminIndex == this.admin.length){
			Admin tempAdmin[] = new Admin[adminIndex + 10];
			for(int i = 0; i < adminIndex; i++)
				tempAdmin[i] = this.admin[i];
			this.admin = tempAdmin;
		}
		this.admin[adminIndex++] = admin;
		out.println("\nAdmin Account Created Successfully..!");
	}
	
	boolean validateUserId(String userId, String domain){
		if(domain.equals("user")){
			for(int i = 0; i < userIndex; i++){
				if(user[i].getUserId().equals(userId)){
					out.println("\nUser Id already found.! Please Try another User Id.!");
					return true;
				}
			}
		} else if(domain.equals("admin")){
			for(int i = 0; i < adminIndex; i++){
				if(admin[i].getAdminId().equals(userId)){
					out.println("\nAdmin Id already found.! Please Try another admin Id.!");
					return true;
				}
			}
		}
		return false;
	}
	
	int adminLogin(String adminId, String password){
		for(int i = 0; i < adminIndex; i++){
			if(admin[i].getAdminId().equals(adminId) && admin[i].getPassword().equals(password)){
				out.println("\n\t\tSuccessfully Logged in.!\n");
				return i;//admin[i];
			}
		}
		return -1;
	}
	
	int userLogin(String userId, String password){
		for(int i = 0; i < userIndex; i++){
			if(user[i].getUserId().equals(userId) && user[i].getPassword().equals(password)){
				out.println("\n\t\tSuccessfully Logged in.!\n");
				return i;
			}
		}
		return -1;
	}
	
	/* itemType = 1 --> Mobiles
	 * itemType = 2 --> EarPhone
	 * sortType = 1 --> Sort by Cost (low to High)
	 * sortType = 2 --> Sort by Cost (High to Low)
	 */
	 
	void exploreProducts(int itemType, int sortType){
		if(itemType == 1 && sortType == 1){
			for(int i=0; i < mobilesIndex-1; i++){
				for(int j = i + 1; j < mobilesIndex; j++){
					if(mobiles[i].getPrice() > mobiles[j].getPrice()){
						Mobile tempMobile = mobiles[i];
						mobiles[i] = mobiles[j];
						mobiles[j] = tempMobile;
					}
				}
			}
			
		} else if(itemType == 1 && sortType == 2){
			for(int i = 0; i < mobilesIndex-1; i++){
				for(int j = i + 1; j < mobilesIndex; j++){
					if(mobiles[i].getPrice() < mobiles[j].getPrice()){
						Mobile tempMobile = mobiles[i];
						mobiles[i] = mobiles[j];
						mobiles[j] = tempMobile;
					}
				}
			}
		} else if(itemType == 2 && sortType == 1){
			for(int i = 0; i < earPhonesIndex-1; i++){
				for(int j=i+1; j < earPhonesIndex; j++){
					if(earPhones[i].getPrice() > earPhones[j].getPrice()){
						EarPhone tempEarphone = earPhones[i];
						earPhones[i] = earPhones[j];
						earPhones[j] = tempEarphone;
					}
				}
			}
			
		} else if(itemType == 2 && sortType == 2){
			for(int i = 0; i < earPhonesIndex-1; i++){
				for(int j = i + 1; j < earPhonesIndex; j++){
					if(earPhones[i].getPrice() < earPhones[j].getPrice()){
						EarPhone tempEarphone = earPhones[i];
						earPhones[i] = earPhones[j];
						earPhones[j] = tempEarphone;
					}
				}
			}
		}
	//	exploreProducts(itemType);
		viewProducts(null, itemType);
	}
	
	/* Type = 1 --> Mobiles 
	 * Type = 2 --> EarPhone 
	 */
	//void exploreProducts(int type){
		/*if(type == 1){
			out.println("Mobile Items : ");
			for(int i = 0; i < mobilesIndex; i++){
				
				out.println("Item Number   : "+ (i+1)
					   +"\nBrand       : "+ mobiles[i].getBrand()
					   +"\nModel       : "+ mobiles[i].getModel()
					   +"\nSold By     : "+ mobiles[i].getAdminName()
					   +"\nRAM         : "+ mobiles[i].getRAM()
					   +"\nMRP         : "+ mobiles[i].getPrice()
					   +"\nStorage     : "+ mobiles[i].getStorage()
					   +"\nBattery     : "+ mobiles[i].getBatteryCapacity()
					   +"\nLaunch Year : "+ mobiles[i].getLaunchYear()
					   +"\nStock       : "+ mobiles[i].getStock()
				+"\n");
			}
		}else if(type == 2){
			out.println("Earphone Items : ");
			for(int i = 0; i < earPhonesIndex; i++){
				out.println("Item Number   : "+ (i+1)
					   +"\nBrand        : "+ earPhones[i].getBrand()
					   +"\nModel        : "+ earPhones[i].getModel()
					   +"\nSold By      : "+ earPhones[i].getAdminName()
				           +"\nConnectivity : "+ earPhones[i].getConnectivity()
				           +"\nMRP          : "+ earPhones[i].getPrice()
				           +"\nWith Mic     : "+ earPhones[i].getWithMic()
				           +"\nStock        : "+ earPhones[i].getStock()
				           +"\nRating       : "+ earPhones[i].getRating()
				+"\n");
			}
		}
		for(int i=0; i < adminIndex; i++)
				viewProducts(null, type);
	}	*/
	
	void addAdminProducts(Admin admin, Object items){
		if(items instanceof Mobile){
			if(admin.getMobilesCount() == admin.getMobiles().length){
				Mobile[] mobiles = admin.getMobiles();
				int totalItems = admin.getMobilesCount();
				Mobile[] tempMobiles = new Mobile[totalItems + 10];
				for(int i = 0; i < totalItems; i++)
					tempMobiles[i] = mobiles[i];
				admin.setMobiles(tempMobiles);
			}
			mobiles[mobilesIndex++] = (Mobile)items;
			admin.setMobilesValue(mobiles[mobilesIndex - 1]);//[admin.getMobilesCount()++]((Mobiles[])items);
		} else if(items instanceof EarPhone){
			if(admin.getEarPhonesCount() == admin.getEarPhones().length){
				EarPhone[] earPhones = admin.getEarPhones();
				int totalItems = admin.getEarPhonesCount();
				EarPhone[] tempEarPhones = new EarPhone[totalItems + 10];
				for(int i=0; i < totalItems; i++)
					tempEarPhones[i] = earPhones[i];
				admin.setEarPhones(tempEarPhones);
			}
			earPhones[earPhonesIndex++] = (EarPhone)items;
			admin.setEarPhonesValue(earPhones[earPhonesIndex - 1]);
		}
	}
	
	/* Type = 1 -> Mobile Items 
	 * Type = 2 -> EarPhone Items 
	 */
	void viewProducts(Admin admin, int type){
		
		if(type == 1){
			Mobile[] mobile;
			int mobilesCount;
			if(admin == null){
				mobile = mobiles;
				mobilesCount = mobilesIndex;
			} else {
				mobile = admin.getMobiles();
				mobilesCount = admin.getMobilesCount();
			}
			out.println("Mobile Items : ");
			for(int i = 0; i < mobilesCount; i++){
				out.println("Item Number      : "+ (i+1)
					   +"\nBrand          : "+ mobile[i].getBrand()
					   +"\nModel          : "+ mobile[i].getModel()
					   +"\nSold By        : "+ mobile[i].getAdminName()
					   +"\nRAM            : "+ mobile[i].getRAM()
					   +"\nMRP            : "+ mobile[i].getPrice()
					   +"\nDiscount Price : "+ mobile[i].getDiscountPrice()
					   +"\nStorage        : "+ mobile[i].getStorage()
					   +"\nBattery        : "+ mobile[i].getBatteryCapacity()
					   +"\nLaunch Year    : "+ mobile[i].getLaunchYear()
					   +"\nStock          : "+ mobile[i].getStock()
				+"\n");
			}
		} else if(type == 2){
			EarPhone[] earphone;
			int earPhonesCount;
			if(admin == null){
				earphone = earPhones;
				earPhonesCount = earPhonesIndex;
			} else {
				earphone = admin.getEarPhones();
				earPhonesCount = admin.getEarPhonesCount();
			}
			out.println("Earphone Items in Your Uploaded Products : ");
			for(int i = 0; i < earPhonesCount; i++){
				out.println("\nItem Number    : "+ (i+1)
					   +"\nBrand          : "+ earphone[i].getBrand()
					   +"\nModel          : "+ earphone[i].getModel()
					   +"\nSold By        : "+ earphone[i].getAdminName()
				           +"\nConnectivity   : "+ earphone[i].getConnectivity()
				           +"\nMRP            : "+ earphone[i].getPrice()
				           +"\nDiscount Price : "+ earphone[i].getDiscountPrice()
				           +"\nWith Mic       : "+ earphone[i].getWithMic()
				           +"\nStock          : "+ earphone[i].getStock()
				+"\n");
			}
		}
	}
	
	
	void addMobiles(int userIndex, int mobileIndex, int numberOfItems){
		if(mobiles[mobileIndex].getStock() < numberOfItems){
			out.println("Sorry.! Out of Stock.! Please Ensure the Number of Items.!");
			return;
		}
		String retailerId = mobiles[mobileIndex].getAdminName();
		for(int i=0; i < adminIndex; i++){
			if(retailerId.equals(admin[i].getAdminId())){
		//		admin[i].setMoneyEarned(numberOfItems * mobiles[mobileIndex].getDiscountPrice());
				mobiles[mobileIndex].newStock(-numberOfItems);
		/**************************************************** Code from Here *****************************************************/
			}
		}
	//	addItemsToCart(Products product)
		user[userIndex].addItemsToCart(new Products(mobiles[mobileIndex].getType(), mobiles[mobileIndex].getBrand(), mobiles[mobileIndex].getModel(), mobiles[mobileIndex].getPrice(), mobiles[mobileIndex].getStock(), numberOfItems, mobiles[mobileIndex].getDiscountPrice(), mobiles[mobileIndex].getAdminName()));
	}
	
	void addEarphones(int userIndex, int earPhoneIndex, int numberOfItems){
		if(earPhones[earPhoneIndex].getStock() < numberOfItems){
			out.println("Sorry.! Out of Stock.! Please Ensure the Number of Items.!");
			return;
		}
		String retailerId = earPhones[earPhoneIndex].getAdminName();
		for(int i=0; i < adminIndex; i++){
			if(retailerId.equals(admin[i].getAdminId())){
				admin[i].setMoneyEarned(numberOfItems * earPhones[earPhoneIndex].getDiscountPrice());
				earPhones[earPhoneIndex].newStock(-numberOfItems);
			}
		}
		user[userIndex].addItemsToCart(new Products(earPhones[earPhoneIndex].getType(), earPhones[earPhoneIndex].getBrand(), earPhones[earPhoneIndex].getModel(), earPhones[earPhoneIndex].getPrice(), earPhones[earPhoneIndex].getStock(), numberOfItems, earPhones[earPhoneIndex].getDiscountPrice(), earPhones[earPhoneIndex].getAdminName()));
	}
	
	/*  item Type -1 --> Mobiles
	 *  item Type -2 --> EarPhone
	 */
	void setDealPercent(float dealPercent, int itemType){
		if(itemType == 1){
			for(int i = 0; i < mobilesIndex; i++){
				mobiles[i].setDiscountPercent(dealPercent);
				mobiles[i].setDiscount();
			}
		} else if(itemType == 2){
			for(int i = 0; i < earPhonesIndex; i++){
				earPhones[i].setDiscountPercent(dealPercent);
				earPhones[i].setDiscount();
			}
		}
	}
	
	void itemsOrdered(int userIndex){
		int cartSize = user[userIndex].getNumberOfUniqueItems();
		for(int cartIndex = 0; cartIndex < cartSize; cartIndex++){//String retailerId = user[userIndex].getRetailerId();
			
			String retailerId = user[userIndex].getCartItems()[cartIndex].getRetailerName();
			for(int adminIndex = 0; adminIndex < this.adminIndex; adminIndex++){
				if(retailerId.equals(admin[adminIndex].getAdminId())){
					admin[adminIndex].setMoneyEarned(user[userIndex].getCartItems()[cartIndex].getNumberOfItems() * user[userIndex].getCartItems()[cartIndex].getDiscountPrice());
				//	earPhones[earPhoneIndex].newStock(-numberOfItems);
				}
			}
		}
		user[userIndex].resetCart();
	}
}

class OnlineShoppingUI{
	
	static Scanner scan = new Scanner(System.in);
	static ShoppingApplication application = new ShoppingApplication();
	
	public static void main(String args[]){
		OnlineShoppingUI ui = new OnlineShoppingUI();
		while(true){
			try{
				out.print("\n1. User Login\n2. Admin Login\n3. Create User Account\n4. Create Admin Account\n5. Exit\nEnter Choice\t: ");
				int option = scan.nextInt();
				switch(option){
					case 1: ui.loginAsUser();
						break;
					case 2: ui.loginAsAdmin();
						break;
					case 3: ui.createAccount("user");
						break;
					case 4: ui.createAccount("admin");
						break;
					case 5: System.exit(0);
					default: out.println("Invalid Option.!");
				}
			} catch(InputMismatchException e) {
				out.println("\nPlease Enter Valid Options.!");
				break;
			//	continue;
			}
		}
	}
	
	void loginAsUser(){
		out.print("Enter User Id      : ");
		String userId = scan.next();
		out.print("Enter Password     : ");
		String password = scan.next();
		int userIndex = application.userLogin(userId, password);
		if(userIndex == -1){
			out.println("\nNo Accounts found.!");
			return;
		}
		User user = application.getUser(userIndex);//application.userLogin(userId, password);
		while(true){
			
				out.println("\nName                        : "+ user.getName() + 
					    "\nNumber of Items in Cart     : "+ user.getNumberOfItemsInCart() +
					    "\nAmount to be paid           : "+ user.getAmountToBePaid() +
					    "\n1. Show Cart\n2. Explore Products\n3. Add to Cart\n4. Proceed To Pay\n5. Logout\nEnter Your Choice\t: ");
			int choice = scan.nextInt();
			switch(choice){
				case 1: application.showCart(userIndex);
					break;
				case 2: viewProducts();
					break;
				case 3: addItemsToCart(userIndex);
					break;
				case 4: proceedToPay(userIndex);
					break;
				case 5: return;
				default: out.println("Invalid Option.!");
			}
		}
	}
	
	void proceedToPay(int userIndex){
		out.println("\nYou will be Shortly redirected to Banking Payment.!\n");
		double cartAmount = application.getUser(userIndex).getAmountToBePaid();
		out.println("You Have to Pay : "+ cartAmount
			   +"\nDo you want to continue the transaction ? (y/n)"
			   +"\nBy Entering Yes(y) Rs."+ cartAmount + "will be debited from Your Account.!!");
		char transactionOption = scan.next().charAt(0);
		if(transactionOption == 'y' ||transactionOption == 'Y'){
			out.println("\nAmount Paid Successfully..!!"
				   +"Thanks for make Purchasing with us...");
			application.itemsOrdered(userIndex);
		} else {
			out.println("Sorry... We can't complete Your Transaction.!\nPlease Try Again Later.!");
		}
		
	}
	
	void addItemsToCart(int userIndex){
		while(true){
			out.print("Choose Category to View Products Details :" 
				 +"\n1. Mobiles\n2. EarPhones\n3. Back\nEnter Your Choice : ");
			int choice = scan.nextInt();
			switch(choice){
				case 1: out.print("Enter Mobile Item Number 	: ");
					int mobileIndex = scan.nextInt();
					out.print("Enter number of same item    : ");
					int numberOfItems = scan.nextInt();
					if(numberOfItems >= 1)
						application.addMobiles(userIndex, mobileIndex-1, numberOfItems);
					else
						out.println("Please Enter a Valid Number of Items.!");
					break;
					
				case 2: out.print("Enter EarPhone Item Number 	: ");
					int earPhoneIndex = scan.nextInt();
					out.print("Enter number of same item    : ");
					int numberOfEarPhoneItems = scan.nextInt();
					if(numberOfEarPhoneItems >= 1)
						application.addEarphones(userIndex, earPhoneIndex-1, numberOfEarPhoneItems);
					else
						out.println("Please Enter a Valid Number of Items.!");
					break;
				case 3: return;
				default: out.println("Invalid Option.!");
			}
		}
	}
	
	void viewProducts(){
		while(true){
			out.print("Choose Category to View Products Details :" 
				 +"\n1. Mobiles\n2. EarPhones\n3. Back\nEnter Your Choice : ");
			int choice = scan.nextInt();
			switch(choice){
				case 1: //both cases will have same implementation.
				case 2: out.print("1. Continue to View Items\n2. Sort Items\n3. Back\nEnter Option  : ");
					int option = scan.nextInt();
					switch(option){
						case 1: application.exploreProducts(choice, 0);
							break;
						case 2: out.print("\n1. Sort by Cost Low to High"
								 +"\n2. Sort by Cost High to Low"
								 +"\nEnter Option  : ");
							int sortType = scan.nextInt();
							switch(sortType){
								case 1: application.exploreProducts(choice, 1);
									break;
								case 2: application.exploreProducts(choice, 2);
									break;
								default: out.println("Invalid Option.!");
							}
							break;
						case 3: break;
					}
				case 3: return;
				default: out.println("Invalid Option.!");
			}
			
		}
	}
	
	void loginAsAdmin(){
		out.print("Enter User Id      : ");
		String adminId = scan.next();
		out.print("Enter Password     : ");
		String password = scan.next();
		int adminIndex = application.adminLogin(adminId, password);
		if(adminIndex == -1){
			out.println("\nNo Accounts found.!");
			return;
		}
		Admin admin = application.getAdmin(adminIndex);
		while(true){
			out.println("\nName                        : "+ admin.getName() + 
				    "\nNumber of Products Uploaded : "+ admin.getNumberOfItemsUploaded() +
				    "\nMoney Earned                : "+ admin.getMoneyEarned()+
				    "\n1. Add Products\n2. View Products\n3. Set Deals\n4. Logout\nEnter Your Choice\t: ");
			int choice = scan.nextInt();
			switch(choice){
				case 1: addProducts(admin);
					break;
				case 2: out.println("1. Mobiles\n2. EarPhones\nEnter Item Type : ");
					application.viewProducts(admin, scan.nextInt());
					break;
				case 3: setDeals(admin);
					break;
				case 4: return;
				default: out.println("Invalid Option.!");
			}
		}
	}
	
	void setDeals(Admin admin){
		while(true){
			out.println("Select Category to Set Deal Percent : "
				   +"\n1. Mobiles\n2. EarPhones\n3. Back\nEnter Your Choice : ");
			int choice = scan.nextInt();
			switch(choice){
				case 1: out.println("Enter Deal Percent on Mobile Items : ");
					float mobilesDeal = scan.nextFloat();
					application.setDealPercent(mobilesDeal, 1);
					break;
				case 2: out.println("Enter Deal Percent on Mobile Items : ");
					float earPhonesDeal = scan.nextFloat();
					application.setDealPercent(earPhonesDeal, 2);
					break;
				case 3: return;
				default: out.println("Invalid Option.!");
			}
		}
	}
	
	void addProducts(Admin admin){
		out.println("Choose Category :\n1. Mobile\n2. EarPhones\nEnter Your Choice	: ");
		int option = scan.nextInt();
		
		if(option == 1){
			out.print("Enter Mobile Brand               : ");
			String brand = scan.next();
			out.print("Enter Mobile Model               : ");
			String model = scan.next();
			out.print("Enter RAM (in GB)                : ");
			short RAM = scan.nextShort();
			out.print("Enter Price in Rs                : ");
			float priceInRs = scan.nextFloat();
			out.print("Enter Storage (in GB)            : ");
			short storage = scan.nextShort();
			out.print("Enter Battery Capacity (in mAh)  : ");
			short batteryCapacity = scan.nextShort();
			out.print("Enter Launch Year                : ");
			short launchYear = scan.nextShort();
			out.print("Enter Initial Stock of Product   : ");
			int stock = scan.nextInt();
			application.addAdminProducts(admin, new Mobile(admin.getName(), brand, model, RAM, priceInRs, storage, batteryCapacity, launchYear, stock));
			
		} else if(option == 2){
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
			
			application.addAdminProducts(admin, new EarPhone(admin.getName(), brand, connectivity, withMic, model, priceInRs, stock));
		}
	}
	
	void createAccount(String domain){
		
		scan.nextLine();
		out.print("Enter "+ domain +" Name    : ");
		String name = scan.nextLine();
		
		String userId;
		boolean userIdFound = false;
		do{
			out.print("Enter "+ domain +" Id      : ");
			userId = scan.next();
			userIdFound = application.validateUserId(userId, domain);
			if(userIdFound){
				out.println("Do you want to try another "+ domain +" Id ? (y / n) ");
				char choice = scan.next().charAt(0);
				if(choice == 'y' || choice == 'Y')
					continue;
				else
					return;
			}
		} while(userIdFound);
		
		String newPassword;
		boolean isValidPassword = false;
		do{
			out.print("Enter Password     : ");
			newPassword = scan.next();
			
			isValidPassword = !validatePassword(newPassword);
			if(isValidPassword){
				out.println("Do you want to try another Password ? (y / n) ");
				char choice = scan.next().charAt(0);
				if(choice == 'y' || choice == 'Y')
					continue;
				else
					return;
			}
		} while(isValidPassword);
		
		String confirmPassword;
		boolean isPasswordsMatching = true;
		do{
			out.print("Confirm Password   : ");
			confirmPassword = scan.next();
			
			isPasswordsMatching = !newPassword.equals(confirmPassword);
			if(isPasswordsMatching){
				out.println("Password Mismatched.!\nDo you want to try again ? (y / n) ");
				char choice = scan.next().charAt(0);
				if(choice == 'y' || choice == 'Y')
					continue;
				else
					return;
			}
		} while(isPasswordsMatching);
		if(domain.equals("user"))
			application.setUserId(new User(name, userId, newPassword));
		else if(domain.equals("admin"))
			application.setAdminId(new Admin(name, userId, newPassword));
	}
	
	boolean validatePassword(String password){
		if(password.length() < 8){
			out.println("Password must have minimum 8 elements.!");
			return false;
		}
		int charactersCount = 0, numbersCount = 0, specialCharacters = 0;
		for(int i = 0; i < password.length(); i++){
			if(password.charAt(i)>= 'a' && password.charAt(i) <= 'z' || password.charAt(i) >= 'A' && password.charAt(i) <= 'Z')
				charactersCount++;
			else if(password.charAt(i)-'0' >= 0 && password.charAt(i)-'0' <= 9)
				numbersCount++;
			else
				specialCharacters++;
		}
		if(charactersCount > 0 && numbersCount > 0 && specialCharacters > 0)
			return true;
		out.println("Password must have minimum 1 character, 1 number and 1 Special Character i.e.,!@#$...");
		return false;
	}
}
