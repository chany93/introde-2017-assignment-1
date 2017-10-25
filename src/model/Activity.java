package model;

import java.util.Calendar;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "name", "description", "place", "startDate" })

public class Activity {
	
	@XmlAttribute(name="id")
	private int activityId;
	
	private String name;
	private String description;
	private String place;
	private String startDate;
	

	public Activity(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Activity() {
		this.activityId = 1;
		this.name = "Noname this time";
		this.description = "busy doing my favourite activity";
		this.setPlace("on the Earth");
		this.startDate = this.getRandomDate();
	}
	
	public Activity(int id, String name, String description, String place, String startDate) {
		super();
		this.activityId = id;
		this.name = name;
		this.description = description;
		this.place = place;
		this.startDate = startDate;
	}
	
	public long getActivityId() {
		return activityId;
	}

	public void setActivityId(int id) {
		this.activityId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	private String getRandomDate() {
		int currentYear = Calendar.getInstance().get(Calendar.YEAR); 		// 1. get the current year
		int year = (int) Math.round(Math.random()*(currentYear-1950)+1950); // 2. generate a random year 
																			//    between 1950 and currentYear
		int month = (int) Math.round(Math.floor(Math.random()*11)+1);		// 3. select a random month of the year
		// 4. select a random day in the selected month
		// 4.1 prepare a months array to store how many days in each month
		int[] months = new int[]{31,28,30,30,31,30,31,31,30,31,30,31};
		// 4.2 if it is a leap year, feb (months[1]) should be 29
		if ((currentYear % 4 == 0) && ((currentYear % 100 != 0) || (currentYear % 400 == 0))) {
			months[1] = 29;
		}
		long day = Math.round(Math.floor(Math.random()*(months[month-1]-1)+1));
		return ""+year+"-"+month+"-"+day;
	}

	// Modify to String to add the missing attributes.
	public String toString() {
		return "Name="+name+", Description="+description + "Place="+place+"StartDate="+startDate;
	}




}