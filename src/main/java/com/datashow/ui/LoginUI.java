package main.java.com.datashow.ui;

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

import main.java.com.datashow.database.PasswordEncryptionService;
import main.java.com.datashow.database.UserCRUD;
import main.java.com.datashow.database.UserSessionDetails;
import main.java.com.datashow.datamodel.LoginHandler;
import main.java.com.datashow.exceptions.UserNotFoundException;
import main.java.com.datashow.persistence.User;

public class LoginUI 
{

	JPanel loginPanel;
	
	public void getLoginPanel(final JFrame cont)
	{
		loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.add(Box.createHorizontalStrut(600));
		
		//user name panel
		JPanel userNamePanel = new JPanel();
		JLabel userLabel = new JLabel("User Name");
		final JTextField userName = new JTextField(20);
		//userName.setMaximumSize(new Dimension(80, userName.getPreferredSize().height));
		userNamePanel.add(userLabel);
		userNamePanel.add(userName);
		
		//password panel
		JPanel passwordPanel = new JPanel();
		JLabel passLabel = new JLabel("Password");
		final JPasswordField passField = new JPasswordField(20);
		passwordPanel.add(passLabel);
		passwordPanel.add(passField);
		
		//JPanel bufferPanel = new JPanel(new FlowLayout());
		JPanel bufferPanel = new JPanel();
		BoxLayout boxlayout = new BoxLayout(bufferPanel, BoxLayout.Y_AXIS);
		bufferPanel.setLayout(boxlayout);
		bufferPanel.add(userNamePanel);
		bufferPanel.add(passwordPanel);

		//label panel
		JLabel label = new JLabel("Login Credentials");
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.X_AXIS));
		labelPanel.add(label);
		
		//button Panel
		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				String password = "";
				for (char a : passField.getPassword())
				{
					password+=a;
				}
				if (LoginHandler.checkCredentials(userName.getText(), password,cont));
				{
					if (UserSessionDetails.isUserLoggedIn())
					{
			        	new LandingPageUI().showGui(cont);
					}
				}
			}
		});

		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
		buttonPanel.add(loginButton);

		
		//add to main panel
		loginPanel.add(new JPanel());
		loginPanel.add(labelPanel);
		//loginPanel.add(userNamePanel);
		//loginPanel.add(passwordPanel);
		loginPanel.add(bufferPanel);
		//loginPanel.add(bufferPanel);
		loginPanel.add(buttonPanel);
		loginPanel.add(Box.createVerticalStrut(10));
		
		cont.getContentPane().removeAll();
		cont.getContentPane().add(loginPanel);
		cont.getContentPane().revalidate();
		cont.pack();

	}

}
