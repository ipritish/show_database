package main.java.com.datashow.ui;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginUI 
{

	JPanel loginPanel;
	
	public JPanel getLoginPanel()
	{
		loginPanel = new JPanel();
		loginPanel.setSize(300, 400);
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		
		//user name panel
		JPanel userNamePanel = new JPanel();
		JLabel userLabel = new JLabel("User Name");
		JTextField userName = new JTextField(20);
		userNamePanel.add(userLabel);
		userNamePanel.add(new JPanel());
		userNamePanel.add(userName);
		
		//password panel
		JPanel passwordPanel = new JPanel();
		JLabel passLabel = new JLabel("Password");
		JPasswordField passField = new JPasswordField(20);
		passwordPanel.add(passLabel);
		passwordPanel.add(new JPanel());
		passwordPanel.add(passField);
		
		//JPanel bufferPanel = new JPanel(new FlowLayout());
		loginPanel.add(new JPanel());
		loginPanel.add(new JLabel("Login Credentials"));
		loginPanel.add(userNamePanel);
		loginPanel.add(passwordPanel);
		
		//loginPanel.add(bufferPanel);
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(new JButton("Login"));
		loginPanel.add(buttonPanel);
		return loginPanel;
	}

}
