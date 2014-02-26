package settings;

import jxmlable.DontObfuscate;

// This is one contact information
public class ContactInfo implements DontObfuscate { 
	public enum Status { INACTIVE, APPROVED, ACTIVE, SUSPENDED, PENDING };
	public enum Acct_type { SUPER, REGULAR, GUEST };
	
	public String m_acctNumber;  // sc account number
	public Status m_accountStatus; // sc account status
	public Acct_type m_acctType; // sc account type
	
	public String m_firstName;
	public String m_lastName;
	public String m_wechartNumber;
	public String m_phoneNumber;
	public String m_2ndPhoneNumber;
	public String m_birthDay;
	public String m_lastStatus;
	public long m_lastStatusTime;
	public int m_familyPosition; // 0 is father, 1 mother, etc sorted by father/mother/1st child/2nd child.
	
	public ContactInfo() {}
}
