public class Comment{
	private String userId;
	private int commentId;
	private String comment;
	private int tweetId;
	private String commenterName;
	
	public Comment(int commentId, String commenterName, String userId, int tweetId, String comment){
		this.userId = userId;
		this.commenterName = commenterName;
		this.commentId = commentId;
		this.comment = comment;
		this.tweetId = tweetId;
	}
	public String getCommenterName(){
		return commenterName;
	}
	public void setCommentId(int commentId){
		this.commentId = commentId;
	}
	public String getCommenterUserId(){
		return userId;
	}
	public int getCommentId(){
		return commentId;
	}
	public String getComment(){
		return comment;
	}
	public int getTweetId(){
		return tweetId;
	}
}
