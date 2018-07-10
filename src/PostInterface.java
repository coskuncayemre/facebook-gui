import java.util.Date;
import java.util.UUID;

public interface PostInterface {
	/**
	 * 
	 * @param text
	 */
	
	public void setText(String text);
	/**
	 * 
	 * @return
	 */
	public String getText();
	/**
	 * 
	 * @return
	 */
	public UUID getID();
	/**
	 * 
	 * @return
	 */
	public Date getDate();

}
