package people;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.ValidationEvent;
import javax.xml.bind.ValidationEventHandler;
import javax.xml.bind.ValidationEventLocator;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;


import people.generated.*;



public class JAXBUnmarsh {

	public void unMarshall(File xmlDocument) {
		
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance("people.generated");

			Unmarshaller unMarshaller = jaxbContext.createUnmarshaller();
			SchemaFactory schemaFactory = SchemaFactory
					.newInstance("http://www.w3.org/2001/XMLSchema");
			Schema schema = schemaFactory.newSchema(new File(
					"people.xsd"));
			unMarshaller.setSchema(schema);
			CustomValidationEventHandler validationEventHandler = new CustomValidationEventHandler();
			unMarshaller.setEventHandler(validationEventHandler);

			@SuppressWarnings("unchecked")
			//get the jaxbelement from people.xml
			JAXBElement<PeopleType> peopleElement = (JAXBElement<PeopleType>) unMarshaller
					.unmarshal(xmlDocument);
			
			//get value "people" from the element
			PeopleType people = peopleElement.getValue();
			
			//instantiates personlist from people method "getPerson()"
			List<PersonType> personList = people.getPerson();
			
			//loop all persons and print them
			for (int i = 0; i < personList.size(); i++) {

				PersonType person = (PersonType) personList.get(i);
				
				System.out.println("Person " + person.getId());
				System.out.println("Firstname: "+ person.getFirstname());
				System.out.println("Lastname: "+ person.getLastname());
				System.out.println("Birthdate: "+ person.getBirthdate());
			
				
				ActivityType activity = person.getActivitypreference();

				System.out.println("Activity " + activity.getId()) ;
				System.out.println("Name: "+ activity.getName() + " Description: " + activity.getDescription() + " Place: " + activity.getPlace() + " Start Date: " + activity.getStartdate() + "\n");
			

				
			}
		} catch (JAXBException e) {
			System.out.println(e.toString());
		} catch (SAXException e) {
			System.out.println(e.toString());
		}
	}

	public static void main(String[] argv) {
		File xmlDocument = new File("people.xml");
		JAXBUnmarsh jaxbUnmarshaller = new JAXBUnmarsh();

		jaxbUnmarshaller.unMarshall(xmlDocument);

	}

	class CustomValidationEventHandler implements ValidationEventHandler {
		public boolean handleEvent(ValidationEvent event) {
			if (event.getSeverity() == ValidationEvent.WARNING) {
				return true;
			}
			if ((event.getSeverity() == ValidationEvent.ERROR)
					|| (event.getSeverity() == ValidationEvent.FATAL_ERROR)) {

				System.out.println("Validation Error:" + event.getMessage());

				ValidationEventLocator locator = event.getLocator();
				System.out.println("at line number:" + locator.getLineNumber());
				System.out.println("Unmarshalling Terminated");
				return false;
			}
			return true;
		}

	}
}
