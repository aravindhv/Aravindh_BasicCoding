public class Comment{
	private String email;
	private int commentId;
	private String comment;
	private int tweetId;
	
	public Comment(int commentId, String email, int tweetId, String comment){
		this.email = email;
		this.commentId = commentId;
		this.comment = comment;
		this.tweetId = tweetId;
	}
	
	public String getCommenterEmail(){
		return email;
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
