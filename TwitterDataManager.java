import java.util.HashMap;
import java.util.ArrayList;
import java.util.Set;
import java.util.Map.Entry;
import java.sql.Timestamp;

public class TwitterDataManager{
	private static HashMap<String, Tweeter> usersData = new HashMap<String, Tweeter>();
	private static Twitter twitter = new Twitter();
	static int tweetId;
	static int commentId;
	
	static {
		usersData = twitter.getUserDetails();
		tweetId = twitter.getMaxTweetId();
		commentId = twitter.getMaxComments();
	}
	
	public HashMap<String, Tweeter> getFollowers(String email){
		return usersData.get(email).getFollowing();
	}
	
	public boolean createAccount(Tweeter tweeter){
		if(twitter.createAccount(tweeter) > 0)
			return true;
		return false;
	}
	
	public void putDataIntoCollection(Tweeter tweeter){
		usersData.put(tweeter.getEmailId(), tweeter);
	}
	
	public String getUserName(String email){
		return usersData.get(email).getUserName();
	}
	
	public Tweeter getUser(String email){
		return usersData.get(email);
	}
	public void addComment(Comment comment, Tweet tweet){
		tweet.addComment(comment);
		twitter.addComment(comment);
	}
	public void hitLike(Tweet tweet){
		tweet.hitLike();
		twitter.putLike(new Tweet(tweet.getTweetId()));
	}
	
	public boolean isUserIdExists(String email){
		if(usersData.containsKey(email)){
			return true;
		}
		return false;
	}
	public Tweeter loginUser(Tweeter tweeter){
		if(usersData.get(tweeter.getEmailId()).getPassword().equals(tweeter.getPassword()))
			return usersData.get(tweeter.getEmailId());
		return null;
	}
	public ArrayList<String> unfollow(Tweeter tweeter){
		Set<Entry<String, Tweeter>> following = tweeter.getFollowing().entrySet();
		ArrayList<String> usersInFollowingList = new ArrayList<String>();
		int usersIndex = 0;
		for(Entry<String, Tweeter> userFollowing : following){
			usersInFollowingList.add(userFollowing.getKey());
		}
		return usersInFollowingList;
	}
	public void unfollowAUser(Follow follow){
		twitter.unfollowAUser(follow);
	}
	public ArrayList<String> getNotInFollowingList(Tweeter tweeter){
		Set<Entry<String, Tweeter>> users = usersData.entrySet();
		ArrayList<String> usersNotInFollowingList = new ArrayList<String>();
		int usersIndex = 0;
		for(Entry<String, Tweeter> userSet : users){
			if(!tweeter.getFollowing().containsKey(userSet.getKey()) && !userSet.getKey().equals(tweeter.getEmailId())){
				usersNotInFollowingList.add(userSet.getKey());
//				out.println(usersIndex++ + ". " + userSet.getKey());
			}
		}
		return usersNotInFollowingList;
	}
	public void follow(Follow follow){
		twitter.followUser(follow);
	}
	public boolean tweet(String tweet, String email){
		if(twitter.addTweet(email, tweet) > 0)
			return true;
		return false;
	}
	
	public void setUserData(String email, String tweet, Timestamp timeStamp){
		usersData.get(email).addTweet(new Tweet(tweetId++, email, tweet, timeStamp));
	}
	
	public String getUserOfEmail(String email){
		return usersData.get(email).getUserName();
	}
	public void addReTweet(String email, String reTweet, Timestamp timeStamp, int tweetId, Tweet tweet){
		Tweet reTweetData = new Tweet(this.tweetId++, email, reTweet, timeStamp, tweetId, 0, 0);
		tweet.addReTweet(reTweetData);
		twitter.reTweet(reTweetData);
	}
	public void commentOnTweet(String commenterEmail, int tweetId, String commentLine, Tweet tweet){
		Comment comment = new Comment(commentId++, commenterEmail, tweetId, commentLine);
		twitter.addComment(comment);
		tweet.addComment(comment);
	}
}
