import java.util.HashMap;

public class Tweeter {
	private String emailId;
	private String userName;
	private String password;
	private HashMap<Integer, Tweet> tweets;
	private HashMap<String, Tweeter> followers;
	private HashMap<String, Tweeter> following;
	
	public Tweeter(String emailId, String userName, String password,HashMap<Integer, Tweet> tweets, HashMap<String, Tweeter> followers, HashMap<String, Tweeter> following) {
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.tweets = tweets;
		this.followers = followers;
		this.following = following;
	}
	
	public Tweeter(String emailId, String userName, String password) {
		this(emailId, userName, password, new HashMap<Integer, Tweet>(), new HashMap<String, Tweeter>(), new HashMap<String, Tweeter>());
	}
	
	public Tweeter(String emailId) {
		this.emailId = emailId;
	}

	public Tweeter(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public HashMap<Integer,Tweet> getTweets() {
		return tweets;
	}
	public HashMap<String, Tweeter> getFollowers() {
		return followers;
	}
	public HashMap<String, Tweeter> getFollowing() {
		return following;
	}
	public void addFollowers(Tweeter follower) {
		followers.put(follower.getEmailId(), follower);
	}
	public void addFollowing(Tweeter following) {
		this.following.put(following.getEmailId(), following);
	}
	public void addTweet(Tweet tweet) {
		this.tweets.put(tweet.getTweetId(), tweet);
	}
	public void unfollow(String following){
		this.following.remove(following);
	}
}
