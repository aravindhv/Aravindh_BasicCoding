import java.sql.Timestamp;
import java.util.ArrayList;
import static java.lang.System.out;
import java.util.TreeSet;

public class Tweet {
	private String tweeterUserId;
	private Timestamp timeOfTweet;
	private String tweeterName;
	private int tweetId;
	private String tweet;
	private int isRetweetOf;
	private int likes;
	private int numberOfComments;
	private ArrayList<Comment> comments;
	private TreeSet<Tweet> reTweets;
	private int numberOfRetweets;
	
	public Tweet(int tweetId, String tweeterName, String tweeterUserId, String tweet, Timestamp timeOfTweet, int isRetweetOf, int likes, int numberOfComments) {
		this.tweeterName = tweeterName;
		this.tweeterUserId = tweeterUserId;
		this.timeOfTweet = timeOfTweet;
		this.tweetId = tweetId;
		this.tweet = tweet;
		this.isRetweetOf = isRetweetOf;
		comments = new ArrayList<Comment>();
		reTweets = new TreeSet<Tweet>(new SortTweetsByDate());
	}
	
	public String getTweeterName(){
		return tweeterName;
	}

	public Tweet(int tweetId){
		this.tweetId = tweetId;
	}	
	
	public String getTweeterUserId() {
		return tweeterUserId;
	}

	public Timestamp getTimeOfTweet() {
		return timeOfTweet;
	}
	public void setTweetId(int tweetId){
		this.tweetId = tweetId;
	}
	public int getTweetId() {
		return tweetId;
	}

	public String getTweet() {
		return tweet;
	}

	public int getIsRetweetOf() {
		return isRetweetOf;
	}

	public int getLikes() {
		return likes;
	}
	
	public void setLikes(int likes){
		this.likes = likes;
	}
	
	public int getNumberOfComments() {
		return numberOfComments;
	}
	
	public void hitLike() {
		this.likes++;
	}
	
	public void setNumberOfComments(int numberOfComments){
		this.numberOfComments = numberOfComments;
	}
	
	private void addCommentCount() {
		this.numberOfComments++;
	}
	public void addComment(Comment comment){
		comments.add(comment);
		addCommentCount();
	}
	private void addRetweetCount(){
		this.numberOfRetweets++;
	}
	public void addReTweet(Tweet tweet){
		this.reTweets.add(tweet);
		addRetweetCount();
	}
	public TreeSet<Tweet> getReTweets(){
		return reTweets;
	}
	public void showComments(){
		out.println("\n:::COMMENTS:::");
		for(Comment comment : comments){
			out.println(comment.getCommenterName() +" >> "+ comment.getComment());
		}
	}
	public void viewTweetData(){
		out.println("\n==============================================================================");
		out.printf("%-20s",this.getTweeterName());
		out.print("----- Tweet ID : "+this.getTweetId() +"-----"+this.getTimeOfTweet()
			  +"\n"+ this.getTweetId() + ". " + this.getTweet()
			  +"\nLikes : "+ this.getLikes()
			  +"\tComments : "+ this.getNumberOfComments()
			  +"\tRetweets : "+ this.getReTweets().size()
			  +"\n==============================================================================");
	}
	
	public void viewReTweets(){
		for(Tweet reTweet : reTweets){
			out.println("\n==============================================================================");
			out.printf("%-20s",reTweet.getTweeterName());
			out.print("----- Tweet ID : "+reTweet.getTweetId() +"-----"+reTweet.getTimeOfTweet()
				  +"\n"+ reTweet.getTweetId() + ". " + reTweet.getTweet()
				  +"\n\tRetweet Of Tweet ID : " + reTweet.getIsRetweetOf());
			out.println("\n==============================================================================");
		}
	}
}
