package main.java.com.datashow.ui;

import javax.swing.JFrame;

import main.java.com.datashow.database.UserSessionDetails;

public class StarterUI {
	
	//private static final Logger logger = Logger.getLogger(AppStarter.class);
	
	JFrame mainFrame = new JFrame("Shows and Anime");
	public void showGui()
	{
		//write logic here if want to skip login in some cases
		UserSessionDetails.setUserLoggedIn(true);
		UserSessionDetails.setUserNameLoggedIn("pritish");
		if (UserSessionDetails.isUserLoggedIn())
		{
			new LandingPageUI().showGui(mainFrame);
		}
		else
		{
			new LoginUI().getLoginPanel(mainFrame);
		}
		mainFrame.setVisible(true);
		mainFrame.setLocation(40, 40);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dataBaseOperate();
	}


}
