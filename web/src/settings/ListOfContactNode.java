package settings;

import java.util.ArrayList;

import jxmlable.ListOfXmlables;

// This is a list of contact
public class ListOfContactNode extends ArrayList implements ListOfXmlables  { 
	public String getPackageName() { return null; }
	public Class getStoredClass() { return ContactInfo.class; }
	
	public ContactInfo gett(int i) {
		return (ContactInfo) super.get(i);
	}
	
	public ListOfContactNode() {}
}
