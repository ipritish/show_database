package main.java.com.datashow.persistence;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id; 

@Entity(name="shows")
public class Show {
	
	@Id
	int Id;
	@Column(name="show_Name")
	String showName;
	@Column(name="rating")
	double rating;

}
