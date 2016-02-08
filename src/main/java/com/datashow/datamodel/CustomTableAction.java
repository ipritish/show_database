package main.java.com.datashow.datamodel;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class CustomTableAction extends AbstractAction{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9113581954388295277L;

	@Override
	public void actionPerformed(ActionEvent e) {
		TableCellListener tcl = (TableCellListener)e.getSource();
        System.out.println("Row   : " + tcl.getRow());
        System.out.println("Column: " + tcl.getColumn());
        System.out.println("Old   : " + tcl.getOldValue());
        System.out.println("New   : " + tcl.getNewValue());
		
	}

}
