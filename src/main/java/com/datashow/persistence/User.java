package main.java.com.datashow.persistence;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;  
  
@Entity(name="user")  
public class User 
{  
	@Id  
	private int Id;  
	@Column(name="username")  
	private String userName;
	@Column(name="password")
	private String password;
 
	public int getUserId() 
	{  
		return Id;  
	}
	
	public void setUserId(int userId) 
	{  
		this.Id = userId;  
	}
	
	public String getUserName() 
	{  
		return userName;  
	}
	
	public void setUserName(String userName) 
	{  
		this.userName = userName;  
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
    
}