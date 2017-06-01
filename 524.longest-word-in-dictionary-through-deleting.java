public class Solution {
    public String findLongestWord(String s, List<String> d) {
	    String candidate = "";
	    if (d == null || d.size() == 0) {
	    	return candidate;
	    }
	    for (int i = 0; i < d.size(); i++) {
	    	if (isValid(s, d.get(i))) {
			candidate = isSmall(d.get(i), candidate);
		}
	    }
	    return candidate;
    }
    public boolean isValid(String s1, String s2) {
    	if (s1.length() < s2.length()) {
		return false;
	}
	int i = 0;
	int j = 0;
	while (j < s1.length() && i < s2.length() {
		if (s1.charAt(j) == s2.charAt(i)) {
			i++;
		}
		j++;
	}
	return i == s2.length() ? true : false;
    }
    public String isSmall(String s1, String s2) {
    	if (s1.length() > s2.length()) {
		return s1;
	}
	if (s2.length() > s1.length()) {
		return s2;
	}
	int i = 0;
	for (;i < s1.length() && i < s2.length(); i++) {
		if (s1.charAt(i) - s2.charAt(i) > 0) {
			return s2;
		} else if (s1.charAt(i) - s2.charAt(i) < 0) {
			return s1;
		}
	}
	return i == s1.length() ? s1 : s2;
    }
}
