class Solution {
    public int jump(int[] nums) {
	if (nums == null || nums.length < 2) {
	    return 0;
	}
	Set<Integer> set = new HashSet<>();
	Queue<Integer> queue = new LinkedList<>();
	int step = 0;
	queue.add(0);
	set.add(0);
	while (!queue.isEmpty()) {
	    int size = queue.size();
	    for (int i = 0; i < size; i++) {
		int pos = queue.poll();
		for (int j = nums[pos]; j >= 1; j--) {
		    int next = pos + j;
		    if (next >= nums.length - 1) {
			return step + 1;
		    }
		    if (!set.contains(next)) {
			queue.add(next);
			set.add(next);
		    }
		}
	    }
	    step++;
	}
	return -1;
    }
    
}
