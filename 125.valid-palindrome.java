public class Solution {
    public boolean isPalindrome(String s) {
	if (s == null || s.length() == 0) {
	    return true;
	}
	int l = 0;
	int r = s.length() - 1;
	while (l <= r) {
	    char head = s.charAt(l);
	    char tail = s.charAt(r);
	    if (!Character.isLetterOrDigit(head)) {
		l++;
	    } else if (!Character.isLetterOrDigit(tail)) {
		r--;
	    } else if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
		return false;
	    } else {
		l++;
	  	r--;
	    }
	}
	return true;
    }
}
