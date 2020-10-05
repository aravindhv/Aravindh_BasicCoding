import static java.lang.System.out;
import java.time.LocalDate;
import java.util.Scanner;

class Donator{
	String contributorName;
	String campaign;
	String paymentMethod;
	String description;
	String emailId;
	float amount;
	LocalDate paymentDate;
	
	Donator(String contributorName, String campaign, String paymentMethod, String description, String emailId, float amount, LocalDate paymentDate){
		this.contributorName = contributorName;
		this.campaign = campaign;
		this.paymentMethod = paymentMethod;
		this.description = description;
		this.emailId = emailId;
		this.amount = amount;
		this.paymentDate = paymentDate;
	}
}

class Campaign{
	
	String owner;
	String campaignName;
	String status;
	LocalDate launchDate;
	LocalDate fundraiserDeadline;
	String fundraisingGoal;
	int amountRaised;
	String description;
	String event;
	int donatorIndex = 0;
	Donator donator[] = new Donator[10];
	
	Campaign(String owner, String campaignName, String status, LocalDate launchDate, LocalDate fundraiserDeadline, String fundraisingGoal, int amountRaised, String description, String event){
		this.owner = owner;
		this.campaignName = campaignName;
		this.status = status;
		this.launchDate = launchDate;
		this.fundraiserDeadline = fundraiserDeadline;
		this.fundraisingGoal = fundraisingGoal;
		this.amountRaised = amountRaised;
		this.description = description;
		this.event = event;
	}
}

class ManageDonatorsAndCampaigns{
	
	static Scanner scan = new Scanner(System.in);
	
	int index = -1;
	Campaign[] campaign = new Campaign[10];
	int campaignFund = 0;
	
	void addCampaign(){
		index++;
		out.println(":::::::::: ENTER CAMPAIGN "+ (index+1) +" DETAILS ::::::::::");
		out.print("Enter Owner Name                            : ");
		String owner = scan.nextLine();
		
		out.print("Enter Campaign Name                         : ");
		String campaignName = scan.nextLine();
		
		out.print("\n1.Not Started\n2.Running\n3.Completed\nSelect Campaign status Option               : ");
		int statusIndex = scan.nextInt();
		String status = statusIndex == 1 ? "Not Started" : statusIndex == 2 ? "Running" : "Completed";
		out.println("Entered Status                              : "+ status);
		scan.nextLine();
		out.print("Enter Campaign Launch Date (dd-mm-yyyy)     : ");
		String date[] = scan.next().split("-");
		LocalDate launchDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
		
		out.print("Enter Fundraiser Deadline Date (dd-mm-yyyy) : ");
		date = scan.next().split("-");
		LocalDate fundRaiserDeadline = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));;
		boolean isBefore = false;
		while(fundRaiserDeadline.isBefore(launchDate)){
			if(isBefore){
				out.print("Invalid Date Please Enter Again(dd-mm-yyyy) : ");
				date = scan.next().split("-");
				fundRaiserDeadline = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
			}
			if(fundRaiserDeadline.isBefore(launchDate))
				isBefore = true;
		}
		scan.nextLine();
		out.print("Enter Fund Raising Goal                     : ");
		String fundRaisingGoal = scan.nextLine();
		
		out.print("Enter Raised Fund                           : ");
		int amountRaised = scan.nextInt();
		scan.nextLine();
		
		out.print("Enter Campaign Description                  : ");
		String description = scan.nextLine();
		
		out.print("Enter Event                                 : ");
		String event = scan.nextLine();
		if(index+1 == campaign.length)
			resize(1);
		campaign[index] = new Campaign(owner, campaignName, status, launchDate, fundRaiserDeadline, fundRaisingGoal, amountRaised, description, event);
		
		System.out.println("\n\n1.Add Donator\n2.View Donator List\n3.Back to Main Menu\n4.Exit\nEnter Your Choice : ");	
		int choice = scan.nextInt();
		switch(choice){
			case 1: if(campaign[index].donatorIndex == campaign[index].donator.length)
					resize(2);
				addDonator(campaign[index].campaignName, index);
				scan.nextLine();
				break;
			case 2: viewDonator(campaign[index]);
				break;
			case 3: return;
			case 4: System.exit(0);
		}
	}
	
	void viewCampaign(){
		if(index == -1){
			out.println("No Campaigns found.!");
		}
		for(int i=0; i<= index; i++){
			out.println("\n########################## CAMPAIGN DETAILS ##########################\n");
			out.println("Owner            : "+ campaign[i].owner);
			out.println("Campaign Name    : "+ campaign[i].campaignName);
			out.println("Status           : "+ campaign[i].status);
			int date = campaign[i].launchDate.getDayOfMonth();
			int month = campaign[i].launchDate.getMonthValue();
			int year = campaign[i].launchDate.getYear();
			out.println("LaunchDate       : "+ date + "-" + (month<10 ? "0"+ month: month) + "-" + year);
			date = campaign[i].fundraiserDeadline.getDayOfMonth();
			month = campaign[i].fundraiserDeadline.getMonthValue();
			year = campaign[i].fundraiserDeadline.getYear();
			out.println("Deadline         : "+ date + "-" + (month<10 ? "0"+ month: month) + "-" + year);
			out.println("FundRaising Goal : "+ campaign[i].fundraisingGoal);
			out.println("Raised Fund      : "+ campaign[i].amountRaised);
			out.println("Description      : "+ campaign[i].description);
			out.println("Event            : "+ campaign[i].event);
			out.println("\n######################################################################");
			label:
			while(true){
				out.println("\n\n1.View Next Campaign\n2.Add Donator\n3.View Donator List\n4.Back to Main Menu\n5.Exit\nEnter Your Choice : ");	
				int choice = scan.nextInt();
				scan.nextLine();
				switch(choice){
					case 1: break label;
					case 2: addDonator(campaign[i].campaignName, i);
						break;
					case 3: viewDonator(campaign[i]);
						break;
					case 4: return;
					case 5: System.exit(0);
				}
			}
		}
	}
	void addDonator(String name, int campaignIndex){
		scan.nextLine();
		out.print(  "Enter Contributor Name          : ");
		String contributorName = scan.nextLine();
		String campaignName = name;
		out.print("Select Payment Method           : \n1.Cash\n2.Cheque\n3.Card                             :");
		int paymentMethodIndex = scan.nextInt();
		String paymentMethod = paymentMethodIndex == 1 ? "Cash" : paymentMethodIndex == 2 ? "Cheque" : "Card";
		out.println("\nEntered Payment Option          : "+ paymentMethod);
		scan.nextLine();
		out.println("Enter Donator Description       : ");
		String description = scan.nextLine();
		out.print("Enter Email                     : ");
		String emailId = scan.next();
		out.print("Enter Donation Amount           : ");
		float amount = scan.nextFloat();
		campaign[campaignIndex].amountRaised += amount;
		out.print("Enter Payment Date (dd-mm-yyyy) : ");
		String date[] = scan.next().split("-");
		LocalDate paymentDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
		while(paymentDate.isBefore(campaign[campaignIndex].launchDate) || paymentDate.isAfter(campaign[campaignIndex].fundraiserDeadline)){
			System.out.println("Date is Out of Campaign Date.!");
			out.print("Enter Payment Date (dd-mm-yyyy) : ");
			date = scan.next().split("-");
			paymentDate = LocalDate.of(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
		}
		campaign[campaignIndex].donator[campaign[campaignIndex].donatorIndex++] = new Donator(contributorName, campaignName, paymentMethod, description, emailId, amount, paymentDate);
	}
	void viewDonator(Campaign campaign){
		if(campaign.donatorIndex == -1){
			out.println("No Donators Found.!");
			return;
		}
		for(int i=0; i<campaign.donatorIndex; i++){
			out.println("######################## DONATOR DETAILS ########################");
			out.println("\nContributer Name : "+ campaign.donator[i].contributorName);
			out.println("Campaign Name    : "+ campaign.donator[i].campaign);
			out.println("Payment Method   : "+ campaign.donator[i].paymentMethod);
			out.println("Description      : "+ campaign.donator[i].description);
			out.println("Email ID         : "+ campaign.donator[i].emailId);
			out.println("Amount Given     : "+ campaign.donator[i].amount);
			int date = campaign.donator[i].paymentDate.getDayOfMonth();
			int month = campaign.donator[i].paymentDate.getMonthValue();
			int year = campaign.donator[i].paymentDate.getYear();
			out.println("Payment Date     : "+ (date < 10 ? "0"+date : date) + "-" + (month < 10 ? "0"+ month: month) + "-" + year);
			out.println("\n#################################################################");
		}
	}
	void resize(int object){
		if(object == 1){
			Campaign temp[] = new Campaign[(campaign.length * 3) / 2];
			for(int i=0; i < campaign.length; i++){
				temp[i] = campaign[i];
			}
			campaign = temp;
		} else if(object == 2){
			Donator temp[] = new Donator[(campaign[index].donator.length * 3) / 2];
			for(int i=0; i < campaign[index].donator.length; i++)
				temp[i] = campaign[index].donator[i];
			campaign[index].donator = temp;
		}
	}
}
class DonatorAndCampaignManagement{
	static Scanner scan = new Scanner(System.in);
	public static void main(String args[]){
		ManageDonatorsAndCampaigns manageDonatorAndCampaign = new ManageDonatorsAndCampaigns();
		mainMenu:
		while(true){
			out.println("\n1.Add Campaign\n2.View Campaign List\n3.Exit\nEnter Your Choice : ");
			int choice = scan.nextInt();
			switch(choice){
				case 1: manageDonatorAndCampaign.addCampaign();
					scan.nextLine();
					break;
				case 2: manageDonatorAndCampaign.viewCampaign();
					break;
				case 3: System.exit(0);
			}
		}
	}
}
