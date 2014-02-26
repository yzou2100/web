package settings;

import jxmlable.DontObfuscate;

/** This is family tree root node */
public class FamilyTree implements DontObfuscate {
	public FamilyTreeNode m_me;
	public FamilyTreeNode m_parent;
	public FamilyTreeNode m_parentInLaw;
	
	public LisfOfFamilyTreeNode m_children;
	public LisfOfFamilyTreeNode m_siblings;
	public LisfOfFamilyTreeNode m_friends;
	public LisfOfFamilyTreeNode m_serviceProviders;
		
	public FamilyTree() {}
}
