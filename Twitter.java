import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.Set;

public class Twitter {
	
	private Connection connection = DatabaseManager.getConnection();
	
	public int createAccount(Tweeter tweeter) {
		String query = "insert into TWEETER values(?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, tweeter.getEmailId());
			preparedStatement.setString(2, tweeter.getUserName());
			preparedStatement.setString(3, tweeter.getPassword());
			return preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public Tweeter userLogin(Tweeter tweeter){
		String query = "select * from TWEETER where EMAIL = ? and PASSWORD = ?";
		HashMap<String, Tweeter> user = new HashMap<String, Tweeter>();
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, tweeter.getEmailId());
			preparedStatement.setString(2, tweeter.getPassword());
			ResultSet resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()){
				user.put(resultSet.getString(1), new Tweeter(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
				getTweetersTweets(user);
				getFollowers(user);
				getFollowing(user);
				return user.get(tweeter.getEmailId());
			}
		}catch(SQLException e){
			e.printStackTrace();
			return null;
		}
		return null;
	}

	public HashMap<String, Tweeter> getUserDetails() {
		String query = "Select * from TWEETER";
		HashMap<String, Tweeter> users = new HashMap<String, Tweeter>();
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					users.put(resultSet.getString(1), new Tweeter(resultSet.getString(1), resultSet.getString(2), resultSet.getString(3)));
				}
				getTweetersTweets(users);
				getFollowers(users);
				getFollowing(users);
				return users;
		} catch (SQLException e) {
				e.printStackTrace();
				return null;
		}
	}

	private void getFollowing(HashMap<String, Tweeter> users) {
		String query = "select PROFILE_EMAIL, FOLLOWER_EMAIL from FOLLOWS where FOLLOWER_EMAIL = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			Set<Entry<String, Tweeter>> tweeterSet = users.entrySet();
			for(Entry<String, Tweeter> tweeterData : tweeterSet) {
				preparedStatement.setString(1, tweeterData.getValue().getEmailId());
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					users.get(resultSet.getString(2)).addFollowing(users.get(resultSet.getString(1)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getFollowers(HashMap<String, Tweeter> users) {
		String query = "select FOLLOWER_EMAIL from FOLLOWS where PROFILE_EMAIL = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			Set<Entry<String, Tweeter>> tweeterSet = users.entrySet();
			for(Entry<String, Tweeter> tweeterData : tweeterSet) {
				String email = tweeterData.getValue().getEmailId();
				preparedStatement.setString(1, email);
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Tweeter tweeter = users.get(resultSet.getString(1));
					tweeter.addFollowers(new Tweeter(resultSet.getString(1)));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void getTweetersTweets(HashMap<String, Tweeter> users) {
		String query = "Select * from TWEET where EMAIL = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			Set<Entry<String, Tweeter>> tweeterSet = users.entrySet();
			for(Entry<String, Tweeter> tweeterData : tweeterSet) {
				preparedStatement.setString(1, tweeterData.getValue().getEmailId());
				ResultSet resultSet = preparedStatement.executeQuery();
				while(resultSet.next()) {
					Tweet tweet = new Tweet(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getTimestamp(4), resultSet.getInt(5), resultSet.getInt(6), resultSet.getInt(7));
					getCommentsOfTweets(tweet);
					getLikesOfTweet(tweet);
					tweeterData.getValue().addTweet(tweet);
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}
	}
	
	private void getLikesOfTweet(Tweet tweet){
		String query = "select LIKES from TWEET where TWEET_ID = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, tweet.getTweetId());
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				int likes = resultSet.getInt(1);
				tweet.setLikes(likes);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	//Comment(String email, int commentId, String comment, int tweetId)
	private void getCommentsOfTweets(Tweet tweet){
		String query = "select * from COMMENTS where TWEET_ID = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, tweet.getTweetId());
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				tweet.addComment(new Comment(resultSet.getInt(1), resultSet.getString(2), resultSet.getInt(3), resultSet.getString(4)));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public int addTweet(String email, String tweet){
	/*
	+---------------------+--------------+------+-----+-------------------+-----------------------------+
	| Field               | Type         | Null | Key | Default           | Extra                       |
	+---------------------+--------------+------+-----+-------------------+-----------------------------+
	| TWEET_ID            | int(11)      | NO   | PRI | NULL              | auto_increment              |
	| EMAIL               | varchar(40)  | NO   |     | NULL              |                             |
	| TWEET               | varchar(150) | NO   |     | NULL              |                             |
	| TIME_OF_TWEET       | timestamp    | NO   |     | CURRENT_TIMESTAMP | on update CURRENT_TIMESTAMP |
	| RETWEET_OF_TWEET_ID | int(11)      | NO   |     | -1                |                             |
	| LIKES               | int(11)      | NO   |     | 0                 |                             |
	| NUMBER_OF_COMMENTS  | int(11)      | NO   |     | 0                 |                             |
	+---------------------+--------------+------+-----+-------------------+-----------------------------+
	*/
	
		String query = "insert into TWEET values(null, '" + email + "','" + tweet +"', null , -1, 0, 0)";
		try(Statement statement = connection.createStatement()){
			return statement.executeUpdate(query);
		} catch(SQLException e){
			return 0;
		}
	}
	public int getMaxTweetId(){
		String query = "select MAX(TWEET_ID) from TWEET";
		try(Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				return resultSet.getInt(1);
			}
		}catch(SQLException e){
			return 0;
		}
		return 0;
	}
	public int getMaxComments(){
		String query = "select MAX(COMMENT_ID) from COMMENTS";
		try(Statement statement = connection.createStatement()){
			ResultSet resultSet = statement.executeQuery(query);
			if(resultSet.next()){
				return resultSet.getInt(1);
			}
		}catch(SQLException e){
			return 0;
		}
		return 0;
	}
	public int putLike(Tweet tweet){
		String query = "update TWEET set LIKES = LIKES + 1 where TWEET_ID = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, tweet.getTweetId());
			return preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	public int reTweet(Tweet tweet){
	//	Tweet(int tweetId, String tweeterEmail, String tweet, Timestamp timeOfTweet, int isRetweetOf, int likes, int numberOfComments)
		String query = "insert into TWEET values(null,?,?,?,?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
	//		preparedStatement.setInt(1, tweet.getTweetId());
			preparedStatement.setString(1, tweet.getTweeterEmail());
			preparedStatement.setString(2, tweet.getTweet());
			preparedStatement.setTimestamp(3, tweet.getTimeOfTweet());
			preparedStatement.setInt(4, tweet.getIsRetweetOf());
			preparedStatement.setInt(5, tweet.getLikes());
			preparedStatement.setInt(6, tweet.getNumberOfComments());
			return preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	public int addComment(Comment comment){
		String query = "insert into COMMENTS values(null,?,?,?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, comment.getCommenterEmail());
			preparedStatement.setInt(2, comment.getTweetId());
			preparedStatement.setString(3, comment.getComment());
			int rowsUpdated = preparedStatement.executeUpdate();
			if(rowsUpdated > 0){
				return addCommentCount(comment.getTweetId());
			}
			return rowsUpdated;
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
	private int addCommentCount(int tweetId){
		String query = "update TWEET set NUMBER_OF_COMMENTS = NUMBER_OF_COMMENTS + 1 where TWEET_ID = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setInt(1, tweetId);
			return preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}
	}
	
	/*
	desc FOLLOWS;
	+----------------+-------------+------+-----+---------+----------------+
	| Field          | Type        | Null | Key | Default | Extra          |
	+----------------+-------------+------+-----+---------+----------------+
	| FOLLOW_ID      | int(11)     | NO   | PRI | NULL    | auto_increment |
	| PROFILE_EMAIL  | varchar(40) | NO   |     | NULL    |                |
	| FOLLOWER_EMAIL | varchar(40) | NO   |     | NULL    |                |
	+----------------+-------------+------+-----+---------+----------------+
	*/
	public int followUser(Follow follow){
		String query = "insert into FOLLOWS values(null, ?, ?)";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, follow.getUserEmail());
			preparedStatement.setString(2, follow.getFollowerEmail());
			return preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return 0;
		}
	}
	public int unfollowAUser(Follow follow){
		String query = "delete from FOLLOWS where PROFILE_EMAIL = ? and FOLLOWER_EMAIL = ?";
		try(PreparedStatement preparedStatement = connection.prepareStatement(query)){
			preparedStatement.setString(1, follow.getUserEmail());
			preparedStatement.setString(2, follow.getFollowerEmail());
			return preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			return -1;
		}
	}
}
