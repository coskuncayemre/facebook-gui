import java.util.ArrayList;

public class VideoPost extends TextPost {

	
	private String videoFileName;
	private static final int maxVideoLength = 10;
	private int duration;
	
	
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	/**
	 * 
	 * @param text
	 * @param locationInfo
	 * @param taggedFriend
	 * @param user
	 * @param videoFileName
	 * @param duration
	 */
	public VideoPost(String text, Location locationInfo, ArrayList<String> taggedFriend, Users user, String videoFileName,int duration) {
		super(text, locationInfo, taggedFriend, user);
		this.setType("VIDEO");
		this.setLocationX(locationInfo.getLongitude());
		this.setLocationY(locationInfo.getLatitude());
		this.setDuration(duration);
		
		this.videoFileName = videoFileName;
	}
	
	public VideoPost(String text, Location locationInfo, Users user, String videoFileName,int duration) {
		super(text, locationInfo, user);
		this.setType("GUI");
		this.setLocationX(locationInfo.getLongitude());
		this.setLocationY(locationInfo.getLatitude());
		this.setDuration(duration);
		
		this.videoFileName = videoFileName;
	}
	
	/**
	 * @return the videoFileName
	 */
	public String getVideoFileName() {
		return videoFileName;
	}
	/**
	 * @param videoFileName the videoFileName to set
	 */
	public void setVideoFileName(String videoFileName) {
		this.videoFileName = videoFileName;
	}
	/**
	 * @return the maxVideoLength
	 */
	public static int getMaxvideolength() {
		return maxVideoLength;
	}
	
	@Override
	public void display(){
		super.display();
		System.out.println("Video: "+this.getVideoFileName());
		System.out.println("Video Duration: "+this.getDuration()+" minutes");
		
	}
	
	
	
}
