package main.java.com.datashow.ui;

import javax.swing.SwingUtilities;

public class AppStarter {
	
	
	public static void main(String[] args) {
		//System.out.println(getLocalCurrentDate());
		
		//Thread t = new Thread(new RunMessage());
		//t.setDaemon(true);
		//t.start();
		
		SwingUtilities.invokeLater(new Runnable() {
            public void run() 
            {            	
            	//Thread t = new Thread(new RunMessage());
            	//t.start();
                System.out.println("Task scheduled.");
                System.out.println(SwingUtilities.isEventDispatchThread());
            	StarterUI start = new StarterUI();
        		start.showGui();
        		//while (t.isAlive());
            }
        });
		
		//while(t.isAlive());
		
		//System.exit(0);
	}
}
