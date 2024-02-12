import java.util.HashMap;
import java.util.Scanner;
import static java.lang.System.out;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class TwitterUI {
	
	static Scanner scan = new Scanner(System.in);
	static TwitterDataManager twitterDataManager = new TwitterDataManager();
	public static void main(String[] args) {
		
		TwitterUI ui = new TwitterUI();
		out.println("Welcome to Twitter Application.!");
		while(true) {
			out.print("1. Create Account"
				+"\n2. Login"
				+"\n3. Exit"
				+"\nEnter Your Option  : ");
			int option = scan.nextInt();
			switch(option) {
				case 1: ui.createAccount();
					break;
				case 2: ui.login();
					break;
				case 3: return;
			}
		}
	}
	
	private void createAccount() {
		out.print("Enter your Email : ");
		String email = scan.next();
		if(twitterDataManager.isUserIdExists(email)){
			out.println("Account already found.!");
			return;
		}
		out.print("Enter Your Name  : ");
		scan.nextLine();
		String name = scan.nextLine();
		String password = setPassword();
		if(password == null)
			return;
		if(twitterDataManager.createAccount(new Tweeter(email, name, password))){
			twitterDataManager.putDataIntoCollection(new Tweeter(email, name, password));
			out.println("Account Successfuly Added.!");
		}else
			out.println("Unable to Create Account.!");
	}
	
	private void login() {
		out.print("Enter User Email : ");
		String email = scan.next();
		if(!twitterDataManager.isUserIdExists(email)){
			out.println("Account Not Found.!");
			return;
		}
		out.print("Enter Password   : ");
		String password = scan.next();
		Tweeter tweeter = twitterDataManager.loginUser(new Tweeter(email, password));
		if(tweeter != null) {
		out.println("\nWELCOME BACK "+ tweeter.getUserName() + " TO TWITTER.!" );
			while(true) {
				out.print("\n1. Tweet"
					 +"\n2. View Tweet"
					 +"\n3. Follow"
					 +"\n4. Unfollow"
					 +"\n5. View Followers"
					 +"\n6. View Following"
					 +"\n7. Logout"
					 +"\nEnter Your Option   : ");
				int option = scan.nextInt();
				switch(option) {
					case 1: tweet(tweeter);
						break;
					case 2: viewTweets(tweeter);
						break;
					case 3: follow(tweeter);
						break;
					case 4: unfollow(tweeter);
						break;
					case 5: viewFollowers(tweeter);
						break;
					case 6: viewFollowing(tweeter);
						break;
					case 7: return;
					default: out.println("Invalid Option.!");
				}
			}
		} else {
			out.println("Problem while Fetcing Datas.!");
		}
	}
	private void viewFollowers(Tweeter tweeter){
//		Set<Entry<String, Tweeter>> followers = tweeter.getFollowers().entrySet();
		Set<Entry<String, Tweeter>> followers = twitterDataManager.getFollowers(tweeter.getEmailId()).entrySet();
		for(Entry<String, Tweeter> follower : followers){
			out.println(">>>" + follower.getValue().getUserName());
		}
	}
	private void unfollow(Tweeter tweeter) {
		try{
			ArrayList<String> usersInFollowingList = twitterDataManager.unfollow(tweeter);
			viewUserList(usersInFollowingList);
			
			if(usersInFollowingList.size() != 0){
				out.println("Enter User Index  : ");
				int userIndex = scan.nextInt();
	//			usersData.get(usersInFollowingList.get(userIndex)).unfollow(usersInFollowingList.get(userIndex));
				tweeter.unfollow(usersInFollowingList.get(userIndex-1));
				twitterDataManager.unfollowAUser(new Follow(usersInFollowingList.get(userIndex-1), tweeter.getEmailId()));
			}else{
				out.println("No Users Found.!");
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			out.println("Invalid Index");
		}
		
	}
	
	private void follow(Tweeter tweeter) {
		try{
			ArrayList<String> usersNotInFollowingList = twitterDataManager.getNotInFollowingList(tweeter);
			viewUserList(usersNotInFollowingList);
			
			if(usersNotInFollowingList.size() != 0){
				out.println("Enter User Index  : ");
				int userIndex = scan.nextInt();
				Tweeter user = twitterDataManager.getUser(usersNotInFollowingList.get(userIndex));
				tweeter.addFollowing(user);
	//			usersData.get(usersNotInFollowingList.get(userIndex)).addFollowing(tweeter);
				twitterDataManager.follow(new Follow(usersNotInFollowingList.get(userIndex-1), tweeter.getEmailId()));
			}else{
				out.println("No Users Found.!");
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			out.println("Invalid Index");
		}
	}
	private void viewUserList(ArrayList<String> users){
		for(int i = 0; i < users.size(); i++)
			out.println((i+1) + ". " + users.get(i));
	}
	
	private void viewFollowing(Tweeter tweeter){
		Set<Entry<String, Tweeter>> following = tweeter.getFollowing().entrySet();
		int i = 1;
		for(Entry<String, Tweeter> follows : following){
			out.println(i++ +". "+follows.getKey());
		}
	}
	
	private void viewTweets(Tweeter tweeter) {
		
		Set<Entry<String, Tweeter>> userFollowing = tweeter.getFollowing().entrySet();
		for(Entry<String, Tweeter> individualData : userFollowing){
			Set<Entry<Integer, Tweet>> tweetSet = individualData.getValue().getTweets().entrySet();
			for(Entry<Integer, Tweet> tweet : tweetSet){
				viewTweetData(tweet);
				label:
				if(tweet.getValue().getIsRetweetOf() == -1){
					while(true){
						out.print("\n1. View Retweets"
							 +"\n2. ReTweet"
							 +"\n3. Like"
							 +"\n4. Comment it"
							 +"\n5. View Comments"
							 +"\n6. View Next"
							 +"\n7. Back"
							 +"\nEnter  Option : ");
						int option = scan.nextInt();
						switch(option){
							case 1: viewRetweets(tweet.getValue());
								break;
							case 2: reReweet(tweet.getValue(), tweeter.getEmailId());
								break;
							case 3: like(tweet.getValue());
								break;
							case 4: commentOnTweet(tweet.getValue(), tweeter.getEmailId());
								break;
							case 5: viewComments(tweet.getValue().getComments());
								break;
							case 6: break label;
							case 7: return;
							default: out.println("Invalid Option.!");
						}
					}
				}
			}
		}
	}
	
	private void like(Tweet tweet){
		twitterDataManager.hitLike(tweet);
	}
	
	private void viewTweetData(Entry<Integer, Tweet> tweet){
		String name = twitterDataManager.getUserOfEmail(tweet.getValue().getTweeterEmail());
		out.println("\n==============================================================================");
		out.printf("%-20s",name);
		out.print("----- Tweet ID : "+tweet.getValue().getTweetId() +"-----"+tweet.getValue().getTimeOfTweet()
			  +"\n"+ tweet.getValue().getTweetId() + ". " + tweet.getValue().getTweet()
			  +"\nLikes : "+ tweet.getValue().getLikes()
			  +"\tComments : "+ tweet.getValue().getNumberOfComments()
			  +"\tRetweets : "+ tweet.getValue().getReTweets().size());
			  int retweetOf = tweet.getValue().getIsRetweetOf();
			  if(retweetOf != -1)
			  	out.print("\tRetweet Of Tweet ID : "+retweetOf);
			  out.println("\n==============================================================================");
	}
	
	private void viewRetweets(Tweet tweet){
		if(tweet.getReTweets().size() == 0){
			out.println("No Retweets Found.!");
			return;
		}
		Set<Entry<Integer, Tweet>> reTweetSet = tweet.getReTweets().entrySet();
		for(Entry<Integer, Tweet> reTweetData : reTweetSet){
			viewTweetData(reTweetData);
		}
	}
	
	private void reReweet(Tweet tweet, String email){
		out.print("Enter Text to Retweet  : ");
		scan.nextLine();
		String reTweet = scan.nextLine();
		Date date = new Date();
		long time = date.getTime();
		Timestamp timeStamp = new Timestamp(time);
		twitterDataManager.addReTweet(email, reTweet, timeStamp, tweet.getTweetId(), tweet);
	}
	
	private void commentOnTweet(Tweet tweet, String commenterEmail){
		out.print("Enter your Comment : ");
		scan.nextLine();
		String commentLine = scan.nextLine();
		twitterDataManager.commentOnTweet(commenterEmail, tweet.getTweetId(), commentLine, tweet);
	//	twitter.addComment(new Comment(commentId++, commenterEmail, tweet.getTweetId(), commentLine), tweet);
	}
	
	private void viewComments(ArrayList<Comment> comments){
		out.println("\n:::COMMENTS:::");
		for(Comment comment : comments){
			String name = twitterDataManager.getUserName(comment.getCommenterEmail());
			out.println(name +" >> "+ comment.getComment());
		}
	}
	
	private void tweet(Tweeter tweeter) {
		out.print("Enter Your Tweet  : ");
		scan.nextLine();
		String tweet = scan.nextLine();
		if(twitterDataManager.tweet(tweet, tweeter.getEmailId())){
			Date date = new Date();
			long time = date.getTime();
			Timestamp timeStamp = new Timestamp(time);
			twitterDataManager.setUserData(tweeter.getEmailId(), tweet, timeStamp);
			out.println("Tweet Posted.!");
		}else{
			out.println("Unable to Upload Yout Tweet.!");
		}
	}
	
	private String setPassword(){
		String newPassword;
		boolean isValidPassword = false;
		do{
			out.print("Enter Password          : ");
			newPassword = scan.next();
			
			isValidPassword = !validatePassword(newPassword);
			if(isValidPassword){
				out.print("Do you want to try another Password ? (y / n)  : ");
				char choice = scan.next().charAt(0);
				if(choice == 'y' || choice == 'Y')
					continue;
				else
					return null;
			}
		}while(isValidPassword);
		
		String confirmPassword;
		boolean isPasswordsMatching = true;
		do{
			out.print("Confirm Password        : ");
			confirmPassword = scan.next();
			
			isPasswordsMatching = !newPassword.equals(confirmPassword);
			if(isPasswordsMatching){
				out.print("Password Mismatched.!\nDo you want to try again ? (y / n) : ");
				char choice = scan.next().charAt(0);
				if(choice == 'y' || choice == 'Y')
					continue;
				else
					return null;
			}
		} while(isPasswordsMatching);
		return confirmPassword;
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
