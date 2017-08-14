public class Solution {
    public int longestValidParentheses(String s) {
	Deque<Integer> stack = new ArrayDeque<>();
	for (int i = 0; i < s.length(); i++) {
	    if (s.charAt(i) == '(') {
		stack.addFirst(i);
	    } else {
		if (!stack.isEmpty() && s.charAt(stack.getFirst()) == '(') {
		    stack.removeFirst();
		} else {
		    stack.addFirst(i);
	   	}
	    }
	}

	int tail = s.length();
	int max = 0;
	if (stack.isEmpty()) {
	    return s.length();
	}
	while (!stack.isEmpty()) {
	    int head = stack.removeFirst();
	    max = Math.max(max, tail - head - 1);
	    tail = head;
	}
	max = Math.max(max, tail);
	return max;
    }
}
