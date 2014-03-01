package settings;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import jxmlable.DontObfuscate;
import jxmlable.XmlGenerator;
import jxmlable.XmlParser;

/** This is family tree root node */
public class FamilyTree implements DontObfuscate {
	public FamilyTreeNode m_me = new FamilyTreeNode();
	public FamilyTreeNode m_parent = new FamilyTreeNode();
	public FamilyTreeNode m_parentInLaw = new FamilyTreeNode();
	
	public ListOfTreeNode m_children = new ListOfTreeNode();
	public ListOfTreeNode m_siblings = new ListOfTreeNode();
	public ListOfTreeNode m_friends = new ListOfTreeNode();
	public ListOfTreeNode m_serviceProviders = new ListOfTreeNode();
		
	public FamilyTree() {}
	
	
	public String toXmlString() {
		try {
			return XmlGenerator.getXml(this);
		}
		catch(Exception e) {
			System.out.println("toXmlStrin failed " + e);
		}
		
		return "";
	}
	
	/** @return FamilyTree object from xml string */
	public static FamilyTree restore(String rawXml) {
		try {
			FamilyTree fTree = new FamilyTree();
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document d = documentBuilder.parse(
					new BufferedInputStream( new ByteArrayInputStream( rawXml.getBytes() ) ) );

			XmlParser.setFromXml(fTree, d.getDocumentElement());  

			return fTree;
		}  catch(Exception e) {
			System.out.println("cannot restore settings");
		}

		return null;
	}
	
	public static FamilyTree createTest(String tag) {
		FamilyTree t = new FamilyTree();
		t.m_me = FamilyTreeNode.createTest("me_" + tag);
		
		t.m_children = ListOfTreeNode.creaetTest("children_" + tag);
		t.m_siblings = ListOfTreeNode.creaetTest("m_siblings_" + tag);
		
		return t;
		
	}
	
	public static void main(String arg[]) { 
		FamilyTree test = createTest("recover");
	    String xmlString = XmlGenerator.getXml(test);
	 	
	    System.out.println(xmlString);	    
	    FamilyTree recovered = FamilyTree.restore(xmlString);
	    
	    String restored = XmlGenerator.getXml(recovered);		 
	    System.out.println("-----Restored-------");		  
	    System.out.println(restored);		   
	}

}
