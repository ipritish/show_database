package main.java.com.datashow.ui;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class LoginUI 
{

	JPanel loginPanel;
	
	public JPanel getLoginPanel()
	{
		loginPanel = new JPanel(new BorderLayout());
		loginPanel.setSize(300, 400);
		
		//user name panel
		JPanel userNamePanel = new JPanel(new BorderLayout());
		JLabel userLabel = new JLabel("User Name");
		JTextField userName = new JTextField(20);
		userNamePanel.add(userLabel, BorderLayout.WEST);
		userNamePanel.add(new JPanel(),BorderLayout.CENTER);
		userNamePanel.add(userName,BorderLayout.EAST);
		
		//password panel
		JPanel passwordPanel = new JPanel(new BorderLayout());
		JLabel passLabel = new JLabel("Password");
		JPasswordField passField = new JPasswordField(20);
		passField.setSize(50, 20);
		passwordPanel.add(passLabel, BorderLayout.WEST);
		passwordPanel.add(new JPanel(),BorderLayout.CENTER);
		passwordPanel.add(passField,BorderLayout.EAST);
		
		loginPanel.add(userNamePanel,BorderLayout.NORTH);
		loginPanel.add(passwordPanel,BorderLayout.SOUTH);
		return loginPanel;
	}

}
