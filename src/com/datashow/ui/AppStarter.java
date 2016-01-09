package com.datashow.ui;

import javax.swing.JFrame;

import org.apache.log4j.Logger;

public class AppStarter {
	
	private static final Logger logger = Logger.getLogger(AppStarter.class);
	
	JFrame mainFrame = new JFrame("Shows and Anime");

	public static void main(String[] args) {
		System.out.println(getLocalCurrentDate());
	}

	private static String getLocalCurrentDate() {

		if (logger.isDebugEnabled()) {
			logger.debug("getLocalCurrentDate() is executed!");
		}

		return "today's date";

	}

}
