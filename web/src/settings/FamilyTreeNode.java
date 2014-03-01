package settings;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;

import jxmlable.DontObfuscate;
import jxmlable.XmlGenerator;
import jxmlable.XmlParser;

/** One node in family tree */
public class FamilyTreeNode implements DontObfuscate {
	public String m_rootScAccount; // root SC account it belongs to
	public String m_relateToRoot; // relationship to the root of the tree { ME, PARENT, CHILD, SIBLING, FRIEND, SERVICE };
	
	public ListOfContactInfo m_listOfContactInfo = new ListOfContactInfo();
	public ListOfString m_familyMessages = new ListOfString();
		
	public String m_lastStatus = "INACTIVE"; // { INACTIVE, SEND_MSG, PENDING, SEND_HELP };
	public long m_lastActionTime;
	
	public FamilyTreeNode()  {} 
	
	
	public static FamilyTreeNode restore(String rawXml) {
		try {
			FamilyTreeNode fTree = new FamilyTreeNode();
			DocumentBuilder documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

			Document d = documentBuilder.parse(
					new BufferedInputStream( new ByteArrayInputStream( rawXml.getBytes() ) ) );

			XmlParser.setFromXml(fTree, d.getDocumentElement());  

			return fTree;
		}  catch(Exception e) {
			System.out.println("cannot restore FamilyTreeNode");
		}

		return null;
	}
	
	public static FamilyTreeNode createTest(String tag) {
		FamilyTreeNode testTreeNode = new FamilyTreeNode();
	    ContactInfo c1 = new ContactInfo();
	    c1.m_acctNumber = "sc1_" + tag;
	    c1.m_accountStatus = "ACTIVE";
	    
	    testTreeNode.m_listOfContactInfo.add(c1);
	    
	    ContactInfo c2 = new ContactInfo();
	    c2.m_acctNumber = "sc2_" + tag;
	    c2.m_accountStatus = "APPROVED";
	    
	    testTreeNode.m_listOfContactInfo.add(c2);
	    
	    testTreeNode.m_lastActionTime = 1234 + tag.length();
	    
	    testTreeNode.m_familyMessages.add("msg1_" + tag);
	    testTreeNode.m_familyMessages.add("msg2_" + tag);
	    
	    return testTreeNode;
	}
	
	
	public static void main(String arg[]) {		
		FamilyTreeNode testTreeNode = createTest("0");
	    String xmlString = XmlGenerator.getXml(testTreeNode);
	    
	    System.out.println("xmlString\r\n");
	    System.out.println(xmlString);
	    System.out.println("Restore");
	    
	    FamilyTreeNode retored = FamilyTreeNode.restore(xmlString);
	    System.out.println(XmlGenerator.getXml(retored));
	}
}
