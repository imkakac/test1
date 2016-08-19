//package Ran Cheng;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadZebrisXML {

//  public static void main(File argv) {
  public static void main(String [] argv) {
    try {

//	File fXmlFile = new File("C:\\Users\\z00323\\workspace\\ZebrisXMLProcessor\\sample data\\SampleTest.xml");
//    File fXmlFile = new File("C:\\Users\\z00323\\workspace\\ZebrisXMLProcessor\\sample data\\treadmill_export_sample_commented_140205.xml");
    File fXmlFile = new File("C:\\Users\\z00323\\workspace\\ZebrisXMLProcessor\\sample data\\K710H_K710H__me-2015-08-27-16-00_Gait Analysis FDM-TGait Analysis.xml");
//    	File fXmlFile = argv;
    	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    	Document doc = dBuilder.parse(fXmlFile);

	//optional, but recommended
	//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
    	doc.getDocumentElement().normalize();

    	System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
	
//	String firstName = doc.getDocumentElement().normalize();

    	System.out.println("----------------------------");
//	get patient info
    	NodeList nList = doc.getElementsByTagName("patient");
    	int listLength = nList.getLength();
    	System.out.println("\nlistLength = " + listLength);
    	for (int temp = 0; temp < nList.getLength(); temp++) {

    		Node nNode = nList.item(temp);

//    		System.out.println("Current Element :" + nNode.getNodeName());
		
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
    			System.out.println("First Name : " + eElement.getElementsByTagName("first_name").item(0).getTextContent());
    			System.out.println("Last Name : " + eElement.getElementsByTagName("last_name").item(0).getTextContent());
//    			System.out.println("Date of Birth : " + eElement.getElementsByTagName("born").item(0).getTextContent());
    			System.out.println("Sex : " + eElement.getElementsByTagName("sex").item(0).getTextContent());
			
    			}
    		}
	
    	nList = doc.getElementsByTagName("cells");
	
    	listLength = nList.getLength();
    	System.out.println("\nlistLength = " + listLength);
    	for (int temp = 0; temp < nList.getLength(); temp++) {

    		Node nNode = nList.item(temp);
//    		System.out.println("Current Element :" + nNode.getNodeName());
		
    		if (nNode.getNodeType() == Node.ELEMENT_NODE) {

    			Element eElement = (Element) nNode;
//    			System.out.println("Cells : " + nNode.getTextContent());
			
    			}
    		}
	
    	nList = doc.getElementsByTagName("event");
    	listLength = nList.getLength();
    	System.out.println("\nEventnumber = " + listLength);
    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
  }

}