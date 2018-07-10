import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

public class TextPost extends Post {
	
	private String type;
	private ArrayList<String> tagged = new ArrayList<String>();
	private double locationX;
	private double locationY;
	
	/**
	 * 
	 * @param text
	 * @param longitude
	 * @param latitude
	 * @param taggedFriend
	 */
	public TextPost(String text,Location locationInfo,ArrayList<String> taggedFriend,Users user) {
		super(text);
		this.setLocationX(locationInfo.getLongitude());
		this.setLocationY(locationInfo.getLatitude());
		this.setType("TEXT");
		for(String p:taggedFriend){
			this.setTagged(p);
		}
		
	}
	
	public TextPost(String text,Location locationInfo,Users user) {
		super(text);
		this.setLocationX(locationInfo.getLongitude());
		this.setLocationY(locationInfo.getLatitude());
		this.setType("GUI");
		}
	
	@Override
	/**
	 * getText
	 */
	public String getText() {
		return this.text;
	}

	@Override
	/**
	 * setText
	 */
	public void setText(String text) {
		
	}

	@Override
	/**
	 * getID
	 */
	public UUID getID() {
		return this.postID;
	}

	@Override
	/**
	 * getDate
	 */
	public Date getDate() {
		return this.postDate;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the tagged
	 */
	public ArrayList<String> getTagged() {
		return tagged;
	}
	
	
	
	/**
	 * @param tagged the tagged to set
	 */
	public void setTagged(String p) {
		this.tagged.add(p);
	}

	/**
	 * @return the locationX
	 */
	public double getLocationX() {
		return locationX;
	}

	/**
	 * @param locationX the locationX to set
	 */
	public void setLocationX(double locationX) {
		this.locationX = locationX;
	}

	/**
	 * @return the locationY
	 */
	public double getLocationY() {
		return locationY;
	}

	/**
	 * @param locationY the locationY to set
	 */
	public void setLocationY(double locationY) {
		this.locationY = locationY;
	}
	/**
	 * display 
	 */
	public void display(){
		System.out.println(this.getText());
		String date = String.format("%td/%tm/%tY", this.getDate(),this.getDate(),this.getDate());
		System.out.println("Date: "+ date);
		this.showPostLocation();
		
	}
	/**
	 * clears cart
	 */
	public void clearCart(){
		int size = tagged.size();
		for(int y=0;y<size;y++){
			this.tagged.remove(size-y-1);
		}
	}

	@Override
	/**
	 * showPostLocation
	 */
	public void showPostLocation() {
		System.out.println("Location: "+this.getLocationX()+", "+this.getLocationY());
	}

	@Override
	/**
	 * showTagUser
	 */
	public void showTagUser() {
		System.out.println("Friends tagged in this post: "+String.join(" ,",this.getTagged()));
	}
	
}
