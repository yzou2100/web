package settings;

import jxmlable.DontObfuscate;

/** One node in family tree */
public class FamilyTreeNode implements DontObfuscate {
	public enum Status { INACTIVE, SEND_MSG, PENDING, SEND_HELP };
	public enum Relate_to_root { ME, PARENT, CHILD, SIBLING, FRIEND, SERVICE };
	public Relate_to_root m_relateToRoot; // relationship to the root of the tree
	
	public ListOfContactNode m_contacts;
	
	public Status m_lastStatus;
	public long m_lastActionTime;
	public ListOfString m_familyMessage;
	
	public FamilyTreeNode()  {} 

}
