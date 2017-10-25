package people;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import model.People;

@XmlRootElement(name="people")
@XmlAccessorType(XmlAccessType.FIELD)

public class PeopleAnnotation {
	
	@XmlElement(name="person")
	private List<People> data = new ArrayList<People>();

	public PeopleAnnotation() {
		
	}
	
	public List<People> getData() {
		return data;
	}

	public void setData(List<People> data) {
		this.data = data;
	}

	
	

}
