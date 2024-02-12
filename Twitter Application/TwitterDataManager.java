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
		twitter.getUserDetails(usersData);
		tweetId = twitter.getMaxTweetId();
		commentId = twitter.getMaxComments();
	}
	public Twitter connectToDatabase(){
		return twitter;
	}
	
	public boolean createAccount(Tweeter tweeter){
		if(tweeter.getUserName().trim().length() > 0){
			usersData.put(tweeter.getUserId(), tweeter);
			return true;
		}
		return false;
	}
	
	public boolean isUserIdExists(String email){
		if(usersData.containsKey(email)){
			return true;
		}
		return false;
	}
	public Tweeter loginUser(Tweeter tweeter){
		if(usersData.get(tweeter.getUserId()).getPassword().equals(tweeter.getPassword()))
			return usersData.get(tweeter.getUserId());
		return null;
	}
	
	public boolean unfollowAUser(Follow follow){
		if(usersData.containsKey(follow.getFollowerUserId())){
			usersData.get(follow.getFollowerUserId()).unfollow(follow.getProfileUserId());
			usersData.get(follow.getProfileUserId()).removeFollower(follow.getFollowerUserId());
			return true;
		}else{
			return false;
		}
	}
	public ArrayList<String> getNotInFollowingList(Tweeter tweeter){
		Set<Entry<String, Tweeter>> users = usersData.entrySet();
		ArrayList<String> usersNotInFollowingList = new ArrayList<String>();
		int usersIndex = 0;
		for(Entry<String, Tweeter> userSet : users)
			if(!tweeter.getFollowing().containsKey(userSet.getKey()) && !userSet.getKey().equals(tweeter.getUserId()))
				usersNotInFollowingList.add(userSet.getKey());
		return usersNotInFollowingList;
	}
	
	public boolean follow(Tweeter tweeter, Follow follow){
		if(usersData.containsKey(follow.getProfileUserId())){
			tweeter.addFollowing(usersData.get(follow.getProfileUserId()));
			return true;
		}else{
			return false;
		}
	}
	
	public Tweet tweet(Tweet tweet){
		if(tweet.getTweet().trim().length() > 0){
			tweet.setTweetId(tweetId++);
			usersData.get(tweet.getTweeterUserId()).addTweet(tweet);
			return tweet;
		}else{
			return null;
		}
	}
	public Tweet addReTweet(Tweet tweet, Tweet parentTweet){
		if(tweet.getTweet().trim().length() != 0){
			tweet.setTweetId(tweetId++);
			parentTweet.addReTweet(tweet);
			return tweet;
		}else{
			return null;
		}
	}
	public Comment commentOnTweet(Tweet tweet, Comment comment){
		if(comment.getComment().trim().length() > 0){
			comment.setCommentId(commentId++);
			twitter.addComment(comment);
			return comment;
		}else{
			return null;
		}
	}
}
