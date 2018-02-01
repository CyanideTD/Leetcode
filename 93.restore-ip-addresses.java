class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
	if (s == null || s.length() < 4) {
	    return res;
	}
	int[] address = {-1, -1, -1, -1};
	buildTree(s, 0, res, address, 0);
	return res;
    }
    public void buildTree(String s, int index, List<String> res, int[] address, int level) {
        if (index == s.length() || level == 4) {
	    if (index == s.length() && level == 4) {
	        String add = String.valueOf(address[0]) + "." + String.valueOf(address[1]) + "." + String.valueOf(address[2]) + "." + String.valueOf(address[3]);
		res.add(add);
	    }
	    return;
	}
	for (int i = 0; i < 3; i++) {
	    if (index + i >= s.length()) {
	        break;
	    } else {
		if (i >= 1 && s.charAt(index) == '0') {
		    return;
		}
	        String curr = s.substring(index, index + i + 1);
		int num = Integer.valueOf(curr);
		if (num > 255) {
		    break;
		} else {
		    address[level] = num;
		    buildTree(s, index + i + 1, res, address, level + 1);
		    address[level] = -1;
		}
	    }
	}

    }
}
