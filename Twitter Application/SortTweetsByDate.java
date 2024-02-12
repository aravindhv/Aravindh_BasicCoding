import java.util.Comparator;
import java.sql.Timestamp;

public class SortTweetsByDate implements Comparator{
	@Override
	public int compare(Object object1, Object object2){
		Tweet tweet1 = (Tweet)object1;
		Tweet tweet2 = (Tweet)object2;
		if(tweet1.getTimeOfTweet().after(tweet2.getTimeOfTweet()))
			return -1;
		else if(tweet2.getTimeOfTweet().after(tweet1.getTimeOfTweet()))
			return 1;
		return 0;
	}
}
