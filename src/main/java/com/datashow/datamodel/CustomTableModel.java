package main.java.com.datashow.datamodel;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import main.java.com.datashow.constants.TableHeaders;
import main.java.com.datashow.database.AnimeCRUD;
import main.java.com.datashow.database.ShowCRUD;
import main.java.com.datashow.database.UserSessionDetails;
import main.java.com.datashow.persistence.Anime;
import main.java.com.datashow.persistence.Show;

public class CustomTableModel extends AbstractTableModel
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1758711250154255480L;
	
	private Vector<Vector<Object>> dataVector;
	private Vector<String> columVector;
	private String dataType;
	private JFrame mainFrame;
	
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
	
	public void setFrame(JFrame frame)
	{
		mainFrame = frame;
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
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
	
	@Override
	public boolean isCellEditable(int row, int col)
	{ 
		return true;
	}
	
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex)
	{
		Vector<Object> temp = dataVector.get(rowIndex);
		
		//this to facilitate visual of immediate change
		if (value instanceof Boolean)
		{
			dataVector.get(rowIndex).set(columnIndex, (Boolean)value);
		}
		else if (value instanceof Double)
		{
			dataVector.get(rowIndex).set(columnIndex, (Double) value);
		}
		else if (value instanceof Integer)
		{
			dataVector.get(rowIndex).set(columnIndex, (Integer) value);
		}
		else
		{
			dataVector.get(rowIndex).set(columnIndex, (String) value);
		}
		
		//check type of data
		if (getDataType().equals(TableHeaders.TYPE_ANIME))
		{
			Anime anime = AnimeData.getAnimeData().get(rowIndex);
			anime.setAnimeName((String)temp.get(0));
			anime.setRating((Double)temp.get(1));
			anime.setSeason((Integer)temp.get(2));
			anime.setAiring((Boolean)temp.get(3));
			anime.setAirDay((String)temp.get(4));
			AnimeCRUD.updateAnimeEntry(anime);
			//AnimeData.setAnimeData(AnimeCRUD.getAllAnimes());
				
		}
		if (getDataType().equals(TableHeaders.TYPE_SHOW))
		{
			Show show = ShowData.getShowData().get(rowIndex);
			show.setShowName((String)temp.get(0));
			show.setRating((Double)temp.get(1));
			show.setSeason((Integer)temp.get(2));
			show.setAiring((Boolean)temp.get(3));
			show.setAirDay((String)temp.get(4));
			ShowCRUD.updateShowEntry(show);
			//ShowData.setShowData(ShowCRUD.getAllShows());
		}
		
		fireTableDataChanged();
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	

}
