import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JRadioButton;
import javax.swing.JPanel;
import java.io.FileNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JTabbedPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.border.TitledBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.event.CaretListener;
import javax.swing.event.CaretEvent;
import java.awt.Toolkit;

public class ProfilePage extends JFrame{


	private static final long serialVersionUID = 1L;
	private JTextField searchField;
	private JLabel profileNameSurname;
	private JTextField updateNameField;
	private JLabel schoolText;
	public static JPanel panel_2 ;
	private JTextField updateSchoolField;
	private JTextField updateBirthDateField;
	private	JComboBox<String> updateRelationBox;
	public static JPanel ownPost;
	private	JComboBox<String> relationshipStatusBox; 
	private	JButton buttonSave;
	private JButton btnProfileUpdate;
	private JButton btnHome;
	
	
	private JLabel lblDateText;
	DefaultListModel<String> model = new DefaultListModel<>();
	DefaultListModel<String> modelBlocked = new DefaultListModel<>();
	static DefaultListModel<String> searchDefaultList = new DefaultListModel<>();
	public static JList<String> searchList = new JList<>(searchDefaultList);
	public JList<String> friendList = new JList<>(model);
	public JList<String> blockedList = new JList<>( modelBlocked );
	static String selectedFriend ="";
	static String selectedBlocked="";
	static int friendsPostsCounter=0;
	/**
	 * Launch the application.
	 * @throws FileNotFoundException 
	 * @throws ParseException 
	 */
	public static void main(String[] args) throws FileNotFoundException, ParseException {
		readFile readObj = new readFile();
		ArrayList<String> usersList = readObj.read_file(args[0]);
		DateFormat dateformat = new SimpleDateFormat("MM/dd/yyyy");
		for (int i = 0; i < usersList.size(); i++) {
			String[] dizi = usersList.get(i).split("\t");
			String[] splitter = dizi[3].split("/");
			dizi[3]=(splitter[1]+"/"+splitter[0]+"/"+splitter[2]);
			
			UserCollection.addUser(UserCollection.userCounter, dizi[0], dizi[1], dizi[2],dizi[3], dizi[4],dizi[5]);
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePage window = new ProfilePage();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ProfilePage() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("personicon8.png"));
		initialize();
	}

	public void addList(DefaultListModel<String> list) {
		for (Users p : UserCollection.userList.get(Main.userID).showFriend()) {
			list.addElement(p.getUsername());
		}
	}
	
	public void addSearchList(DefaultListModel<String> list) {
		
	}
	
	public void creater(){
		ProfilePageFriend newpp = new ProfilePageFriend();
		setVisible(false);
		newpp.setVisible(true);
	}
	
	public void searcher(String name,int counterx){
		
		for (Users p : UserCollection.userList) {
			if(UserCollection.userList.get(Main.userID).showBlocked().contains(p)){
				
			}
			else if(p.getName().toLowerCase().startsWith(name.toLowerCase(),counterx)) {

				
				searchList.setBounds(248, 30, 142, 100);
				getContentPane().add(searchList);
				searchList.setVisible(true);
				searchDefaultList.addElement(p.getName());
			}
		}
		
		
		
		
			searchList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2) {
					
					Main.awayUserID = Function.whichFriendID(ProfilePage.searchList.getSelectedValue());
					creater();
					
				}
			}
		});
	}
	
	
	public static void showFriendPost(){
		for(Users p:UserCollection.userList.get(Main.userID).showFriend()){
			for(int i=0;i<p.getGeneral().size();i++){
				JPanel panel_3 = new JPanel();
				panel_3.setLayout(null);
				panel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_3.setBounds(0, 64*(friendsPostsCounter), 379, 64);
				panel_2.add(panel_3);
				
				JLabel label = new JLabel("Tagged Users:");
				label.setBounds(0, 50, 109, 14);
				panel_3.add(label);
				
				JLabel label_2 = new JLabel(checkPost(p.getGeneral().get(i)));
				label_2.setFont(new Font("Arial Black", Font.BOLD, 18));
				label_2.setBounds(0, -2, 25, 48);
				panel_3.add(label_2);
				
				JLabel label_3 = new JLabel("<html>"+p.getGeneral().get(i).getText()+"</html>");
				label_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
				label_3.setForeground(Color.BLUE);
				label_3.setBounds(35, 21, 246, 24);
				panel_3.add(label_3);
				
				JLabel label_4 = new JLabel(""+String.join(" ,",p.getGeneral().get(i).getTagged()));
				label_4.setBounds(86, 50, 283, 14);
				panel_3.add(label_4);

				JLabel lblNewLabel = new JLabel(p.getName()+"'s has shared");
				lblNewLabel.setBounds(20, 8, 195, 14);
				panel_3.add(lblNewLabel);
				friendsPostsCounter++;
			}
		}
		
	}
	public void addListBlocked(DefaultListModel<String> list) {
		for (Users p : UserCollection.userList.get(Main.userID).showBlocked()) {
			list.addElement(p.getUsername());
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static void showPost(){
		
		for(int i=0;i<UserCollection.userList.get(Main.userID).getGeneral().size();i++){
			int postIndex=i;
			
			
			if(UserCollection.userList.get(Main.userID).getGeneral().size()>0){
				JPanel panel_i = new JPanel();
				panel_i.setLayout(null);
				panel_i.setBorder(new LineBorder(new Color(0, 0, 0)));
				panel_i.setBounds(0, 64*(i), 379, 64);
				ownPost.add(panel_i);
				
				
				JButton button = new JButton("Tag Friends");
				button.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseClicked(MouseEvent e) {
						if(e.getClickCount()==1){
							TagFriend wndw = new TagFriend(postIndex);
							wndw.setVisible(true);
						}
					}
				});
				button.setBounds(260, 11, 109, 29);
				panel_i.add(button);
				
				JLabel label_5 = new JLabel("Tagged Users:");
				label_5.setBounds(0, 50, 109, 14);
				panel_i.add(label_5);
				
				JLabel label_6 = new JLabel(checkPost(UserCollection.userList.get(Main.userID).getGeneral().get(i)));
				label_6.setFont(new Font("Arial Black", Font.BOLD, 18));
				label_6.setBounds(0, -2, 25, 48);
				panel_i.add(label_6);
				
				JLabel label_7 = new JLabel("<html>"+UserCollection.userList.get(Main.userID).getGeneral().get(i).getText() + "</html>");
				label_7.setForeground(Color.BLUE);
				label_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
				label_7.setBounds(35, 11, 246, 24);
				panel_i.add(label_7);
				
	
				JLabel label_8 = new JLabel(""+String.join(" ,",UserCollection.userList.get(Main.userID).getGeneral().get(i).getTagged()));
				label_8.setBounds(86, 50, 283, 14);
				panel_i.add(label_8);
				ownPost.setPreferredSize(new Dimension(379, 64*i));
			}
			else{
				
			}
		}

	}
	
	
	public void updateProfileMethod(){
		lblDateText.setVisible(false);
		updateBirthDateField.setVisible(true);
		profileNameSurname.setVisible(false);
		updateNameField.setVisible(true);
		schoolText.setVisible(false);
		updateSchoolField.setVisible(true);
		relationshipStatusBox.setVisible(false);
		updateRelationBox.setVisible(true);
		btnProfileUpdate.setVisible(false);
		buttonSave.setVisible(true);
	}
	
	public static String checkPost(Post x){
		if(x.getClass().toString().contains("Text")){
			return "T";
		}
		else if(x.getClass().toString().contains("Image")){
			return "I";
		}
		else{
			return "V";
		}
	}
	
	public void saveProfileMethod(){
		UserCollection.userList.get(Main.userID).updateProfile(updateNameField.getText(), updateBirthDateField.getText(), updateSchoolField.getText(), updateRelationBox.getSelectedItem().toString());
		profileNameSurname.setText(UserCollection.userList.get(Main.userID).getName());
		schoolText.setText(UserCollection.userList.get(Main.userID).getSchoolGraduated());
		lblDateText.setText(UserCollection.userList.get(Main.userID).getDateOfBirth());
		relationshipStatusBox.removeAllItems();
		relationshipStatusBox.addItem(UserCollection.userList.get(Main.userID).getRelationshipStatus());
		lblDateText.setVisible(true);
		updateBirthDateField.setVisible(false);
		profileNameSurname.setVisible(true);
		updateNameField.setVisible(false);
		schoolText.setVisible(true);
		updateSchoolField.setVisible(false);
		relationshipStatusBox.setVisible(true);
		updateRelationBox.setVisible(false);
		buttonSave.setVisible(false);
		btnProfileUpdate.setVisible(true);
	}
	
	
	private void initialize() {
		setTitle("Profile Page");
		setBounds(100, 100, 678, 617);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		JLabel profileImage = new JLabel("");
		profileImage.setBounds(10, 37, 150, 143);
		ImageIcon img = new ImageIcon("personicon8.png");
		getContentPane().setLayout(null);
		profileImage.setIcon(img);
		getContentPane().add(profileImage);
		
		JButton btnCreatePost = new JButton("Create a Post");
		btnCreatePost.setBounds(432, 9, 128, 23);
		btnCreatePost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() ==1){
					AddPost addPost = new AddPost();
					addPost.setVisible(true);
				}
			}
		});
		getContentPane().add(btnCreatePost);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(563, 9, 89, 23);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					UserCollection.userList.get(Main.userID).setSignedIn(false);
					ProfilePage.searchDefaultList.removeAllElements();
					ProfilePageFriend.searchDefaultList.removeAllElements();
					friendsPostsCounter=0;
					setVisible(false);
				}
			}
		});
		getContentPane().add(btnLogout);
		
		profileNameSurname = new JLabel("");
		profileNameSurname.setBounds(193, 130, 223, 32);
		
		profileNameSurname.setText(UserCollection.userList.get(Main.userID).getName());
		profileNameSurname.setFont(new Font("Arial Black", Font.BOLD, 18));
		getContentPane().add(profileNameSurname);
		
		searchField = new JTextField();
		searchField.addCaretListener(new CaretListener() {
			int counter=0;
			public void caretUpdate(CaretEvent e) {
				
				ProfilePage.searchDefaultList.removeAllElements();
				searcher(searchField.getText(),counter);
				
			}
		});
		searchField.setBounds(248, 10, 142, 20);
		getContentPane().add(searchField);
		searchField.setColumns(10);
		
		
		JLabel lblSearchFriend = new JLabel("Search Friends");
		lblSearchFriend.setBounds(160, 13, 134, 14);
		getContentPane().add(lblSearchFriend);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 434, 170, 106);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().add(scrollPane);
		
		
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 191, 170, 206);
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(null, "Information", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDateOfBirth = new JLabel("Date of Birth");
		lblDateOfBirth.setFont(new Font("Arial Black", Font.BOLD, 10));
		lblDateOfBirth.setBounds(10, 11, 102, 14);
		panel.add(lblDateOfBirth);
		
		JLabel schoolGraduated = new JLabel("School Graduated");
		schoolGraduated.setFont(new Font("Arial Black", Font.BOLD, 10));
		schoolGraduated.setBounds(10, 54, 127, 14);
		panel.add(schoolGraduated);
		
		JLabel label_1 = new JLabel("Relationship Status");
		label_1.setFont(new Font("Arial Black", Font.BOLD, 10));
		label_1.setBounds(10, 97, 150, 14);
		panel.add(label_1);
		
		lblDateText = new JLabel("");
		lblDateText.setText(UserCollection.userList.get(Main.userID).getDateOfBirth().toString());
		lblDateText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDateText.setBounds(10, 36, 102, 14);
		panel.add(lblDateText);
		
		schoolText = new JLabel("");
		schoolText.setText(UserCollection.userList.get(Main.userID).getSchoolGraduated());
		schoolText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		schoolText.setBounds(10, 79, 115, 14);
		panel.add(schoolText);
		
		relationshipStatusBox = new JComboBox<String>();
		relationshipStatusBox.addItem(UserCollection.userList.get(Main.userID).getRelationshipStatus());
		relationshipStatusBox.setBounds(10, 122, 127, 20);
		panel.add(relationshipStatusBox);
		
		
		updateBirthDateField = new JTextField((String) null);
		updateBirthDateField.setBounds(10, 36, 102, 14);
		panel.add(updateBirthDateField);
		updateBirthDateField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		updateBirthDateField.setVisible(false);
		
		updateSchoolField = new JTextField((String) null);
		updateSchoolField.setBounds(10, 79, 115, 14);
		panel.add(updateSchoolField);
		updateSchoolField.setFont(new Font("Tahoma", Font.PLAIN, 10));
		updateSchoolField.setVisible(false);
		
		
		JRadioButton btnNormal = new JRadioButton("Normal");
		btnNormal.setBounds(67, 404, 73, 23);

		addList(model);
		btnNormal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					scrollPane.setViewportView(friendList);
					selectedFriend=friendList.getSelectedValue();
					
				}
				
			}
		});
		btnNormal.setSelected(true);
		getContentPane().add(btnNormal);
		
		addListBlocked(modelBlocked);
		JRadioButton btnBlocked = new JRadioButton("Blocked");
		btnBlocked.setBounds(142, 404, 89, 23);
		btnBlocked.setSelected(true);

		
		btnBlocked.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					
					scrollPane.setViewportView(blockedList);
					selectedBlocked=blockedList.getSelectedValue();
					
				}
			}
		});
		getContentPane().add(btnBlocked);
		
		ButtonGroup group = new ButtonGroup();
		group.add(btnNormal);
		group.add(btnBlocked);
		
		JLabel lblFriends = new JLabel("Friends");
		lblFriends.setBounds(20, 409, 46, 14);
		getContentPane().add(lblFriends);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(248, 200, 384, 340);
		getContentPane().add(scrollPane_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane_1.setViewportView(tabbedPane);
		
		ownPost = new JPanel();
		tabbedPane.addTab("Posts", null, ownPost, null);
		ownPost.setLayout(null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Friend's Posts", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		
		showPost();

		showFriendPost();
		
		
		updateNameField = new JTextField((String) null);
		updateNameField.setBounds(193, 130, 223, 32);
		updateNameField.setFont(new Font("Arial Black", Font.BOLD, 18));
		getContentPane().add(updateNameField);
		updateNameField.setVisible(false);
		

		updateRelationBox = new JComboBox<String>();
		updateRelationBox.setBounds(10, 122, 127, 20);
		panel.add(updateRelationBox);
		updateRelationBox.addItem("Single");
		updateRelationBox.addItem("In relationship");
		updateRelationBox.addItem("Divorced");
		updateRelationBox.addItem("Complicated");
		updateRelationBox.setVisible(false);
	

		buttonSave = new JButton("Save");
		buttonSave.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					saveProfileMethod();
				}
			}
		});
		buttonSave.setBounds(10, 163, 89, 23);
		panel.add(buttonSave);
		buttonSave.setVisible(false);
		
		btnProfileUpdate = new JButton("Update");
		btnProfileUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					updateProfileMethod();
				}
			}
		});
		btnProfileUpdate.setBounds(10, 163, 89, 23);
		panel.add(btnProfileUpdate);
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 9, 89, 23);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					
				}
			}
		});
		getContentPane().add(btnHome);
		btnHome.setVisible(false);
		
		
		
		JButton btnBlockFriend = new JButton("Block this person");
		btnBlockFriend.setBounds(499, 168, 134, 23);
		btnBlockFriend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		getContentPane().add(btnBlockFriend);
		btnBlockFriend.setVisible(false);
		

		JButton btnNewButton = new JButton("Remove Selected User");
		btnNewButton.setBounds(20, 544, 170, 23);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() ==1){
					if(UserCollection.userList.get(Main.userID).showFriend().contains(Function.whoIs(friendList.getSelectedValue()))){
						UserCollection.userList.get(Main.userID).removeFriend(Function.whoIs(friendList.getSelectedValue()));
						model.remove(friendList.getSelectedIndex());
					}
					else if (UserCollection.userList.get(Main.userID).showBlocked()
							.contains(Function.whoIs(blockedList.getSelectedValue()))) {
						
						UserCollection.userList.get(Main.userID).unBlock(Function.whoIs(friendList.getSelectedValue()));
						modelBlocked.remove(blockedList.getSelectedIndex());
					}
					else{
						
					}
						
					
					
				}
			}
		});
		getContentPane().add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 662, 38);
		getContentPane().add(panel_1);
		
		
		
	}
	
}
