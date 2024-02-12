import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;

public class Tweet {
	private String tweeterEmail;
	private Timestamp timeOfTweet;
	private int tweetId;
	private String tweet;
	private int isRetweetOf;
	private int likes;
	private int numberOfComments;
	private ArrayList<Comment> comments;
	private HashMap<Integer, Tweet> reTweets;
	private int numberOfRetweets;
	
	public Tweet(int tweetId, String tweeterEmail, String tweet, Timestamp timeOfTweet, int isRetweetOf, int likes, int numberOfComments) {
		this.tweeterEmail = tweeterEmail;
		this.timeOfTweet = timeOfTweet;
		this.tweetId = tweetId;
		this.tweet = tweet;
		this.isRetweetOf = isRetweetOf;
		comments = new ArrayList<Comment>();
		reTweets = new HashMap<Integer, Tweet>();
	}
	
	public Tweet(int tweetId, String tweeterEmail, String tweet, Timestamp timeOfTweet) {
		this(tweetId, tweeterEmail, tweet, timeOfTweet, -1, 0, 0);
	}

	public Tweet(int tweetId){
		this.tweetId = tweetId;
	}	
	
	public String getTweeterEmail() {
		return tweeterEmail;
	}

	public Timestamp getTimeOfTweet() {
		return timeOfTweet;
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
		this.reTweets.put(tweet.getTweetId(), tweet);
		addRetweetCount();
	}
	public HashMap<Integer, Tweet> getReTweets(){
		return reTweets;
	}
	public ArrayList<Comment> getComments(){
		return comments;
	}
}
