package settings;

import java.util.ArrayList;

import jxmlable.ListOfXmlables;

public class LisfOfFamilyTreeNode extends ArrayList implements ListOfXmlables  {
	public String getPackageName() {return null; }
	public Class getStoredClass() {  return FamilyTreeNode.class; }

	public FamilyTreeNode gett(int i) {
		return (FamilyTreeNode) super.get(i);
	}
	
	LisfOfFamilyTreeNode() { }
}