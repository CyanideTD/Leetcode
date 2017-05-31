public class Solution {
    public boolean checkInclusion(String s1, String s2) {
    	if (s1 == null || s2 == null || s1.length() > s2.length()) {
		return false;
	}
	int head = 0;
	int tail = 0;
	int length2 = s2.length();
	int length1 = s1.length();
	int[] hash = new int[256];
	for (int i = 0; i < length1; i++) {
		hash[s1.charAt(i)]--;
	}
	while (tail < length2) {
		if (++hash[s2.charAt(tail++)] > 0) {
			while (--hash[s2.charAt(head++)] != 0) {
			}
		} else {
			if (tail - head == length1) {
				return true;
			}
		}
	}
	return false;
    }
}
