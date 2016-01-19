package main.java.com.datashow.ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class AddUserUI {

	JPanel addUserPanel;
	
	public JPanel getAddUserUI()
	{
		//JButton button = new JButton("test");
		addUserPanel = new JPanel();
		//addUserPanel.add(button);
		//layout added
		BoxLayout addUserLayout = new BoxLayout(addUserPanel, BoxLayout.Y_AXIS);
		addUserPanel.setLayout(addUserLayout);
		
		//user name panel
		JPanel userNamePanel = new JPanel();
		userNamePanel.setLayout(new BoxLayout(userNamePanel, BoxLayout.X_AXIS));
		JLabel userLabel = new JLabel("User Name: ",JLabel.RIGHT);
		userLabel.setPreferredSize(new Dimension(120, 32));
		JTextField userName = new JTextField(20);
		userName.setMaximumSize(userName.getPreferredSize());
		userName.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		userNamePanel.add(userLabel);
		userNamePanel.add(userName);
				
		//password panel
		JPanel passwordPanel = new JPanel();
		passwordPanel.setLayout(new BoxLayout(passwordPanel, BoxLayout.X_AXIS));
		JLabel passLabel = new JLabel("Password: ",JLabel.RIGHT);
		passLabel.setPreferredSize(new Dimension(120, 32));
		JPasswordField passField = new JPasswordField(20);
		passField.setMaximumSize(passField.getPreferredSize());
		passField.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		passwordPanel.add(passLabel);
		passwordPanel.add(passField);
		
		//confirm password panel
		JPanel confirmPasswordPanel = new JPanel();
		confirmPasswordPanel.setLayout(new BoxLayout(confirmPasswordPanel, BoxLayout.X_AXIS));
		JLabel confirmPassLabel = new JLabel("Confirm Password: ",JLabel.RIGHT);
		confirmPassLabel.setPreferredSize(new Dimension(120, 32));		
		JPasswordField confirmPassField = new JPasswordField(20);
		confirmPassField.setMaximumSize(confirmPassField.getPreferredSize());
		confirmPassField.setAlignmentX(JPanel.RIGHT_ALIGNMENT);
		confirmPasswordPanel.add(confirmPassLabel);
		confirmPasswordPanel.add(confirmPassField);
		
		//JPanel bufferPanel = new JPanel(new FlowLayout());
		JPanel bufferPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(bufferPanel, BoxLayout.Y_AXIS);
		bufferPanel.setLayout(boxlayout);
		bufferPanel.add(userNamePanel);
		bufferPanel.add(passwordPanel);
		bufferPanel.add(confirmPasswordPanel);
		
		//button Panel
		JButton addUserButton = new JButton("Add User");
		addUserButton.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
					//TODO perform add used in database
			}
		});
		
		addUserPanel.add(Box.createVerticalStrut(10));
		addUserPanel.add(bufferPanel);
		addUserPanel.add(addUserButton);
		addUserPanel.add(Box.createVerticalStrut(10));
		return addUserPanel;
	}
}
