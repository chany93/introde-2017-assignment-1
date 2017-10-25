package dao;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import model.People;

@XmlRootElement(name="people")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeopleStore {
	@XmlElementWrapper(name="peopleList")
	@XmlElement(name="person")
	private List<People> data = new ArrayList<People>();
	
	public PeopleStore () {
	}

	public List<People> getData() {
		return data;
	}

	public void setData(List<People> data) {
		this.data = data;
	}
}
