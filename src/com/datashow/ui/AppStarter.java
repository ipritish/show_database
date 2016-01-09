package com.datashow.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

public class AppStarter {
	
	private static final Logger logger = Logger.getLogger(AppStarter.class);
	
	JFrame mainFrame = new JFrame("Shows and Anime");
	
	public void showGui()
	{
		JPanel panel = new JPanel();
		mainFrame.add(panel);
		mainFrame.setVisible(true);
		mainFrame.setLocation(20, 30);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		//System.out.println(getLocalCurrentDate());
		AppStarter start = new AppStarter();
		start.showGui();
	}

	private static String getLocalCurrentDate() {

		if (logger.isDebugEnabled()) {
			logger.debug("getLocalCurrentDate() is executed!");
		}

		return "today's date";

	}

}
