import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;

public class CreateUsers extends JFrame{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//	private JFrame frame;
	private JTextField usernameField;
	private JTextField nameSurnameField;
	private JTextField schoolField;
	private JTextField birthDateField;
	private JPasswordField passwordField;
	private JPasswordField passwordFieldReType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateUsers window = new CreateUsers();
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
	public CreateUsers() {
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		setSize(300, 500);
		setBounds(100, 100, 341, 431);
		setLocation(200, 400);
		getContentPane().setLayout(null);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JLabel lblNewLabel = new JLabel("");
		Image imgx = new ImageIcon(this.getClass().getResource("/Facebooklogo1.png")).getImage();
		lblNewLabel.setIcon(new ImageIcon(imgx));
		lblNewLabel.setBounds(10, 32, 340, 59);
		getContentPane().add(lblNewLabel);
		
		JLabel lblCreateUsers = new JLabel("Create User");
		lblCreateUsers.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblCreateUsers.setBounds(123, 102, 152, 21);
		getContentPane().add(lblCreateUsers);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 143, 107, 21);
		getContentPane().add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 169, 107, 21);
		getContentPane().add(lblPassword);
		
		JLabel lblPasswrodretype = new JLabel("Passwrod(re-type)");
		lblPasswrodretype.setBounds(10, 194, 107, 21);
		getContentPane().add(lblPasswrodretype);
		
		JLabel lblNameSurname = new JLabel("Name Surname");
		lblNameSurname.setBounds(10, 226, 107, 21);
		getContentPane().add(lblNameSurname);
		
		JLabel lblSchoolGrau = new JLabel("School graduated");
		lblSchoolGrau.setBounds(10, 256, 107, 21);
		getContentPane().add(lblSchoolGrau);
		
		JLabel lblBirthDate = new JLabel("Birth Date");
		lblBirthDate.setBounds(10, 286, 107, 21);
		getContentPane().add(lblBirthDate);
		
		JLabel lblRelationshipStatus = new JLabel("Relationship Status");
		lblRelationshipStatus.setBounds(10, 313, 107, 21);
		getContentPane().add(lblRelationshipStatus);
		
		usernameField = new JTextField();
		usernameField.setBounds(123, 143, 86, 20);
		getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		nameSurnameField = new JTextField();
		nameSurnameField.setColumns(10);
		nameSurnameField.setBounds(123, 226, 175, 20);
		getContentPane().add(nameSurnameField);
		
		schoolField = new JTextField();
		schoolField.setColumns(10);
		schoolField.setBounds(123, 256, 175, 20);
		getContentPane().add(schoolField);
		
		birthDateField = new JTextField();
		birthDateField.setColumns(10);
		birthDateField.setBounds(123, 286, 86, 20);
		getContentPane().add(birthDateField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(123, 169, 86, 21);
		getContentPane().add(passwordField);
		
		passwordFieldReType = new JPasswordField();
		passwordFieldReType.setBounds(123, 194, 86, 21);
		getContentPane().add(passwordFieldReType);
		
		JComboBox<String> relationshipStatusBox = new JComboBox<String>();
		relationshipStatusBox.addItem("Single");
		relationshipStatusBox.addItem("In a relationship");
		relationshipStatusBox.addItem("Divorced");
		relationshipStatusBox.addItem("Complicated");
		relationshipStatusBox.setBounds(123, 313, 124, 21);
		getContentPane().add(relationshipStatusBox);
		
		JButton btnCreateUser = new JButton("Create User");
		btnCreateUser.setBounds(110, 358, 124, 23);
		btnCreateUser.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				if(usernameField.getText().equals("") || passwordField.getPassword().equals("") || passwordFieldReType.getPassword().equals("") || schoolField.getText().equals("") || nameSurnameField.getText().equals("") || birthDateField.getText().equals("")){
					JOptionPane.showMessageDialog(null, "Please try again.");
				}
				else{
					if(passwordField.getText().equals(passwordFieldReType.getText())){
						UserCollection.addUser(UserCollection.userCounter, nameSurnameField.getText(), usernameField.getText(), passwordField.getText(),birthDateField.getText(), schoolField.getText(),relationshipStatusBox.getSelectedItem().toString());
						UserCollection.userCounter++;
						Main.model.addElement(usernameField.getText());
						setVisible(false);
					}
					else{
						
						JOptionPane.showMessageDialog(null, "Password does not match.");
					}
				}
				
			}
		});
		getContentPane().add(btnCreateUser);
		
	}
}
