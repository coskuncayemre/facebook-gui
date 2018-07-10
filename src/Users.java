import java.util.Date;
import java.util.ArrayList;
import java.util.UUID;

public class Users {

	private int userID;
	private String password;
	private String name;
	private String username;
	private String relationshipStatus;
	private String dateOfBirth;
	private String schoolGraduated;
	private Date lastLogin;	
	private boolean signedIn;
	private ArrayList<Users> friends = new ArrayList<Users>();
	private ArrayList<Users> blocked = new ArrayList<Users>();
	private ArrayList<Users> normal = new ArrayList<Users>();
	private ArrayList<Users> blockedFriends = new ArrayList<Users>();
	private ArrayList<TextPost> generalPost = new ArrayList<TextPost>();
	private ArrayList<TextPost>	friendsPosts = new ArrayList<TextPost>();
	private ArrayList<TextPost> textPost = new ArrayList<TextPost>();
	private ArrayList<ImagePost> imagePost = new ArrayList<ImagePost>();
	private ArrayList<VideoPost> videoPost = new ArrayList<VideoPost>();
	private ArrayList<String> taggedFriend = new ArrayList<String>();
	private ArrayList<String> unTaggedFriend = new ArrayList<String>();
	private ArrayList<UUID> postID = new ArrayList<UUID>();
	
	
	
	
	/**
	 * @return the relationshipStatus
	 */
	public String getRelationshipStatus() {
		return relationshipStatus;
	}
	/**
	 * @param relationshipStatus the relationshipStatus to set
	 */
	public void setRelationshipStatus(String relationshipStatus) {
		this.relationshipStatus = relationshipStatus;
	}
	
	
	/**
	 * @return the textPost
	 */
	public ArrayList<TextPost> gettextPost() {
		return textPost;
	}
	/**
	 * @param textPost the textPost to set
	 */
	public void addImagePost(ImagePost x) {
		this.imagePost.add(x);
	}
	public ArrayList<ImagePost> getImagePost() {
		return imagePost;
	}
	/**
	 * @param textPost the textPost to set
	 */
	public void addVideoPost(VideoPost x) {
		this.videoPost.add(x);
	}
	
	/**
	 * getVideoPost
	 * @return
	 */
	public ArrayList<VideoPost> getVideoPost() {
		return videoPost;
	}
	/**
	 * getPostIDList
	 * @return
	 */
	public ArrayList<UUID> getPostIDList() {
		return postID;
	}
	
	
	
	public ArrayList<TextPost> getGeneral() {
		return generalPost;
	}
	
	public ArrayList<TextPost> getFriendsPosts() {
		return friendsPosts;
	}
	
	/**
	 * @param textPost the textPost to set
	 */
	public void addtextPost(TextPost x) {
		this.textPost.add(x);
	}
	
	
	
	
	
	/**
	 * 
	 * @param x
	 */
	public void addFriend(Users x){
		this.friends.add(x);
	}
	
	public ArrayList<Users> showNormal(){
		for(Users p: this.friends){
			if(this.blocked.contains(p)){
				
			}else{
				normal.add(p);
			}
		}
		return normal;
	}
	
	public void removeFriend(Users x){
		this.friends.remove(x);
	}
	
	/**
	 * 
	 * @return
	 */
	public ArrayList<Users> showFriend(){
		return friends;
	}
	/**
	 * array of blocked user
	 * @param x
	 */
	public void block(Users x){
		this.blocked.add(x);
		this.friends.remove(x);
	}
	/**
	 * remove blocked user
	 * @param x
	 */
	public void unBlock(Users x){
		this.blocked.remove(x);
	}
	/**
	 * show blocked user
	 * @return
	 */
	public ArrayList<Users> showBlocked(){
		return this.blocked;
	}
	/**
	 * adding tag
	 * @param x
	 */
	public void addTag(String x){
		this.taggedFriend.add(x);
	}
	
	public void addUNTag(String x){
		this.unTaggedFriend.add(x);
	}
	
	public void removeUntagged(Users x){
		this.unTaggedFriend.remove(x);
	}
	
	public void clearCart(){
		int size = taggedFriend.size();
		for(int y=0;y<size;y++){
			this.taggedFriend.remove(size-y-1);
		}
	}
	public ArrayList<String> showTagged(){
		return this.taggedFriend;
	}
	
	public ArrayList<String> showUNTagged(){
		return this.unTaggedFriend;
	}
	/**
	 * 
	 * @param x
	 */
	public void blockFriend(Users x){
		this.blockedFriends.add(x);
		this.friends.remove(x);
	}
	/**
	 * 
	 * @param x
	 */
	public void unblockFriend(Users x){
		this.blockedFriends.remove(x);
	}
	/**
	 * 
	 * @return
	 */
	public ArrayList<Users> ShowBlockedFriend(){
		return this.blockedFriends;
	}
	
	
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return userID;
	}
	
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	/**
	 * @return the schoolGraduated
	 */
	public String getSchoolGraduated() {
		return schoolGraduated;
	}
	/**
	 * @param schoolGraduated the schoolGraduated to set
	 */
	public void setSchoolGraduated(String schoolGraduated) {
		this.schoolGraduated = schoolGraduated;
	}
	/**
	 * @return the lastLogin
	 */
	public Date getLastLogin() {
		return lastLogin;
	}
	/**
	 * @param lastLogin the lastLogin to set
	 */
	public void setLastLogin(Date lastLogin) {
		this.lastLogin = lastLogin;
	}
	/**
	 * @return the signedIn
	 */
	public boolean isSignedIn() {
		return signedIn;
	}
	/**
	 * @param signedIn the signedIn to set
	 */
	public void setSignedIn(boolean signedIn) {
		this.signedIn = signedIn;
	}
	/**
	 * 
	 * @param userID
	 * @param password
	 * @param name
	 * @param username
	 * @param dizi
	 * @param schoolGraduated
	 */
	public Users(int userID, String name, String username,String password, String dizi, String schoolGraduated,String relationship) {
		super();
		this.userID = userID;
		this.password = password;
		this.name = name;
		this.username = username;
		this.schoolGraduated = schoolGraduated;
		this.dateOfBirth=dizi;
		this.relationshipStatus=relationship;
	}


	/**
	 * Update profile
	 * @param name
	 * @param date
	 * @param school
	 * @param relationshipStatus
	 */
	public void updateProfile(String name,String date, String school,String relationshipStatus) {
		this.setName(name);
		this.setDateOfBirth(date);
		this.setSchoolGraduated(school);
		this.setRelationshipStatus(relationshipStatus);
	}
	
	/**
	 * 
	 * @param text
	 * @param longitude
	 * @param latitude
	 * @param taggedFriend
	 * @param user
	 */
	public void addTextPost(String text, double longitude, double latitude, ArrayList<String> taggedFriend,Users user) {
		Location locationInfo = new Location(latitude, longitude);
		TextPost newTextPost = new TextPost(text, locationInfo, taggedFriend,user);
		this.addtextPost(newTextPost);
		this.postID.add(newTextPost.getID());
		this.generalPost.add(newTextPost);
		user.clearCart();
	}
	
	public void addGuiTextPost(String text, double longitude, double latitude,Users user) {
		Location locationInfo = new Location(latitude, longitude);
		TextPost newTextPost = new TextPost(text, locationInfo,user);
		this.addtextPost(newTextPost);
		this.postID.add(newTextPost.getID());
		this.generalPost.add(newTextPost);
		user.clearCart();
	}
	
	
	/**
	 * 
	 * @param text
	 * @param longitude
	 * @param latitude
	 * @param taggedFriend
	 * @param user
	 * @param dizi
	 * @param img
	 */
	public void addImagePost(String text, double longitude, double latitude, ArrayList<String> taggedFriend,Users user, String dizi, String[] img) {
		Location locationInfo = new Location(latitude, longitude);
		ImagePost newImagePost = new ImagePost(text, locationInfo, taggedFriend,user, dizi, img);
		this.generalPost.add((ImagePost) newImagePost);
		this.postID.add(newImagePost.getID());
		this.imagePost.add((ImagePost) newImagePost);
		user.clearCart();
	}
	
	public void addGuiImagePost(String text, double longitude, double latitude,Users user, String dizi, String[] img) {
		Location locationInfo = new Location(latitude, longitude);
		ImagePost newImagePost = new ImagePost(text, locationInfo,user, dizi, img);
		this.generalPost.add((ImagePost) newImagePost);
		this.postID.add(newImagePost.getID());
		this.imagePost.add((ImagePost) newImagePost);
		user.clearCart();
	}
	
	
	/**
	 * 
	 * @param text
	 * @param longitude
	 * @param latitude
	 * @param taggedFriend
	 * @param user
	 * @param name
	 * @param duration
	 */
	public void addVideoPost(String text, double longitude, double latitude, ArrayList<String> taggedFriend,Users user,String name,int duration) {
		Location locationInfo = new Location(latitude, longitude);
		VideoPost newVideoPost = new VideoPost(text, locationInfo, taggedFriend, user, name,duration);
		this.generalPost.add((VideoPost) newVideoPost);
		this.postID.add(newVideoPost.getID());
		this.videoPost.add((VideoPost) newVideoPost);
		user.clearCart();
	}
	
	
	public void addGuiVideoPost(String text, double longitude, double latitude,Users user,String name,int duration) {
		Location locationInfo = new Location(latitude, longitude);
		VideoPost newVideoPost = new VideoPost(text, locationInfo, user, name,duration);
		this.generalPost.add((VideoPost) newVideoPost);
		this.postID.add(newVideoPost.getID());
		this.videoPost.add((VideoPost) newVideoPost);
		user.clearCart();
	}


	public void friendPost(){
		for(Users p:this.showFriend()){
			for(TextPost x:p.getGeneral()){
				this.friendsPosts.add(x);
			}
		}
		
	}
	
	
}