import java.util.Date;
import java.util.UUID;

public abstract class Post implements PostInterface {
	public abstract void showPostLocation();

	public abstract void showTagUser();

	public String text;
	public Date postDate;
	static Date nowtime = new Date();
	public UUID postID = UUID.randomUUID();

	/**
	 * 
	 * @param text
	 */
	public Post(String text) {
		super();
		this.text = text;
		this.postDate = nowtime;
	}
}
