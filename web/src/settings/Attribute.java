package settings;

import jxmlable.DontObfuscate;

public class Attribute implements DontObfuscate {
	public String m_repeatType; // NONE/ONCE/MINUTE/HOUR/DAY/WEEKLY/MONTH/YEAR
	public String m_startTime;
	public String m_endTime;
	public String m_actionType;
	public String m_actionLink;
	public String m_actionParameters;
	
	Attribute() {} // needed for xml tool

}
