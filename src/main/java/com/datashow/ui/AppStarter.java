package main.java.com.datashow.ui;

import java.lang.reflect.InvocationTargetException;

import javax.swing.SwingUtilities;

import test.RunMessage;

public class AppStarter {
	
	
	public static void main(String[] args) {
		//System.out.println(getLocalCurrentDate());
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() 
            {            	
                System.out.println("Task scheduled.");
            	StarterUI start = new StarterUI();
        		start.showGui();
            }
        });
	}
}
