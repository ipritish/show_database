package main.java.com.datashow.datamodel;

public class LoginHandler {
	
	private boolean userExist;
	
	public boolean checkCredentials(String userName , String password)
	{
		setUserExist(false);
		//check credentials
		return isUserExist();
	}

	public boolean isUserExist() {
		return userExist;
	}

	public void setUserExist(boolean userExist) {
		this.userExist = userExist;
	}

}
