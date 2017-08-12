public class Solution {
    public String longestCommonPrefix(String[] strs) {
	StringBuilder res = new StringBuilder();
	if (strs == null || strs.length == 0) {
	    return "";
	}
	Arrays.sort(strs);
	for (int i = 0; i < strs[0].length(); i++) {
	    if (strs[0].charAt(i) == strs[strs.length - 1].charAt(i)) {
		res.append(strs[0].charAt(i));
	    } else {
		return res.toString();
	    }
	}
	return res.toString();        
    }
}
