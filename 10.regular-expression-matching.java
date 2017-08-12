public class Solution {
    public boolean isMatch(String s, String p) {
	int i = 0;
	int j = 0;
	boolean flag = true;
	while (i < s.length() && j < p.length()) {
	    if (!flag) {
		while (j < p.length() && p.charAt(j) == '*') {
		    j++;
	 	}
		flag = true;
	    } else if (s.charAt(i) == s.charAt(j)) {
		i++;
		j++;
	    } else if (p.charAt(j) == '.') {
		i++;
		j++;
	    } else if (p.charAt(j) == "*") {
		char same = null;
		if (j > 0 && p.charAt(j) == '.') {
		    same = s.charAt(i - 1);
		} else {
		    same = s.charAt(j - 1);
	     	}
		if (same != s.charAt(i)) {
		    j++;
		    continue;
		} else {
		    
		}
	    } else if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
		j++;
		flag = false;
	    } else {
		return false;
	    }
	}
	if (i == s.length()) {
	    return true;
	}
    }
}
