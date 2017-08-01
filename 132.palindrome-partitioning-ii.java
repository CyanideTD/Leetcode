public class Solution {
    public int minCut(String s) {
	StringBuilder t = new StringBuilder(s);
	t.append(t.reverse());
        int[] next = new int[t.length()];
	int j = 0;
	int i = 1;
	while (i < next.length) {
	    while (j > 0 && t.charAt(i) != t.charAt(j)) {
		j = next[j - 1];
	    }
	    if (t.charAt(i) == t.charAt(j)) {
		next[i] = j + 1;
		j++;
	    } else {
		next[i] = 0;
	    }
	    i++;
	}
	
	int index = next[next.length() - 1];
	return new StringBuilder(s).subString(index, s.length()).reverse() + s;
    }
}
