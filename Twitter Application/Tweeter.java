import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;
import static java.lang.System.out;
import java.util.TreeSet;
import java.sql.Timestamp;
import java.util.Comparator;

public class Tweeter {
	private String emailId;
	private String userName;
	private String password;
	private TreeSet<Tweet> tweets;
	private HashMap<String, Tweeter> followers;
	private HashMap<String, Tweeter> following;
	private TreeSet<Tweet> tweetsTimeLine;
	
	public Tweeter(String emailId, String userName, String password,TreeSet<Tweet> tweets, HashMap<String, Tweeter> followers, HashMap<String, Tweeter> following) {
		this.emailId = emailId;
		this.userName = userName;
		this.password = password;
		this.tweets = tweets;
		this.followers = followers;
		this.following = following;
		following.put(this.emailId, this);
		this.tweetsTimeLine = new TreeSet<Tweet>(new SortTweetsByDate());
	}
	
	public Tweeter(String emailId, String userName, String password) {
		this(emailId, userName, password, new TreeSet<Tweet>(new SortTweetsByDate()), new HashMap<String, Tweeter>(), new HashMap<String, Tweeter>());
	}
	public int getFollowingCount(){
		return following.size();
	}
	public Tweeter(String emailId) {
		this.emailId = emailId;
	}

	public Tweeter(String emailId, String password) {
		this.emailId = emailId;
		this.password = password;
	}
	public TreeSet<Tweet> getTweetsByTime(){
		Set<Entry<String, Tweeter>> tweeterSet = following.entrySet();
		for(Entry<String, Tweeter> tweeter : tweeterSet){
			TreeSet<Tweet> tweetSet = tweeter.getValue().getTweetSet();
			for(Tweet tweet : tweetSet)
				if(tweet.getIsRetweetOf() == -1)
					tweetsTimeLine.add(tweet);
		}
		return tweetsTimeLine;
	}
	public TreeSet<Tweet> getTweetSet(){
		return tweets;
	}
	public void removeFollower(String follower){
		followers.remove(follower);
	}
	public String getUserId() {
		return emailId;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public HashMap<String, Tweeter> getFollowers() {
		return followers;
	}
	public HashMap<String, Tweeter> getFollowing() {
		return following;
	}
	public void addFollowers(Tweeter follower) {
		if(follower != null && follower.getUserName().trim().length() > 0)
			this.followers.put(follower.getUserId(), follower);
	}
	public void addFollowing(Tweeter following) {
		if(following != null && following.getUserName().trim().length() > 0)
			this.following.put(following.getUserId(), following);
	}
	public void addTweet(Tweet tweet) {
		if(tweet != null && tweet.getTweet().trim().length() > 0)
			this.tweets.add(tweet);
	}
	public void unfollow(String following){
		this.following.remove(following);
	}
	public void showFollowers(){
		viewEntryData(followers.entrySet());
	}
	public void showFollowing(){
		viewEntryData(following.entrySet());
	}
	public void viewEntryData(Set<Entry<String, Tweeter>> tweeterSet){
		int i = 1;
		for(Entry<String, Tweeter> individualTweeter : tweeterSet){
			if(!individualTweeter.getValue().getUserName().equals(userName))
				out.println(i++ + ". " + individualTweeter.getValue().getUserName());
		}
	}
	private void viewTweets(){
		if(tweets.size() == 0){
			out.println("No Retweets Found.!");
			return;
		}
		for(Tweet tweetData : tweets){
			out.println(">>>" + tweetData.getTweet());
		}
	}
}
