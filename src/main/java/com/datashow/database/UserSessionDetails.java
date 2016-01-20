package main.java.com.datashow.database;

public class UserSessionDetails {
	
	private static boolean userLoggedIn = false;
	
	private static String userNameLoggedIn = "";
	
	public static boolean isUserLoggedIn() 
	{
		return userLoggedIn;
	}

	public static void setUserLoggedIn(boolean userLoggedIn) 
	{
		UserSessionDetails.userLoggedIn = userLoggedIn;
	}

	public static String getUserNameLoggedIn() 
	{
		return userNameLoggedIn;
	}
	
	public static void setUserNameLoggedIn(String userNameLoggedIn) 
	{
		UserSessionDetails.userNameLoggedIn = userNameLoggedIn;
	}
	

}
