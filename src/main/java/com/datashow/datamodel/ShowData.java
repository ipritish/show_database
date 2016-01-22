package main.java.com.datashow.datamodel;

import java.util.Vector;

public class ShowData {
	
	private static Vector<Vector<Object>> showData = new Vector<Vector<Object>>();

	public static Vector<Vector<Object>> getShowData() {
		return showData;
	}

	public static void setShowData(Vector<Vector<Object>> showData) {
		ShowData.showData = showData;
	}


}
