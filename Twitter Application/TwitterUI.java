import java.util.HashMap;
import java.util.Scanner;
import static java.lang.System.out;
import java.sql.Timestamp;
import java.util.Date;
import java.util.ArrayList;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

public class TwitterUI {
	
	static Scanner scan = new Scanner(System.in);
	static TwitterDataManager twitterDataManager = new TwitterDataManager();
	private final int DEFAULT_TWEET_ID = -1, DEFAULT_COMMENT_ID = -1, DEFAULT_LIKES = 0, DEFAULT_NUMBER_OF_COMMENTS = 0;
	
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
		out.print("Enter your UserID : ");
		String userId = scan.next();
		if(twitterDataManager.isUserIdExists(userId)){
			out.println("User ID already found.!");
			return;
		}
		out.print("Enter Your Name  : ");
		scan.nextLine();
		String name = scan.nextLine();
		String password = setPassword();
		if(password == null)
			return;
		Tweeter tweeter = new Tweeter(userId, name, password);
		if(twitterDataManager.createAccount(tweeter))
			out.println("Account Successfuly Created.!");
		else
			out.println("Unable to Create Account.!");
		twitterDataManager.connectToDatabase().createAccount(tweeter);
	}
	
	private void login() {
		out.print("Enter UserID : ");
		String userId = scan.next();
		if(!twitterDataManager.isUserIdExists(userId)){
			out.println("Account Not Found.!");
			return;
		}
		out.print("Enter Password   : ");
		String password = scan.next();
	
		/*
		 * For Validation of a Tweeter's userID and Password and return tweeter object if any match found.!
		 */	
		Tweeter tweeter = twitterDataManager.loginUser(new Tweeter(userId, password));
		
		if(tweeter != null) {
			
			/*
			 * Collect the tweets sorted by time and user's not-following namelist at the time of login.
			 */
			
			ArrayList<String> usersNotInFollowingList = twitterDataManager.getNotInFollowingList(tweeter);
			TreeSet<Tweet> tweetsInTimeLine = tweeter.getTweetsByTime();
			
			out.println("\nWELCOME BACK "+ tweeter.getUserName() + " TO TWITTER.!" );
			while(true) {
				out.print("\n1. Tweet"
					 +"\n2. View Tweet"
					 +"\n3. Follow"
					 +"\n4. Unfollow"
					 +"\n5. Refresh"
					 +"\n6. View New Users"
					 +"\n7. View Followers"
					 +"\n8. View Following"
					 +"\n9. Logout"
					 +"\nEnter Your Option   : ");
				int option = scan.nextInt();
				switch(option) {
					case 1: tweet(tweeter);
						break;
					case 2: viewTweets(tweetsInTimeLine, tweeter.getUserId(), tweeter.getUserName());
						break;
					case 3: follow(tweeter, usersNotInFollowingList);
						break;
					case 4: unfollow(tweeter, usersNotInFollowingList);
						break;
					case 5: refreshFeed(tweeter, tweetsInTimeLine);
						break;
					case 6: viewUsersYouAreNotFollowing(usersNotInFollowingList);
						break;
					case 7: tweeter.showFollowers();
						break;
					case 8: tweeter.showFollowing();
						break;
					case 9: return;
					default: out.println("Invalid Option.!");
				}
			}
		} else {
			out.println("Problem while Fetcing Datas.!");
		}
	}
	
	/*
	 * Have to Refresh the Tweets to load the new Tweets after following someone new.!
	 */
	public void refreshFeed(Tweeter tweeter, TreeSet<Tweet> tweetsInTimeLine){
		tweetsInTimeLine = tweeter.getTweetsByTime();
		out.println("\nTimeline Refreshed.!");
	}
	
	private void viewUsersYouAreNotFollowing(ArrayList<String> usersNotInFollowingList){
		
		for(int i = 0; i < usersNotInFollowingList.size(); i++)
			out.println((i+1) + ". " + usersNotInFollowingList.get(i));
	}
	
	private void unfollow(Tweeter tweeter, ArrayList<String> usersNotInFollowingList) {
		try{
			if(tweeter.getFollowingCount() != 0){
				out.println("Enter User Index  : ");
				int userIndex = scan.nextInt();
				String userToUnfollow = new ArrayList<>(tweeter.getFollowing().keySet()).get(userIndex);
				
				Follow follow = new Follow(userToUnfollow, tweeter.getUserId());
				twitterDataManager.connectToDatabase().unfollowAUser(follow);
				
				if(twitterDataManager.unfollowAUser(follow)){
					usersNotInFollowingList.add(userToUnfollow);
					out.println("Unfollowed Successfully.!");
				}else{
					out.println("Unable to Unfollow User.!");
				}
			} else {
				out.println("No follows.!");
			}
		}catch(ArrayIndexOutOfBoundsException e){
			out.println("Invalid Index");
		}
		
	}
	
	private void follow(Tweeter tweeter, ArrayList<String> usersNotInFollowingList) {
		try{
			if(usersNotInFollowingList.size() != 0){
				out.println("Enter User Index  : ");
				int userIndex = scan.nextInt();
				
				Follow follow = new Follow(usersNotInFollowingList.get(userIndex-1), tweeter.getUserId());
				twitterDataManager.connectToDatabase().followUser(follow);
				if(twitterDataManager.follow(tweeter, follow)){
					usersNotInFollowingList.remove(userIndex-1);
					out.println("Successfully Followed.!");
				}else{
					out.println("Unable to follow this Profile.!");
				}
			}else{
				out.println("Your Following List is Empty.!");
			}
			
		}catch(ArrayIndexOutOfBoundsException e){
			out.println("Invalid Index");
		}
	}
	
	private void viewTweets(TreeSet<Tweet> tweets, String userId, String userName) {
		
		for(Tweet tweet : tweets){
			tweet.viewTweetData();
			label:
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
					case 1: tweet.viewReTweets();
						break;
					case 2: reReweet(tweet, userId, userName);
						break;
					case 3: like(tweet);
						break;
					case 4: commentOnTweet(tweet, userId, userName);
						break;
					case 5: tweet.showComments();
						break;
					case 6: break label;
					case 7: return;
					default: out.println("Invalid Option.!");
				}
			}
		}
	}
	
	private void like(Tweet tweet){
		tweet.hitLike();
		if(twitterDataManager.connectToDatabase().putLike(tweet) > 0)
			out.println("Liked.!");
		else
			out.println("Unable to Like the Tweet.!");
	}
	
	private void reReweet(Tweet tweet, String email, String tweetedBy){
		out.print("Enter Text to Retweet  : ");
		scan.nextLine();
		String reTweet = scan.nextLine();
		
		tweet = twitterDataManager.addReTweet(new Tweet(DEFAULT_TWEET_ID, tweetedBy, email, reTweet, new Timestamp(new Date().getTime()), tweet.getTweetId(), DEFAULT_LIKES, DEFAULT_NUMBER_OF_COMMENTS), tweet);
		twitterDataManager.connectToDatabase().reTweet(tweet);
		
		if(tweet != null)
			out.println("Successfully Retweeted.!");
		else
			out.println("Unable to Retweet.!");
	}
	
	private void commentOnTweet(Tweet tweet, String commenterUserId, String userName){
		out.print("Enter your Comment : ");
		scan.nextLine();
		String commentLine = scan.nextLine();
		Comment comment = twitterDataManager.commentOnTweet(tweet, new Comment(DEFAULT_COMMENT_ID, userName, commenterUserId, tweet.getTweetId(), commentLine));
		tweet.addComment(comment);
		if(comment != null)
			out.println("Successfully Commented.!");
		else
			out.println("Unable to Comment.!");
	}
	
	private void tweet(Tweeter tweeter) {
		out.print("Enter Your Tweet  : ");
		scan.nextLine();
		String tweetLine = scan.nextLine();
		Tweet tweet = twitterDataManager.tweet(new Tweet(DEFAULT_TWEET_ID, tweeter.getUserName(), tweeter.getUserId(), tweetLine, new Timestamp(new Date().getTime()), DEFAULT_TWEET_ID, DEFAULT_LIKES, DEFAULT_NUMBER_OF_COMMENTS));
		twitterDataManager.connectToDatabase().addTweet(tweet);
		if(tweet != null)
			out.println("Tweet Posted.!");
		else
			out.println("Unable to Upload Yout Tweet.!");
	}
	
	public String setPassword(){
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
	
	public boolean validatePassword(String password){
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
