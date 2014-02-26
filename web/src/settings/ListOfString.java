package settings;

import java.util.ArrayList;

import jxmlable.ListOfXmlables;

public class ListOfString extends ArrayList implements ListOfXmlables  {
	public String getPackageName() {return null; }
	public Class getStoredClass() {  return String.class; }
	
	public String gett(int i) {
		return (String) super.get(i);
	}
	
	public ListOfString() { }
}
