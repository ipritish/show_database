package main.java.com.datashow.datamodel;

import java.util.Vector;

import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends DefaultTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1758711250154255480L;
	
	public CustomTableModel(Vector dataVector, Vector columVector)
	{
		super(dataVector,columVector);
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
