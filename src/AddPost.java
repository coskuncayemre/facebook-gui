import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddPost extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2782997434160507328L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField latitudeField;
	private JTextField longitudeField;
	private JTextField fileNameField;
	private JTextField heightField;
	private JTextField widthField;
	private JTextField durationField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPost frame = new AddPost();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddPost() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setTitle("Add Post");
		setBounds(100, 100, 450, 247);
		
		getContentPane().setLayout(null);
		JOptionPane.showMessageDialog(null,"If you want to create TextPost,you should selected again 'TextPost' from ComboBox.");
		JLabel lblNewLabel = new JLabel("Post Type");
		lblNewLabel.setBounds(10, 28, 74, 19);
		getContentPane().add(lblNewLabel);
		
		JLabel lblText = new JLabel("Text:");
		lblText.setBounds(10, 61, 74, 19);
		getContentPane().add(lblText);
		
		JLabel lblLatitude = new JLabel("Latitude:");
		lblLatitude.setBounds(10, 91, 74, 19);
		getContentPane().add(lblLatitude);
		
		JLabel lblLongtitude = new JLabel("Longitude:");
		lblLongtitude.setBounds(186, 91, 74, 19);
		getContentPane().add(lblLongtitude);
		
		JButton btnAddPost = new JButton("Add Post");
		btnAddPost.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 1){
					setVisible(false);
				}
			}
		});
		btnAddPost.setBounds(323, 26, 89, 23);
		getContentPane().add(btnAddPost);
		
		textField = new JTextField();
		textField.setBounds(64, 60, 348, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		latitudeField = new JTextField();
		latitudeField.setBounds(64, 91, 112, 20);
		getContentPane().add(latitudeField);
		latitudeField.setColumns(10);
		
		
		longitudeField = new JTextField();
		longitudeField.setBounds(242, 90, 101, 20);
		getContentPane().add(longitudeField);
		longitudeField.setColumns(10);
		

		JLabel lblFileName = new JLabel("Filename:");
		lblFileName.setBounds(10, 121, 74, 19);
		getContentPane().add(lblFileName);
		lblFileName.setVisible(false);
		
		fileNameField = new JTextField();
		fileNameField.setColumns(10);
		fileNameField.setBounds(64, 121, 184, 20);
		getContentPane().add(fileNameField);
		fileNameField.setVisible(false);
		
		JLabel lblWidth = new JLabel("Width:");
		lblWidth.setBounds(10, 151, 74, 19);
		getContentPane().add(lblWidth);
		lblWidth.setVisible(false);
		
		JLabel lblHeight = new JLabel("Height:");
		lblHeight.setBounds(139, 151, 74, 19);
		getContentPane().add(lblHeight);
		lblHeight.setVisible(false);
		
		widthField = new JTextField();
		widthField.setColumns(10);
		widthField.setBounds(64, 151, 74, 20);
		getContentPane().add(widthField);
		widthField.setVisible(false);
		
		heightField = new JTextField();
		heightField.setColumns(10);
		heightField.setBounds(174, 152, 74, 20);
		getContentPane().add(heightField);
		heightField.setVisible(false);
		
		JLabel lblDuration = new JLabel("Duration:");
		lblDuration.setBounds(10, 151, 74, 19);
		getContentPane().add(lblDuration);
		lblDuration.setVisible(false);
		
		
		durationField = new JTextField();
		durationField.setColumns(10);
		durationField.setBounds(64, 151, 74, 20);
		getContentPane().add(durationField);
		durationField.setVisible(false);

		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("TextPost");
		comboBox.addItem("ImagePost");
		comboBox.addItem("VideoPost");
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(comboBox.getSelectedItem().toString().equals("TextPost")){
					lblFileName.setVisible(false);
					fileNameField.setVisible(false);
					lblDuration.setVisible(false);
					durationField.setVisible(false);
					lblWidth.setVisible(false);
					widthField.setVisible(false);
					lblHeight.setVisible(false);
					heightField.setVisible(false);
					btnAddPost.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try{
								if (e.getClickCount() == 1) {
									Function.addGuiTextPost(UserCollection.userList.get(Main.userID).getUsername(), textField.getText(), longitudeField.getText(), latitudeField.getText());
									JOptionPane.showMessageDialog(null, "Success");
									ProfilePage.showPost();
									ProfilePage.showFriendPost();
								}
							}
							catch (Exception exc) {
								JOptionPane.showMessageDialog(null, "Please try again");
							}
						}
					});
				}
				else if (comboBox.getSelectedItem().toString().equals("ImagePost")) {
					lblFileName.setVisible(true);
					fileNameField.setVisible(true);
					lblWidth.setVisible(true);
					widthField.setVisible(true);
					lblHeight.setVisible(true);
					heightField.setVisible(true);
					lblDuration.setVisible(false);
					durationField.setVisible(false);
					btnAddPost.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							try{
								
								if(e.getClickCount() == 1){
									Function.addGuiImagePost(UserCollection.userList.get(Main.userID).getUsername(), textField.getText(), longitudeField.getText(), latitudeField.getText(), widthField.getText(),heightField.getText(), fileNameField.getText());
									JOptionPane.showMessageDialog(null, "Success");
									ProfilePage.showPost();
									ProfilePage.showFriendPost();
								}
							}
							catch (Exception exc) {
								JOptionPane.showMessageDialog(null, "Please try again");
							}
						}
					});
					
					
				}
				else if(comboBox.getSelectedItem().toString().equals("VideoPost")){
					lblFileName.setVisible(true);
					fileNameField.setVisible(true);
					lblDuration.setVisible(true);
					durationField.setVisible(true);
					lblWidth.setVisible(false);
					widthField.setVisible(false);
					lblHeight.setVisible(false);
					heightField.setVisible(false);
					btnAddPost.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							if (e.getClickCount() == 1) {
								try{
									if(Integer.parseInt(durationField.getText())>10){
										JOptionPane.showMessageDialog(null, "The maximum allowed video duration is 10 minutes).");
									}
									else{
										Function.addGuiVidePost(UserCollection.userList.get(Main.userID).getUsername(), textField.getText(), longitudeField.getText(), latitudeField.getText(),durationField.getText(), fileNameField.getText());	
										JOptionPane.showMessageDialog(null, "Success");
										ProfilePage.showPost();
										ProfilePage.showFriendPost();
									}
								}
								catch (Exception exc) {
									JOptionPane.showMessageDialog(null, "Please try again");
								}
							}
						}
					});
					
				}
			}
		});
		
		comboBox.setBounds(64, 27, 102, 20);
		getContentPane().add(comboBox);
					}

}
