import java.util.Scanner;
import static java.lang.System.out;
import java.time.LocalDate;

       /* DONATOR DETAILS

	* Donation
	* Contributor Name 
	* Campaign 
	* Payment Method 
	* Description 
	* Email ID 
	* Amount USD 
	* Payment Date [dd-MMM-yyyy]
	
	*/
class Donator{
	private String donatorName;
	private String campaignName;
	private String paymentMethod;
	private String description;
	private String email;
	private float amount;
	private LocalDate paymentDate;
	
	Donator(String donatorName, String campaignName, String email, float amount){
		this.donatorName = donatorName;
		this.campaignName = campaignName;
		this.email = email;
		this.amount = amount;
	}
	void setPaymentMethod(String paymentMethod){
		this.paymentMethod = paymentMethod;
	}
	void setPaymentDate(LocalDate paymentDate){
		this.paymentDate = paymentDate;
	}
}

/* 	  CAMPAIGN DETAILS

	 * Owner
	 * Campaign Name
	 * Status - Not Started , Running Completed
	 * Launch Date
	 * Fundraiser Deadline
	 * Fundraising Goal
	 * Amount Raised
	 * Description
	 * Event
	 * Campaign - Completed Campaigns - Ongoing Campaigns
	 
	 */
class Campaign{
	private String ownerName;
	private String campaignName;
	private String status;
	private LocalDate launchDate;
	private LocalDate deadLine;
	private double fundRaisingGoal;
	private float amountRaised;
	private String description;
	private String event;
	private Donator[] donator;
	
	Campaign(String ownerName, String campaignName, LocalDate launchDate, double fundRaisingGoal, String description){
		donator = new Donator[10];
		this.ownerName = ownerName;
		this.campaignName = campaignName;
		this.launchDate = launchDate;
		this.fundRaisingGoal = fundRaisingGoal;
		this.description = description;
	}
	void setStatus(String status){
		this.status = status;
	}
	String getOwnerName(){
		return ownerName;
	}
	String getCampaignName(){
		return campaignName;
	}
	double getFundRaisingGoal(){
		return fundRaisingGoal;
	}
	void addCampaignAmount(float amountRaised){
		this.amountRaised += amountRaised;
	}
	void setEvent(String event){
		this.event = event;
	}
	Donator[] getAllDonatorsDetails(){
		return donator;
	}
	Donator getDonatorDetails(int donatorIndex){
		return donator[donatorIndex];
	}
}

class CampaignManager{

	Campaign []campaign;
}

class CampaignManagementUI{
	public static void main(String args[]){
		CampaignManager manager = new CampaignManager(); 
		out.println("\n\t******** WELCOME TO CAMPAIGN MANAGEMENT ********");
	}
}
