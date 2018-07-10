import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class UserCollection {
	public static ArrayList<Users> userList = new ArrayList<>();
	static int userCounter = 1;
	static int removeUserCounter = 0;

	/**
	 * 
	 * @param args
	 * @throws FileNotFoundException
	 * @throws NumberFormatException
	 * @throws ParseException
	 */
	public static void startFunc(String[] args) throws FileNotFoundException, NumberFormatException, ParseException {
		readFile readObj = new readFile();
		ArrayList<String> usersList = readObj.read_file(args[0]);
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		for (int i = 0; i < usersList.size(); i++) {
			String[] dizi = usersList.get(i).split("\t");
			String[] splitter = dizi[3].split("/");
			dizi[3]=(splitter[1]+"/"+splitter[0]+"/"+splitter[2]);

			UserCollection.addUser(userCounter, dizi[0], dizi[1], dizi[2],dizi[3], dizi[4],dizi[5]);
		}
	}

	/**
	 * 
	 * @param userID
	 * @param name
	 * @param username
	 * @param password
	 * @param dizi
	 * @param school
	 */
	public static boolean addUser(int userID, String name, String username, String password, String dizi,
			String school,String relationship) {

		Users newUser = new Users(userID, name, username, password, dizi, school,relationship);
		userCounter++;
		return userList.add(newUser);

	}

	/**
	 * 
	 * @param userID
	 * @return
	 */
	public static boolean removeUser(int userIndex) {

		
		
		for(Users p: userList){
			
			if(p.getUserID()-1 > userIndex){
				p.setUserID(p.getUserID()-1);
				System.out.println(p.getName());
				System.out.println(p.getUserID());	
			}
		}
		userList.remove(userIndex);
		return true;





	}

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */

	public static boolean userSignIn(String username, String password) {
		if (checkUsername(username)) {
			for (int x = 0; x < userList.size(); x++) {
				if (userList.get(x).getUsername().equals(username) && userList.get(x).getPassword().equals(password)) {
					userList.get(x).setSignedIn(true);
					return true;
				} else if (userList.get(x).getUsername().equals(username)) {

					return false;
				} else if (userList.get(x).getPassword().equals(password)) {

					return false;
				}
			}
		}

		return false;

	}

	/**
	 * checkID method
	 * @param userID
	 * @return
	 */
	public static boolean checkID(int userID) {
		for (int x = 0; x < userList.size(); x++) {
			if (userList.get(x).getUserID() == userID) {
				return true;
			}
		}
		return false;
	}
	/**
	 * 
	 * @param username
	 * @return
	 */
	public static boolean checkUsername(String username) {
		for (int x = 0; x < userList.size(); x++) {
			if (userList.get(x).getUsername().equals(username)) {
				return true;
			}
		}
		return false;
	}
	/**
	 * ShowPost method
	 * @param user
	 */
	public static void showPosts(Users user) {
		for(int i=0;i<user.getGeneral().size();i++){
			user.getGeneral().get(i).display();
			if(user.getGeneral().get(i).getTagged().isEmpty()){

				continue;
			}
			user.getGeneral().get(i).showTagUser();


		}
	}
}
