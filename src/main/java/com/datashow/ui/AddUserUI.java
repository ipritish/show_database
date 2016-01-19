package main.java.com.datashow.ui;

import javax.swing.JButton;
import javax.swing.JPanel;

public class AddUserUI {

	JPanel addUserPanel;
	
	public JPanel getAddUserUI()
	{
		JButton button = new JButton("test");
		addUserPanel = new JPanel();
		addUserPanel.add(button);
		return addUserPanel;
	}
}
