package people;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import people.generated.*;

public class JAXBMarsh {
		
	public void generateXMLDocument(File xmlDocument) {
		
		PeopleAnnotation people =new PeopleAnnotation();
		PeopleDB.initializeDB(people);
		try {

			JAXBContext jaxbContext = JAXBContext.newInstance(PeopleAnnotation.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output", new Boolean(true));
			
			
			

		
			marshaller.marshal(people, new FileOutputStream(xmlDocument));
			marshaller.marshal(people, System.out);

		} catch (IOException e) {
			System.out.println(e.toString());

		} catch (JAXBException e) {
			System.out.println(e.toString());

		}

	}

	public static void main(String[] argv) {
		String xmlDocument = "NewPeople.xml";
		JAXBMarsh jaxbMarshaller = new JAXBMarsh();
		jaxbMarshaller.generateXMLDocument(new File(xmlDocument));
	}
}