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
    	NodeList cellSizeList = doc.getElementsByTagName("cell_size");
    	Element cellSizeElement = (Element)cellSizeList.item(0);
//    	String cellSizeX = cellSize.getFirstChild().getNodeValue();
    	String cellSizeX = cellSizeElement.getElementsByTagName("x").item(0).getFirstChild().getTextContent();
    	float x = Float.parseFloat(cellSizeX);
    	String cellSizeY = cellSizeElement.getElementsByTagName("y").item(0).getFirstChild().getTextContent();
    	float y = Float.parseFloat(cellSizeY);
    	float cellArea = x*y;
    	System.out.println("\nCell Size = " + x + " X " +y);
    	
    	String dateMeasured = doc.getElementsByTagName("measured").item(0).getTextContent();
    	System.out.println("\nDate = " + dateMeasured);    
    	
    	String fileName = doc.getElementsByTagName("description").item(0).getTextContent();
    	System.out.println("\nFileName = " + fileName);    

    	float frequency = Float.parseFloat(doc.getElementsByTagName("frequency").item(0).getTextContent());
    	System.out.println("\nFrequency = " + frequency);
    	
    	String endTime = doc.getElementsByTagName("end").item(doc.getElementsByTagName("end").getLength()-1).getTextContent();
    	int frame = Math.round(Float.parseFloat(endTime)*frequency);
    	System.out.println("\nEndTime = " + (1/frequency*(frame-1)) + " ms");
    	System.out.println("\nFrameNumber = " + frame);
    	
    	
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
	
//    	nList = doc.getElementsByTagName("cells");
//	
//    	listLength = nList.getLength();
//    	System.out.println("\nlistLength = " + listLength);
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
    	System.out.println("\nEventNumber = " + listLength);
    	
    	for (int temp = 0; temp < listLength; temp++) {
    		
    	}
    	
    	} catch (Exception e) {
    		e.printStackTrace();
    	}
  }

}