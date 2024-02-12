class Follow{
	private String userEmail;
	private String followerEmail;
	
	public Follow(String userEmail, String followerEmail){
		this.userEmail = userEmail;
		this.followerEmail = followerEmail;
	}
	public String getFollowerEmail(){
		return followerEmail;
	}
	public String getUserEmail(){
		return userEmail;
	}
}
