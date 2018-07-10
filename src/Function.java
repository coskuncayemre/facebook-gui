import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.ArrayList;

public class Function {

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	
	public static int whoIsOnline(){
		for (Users p: UserCollection.userList) {
			if(p.isSignedIn()){
				
				return (p.getUserID()-1-(UserCollection.removeUserCounter));
			}
		}
		return -1;
	}
	
	public static int whoIsID(String name){
		for(Users p: UserCollection.userList){
			if(p.getUsername().equals(name)){
				
				return (p.getUserID()-1);
			}
		}
		return -1;
		
	}
	
	public static int whichFriendID(String name){
		for(Users p: UserCollection.userList){
			if(p.getName().equals(name)){
				return (p.getUserID()-1-(UserCollection.removeUserCounter));
			}
		}
		return -1;
		
	}
	
	
	/**
	 * 
	 * @param name
	 * @return
	 */
	public static Users whoIs(String name){
		for(Users p: UserCollection.userList){
			if(p.getUsername().equals(name)){
				return p;
			}
		}
		return null;
		
	}
	/**
	 * 
	 * @param username
	 * @return
	 */
	public static boolean checkFriend(String username,String user) {
		try{
			for (Users s : UserCollection.userList.get(whoIsID(user)).showFriend()) {
		
			if (s.getUsername().equals(username)) {
				return true;
			}
		}
	
	
	}	
	catch(NullPointerException e){
		
	}
		return false;
	}
	/**
	 * This function checks user is real.
	 * @param username
	 * @return
	 */
	public static boolean checkUser(String username) {
		for (Users s : UserCollection.userList) {
			if (s.getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	} 
	/**
	 * This function helps tag friends
	 * @param name
	 */
	public static void tagger(String name,String user) {
		String[] dizi = name.split(":");
		for (String p : dizi) {
			if (checkFriend(p,user)) {
				
					UserCollection.userList.get(whoIsID(user)).addTag(whoIs(p).getName());
				
			}
		}
		
	}
	
	
	public static void addVidePost(String user, String text, String longitude, String latitude, String duration,
			String taggedFriend, String fileName) {
		try {
			if (Integer.parseInt(duration) <= VideoPost.getMaxvideolength()) {

				tagger(taggedFriend, user);
				UserCollection.userList.get(whoIsID(user)).addVideoPost(text, Double.parseDouble(longitude),
						Double.parseDouble(latitude), UserCollection.userList.get(whoIsID(user)).showTagged(),
						UserCollection.userList.get(whoIsID(user)), fileName, Integer.parseInt(duration));
				
			} else {
				System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
			}

		} catch (ArrayIndexOutOfBoundsException indexError) {
			indexError.getMessage();
		} catch (NumberFormatException e) {
			e.getMessage();
		}

	}	
	
	
	public static void addGuiVidePost(String user, String text, String longitude, String latitude, String duration, String fileName) {
		try {
			if (Integer.parseInt(duration) <= VideoPost.getMaxvideolength()) {

				UserCollection.userList.get(whoIsID(user)).addGuiVideoPost(text, Double.parseDouble(longitude),
						Double.parseDouble(latitude), UserCollection.userList.get(whoIsID(user)), fileName,
						Integer.parseInt(duration));
				
			} else {
				System.out.println("Error: Your video exceeds maximum allowed duration of 10 minutes.");
			}

		} catch (ArrayIndexOutOfBoundsException indexError) {
			indexError.getMessage();
		} catch (NumberFormatException e) {
			e.getMessage();
		}

	}
	public static void addFriend(String user, String newFriend) {
		try {

			if (UserCollection.userList.get(whoIsID(user)).showFriend().contains(whoIs(newFriend))) {

			} else {

				UserCollection.userList.get(whoIsID(user)).addFriend(whoIs(newFriend));

				if (UserCollection.userList.get(whoIsID(newFriend)).showFriend().contains(whoIs(user))) {

				} else {
					UserCollection.userList.get(whoIsID(newFriend)).addFriend(whoIs(user));
				}
				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			
		}
		catch(NullPointerException e){
			
		}
	}
	
	
	public static void addImagePost(String user,String text,String longitude,String latitude,String pixel,String taggedFriend,String fileName){
		try{
			String[] img = pixel.split("<x>");
			tagger(taggedFriend,user);
			UserCollection.userList.get(whoIsID(user)).addImagePost(text,Double.parseDouble(longitude),Double.parseDouble(latitude),UserCollection.userList.get(whoIsID(user)).showTagged(),UserCollection.userList.get(whoIsID(user)), fileName,img);
			
		}
		catch(ArrayIndexOutOfBoundsException indexError){
			indexError.getMessage();
		}
		catch(NullPointerException e){
			
		}
	}
	
	
	
	public static void addGuiImagePost(String user,String text,String longitude,String latitude,String pixel1,String pixel2,String fileName){
		try{
			String[] img = new String[2];
			img[0]=pixel1;
			img[1]=pixel2;
			UserCollection.userList.get(whoIsID(user)).addGuiImagePost(text, Double.parseDouble(longitude),Double.parseDouble(latitude), UserCollection.userList.get(whoIsID(user)), fileName, img);
			
		}
		catch(ArrayIndexOutOfBoundsException indexError){
			indexError.getMessage();
		}
	}
	
	public static void addTextPost(String user,String text,String longitude,String latitude,String taggedFriend){
		
		try{
			
			Function.tagger(taggedFriend,user);
			UserCollection.userList.get(whoIsID(user)).addTextPost(text,Double.parseDouble(longitude),Double.parseDouble(latitude),UserCollection.userList.get(whoIsID(user)).showTagged(),UserCollection.userList.get(whoIsID(user)));
			
		}
		catch(ArrayIndexOutOfBoundsException indexError){
			
		}
		
		catch(NullPointerException e){
			
		}
	
		
	}
	
public static void addGuiTextPost(String user,String text,String longitude,String latitude){
		
		try{
			UserCollection.userList.get(whoIsID(user)).addGuiTextPost(text,Double.parseDouble(longitude),Double.parseDouble(latitude),UserCollection.userList.get(whoIsID(user)));
			
		}
		catch(ArrayIndexOutOfBoundsException indexError){
			indexError.getMessage();
		}
	
		
	}
	
	public static void blockFriend(String user,String newFriend){
		try{
			if(UserCollection.checkUsername(user)){
				if(UserCollection.userList.get(whoIsID(user)).showFriend().contains(whoIs(newFriend))){
					if(UserCollection.userList.get(whoIsID(user)).ShowBlockedFriend().contains(whoIs(newFriend))){
						
					}
					else{	
						
					UserCollection.userList.get(whoIsID(user)).blockFriend(whoIs(newFriend));
					UserCollection.userList.get(whoIsID(user)).block(whoIs(newFriend));
					UserCollection.userList.get(whoIsID(newFriend)).blockFriend(whoIs(user));
					UserCollection.userList.get(whoIsID(newFriend)).block(whoIs(user));
						
					}
				}
				else if(UserCollection.userList.get(whoIsID(user)).showBlocked().contains(whoIs(newFriend))){
				
				}
				else{
					UserCollection.userList.get(whoIsID(user)).block(whoIs(newFriend));	
					
				}
			}
		else{
				
			}
		}
		catch (ArrayIndexOutOfBoundsException e){
			
		}
	}
	
	/**
	 * This function reads the file and performs the necessary operations
	 * @param args
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	
	public static void startFunc(String[] args) throws FileNotFoundException, NumberFormatException, ParseException {
		/**
		 * reads file
		 */
		
		readFile readObj = new readFile();
		ArrayList<String> commandsList = readObj.read_file(args[1]);
		for (int i = 0; i < commandsList.size(); i++) {
			
			String[] dizi = commandsList.get(i).split("\t");
			if (dizi[0].equals("ADDFRIEND")) {
				Function.addFriend(dizi[1],dizi[2]);
			}
			
			else if(dizi[0].equals("BLOCKFRIEND")){
				Function.blockFriend(dizi[1],dizi[2]);
			}
			
			else if(dizi[0].equals("ADDPOST-TEXT")){
				Function.addTextPost(dizi[1], dizi[2], dizi[3], dizi[4], dizi[5]);
			}
			
			else if(dizi[0].equals("ADDPOST-IMAGE")){
				Function.addImagePost(dizi[1], dizi[2], dizi[3], dizi[4], dizi[7], dizi[5], dizi[6]);
			}
			
			else if(dizi[0].equals("ADDPOST-VIDEO")){
				Function.addVidePost(dizi[1], dizi[2], dizi[3], dizi[4], dizi[7],dizi[5], dizi[6]);
			}
			
		}

	}

	
}
