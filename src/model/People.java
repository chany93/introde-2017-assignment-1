package model;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

// XmlRootElement defines the root element of the XML tree to which this class will be serialized
// --> <person> ... </person> 
@XmlRootElement(name = "person")	
// XmlType can optionally define the order in which the fields of person are written
@XmlType(propOrder = { "firstname", "lastname", "birthdate", "pActivity" })
// XmlAccessorType indicates what to use to create the mapping: either FIELDS, PROPERTIES (i.e., getters/setters), PUBLIC_MEMBER or NONE (which means, you should indicate manually)
@XmlAccessorType(XmlAccessType.FIELD)
public class People {
	private String firstname;		
	private String lastname;		
	// XmlElement indicates the element to use for this field. Only used if the name in XML will be different than that in the class
	@XmlElement(name="activitypreference")
	private Activity pActivity;	
	private String birthdate;
	// XmlAttribute indicates that this field will be serialized as an attribute
	@XmlAttribute(name="id")
	private Long personId;
	

	public People() {

	}
	
	public People(Long personId, String fname, String lname, String birthdate, Activity pa) {
		this.setPersonId(personId); 	
		this.setFirstname(fname);
		this.setLastname(lname);
		this.setBirthdate(birthdate); 	
		this.pActivity=pa;
	}
	

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Activity getAProfile() {
		return pActivity;
	}
	public void setAProfile(Activity aProfile) {
		this.pActivity = aProfile;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public Long getPersonId() {
		return personId;
	}
	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	
}
