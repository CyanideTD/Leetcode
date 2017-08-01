public class Solution {
    public String shortestPalindrome(String s) {
	if (s.length() < 2) {
	    return s;
	}
        StringBuilder t = new StringBuilder(s);
	String rev = t.reverse().toString();
        t.append("#");
        t.append(rev);
        int[] next = new int[t.length()];
        int j = 0;
        int i = 1;
        while (i < next.length) {
	    j = next[i - 1];
            while (j > 0 && t.charAt(i) != t.charAt(j)) {
                j = next[j - 1];
            }
	    if (t.charAt(i) == t.charAt(j)) {
		next[i] = j + 1;
	    } else {
		next[i] = j;	
	    }
            i++;
        }
        return rev.substring(0, s.length() - next[t.length() - 1]) + s;
    }
}

