import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;


import javax.swing.JTextField;

import javax.swing.JLabel;


import java.awt.Image;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class Main  extends JFrame{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	static DefaultListModel<String> model = new DefaultListModel<>();
	public static int userID=-1;
	public static int awayUserID;

	/**
	 * Launch the application.
	 * @throws ParseException 
	 * @throws FileNotFoundException 
	 */
	public static void main(String[] args) throws ParseException, FileNotFoundException {
		UserCollection.startFunc(args);
		Function.startFunc(args);
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
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
	public Main() {
		setBounds(100, 100, 512, 332);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		initialize();
		
	}
	
	public void addList(DefaultListModel<String> list){
		for(Users p:UserCollection.userList){
			list.addElement(p.getUsername());
		}
	}
	
	
	/**
	 * Initialize the contents of the 
	 */
	public void initialize() {
		setTitle("Facebook Login Page");
		getContentPane().setLayout(null);
		addList(model);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 199, 369, 49);
		getContentPane().add(scrollPane);
		JList<String> list = new JList<>( model );
		list.setVisibleRowCount(2);
		list.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					
					textField.setText(UserCollection.userList.get(list.getSelectedIndex()).getUsername());
					passwordField.setText(UserCollection.userList.get(list.getSelectedIndex()).getPassword());
				}
			}
		});
		list.setLayoutOrientation(JList.VERTICAL_WRAP);
		scrollPane.setViewportView(list);
		
		
		
		
		JButton btnNewUser = new JButton("New User...");
		btnNewUser.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					CreateUsers cru = new CreateUsers();
					cru.setVisible(true);
				}
			}
		});
		btnNewUser.setBounds(356, 259, 117, 23);
		getContentPane().add(btnNewUser);
		
		JButton button = new JButton("Remove User");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to remove?",null,  JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION)
				{
					UserCollection.removeUser(Function.whoIsID(list.getSelectedValue()));
					model.remove(list.getSelectedIndex());
					
				}
				
				
			}
		});
		button.setBounds(10, 259, 117, 23);
		getContentPane().add(button);
		
		JLabel lblRegisteredUsers = new JLabel("Registered Users");
		lblRegisteredUsers.setBounds(10, 181, 101, 14);
		getContentPane().add(lblRegisteredUsers);
		
		textField = new JTextField();
		textField.setBounds(400, 75, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(400, 100, 86, 18);
		getContentPane().add(passwordField);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(333, 78, 86, 14);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(333, 102, 75, 14);
		getContentPane().add(lblPassword);
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(397, 129, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(UserCollection.userSignIn(textField.getText(), passwordField.getText())){
					try{
					if(userID==-1){
						userID=Function.whoIsOnline();
						ProfilePage pp= new ProfilePage();
						JOptionPane.showMessageDialog(null, "You have successfuly login.");
						pp.setVisible(true);
					}else{
						userID=Function.whoIsOnline();
						ProfilePage pp= new ProfilePage();
						JOptionPane.showMessageDialog(null, "You have successfuly login.");
						pp.setVisible(true);
					}
					
					}
					catch (NullPointerException exc){
						JOptionPane.showMessageDialog(null, "No such user!");
					}
				}
				else{
					
				}
			}
		});
		getContentPane().add(btnLogin);
		
		JLabel label = new JLabel("");
		Image img = new ImageIcon(this.getClass().getResource("/Facebooklogo1.png")).getImage();
		label.setIcon(new ImageIcon(img));
		label.setBounds(0, 56, 302, 83);
		getContentPane().add(label);
		
	}
	
	
}
