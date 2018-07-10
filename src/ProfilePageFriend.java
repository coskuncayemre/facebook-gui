import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;

import java.awt.SystemColor;
import java.awt.Toolkit;

public class ProfilePageFriend extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4061136694661528659L;

	private JPanel contentPane;

	private JTextField searchField;
	private JLabel profileNameSurname;
	private JLabel schoolText;
	public static JPanel panel_2 ;
	public static JPanel ownPost;
	private	JComboBox<String> relationshipStatusBox; 
	private JButton btnHome;
	
	private JLabel lblDateText;
	DefaultListModel<String> model = new DefaultListModel<>();
	DefaultListModel<String> modelBlocked = new DefaultListModel<>();
	static DefaultListModel<String> searchDefaultList = new DefaultListModel<>();
	public static JList<String> searchList = new JList<>(searchDefaultList);
	static String selectedFriend ="";
	static String selectedBlocked="";
	static int friendsPostsCounter=0;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilePageFriend frame = new ProfilePageFriend();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	public void creater(){
		ProfilePageFriend newpp = new ProfilePageFriend();
		setVisible(false);
		newpp.setVisible(true);
	}
	

	public void addList(DefaultListModel<String> list) {
		for (Users p : UserCollection.userList.get(Main.awayUserID).showFriend()) {
			list.addElement(p.getUsername());
		}
	}
	
	public void addSearchList(DefaultListModel<String> list) {
		
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
		
		for(Users p:UserCollection.userList.get(Main.awayUserID).showFriend()){
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
				lblNewLabel.setBounds(20, 11, 195, 14);
				panel_3.add(lblNewLabel);
				friendsPostsCounter++;
			}
		}
		
	}
	public void addListBlocked(DefaultListModel<String> list) {
		for (Users p : UserCollection.userList.get(Main.awayUserID).showBlocked()) {
			list.addElement(p.getUsername());
		}
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	
	public static void showPost(){
		
		for(int i=0;i<UserCollection.userList.get(Main.awayUserID).getGeneral().size();i++){
			int postIndex=i;
			
			
			if(UserCollection.userList.get(Main.awayUserID).getGeneral().size()>0){
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
				
				JLabel label_6 = new JLabel(checkPost(UserCollection.userList.get(Main.awayUserID).getGeneral().get(i)));
				label_6.setFont(new Font("Arial Black", Font.BOLD, 18));
				label_6.setBounds(0, -2, 25, 48);
				panel_i.add(label_6);
				
				JLabel label_7 = new JLabel("<html>"+UserCollection.userList.get(Main.userID).getGeneral().get(i).getText() + "</html>");
				label_7.setForeground(Color.BLUE);
				label_7.setFont(new Font("Tahoma", Font.PLAIN, 9));
				label_7.setBounds(35, 11, 246, 24);
				panel_i.add(label_7);
	
				JLabel label_8 = new JLabel(""+String.join(" ,",UserCollection.userList.get(Main.awayUserID).getGeneral().get(i).getTagged()));
				label_8.setBounds(86, 50, 283, 14);
				panel_i.add(label_8);
				ownPost.setPreferredSize(new Dimension(379, 64*i));
			}
			else{
				
			}
		}

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
	
	
	
	/**
	 * Create the frame.
	 */
	public ProfilePageFriend() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("personicon8.png"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		setTitle("Profile Page");
		setBounds(100, 100, 678, 617);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel profileImage = new JLabel("");
		profileImage.setBounds(10, 37, 150, 143);
		ImageIcon img = new ImageIcon("personicon8.png");
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		profileImage.setIcon(img);
		getContentPane().add(profileImage);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(563, 9, 89, 23);
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					JOptionPane.showMessageDialog(null, "Are you sure?");
					UserCollection.userList.get(Main.awayUserID).setSignedIn(false);
					setVisible(false);
					
				}
			}
		});
		getContentPane().add(btnLogout);
		
		profileNameSurname = new JLabel("");
		profileNameSurname.setBounds(193, 138, 223, 32);
		
		profileNameSurname.setText(UserCollection.userList.get(Main.awayUserID).getName());
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
		lblDateText.setText(UserCollection.userList.get(Main.awayUserID).getDateOfBirth().toString());
		lblDateText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDateText.setBounds(10, 36, 102, 14);
		panel.add(lblDateText);
		
		schoolText = new JLabel("");
		schoolText.setText(UserCollection.userList.get(Main.awayUserID).getSchoolGraduated());
		schoolText.setFont(new Font("Tahoma", Font.PLAIN, 10));
		schoolText.setBounds(10, 79, 115, 14);
		panel.add(schoolText);
		
		relationshipStatusBox = new JComboBox<String>();
		relationshipStatusBox.addItem(UserCollection.userList.get(Main.awayUserID).getRelationshipStatus());
		relationshipStatusBox.setBounds(10, 122, 127, 20);
		panel.add(relationshipStatusBox);
		
		
		JRadioButton btnNormal = new JRadioButton("Normal");
		btnNormal.setBounds(67, 404, 73, 23);

		addList(model);
		btnNormal.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					JList<String> friendList = new JList<>(model);
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
					JList<String> blockedList = new JList<>( modelBlocked );
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
		contentPane.add(scrollPane_1);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		scrollPane_1.setViewportView(tabbedPane);
		
		ownPost = new JPanel();
		tabbedPane.addTab("Posts", null, ownPost, null);
		ownPost.setLayout(null);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Friend's Posts", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		
		try{
			showPost();
		}
		catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Please try again");
		}

		try{
			showFriendPost();
		}
		catch (IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(null, "Please try again");
		}
		
		if(UserCollection.userList.get(Main.userID).showFriend().contains(UserCollection.userList.get(Main.awayUserID))){
			JButton btnBlockFriend = new JButton("Block this person");
			btnBlockFriend.setBounds(497, 207, 134, 23);
			btnBlockFriend.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1){
						UserCollection.userList.get(Main.userID).removeFriend(UserCollection.userList.get(Main.awayUserID));
						UserCollection.userList.get(Main.userID).block(UserCollection.userList.get(Main.awayUserID));
						JOptionPane.showMessageDialog(null, "You blocked "+UserCollection.userList.get(Main.awayUserID).getName());
						setVisible(false);
						ProfilePage newWndw= new ProfilePage();
						newWndw.setVisible(true);
					}
				}
			});
			getContentPane().add(btnBlockFriend);
			btnBlockFriend.setVisible(true);
		}
		else{
			JButton btnAddFriend = new JButton("Add Friend");
			btnAddFriend.setBounds(497, 207, 134, 23);
			btnAddFriend.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount()==1){
						UserCollection.userList.get(Main.userID).addFriend(UserCollection.userList.get(Main.awayUserID));
						JOptionPane.showMessageDialog(null, "You added "+UserCollection.userList.get(Main.awayUserID).getName()+" as a friend");
						setVisible(false);
						ProfilePage newWndw= new ProfilePage();
						newWndw.setVisible(true);
					}
				}
			});
			getContentPane().add(btnAddFriend);
			btnAddFriend.setVisible(true);
		
		}
		
		btnHome = new JButton("Home");
		btnHome.setBounds(20, 9, 89, 23);
		btnHome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					setVisible(false);
					ProfilePage newWndw= new ProfilePage();
					ProfilePage.searchDefaultList.removeAllElements();
					ProfilePageFriend.searchDefaultList.removeAllElements();
					newWndw.setVisible(true);
				}
			}
		});
		getContentPane().add(btnHome);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.textHighlight);
		panel_1.setBounds(0, 0, 662, 38);
		contentPane.add(panel_1);
		btnHome.setVisible(true);
		
		
		

	}
}
