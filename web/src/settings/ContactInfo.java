package settings;

import jxmlable.DontObfuscate;

// This is one contact information
public class ContactInfo implements DontObfuscate { 
	
	public String m_acctNumber;  // sc account number 
	public String m_accountStatus; // sc account status { INACTIVE, APPROVED, ACTIVE, SUSPENDED, PENDING };
	public String m_acctType; // sc account type { SUPER, REGULAR, GUEST };
	
	public String m_firstName; 
	public String m_lastName;
	public String m_wechartNumber;
	public String m_phoneNumber;
	public String m_2ndPhoneNumber;
	public String m_address;
	public String m_birthDay;
	public String m_lastStatus;
	public long m_lastStatusTime;
	public int m_familyPosition; // 0 is father, 1 mother, etc sorted by father/mother/1st child/2nd child.
	
	public ContactInfo() {}
}
