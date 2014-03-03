package httpConn;

public class PwdEncoder {
	private static final int KEYS[] = {
		12379,
		25678,
		33987,
		12567,
		99764,
		32321,
		77797,
		39971,
		6907,
		29876,
		12409,
		87678,
		12354,
		4534,
		234234,
		2355,
		98732,
		23423				
	};
	
	public static String encode(String rawPwd) {
		if ( rawPwd.length() > 16 ) {
			return null;
		}
		
		char m='l', d = (char)('~' - m + 1);
		StringBuilder sb = new StringBuilder();
		
		for ( int i = 0; i < rawPwd.length(); i++ ) {
			char test = (char)((rawPwd.charAt(i) - m + (KEYS[i]%d))%d+m);
			sb.append(Character.toString(test));
		}
				
		return sb.toString();
	}

}
