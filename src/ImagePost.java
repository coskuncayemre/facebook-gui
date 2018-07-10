import java.util.ArrayList;

public class ImagePost extends TextPost {
	
	private ArrayList<String> tagged = new ArrayList<String>();
	
	/**
	 * 
	 * @param text
	 * @param locationInfo
	 * @param taggedFriend
	 * @param filePath
	 * @param resolution
	 */

	private String imageFileName;
	private int[] resolution = new int[2];
	/**
	 * 
	 * @param text
	 * @param locationInfo
	 * @param taggedFriend
	 * @param user
	 * @param imageFileName
	 * @param bab
	 */
	public ImagePost(String text, Location locationInfo, ArrayList<String> taggedFriend, Users user, String imageFileName,
			String[] bab) {
		super(text, locationInfo, taggedFriend, user);
		this.setType("IMAGE");
		this.setLocationX(locationInfo.getLongitude());
		this.setLocationY(locationInfo.getLatitude());
		for(String p:taggedFriend){
			tagged.add(p);
		}
		this.setImageFileName(imageFileName);
		this.setResolution(resolution);
		for(int i =0; i<bab.length;i++){
			this.resolution[i]=Integer.parseInt(bab[i]);
		}
	}
	
	public ImagePost(String text, Location locationInfo, Users user, String imageFileName,
			String[] bab) {
		super(text, locationInfo, user);
		this.setType("GUI");
		this.setLocationX(locationInfo.getLongitude());
		this.setLocationY(locationInfo.getLatitude());
		this.setImageFileName(imageFileName);
		this.setResolution(resolution);
		for(int i =0; i<bab.length;i++){
			this.resolution[i]=Integer.parseInt(bab[i]);
		}
	}

	

	/**
	 * @return the imageFileName
	 */
	public String getImageFileName() {
		return imageFileName;
	}

	/**
	 * @param imageFileName
	 *            the imageFileName to set
	 */
	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	/**
	 * @return the resolution
	 */
	public int[] getResolution() {
		return resolution;
	}

	/**
	 * @param resolution
	 *            the resolution to set
	 */
	public void setResolution(int[] resolution) {
		this.resolution = resolution;
	}
	
	@Override
	public void display(){
		super.display();
		System.out.println("Image: "+this.getImageFileName());
		System.out.println("Image resolution: "+this.getResolution()[0]+"x"+this.getResolution()[1]);
		
	}
	
	
	
}
