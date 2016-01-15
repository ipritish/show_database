package main.java.com.datashow.persistence;

import javax.persistence.Column;  
import javax.persistence.Entity;  
import javax.persistence.Id;

@Entity(name="anime")
public class Anime 
{
	@Id
	private int Id;
	
	@Column(name="anime_Name")
	private String animeName;
	
	@Column(name="rating")
	private double rating;
	
	@Column(name="season")
	private int season;
	
	@Column(name="OnAir")
	private boolean isAiring;
	
	@Column(name="airDay")
	private String airDay;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getAnimeName() {
		return animeName;
	}

	public void setAnimeName(String animeName) {
		this.animeName = animeName;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public int getSeason() {
		return season;
	}

	public void setSeason(int season) {
		this.season = season;
	}

	public boolean isAiring() {
		return isAiring;
	}

	public void setAiring(boolean isAiring) {
		this.isAiring = isAiring;
	}

	public String getAirDay() {
		return airDay;
	}

	public void setAirDay(String airDay) {
		this.airDay = airDay;
	}

}
