package main.java.com.datashow.ui;

import javax.swing.JFrame;

public class StarterUI {
	
	//private static final Logger logger = Logger.getLogger(AppStarter.class);
	
	JFrame mainFrame = new JFrame("Shows and Anime");
	public void showGui()
	{
		//write logic here if want to skip login in some cases
		new LoginUI().getLoginPanel(mainFrame);
		mainFrame.setVisible(true);
		mainFrame.setLocation(40, 40);
		mainFrame.pack();
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//dataBaseOperate();
	}


}
