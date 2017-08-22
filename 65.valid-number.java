class Solution {
    public boolean isNumber(String s) {
	String res = s.trim();
	int countE = 0;
	int countD = 0;
	if (res.length() == 0) {
	    return false;
	}
	
	for (int i = 0; i < res.length(); i++) {
	    if (res.charAt(i) <= 'z' && res.charAt(i) >= 'a') {
	    	if (res.charAt(i) != 'e') {
		    return false;
		} else {
		    countE++;
		    if (i == 0 || i == res.length() - 1) {
		 	return false;
		    } else if (res.charAt(i - 1) > '9' || res.charAt(i - 1) <= '0') {
			return false;
		    }
	 	}
	    }
	    if (res.charAt(i) == '.') {
		countD++;
		if (i == 0 && i == res.length() - 1) {
		    return false;
		} else if (res.charAt(i - 1) > '9' || res.charAt(i - 1) < '0' || res.charAt(i + 1) > '9' || res.charAt(i + 1) < '0') {
		    return false;
		}
	    }
	}        
	if (countE > 1 || countD > 1) {
	    return false;
	}
	return true;
    }
}
