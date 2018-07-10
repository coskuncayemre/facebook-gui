import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashSet;
import java.util.Set;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

public class TagFriend extends JFrame {
	DefaultListModel<String> model = new DefaultListModel<>();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3869302237479316635L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TagFriend frame = new TagFriend();
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
	
	public void addList(DefaultListModel<String> list,int index) {
		
		Set<String> hs = new HashSet<>();
		for (Users p : UserCollection.userList.get(Main.userID).showFriend()) {
			
			if(UserCollection.userList.get(Main.userID).getGeneral().get(index).getType().equals("GUI")){
				hs.add(p.getUsername());
			}else{
			for (String x : UserCollection.userList.get(Main.userID).getGeneral().get(index).getTagged()) {
				if(p.getName().equals(x)){
					
				}
				else{
					if(UserCollection.userList.get(Main.userID).getGeneral().get(index).getTagged().contains(p.getName())){
						
					}
					else{
						hs.add(p.getUsername());
					}
				}
			}
			}
		}
		for(String y:hs){
			list.addElement(y);
		}
	}
	
	
	public TagFriend(int postIndex) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setBounds(100, 100, 220, 302);
		getContentPane().setLayout(null);
		
		JLabel lblTaggableFriends = new JLabel("Taggable Friends");
		lblTaggableFriends.setBounds(10, 11, 159, 24);
		getContentPane().add(lblTaggableFriends);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(10, 46, 184, 163);
		getContentPane().add(scrollPane);
		
		addList(model,postIndex);
		JList<String> list = new JList<>(model);
		scrollPane.setViewportView(list);
		
		JButton btnNewButton = new JButton("Tag Friend");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount()==1){
					if(list.isSelectionEmpty()){
						
					}else{
						UserCollection.userList.get(Main.userID).getGeneral().get(postIndex).setTagged(Function.whoIs(list.getSelectedValue()).getName());
						
						JOptionPane.showMessageDialog(null, "To refresh own posts Please click Friend's Posts and again click Posts");
						ProfilePage.showPost();
						
					}
					setVisible(false);
				}
			}
		});
		btnNewButton.setBounds(10, 229, 184, 23);
		getContentPane().add(btnNewButton);
		
		
	}
	
	public TagFriend() {
		
	}

}
