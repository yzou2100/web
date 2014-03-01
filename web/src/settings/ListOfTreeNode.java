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

public class ListOfTreeNode extends ArrayList implements ListOfXmlables  {
	public String getPackageName() {return null; }
	public Class getStoredClass() {  return FamilyTreeNode.class; }

	public FamilyTreeNode gett(int i) {
		return (FamilyTreeNode) super.get(i);
	}
	
	public ListOfTreeNode() { }
	

	/** @return ListOfFamilyTreeNode object from xml string */
	public static ListOfTreeNode restore(String rawXml) {
		try {
			ListOfTreeNode listOfFamilyTreeNode = new ListOfTreeNode();
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document d = documentBuilder.parse(
					new BufferedInputStream( new ByteArrayInputStream( rawXml.getBytes() ) ) );

			XmlParser.setFromXml(listOfFamilyTreeNode, d.getDocumentElement());  

			return listOfFamilyTreeNode;
		}  catch(Exception e) {
			System.out.println("cannot restore ListOfFamilyTreeNode");
		}

		return null;
	}
	
	public static ListOfTreeNode creaetTest(String tag) {

		ListOfTreeNode ln = new ListOfTreeNode();
		ln.add(FamilyTreeNode.createTest(tag + "_1"));
		ln.add(FamilyTreeNode.createTest(tag + "_2"));
		
		return ln;
	}
	
	public static void main(String arg[]) {		
		ListOfTreeNode ln = creaetTest("ListTreeNodeTest");		  
	    String xmlString = XmlGenerator.getXml(ln);
	    
	    System.out.println("xmlString\r\n");
	    System.out.println(xmlString);
	    System.out.println("Restore");
	    
	    ListOfTreeNode restored = ListOfTreeNode.restore(xmlString);
	    System.out.println(XmlGenerator.getXml(restored));
		
	}
}