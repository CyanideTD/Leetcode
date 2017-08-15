public class Solution {
    public String countAndSay(int n) {
	if (n == 1) {
	    return "1";
	}
	StringBuilder s = new StringBuilder("1");
	StringBuilder res = new StringBuilder();
	for (int i = 1; i < n; i++) {
	    int index = 0;
	    while (index < s.length()) {
		int num = 0;
	 	int next = index;
		while (next < s.length() && s.charAt(next) == s.charAt(index)) {
		    num++;
		    next++;
		}
		res.append((char) ('0' + num));
		res.append(s.charAt(index));
		index = next;
	    }
	    s = res;
	    res = new StringBuilder();
	}
	return s.toString();
    }
}
