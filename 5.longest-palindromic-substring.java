public class Solution {
    public String longestPalindrome(String s) {
	int max = 0;
	int j = -1;
	int k = -1;
	int n = s.length();
	if (n < 2) {
	    return s;
	}
	for (int i = 0; i < 2 * (n - 1); i++) {
	    int count = 0;
	    int left = i / 2;
	    int right = (i + 1) / 2;
	    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
		left--;
		right++;
	    }
	    count = right - left - 1;
	    if (count > max) {
		j = left + 1;
		k = right - 1;
		max = count;
	    }
	}
	return s.substring(j, k + 1);
    }
}
