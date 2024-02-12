class Follow{
	private String profileUserId;
	private String followerUserId;
	
	public Follow(String profileUserId, String followerUserId){
		this.profileUserId = profileUserId;
		this.followerUserId = followerUserId;
	}
	public String getFollowerUserId(){
		return followerUserId;
	}
	public String getProfileUserId(){
		return profileUserId;
	}
}
