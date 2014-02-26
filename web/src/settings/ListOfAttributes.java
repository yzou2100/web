package settings;

import java.util.ArrayList;

import jxmlable.ListOfXmlables;

public class ListOfAttributes extends ArrayList implements ListOfXmlables  {
	public String getPackageName() {return null; }
	public Class getStoredClass() {  return Attribute.class; }

	public Attribute gett(int i) {
		return (Attribute) super.get(i);
	}
	
	ListOfAttributes() { }
}