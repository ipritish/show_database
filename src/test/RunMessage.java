package test;

import javax.swing.JOptionPane;

public class RunMessage implements Runnable{

	@Override
	public void run() {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null,"Successful","Success",JOptionPane.PLAIN_MESSAGE);
		
	}

}
