package people;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.module.jaxb.JaxbAnnotationModule;

import dao.PeopleStore;
import model.Activity;
import model.People;


public class PeopleJSON {
	public static PeopleStore people = new PeopleStore();

	public static void initializeDB() {
		
		//activities to add to the persons
		Activity a1 = new Activity(1, "Knowledge", "Knows nothing", "Westeros", "2016-11-13");
		Activity a2 = new Activity(2, "Killing", "Killing people", "Westeros", "2017-11-11");
		Activity a3 = new Activity(3, "Swimming", "Swimming and winning", "USA", "2017-12-15");
		
		//person to write in json
		People Jon = new People(new Long(1), "Jon", "Snow", "1985-07-26", a1);
		People Arya = new People(new Long(2), "Arya", "Stark", "1984-08-02", a2);
		People Michele = new People(new Long(3), "Michele", "Felpe", "1984-09-20", a3);
		
		//adding the persons to the instance of the annotation
		people.getData().add(Jon);
		people.getData().add(Arya);
		people.getData().add(Michele);
	}	

	public static void main(String[] args) throws Exception {
		
		initializeDB();
		
		// Jackson Object Mapper 
		ObjectMapper mapper = new ObjectMapper();
		
		// Adding the Jackson Module to process JAXB annotations
        JaxbAnnotationModule module = new JaxbAnnotationModule();
        
		// configure as necessary
		mapper.registerModule(module);
		mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        mapper.configure(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS, true);

        String result = mapper.writeValueAsString(people);
        System.out.println(result);
        mapper.writeValue(new File("people.json"), people);
    }
}
