package main.java.com.datashow.persistence;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.GeneratedValue;  
import javax.persistence.Id;  
  
@Entity(name="User_table")  
public class User 
{  
	@Id  
	int Id;  
	@Column(name="User_Name")  
	String userName;  
 
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
    
}