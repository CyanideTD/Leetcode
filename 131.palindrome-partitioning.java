public class Solution {
    public List<List<String>> partition(String s) {
	int len = s.length();
	List<List<String>>[] res = new List[len + 1];
	res[0] = new ArrayList<List<String>>();
	res[0].add(new ArrayList<String>());
	for (int i = 1; i <= len; i++) {
	    res[i] = new ArrayList<List<String>>();
	    for (int j = i - 1; j >= 0; j--) {
		if (check(s.substring(j, i))) {
		    for (List<String> list : res[j]) {
			List<String> cur = new ArrayList<>(list);
			cur.add(s.substring(j, i));
			res[i].add(cur);
		    }
	   	}
	    }
	}
	return res[len];
	 
    }
    public boolean check(String s) {
	int i = 0;
	int j = s.length() - 1;
	while (i <= j) {
	    if (s.charAt(i) != s.charAt(j)) {
		return false;
	    }
	    i++;
	    j--;
	}
	return true;
    }
}
