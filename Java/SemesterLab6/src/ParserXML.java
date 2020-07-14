import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class ParserXML {

	public ParserXML() throws ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated constructor stub
		
		//Specify File - xml
		File xml = new File("Passports.xml");
		//Call document builder factory
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		//call document buider 
		DocumentBuilder dBuilder = factory.newDocumentBuilder();
		//parse xml file to document builder
		Document doc = dBuilder.parse(xml);
		
		//Normalize the document
		doc.getDocumentElement().normalize();
		
		//root NODE is doc.getdocumentelement.getnodename
		System.out.println("This is your root element:"+ doc.getDocumentElement().getNodeName());
		
		
		//create a node list to get more then one node set it equLl getelementbytagname IN THIS CASE for example "countires" which will get all user elements 
		NodeList countries = doc.getElementsByTagName("AnnualTotals");
		
		
		//create a for loop and go through this nodlist
		for(int i = 0 ; i <countries.getLength(); i++)
		{
			//Import node  and create an instance of the information that you wish to pull then set it to equal the iteration of the node element in the list
			Node country = countries.item(i);
			
			//Printing out child nodes
			//System.out.println("The Name of the child node is:" + country.getNodeName());
			
			//check what the type of element to see if it equals node type 1 IE AN ELEMENT
			if(country.getNodeType() == Node.ELEMENT_NODE)
			{
				//cast the node to type element
				Element e = (Element) country;
				System.out.println("==============================" );
				
				//Print out country name
				Node name = e.getElementsByTagName("CountryOfBirth").item(0);
				String cName = name.getTextContent();
				System.out.println("Country Name:" + cName );
				
				//Print out Year of issue
				Node year = e.getElementsByTagName("YearofIssue").item(0);
				String yoi = year.getTextContent();
				System.out.println("Year of Issue:" + yoi );
				
				//Print out amount of pasports isssued
				Node amount = e.getElementsByTagName("TotalIssued").item(0);
				String amountIssued = amount.getTextContent();
				System.out.println("Amount Of Passports Issued:" + amountIssued );
				
				System.out.println("==============================" );
				System.out.println("   " );
			}
			
			
		}
		//print out the node element name which is the the tag name for  node
		
		
		//get the attrobute
		//get the tagame of the first name , lastname , occupation(ESSENTIALLY THE ATTRIBUTES OF THE ELEMENT)
		//Store them in strings
		//print them out
	
		
	}
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		new ParserXML();
	}

}
