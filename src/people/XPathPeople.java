package people;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XPathPeople {
	Document doc;
	XPath xpath;

	public void loadXML() throws ParserConfigurationException, SAXException, IOException {

		DocumentBuilderFactory domFactory = DocumentBuilderFactory.newInstance();
		domFactory.setNamespaceAware(true);
		DocumentBuilder builder = domFactory.newDocumentBuilder();
		doc = builder.parse("people.xml");

		// creating xpath object
		getXPathObj();
	}

	
	public XPath getXPathObj() {

		XPathFactory factory = XPathFactory.newInstance();
		xpath = factory.newXPath();
		return xpath;
	}

	/**
	 * 
	 * @param personId
	 * @return node of the description of the preferred activity
	 * @throws XPathExpressionException
	 */
	public Node getActivityDescription(Integer personId) throws XPathExpressionException {

		XPathExpression expr = xpath.compile("/people/person[@id=" + personId + "]/activitypreference/description");
		Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		return node;
	}

	/**
	 * the function uses the id passed as parameter to look for the place of the activity 
	 * belonging to the person with the id passed
	 *
	 * @param personId
	 * @return node of the place of the preferred activity
	 * @throws XPathExpressionException
	 */
	public Node getActivityPlace(Integer personId) throws XPathExpressionException {

		XPathExpression expr = xpath.compile("/people/person[@id=" + personId + "]/activitypreference/place");
		Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		return node;
	}

	/**
	 * prints all persons in the xml file
	 *
	 * @throws XPathExpressionException
	 */
	
	public  void getPeople() throws XPathExpressionException {

		
		NodeList persons = (NodeList) xpath.evaluate("//people/person", doc, XPathConstants.NODESET);
		//loop throu the person nodes to print them
		for (int i = 0; i < persons.getLength(); i++) {
		      Node person = (Node) persons.item(i);
		      String personId = xpath.evaluate("@id", person);
		      String personFirstname = xpath.evaluate("firstname", person);
		      String personLastname = xpath.evaluate("lastname", person);
		      String personBirthday = xpath.evaluate("birthdate", person);
		      System.out.println("ID: " + personId + "\n" + personFirstname + " " + personLastname + " - " + personBirthday);
		    	  String activityId = xpath.evaluate("activitypreference/@id", person);
		    	  String activityName = xpath.evaluate("activitypreference/name", person);
		    	  String activityDes = xpath.evaluate("activitypreference/description", person);
		    	  String activityPlace = xpath.evaluate("activitypreference/place", person);
		    	  String activityStartdate = xpath.evaluate("activitypreference/startdate", person);
		    	  System.out.println("Activity " + activityId + ": " + activityName + " (" + activityDes + ") in " + activityPlace + " - " + activityStartdate + "\n");
		    	  
		}
	}
	
	/**
	 * the function gets all startdates and parses them as date type to compare them with the date passed as parameter.
	 * it prints the nodes which satisfy the condition passed as parameter 
	 *
	 * @param date
	 * @param condition
	 * @throws XPathExpressionException
	 * @throws DOMException
	 * @throws ParseException
	 */
	
	public void getActivityByStartdate(String date, String condition) throws XPathExpressionException, DOMException, ParseException {
		
		XPathExpression expr = xpath.compile("/people/person/activitypreference/startdate");
		NodeList nodes = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
		//System.out.println(nodes.getLength());

		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd"); //format of date from xml

		for (int i = 0; i < nodes.getLength(); i++) {
		  Node startdateNode = nodes.item(i);
		  Date startdate = df.parse(startdateNode.getTextContent());
		  Date myDate = df.parse(date);
		 
		  //checks if the condition passed are true 
		  if (myDate.before(startdate) && condition.equals(">")) {
		    Node personNode = startdateNode.getParentNode().getParentNode(); //Get "person" node
		    System.out.println(personNode.getTextContent()); //prints persons who passes conditions
		  } else if (myDate.after(startdate) && condition.equals("<")) {
			  Node personNode = startdateNode.getParentNode().getParentNode(); //Get "person" node
			  System.out.println(personNode.getTextContent()); //prints persons who passes conditions
		  }	else if (myDate.equals(startdate) && condition.equals("=")) {
			  Node personNode = startdateNode.getParentNode().getParentNode(); //Get "person" node
			  System.out.println(personNode.getTextContent()); //prints persons who passes conditions
		  }
		}
		
		
	}
	
	/**
	 * the function uses the id passed as parameter to look for the preferred activity 
	 * belonging to the person with the id passed
	 * @param personId
	 * @return node with the preferred activity 
	 * @throws XPathExpressionException
	 */
	public Node getActivityPreference(Integer personId) throws XPathExpressionException {
		
		XPathExpression expr = xpath.compile("/people/person[@id=" + personId + "]/activitypreference");
		Node node = (Node) expr.evaluate(doc, XPathConstants.NODE);
		return node;
	}

	public static void main(String[] args)
			throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, DOMException, ParseException {

		XPathPeople test = new XPathPeople();
		test.loadXML();
		
		System.out.println("Printing list of all persons");
		test.getPeople();	
		
		System.out.println("\n Printing the preferred activity of person with id 5");
		Node node = test.getActivityPreference(5);
		System.out.println(node.getTextContent());
		
		System.out.println("\n Printing persons which satisfy the condition startdate>2017-10-13");
		test.getActivityByStartdate("2017-10-13", ">");
	
		
		
		

	}
}

