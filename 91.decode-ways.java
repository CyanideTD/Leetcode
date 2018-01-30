class Solution {
    public int numDecodings(String s) {
	if (s == null || s.length() == 0) {
	    return 0;
	}
	if (s.charAt(0) == '0') {
	    return 0;
	}
	int length = s.length();
	int[] ways = new int[length];
	ways[0] = 1;
	for (int i = 1; i < length; i++) {
	    if (s.charAt(i) == '0') {
		if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') {
		    return 0;
		}
		if (i == 1) {
		    ways[i] = 1;
		} else {
		    ways[i] = ways[i - 2];
		}
	    } else {
	        String number = s.substring(i - 1, i + 1);
		if (s.charAt(i - 1) == '0') {
		    ways[i] = ways[i - 1];
		} else if (Integer.valueOf(number) > 26){
		    ways[i] = ways[i - 1];
		} else {
		    if (i == 1) {
		        ways[i] = 2;
		    } else {
			ways[i] = ways[i - 1] + ways[i - 2];
		    }
		}
	    }
	}
	return ways[length - 1];
    }
}
