package com.datashow.ui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuChangeListener implements ChangeListener {
	
	JMenu actionMenubar;

	public MenuChangeListener(JMenu menubar) {
		actionMenubar = menubar;
	}

	public void stateChanged(ChangeEvent e) {
		//actionMenubar.se
		//System.out.println("changed");
		actionMenubar.setText("test");

	}

}
