package main.java.com.datashow.ui;

import javax.swing.SwingUtilities;

public class AppStarter {
	
	
	public static void main(String[] args) {
		//System.out.println(getLocalCurrentDate());
		
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	MainUI start = new MainUI();
        		start.showGui();
            }
        });
	}
}
