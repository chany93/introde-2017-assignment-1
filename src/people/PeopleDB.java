package people;



import model.Activity;
import model.People;



public class PeopleDB {

	
	public static void initializeDB(PeopleAnnotation people) {
	

			People person = new People(new Long(1), "Bond", "Martin", "1984-09-20", new Activity(100, "Running", "Running to the Park", "Gocciadoro", "2017-10-13"));
			people.getData().add(person);
			person = new People(new Long(2), "Mario", "Rossi", "1991-10-05", new Activity(101, "Swimming", "Swimming in the pool", "Gardolo", "2017-10-23"));
			people.getData().add(person);
			person = new People(new Long(3), "Damiano", "Bianchi", "1979-03-27", new Activity(102, "Trekking", "Trekking on the mountains", "Bondone", "2015-05-12"));
			people.getData().add(person);

		}
	}

