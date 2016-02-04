package main.java.com.datashow.datamodel;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import main.java.com.datashow.database.PasswordEncryptionService;
import main.java.com.datashow.database.UserCRUD;
import main.java.com.datashow.database.UserSessionDetails;
import main.java.com.datashow.exceptions.UserNotFoundException;
import main.java.com.datashow.persistence.User;

public class LoginHandler {
	
	private static boolean userExist;
	
	public static boolean checkCredentials(String userName , String password, JFrame cont)
	{
		setUserExist(false);
		//check credentials
		
		if (userName.equals("") == false)
		{

			if (password.equals("") == false)
			{
				try
				{
					User user = UserCRUD.getUser(userName);
					if (user != null)
					{
						if (user.getPassword().equals(PasswordEncryptionService.getInstance().encrypt(password)))
				        {
				        	JOptionPane.showMessageDialog(cont,"login successful","Success",JOptionPane.PLAIN_MESSAGE);
				        	UserSessionDetails.setUserNameLoggedIn(user.getUserName());
				        	UserSessionDetails.setUserLoggedIn(true);
				        	setUserExist(true);

				        }
				        else
				        {
				        	JOptionPane.showMessageDialog(cont,"Invalid Login credentials","Error",JOptionPane.ERROR_MESSAGE);
				        }
					}
					else
					{
						JOptionPane.showMessageDialog(cont,"user not found","Error",JOptionPane.ERROR_MESSAGE);
					}
				}
				catch (UserNotFoundException une)
				{
					JOptionPane.showMessageDialog(cont,"user not found","Error",JOptionPane.ERROR_MESSAGE);
				}
			}
			else
			{
				JOptionPane.showMessageDialog(cont,"Password Empty","Error",JOptionPane.ERROR_MESSAGE);
			}
		}
		else
		{
			JOptionPane.showMessageDialog(cont,"User Name Empty","Error",JOptionPane.ERROR_MESSAGE);
		}
		return doesUserExist();
	}

	public static boolean doesUserExist() {
		return userExist;
	}

	public static void setUserExist(boolean userExist) {
		LoginHandler.userExist = userExist;
	}

}
