public class Solution {
    public int strStr(String haystack, String needle) {
	if (needle.length() == 0) {
	    return 0;
	}
	for (int i = 0; i <= haystack.length() - needle.length(); i++) {
	    int first = i;
	    int second = 0;
	    while (second < needle.length() && haystack.charAt(first) == needle.charAt(second)) {
		first++;
		second++;
	    }
	    if (second == needle.length()) {
		return i;
	    }
	}
	return -1;
    }
}
