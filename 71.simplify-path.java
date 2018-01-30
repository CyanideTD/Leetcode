class Solution {
    public String simplifyPath(String path) {
	if (path == null || path.length() == 0) {
	    return "";
	}
	char[] pa = path.toCharArray();
	ArrayDeque<String> stack = new ArrayDeque<>();
	int index = 0;
    	while (index < pa.length) {
    	    if (pa[index] == '/') {
    		if ((stack.isEmpty() || stack.peekFirst() != "/") && index != pa.length - 1) {
    			stack.addFirst("/");
    		}
    		index++;
    		} else {
		    int start = index;
		    while (index < pa.length && pa[index] != '/') {
	 	    index++;
		}
		    String str = path.substring(start, index);
		    if (str.equals("..")) {
		        stack.pop();
	    	        if (!stack.isEmpty()) {
	    	            stack.pop();
	    		}
		    } else if (str.equals(".")) {
			stack.pop();
		    } else {
			stack.addFirst(str);
		    }
		}
    	}
    	    
	StringBuilder res = new StringBuilder();
    	while (!stack.isEmpty()) {
    	    String pop = stack.pollFirst();
    	    res.insert(0, pop);
    	}
    	if (res.length() == 0) {
    	    return "/";
    	}
	if (res.length() != 1 && res.charAt(res.length() - 1) == '/') {
	    return res.substring(0, res.length() - 1).toString();
	}
	return res.toString();
    }
}
