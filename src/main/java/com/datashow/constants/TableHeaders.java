package main.java.com.datashow.constants;

public class TableHeaders {
	
	public static final String[] showcolumnNames = {"Show Name",
            "IMDB Rating",
            "Current Season",
            "Is Airing",
            "Air Day"};	
	
	public static final String[] animeColumnNames = {"Anime Name",
        "MAL Rating",
        "Current Season",
        "Is Airing",
        "Air Day"};	
	
	public static Object[][] placeHoderShowData = {
		    {"Unbreakable Kimmi Smicdht", new Double(8.0),
		     new Integer(2), new Boolean(false), "Sunday"},
		     {"Archer", new Double(8.9),
			     new Integer(7), new Boolean(false), "Sunday"}
		};
	
	public static Object[][] placeHoderAnimeData = {
		    {"Naruto", new Double(8.0),
		     new Integer(2), new Boolean(true), "Thursday"}
		};

}
