package main.java.com.datashow.datamodel;

import java.util.Vector;

import javax.swing.JCheckBox;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

public class CustomTableModel extends AbstractTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1758711250154255480L;
	
	private Vector<Vector<Object>> dataVector;
	private Vector<String> columVector;
	
	public CustomTableModel(Vector<Vector<Object>> data, Vector<String> column)
	{
		dataVector = data;
		columVector = column;
		//fireTableStructureChanged();
	}

	public CustomTableModel() 
	{
		dataVector = new Vector<Vector<Object>>();
		columVector = new Vector<String>();
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataVector.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columVector.size();
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) 
	{
		// TODO Auto-generated method stub
		return dataVector.get(rowIndex).get(columnIndex);
	}
	
	@Override
	public String getColumnName(int column) 
	{
		  return columVector.get(column);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public Class getColumnClass(int c) 
	{
	      return getValueAt(0, c).getClass();
	}
	
	public void setTableData(Vector<Vector<Object>> data, Vector<String> column)
	{
		columVector = column;
		dataVector = data;
		fireTableStructureChanged();
	}
	

}
