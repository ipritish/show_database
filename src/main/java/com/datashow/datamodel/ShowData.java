package main.java.com.datashow.datamodel;

import java.util.ArrayList;
import java.util.Vector;

import main.java.com.datashow.persistence.Show;

public class ShowData {
	
	private static Vector<Vector<Object>> showTableData = new Vector<Vector<Object>>();
	
	private static ArrayList<Show> showData = new ArrayList<Show>();
 
	public static Vector<Vector<Object>> getShowTableData() {
		return showTableData;
	}

	public static void setShowTableData(Vector<Vector<Object>> showData) {
		ShowData.showTableData = showData;
	}

	public static ArrayList<Show> getShowData() {
		return showData;
	}

	public static void setShowData(ArrayList<Show> showData) {
		ShowData.showData = showData;
	}


}
