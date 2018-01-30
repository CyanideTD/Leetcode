public class Solution {
    public String convert(String s, int numRows) {
	if (s.equals("")) {
	    return "";
	}
	int length = s.length();
	StringBuffer[] buffer = new StringBuffer[numRows];
	for (int i = 0; i < numRows; i++) {
	    buffer[i] = new StringBuffer();
	}
	char[] charArr = s.toCharArray();
	int index = 0;
	while (index < length) {
	    for (int i = 0; i < numRows && index < length; i++) {
	    	buffer[i].append(charArr[index++]);
	    }
	    for (int i = numRows - 2; i >= 1  && index < length; i--) {
	    	buffer[i].append(charArr[index++]);
	    }
	}
	StringBuffer res = new StringBuffer();
	for (int i = 0; i < numRows; i++) {
	    res.append(buffer[i]);
	}
	return res.toString();
    }
}
