package model;

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
	

	public Activity() {
		
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

}
