package main.java.com.datashow.datamodel;

import java.util.ArrayList;
import java.util.Vector;

import main.java.com.datashow.persistence.Anime;
import main.java.com.datashow.persistence.Show;

public class ShowData {
	
	
	private static ArrayList<Show> showData = new ArrayList<Show>();
 
	public static ArrayList<Show> getShowData() {
		return showData;
	}

	public static void setShowData(ArrayList<Show> showData) {
		ShowData.showData = showData;
	}
	
	public static Vector<Vector<Object>> getVectorFromListData()
	{
		Vector<Vector<Object>> tableData = new Vector<Vector<Object>>();
		for (Show singleShow : getShowData())
		{
			Vector<Object> singleRow = new Vector<Object>();
			singleRow.addElement(singleShow.getShowName());
			singleRow.addElement(singleShow.getRating());
			singleRow.addElement(singleShow.getSeason());
			singleRow.addElement(singleShow.isAiring());
			singleRow.addElement(singleShow.getAirDay());
			
			tableData.addElement(singleRow);
		}
		
		return tableData;
	}


}
