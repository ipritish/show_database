package main.java.com.datashow.ui;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import main.java.com.datashow.database.UserCRUD;
import main.java.com.datashow.database.PasswordEncryptionService;
import main.java.com.datashow.persistence.HibernateUtil;
import main.java.com.datashow.persistence.User;

public class AddUserUI {

	JPanel addUserPanel;
	boolean isValidated = false;
	
	public void getAddUserUI(final JFrame cont)
	{
		//JButton button = new JButton("test");
		addUserPanel = new JPanel();
		//addUserPanel.add(button);
		//layout added
		BoxLayout addUserLayout = new BoxLayout(addUserPanel, BoxLayout.Y_AXIS);
		addUserPanel.setLayout(addUserLayout);
		addUserPanel.add(Box.createHorizontalStrut(600));
		
		//user name panel
		JPanel userNamePanel = new JPanel();
		userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
		JLabel userLabel = new JLabel("User Name: ",JLabel.RIGHT);
		userLabel.setPreferredSize(new Dimension(120, 32));
		final JTextField userName = new JTextField(20);
		userName.setMaximumSize(userName.getPreferredSize());
		userName.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		userNamePanel.add(userLabel);
		userNamePanel.add(userName);
				
		//password panel
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		JLabel passLabel = new JLabel("Password: ",JLabel.RIGHT);
		passLabel.setPreferredSize(new Dimension(120, 32));
		final JPasswordField passField = new JPasswordField(20);
		passField.setMaximumSize(passField.getPreferredSize());
		passField.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		passwordPanel.add(passLabel);
		passwordPanel.add(passField);
		
		//confirm password panel
		JPanel confirmPasswordPanel = new JPanel();
		confirmPasswordPanel.setLayout(new BoxLayout(confirmPasswordPanel, BoxLayout.X_AXIS));
		JLabel confirmPassLabel = new JLabel("Confirm Password: ",JLabel.RIGHT);
		confirmPassLabel.setPreferredSize(new Dimension(120, 32));		
		final JPasswordField confirmPassField = new JPasswordField(20);
		confirmPassField.setMaximumSize(confirmPassField.getPreferredSize());
		confirmPassField.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		confirmPasswordPanel.add(confirmPassLabel);
		confirmPasswordPanel.add(confirmPassField);
		
		//JPanel bufferPanel = new JPanel(new FlowLayout());
		JPanel bufferPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(bufferPanel, BoxLayout.Y_AXIS);
		bufferPanel.setLayout(boxlayout);
		bufferPanel.add(userNamePanel);
		bufferPanel.add(Box.createVerticalStrut(10));
		bufferPanel.add(passwordPanel);
		bufferPanel.add(Box.createVerticalStrut(10));
		bufferPanel.add(confirmPasswordPanel);
		
		//button Panel
		JButton addUserButton = new JButton("Add User");
		addUserButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
					if(userName.getText().equals("") == false)
					{
						String originalPassword = "";
						String originalConfirmPassword = "";
						for(char a : passField.getPassword())
						{
							originalPassword+=a;
						}
						
						for(char a : confirmPassField.getPassword())
						{
							originalConfirmPassword+=a;
						}
						System.out.println(originalConfirmPassword + " "+ originalPassword);
						if (originalPassword.equals(originalConfirmPassword))
						{
							PasswordEncryptionService encService = PasswordEncryptionService.getInstance();
							
							UserCRUD.addUser(userName.getText(), encService.encrypt(originalPassword));
							JOptionPane.showMessageDialog(cont,"user added","Inane error",JOptionPane.PLAIN_MESSAGE);
							JOptionPane.showMessageDialog(cont,"thanks","Inane error",JOptionPane.PLAIN_MESSAGE);
						}
						else
						{
							JOptionPane.showMessageDialog(cont,"password and confirm password don't match","Inane error",JOptionPane.ERROR_MESSAGE);
						}
					}
					else
					{
						JOptionPane.showMessageDialog(cont,"Empty User Name","Inane error",JOptionPane.ERROR_MESSAGE);
					}
			}
		});
		
		addUserPanel.add(Box.createVerticalStrut(30));
		addUserPanel.add(bufferPanel);
		addUserPanel.add(addUserButton);
		addUserPanel.add(Box.createVerticalStrut(10));
		
		cont.getContentPane().removeAll();
		cont.getContentPane().add(addUserPanel);
		cont.revalidate();
		cont.pack();

	}
}
