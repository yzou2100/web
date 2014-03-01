package settings;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import jxmlable.ListOfXmlables;
import jxmlable.XmlGenerator;
import jxmlable.XmlParser;

// This is a list of contact
public class ListOfContactInfo extends ArrayList implements ListOfXmlables  { 
	public String getPackageName() { return null; }
	public Class getStoredClass() { return ContactInfo.class; }
	
	public ContactInfo gett(int i) {
		return (ContactInfo) super.get(i);
	}
	
	public ListOfContactInfo() {}
	
	
	
	/** @return ListOfContactInfo object from xml string */
	public static ListOfContactInfo restore(String rawXml) {
		try {
			ListOfContactInfo fTree = new ListOfContactInfo();
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document d = documentBuilder.parse(
					new BufferedInputStream( new ByteArrayInputStream( rawXml.getBytes() ) ) );

			XmlParser.setFromXml(fTree, d.getDocumentElement());  

			return fTree;
		}  catch(Exception e) {
			System.out.println("cannot restore ListOfContactInfo");
		}

		return null;
	}
	
	public static void main(String arg[]) {
		ListOfContactInfo test = new ListOfContactInfo();
	    ContactInfo c1 = new ContactInfo();
	    c1.m_acctNumber = "sc1";
	    c1.m_accountStatus = "ACTIVE";
	    
	    test.add(c1);
	    
	    ContactInfo c2 = new ContactInfo();
	    c2.m_acctNumber = "sc2";
	    c2.m_accountStatus = "APPROVED";
	    
	    test.add(c2);
	    
	    String xmlString = XmlGenerator.getXml(test);
	    
	    System.out.println("xmlString\r\n");
	    System.out.println(xmlString);
	    System.out.println("Restore");
	    
	    ListOfContactInfo retored = ListOfContactInfo.restore(xmlString);
	    System.out.println(XmlGenerator.getXml(retored));
	}
}
