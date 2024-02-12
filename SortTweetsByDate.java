import java.util.Comparator;
import java.sql.Timestamp;

public class SortTweetsByDate implements Comparator<Tweet>{
	@Override
	public int compare(Tweet tweet1, Tweet tweet2){
		if(tweet1.getTimeOfTweet().after(tweet2.getTimeOfTweet()))
			return 1;
		else if(tweet2.getTimeOfTweet().after(tweet1.getTimeOfTweet())
			return -1;
		return 0;
	}
}
