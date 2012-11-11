package com.gesoftware.familyweighttracker.data;

import java.text.SimpleDateFormat;

public class Weight {
	
	private long id;
	private long personId;
	private double weight;
	private long dateTime;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public long getPersonId() {
		return personId;
	}
	
	public void setPersonId(long personId) {
		this.personId = personId;
	}
	
	public double getWeight() {
		return weight;
	}
	
	public void setWeight(double weight) {
		this.weight = weight;
	}
	
	public String getDate() {
		return new SimpleDateFormat("dd-MMM-yy HH:mm:ss").format(dateTime);
	}
	
	public long getDateAsLong() {
		return this.dateTime;
	}
	
	public void setDate(long dateTimeMilli) {
		this.dateTime = dateTimeMilli;
	}

	// Will be used by the ArrayAdapter in the ListView
	@Override
	public String toString() {
		return Double.toString(weight);
	}
}
